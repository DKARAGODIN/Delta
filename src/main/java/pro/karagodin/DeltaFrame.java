package pro.karagodin;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;
import ru.customs.commonaggregatetypes._5_22.PersonSignatureType;
import ru.customs.commonaggregatetypes._5_22.RFOrganizationFeaturesType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.AttachedDocumentType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.EngineType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.ObjectFactory;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.PayerTPOType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.PersonType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.RecyclingDetailsType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.UtilCollDetailsType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.VehicleProdDateType;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.VehicleType;
import ru.customs.ruscommonaggregatetypes._5_22.RUAddressType;
import ru.customs.ruscommonaggregatetypes._5_22.RUIdentityCardType;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;


public class DeltaFrame extends BaseFrame implements ActionListener {

	private RecyclingDetailsType data;

	public DeltaFrame() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			if (event.getSource() == open) {
				openFile();
			} else if (event.getSource() == save) {
				if (isInputValid()) {
					saveFile();
				} else {
					throw new RuntimeException("Форма не прошла валидацию");
				}
			} else if (event.getSource() == clear) {
				clearFields();
				data = null;
				runAllCheckers();
			} else if (event.getSource() == saveBroker) {
				saveBroker();
			} else if (event.getSource() == openBroker) {
				openBroker();
			}
		} catch (Exception e) {
			List<String> messages = new ArrayList<>();
			String message = e.getMessage();
			if (e.getMessage() == null) {
				Throwable cause = e.getCause();
				if (cause != null) {
					message = cause.getMessage();
				}
			}
			if (message != null) {
				messages.add(message);
			} else {
				messages.add(e.toString());
			}
			messages.add("");
			for (StackTraceElement elem : e.getStackTrace()) {
				messages.add(elem.toString());
			}
			String text = String.join("\n", messages);

			JDialog d = new JDialog(this, "Ошибка");
			JTextArea a = new JTextArea();
			a.setEditable(false);
			a.setText(text);
			d.add(a);
			d.setSize(750, 750);
			d.setLocationRelativeTo(null);
			d.setVisible(true);
		}
	}

	private void saveBroker() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Сохранить информацию о брокере");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();

			StringBuilder sb =new StringBuilder();
			sb.append(StringUtils.defaultString(brokerSurNameInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerNameInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerMiddleNameInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerBdInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerPassportInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerPassportIssueInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerAddressInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerEmailInput.getText()));
			sb.append(System.lineSeparator());
			sb.append(StringUtils.defaultString(brokerPhoneInput.getText()));
			sb.append(System.lineSeparator());

			Files.writeString(f.toPath(), sb.toString(), StandardCharsets.UTF_8);
		}
	}

	private void openBroker() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Выберите файл");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			List<String> str = Files.readAllLines(fileChooser.getSelectedFile().toPath(), StandardCharsets.UTF_8);
			brokerSurNameInput.setText(str.get(0));
			brokerNameInput.setText(str.get(1));
			brokerMiddleNameInput.setText(str.get(2));
			brokerBdInput.setText(str.get(3));
			brokerPassportInput.setText(str.get(4));
			brokerPassportIssueInput.setText(str.get(5));
			brokerAddressInput.setText(str.get(6));
			brokerEmailInput.setText(str.get(7));
			brokerPhoneInput.setText(str.get(8));
		}
	}


	private void saveFile() throws JAXBException, DatatypeConfigurationException, IOException, ParseException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Сохранить файл");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			upperCase();
			fillDataFromFields();
			JAXBElement<RecyclingDetailsType> element = new ObjectFactory().createRecyclingDetails(data);
			File f = fileChooser.getSelectedFile();
			if (!f.getName().endsWith(".xml")) {
				f = new File(f.getParentFile(), f.getName() + ".xml");
			}
			createRequest(f);
			try {
				XmlUtils.marshall(element, f);
			} catch (JAXBException e) {
				f.delete();
				throw e;
			}
		}
	}

	private void openFile() throws IOException, SAXException, JAXBException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Выберите файл");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			BOMInputStream bis = BOMInputStream.builder().setInputStream(new FileInputStream(fileChooser.getSelectedFile())).get();
			String xml = new String(bis.readAllBytes());
			XmlUtils.validate(xml);
			data = XmlUtils.unMarshall(new StreamSource(new StringReader(xml)), RecyclingDetailsType.class).getValue();
			clearFields();
			fillFieldsFromData();
			runAllCheckers();
		}
	}

	private void fillFieldsFromData() {
		List<PayerTPOType> payers = data.getPayer();
		if (!payers.isEmpty()) {
			PayerTPOType payer = payers.get(0);
			PersonType person = payer.getPerson();
			if (person != null) {
				surNameInput.setText(person.getPersonSurname());
				nameInput.setText(person.getPersonName());
				middleNameInput.setText(person.getPersonMiddleName());
			}
			RFOrganizationFeaturesType org = payer.getRFOrganizationFeatures();
			if (org != null) {
				innInput.setText(org.getINN());
			}
			RUAddressType address = payer.getTPOAddress();
			if (address != null) {
				registrationInput.setSelectedItem(address.getAddressKindCode());
				countryCodeInput.setSelectedItem(address.getCountryCode());
				countryNameInput.setText(address.getCounryName());
				regionNameInput.setText(address.getRegion());
				townNameInput.setText(address.getTown());
				streetNameInput.setText(address.getStreetHouse());
				houseNumberInput.setText(address.getHouse());
				roomInput.setText(address.getRoom());
			}
			RUIdentityCardType card = payer.getIdentityDoc();
			if (card != null) {
				identityCardCodeInput.setSelectedItem(IdentityCardCode.cache.get(card.getIdentityCardCode()));
				identityCardSeriesInput.setText(card.getIdentityCardSeries());
				identityCardNumberInput.setText(card.getIdentityCardNumber());
				XMLGregorianCalendar calendar = card.getIdentityCardDate();
				if (calendar != null) {
					identityCardDateInput.setValue(calendar.toGregorianCalendar().getTime());
				}
				identityOrganisationNameInput.setText(card.getOrganizationName());
				identityIssuerCodeInput.setText(card.getIssuerCode());
				identityCountryCodeInput.setSelectedItem(card.getCountryCode());
			}
		}
		List<UtilCollDetailsType> utils = data.getUtilCollDetails();
		if (!utils.isEmpty()) {
			UtilCollDetailsType util = utils.get(0);
			udVehicleEPassportIdInput.setText(util.getVehicleEPassportId());
			udSignInput.setSelectedItem(util.getSign());
			udTransportKindCodeInput.setSelectedItem(TransportKind.cache.get(util.getTransportKindCode()));
			VehicleType vehicleType = util.getVehicle();
			if (vehicleType != null) {
				udTransportCategoryCodeInput.setText(vehicleType.getTransportCategoryCode());
				udMarkCodeInput.setSelectedItem(MarkKind.cache.get(vehicleType.getMarkCode()));
				udModelInput.setText(vehicleType.getModel());
				BigDecimal engineVolumeQuanity = vehicleType.getEngineVolumeQuanity();
				if (engineVolumeQuanity != null) {
					udEngineVolumeQuantityInput.setText(engineVolumeQuanity.toPlainString());
				}
				List<EngineType> engines = vehicleType.getEngine();
				if (!engines.isEmpty()) {
					EngineType engine = engines.get(0);
					udEngineModelCodeInput.setSelectedItem(EngineCode.cache.get(engine.getEngineModeCode()));
					udEngineModelInput.setText(engine.getEngineModel());
					BigDecimal enginePowerKvt = engine.getEnginePowerKvtQuanity();
					if (enginePowerKvt != null) {
						udEnginePowerKvtInput.setText(enginePowerKvt.toPlainString());
					}
				}
				BigDecimal totalWeight = vehicleType.getTotalWeight();
				if (totalWeight != null) {
					udTotalWeightInput.setText(totalWeight.toPlainString());
				}
				VehicleProdDateType vehicleProdDateType = vehicleType.getVehicleProdDate();
				if (vehicleProdDateType != null) {
					XMLGregorianCalendar calendar = vehicleProdDateType.getManufactureDate();
					if (calendar != null) {
						udManufactureDateInput.setValue(calendar.toGregorianCalendar().getTime());
					}
				}
				if (vehicleType.isEngineTypeIndicator() != null && vehicleType.isEngineTypeIndicator()) {
					udElectricEngineYN.setSelected(true);
				} else {
					udElectricEngineYN.setSelected(false);
				}
				if (vehicleType.isPersonalUseIndicator() != null && vehicleType.isPersonalUseIndicator()) {
					udPersonalUseYN.setSelected(true);
				} else {
					udPersonalUseYN.setSelected(false);
				}
			}
			udVinInput.setText(util.getVINID());
			BigDecimal importCustomsDuty = util.getImportCustomsDuty();
			if (importCustomsDuty != null)
				payImportCustomsDutyInput.setText(importCustomsDuty.toPlainString());
			BigDecimal excise = util.getExcise();
			if (excise != null)
				payExciseInput.setText(excise.toPlainString());
			BigDecimal vat = util.getVAT();
			if (vat != null)
				payVatInput.setText(vat.toPlainString());
			XMLGregorianCalendar calendar = util.getBorderCrossingDate();
			if (calendar != null)
				payBorderCrossingDateInput.setValue(calendar.toGregorianCalendar().getTime());
			BigDecimal dutyTaxFreeRate = util.getDutyTaxFeeRateValue();
			if (dutyTaxFreeRate != null)
				payDutyTaxFeeRateInput.setText(dutyTaxFreeRate.toPlainString());
			BigDecimal coefficient = util.getCoefficient();
			if (coefficient != null)
				payCoefficientInput.setText(coefficient.toPlainString());
			List<AttachedDocumentType> documents = util.getPresentedDocument();
			for (int i = 0; i < 5 && i < documents.size(); i++) {
				if (i == 0) {
					AttachedDocumentType doc = documents.get(0);
					doc1KindCodeInput.setSelectedItem(doc.getDocKindCode());
					doc1NameInput.setText(doc.getPrDocumentName());
					doc1NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc1DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 1) {
					AttachedDocumentType doc = documents.get(1);
					doc2KindCodeInput.setSelectedItem(doc.getDocKindCode());
					doc2NameInput.setText(doc.getPrDocumentName());
					doc2NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc2DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 2) {
					AttachedDocumentType doc = documents.get(2);
					doc3KindCodeInput.setSelectedItem(doc.getDocKindCode());
					doc3NameInput.setText(doc.getPrDocumentName());
					doc3NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc3DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 3) {
					AttachedDocumentType doc = documents.get(3);
					doc4KindCodeInput.setSelectedItem(doc.getDocKindCode());
					doc4NameInput.setText(doc.getPrDocumentName());
					doc4NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc4DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 4) {
					AttachedDocumentType doc = documents.get(4);
					doc5KindCodeInput.setSelectedItem(doc.getDocKindCode());
					doc5NameInput.setText(doc.getPrDocumentName());
					doc5NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc5DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				}
			}
		}
		surNameInput.setText(data.getPayer().get(0).getPerson().getPersonSurname());
	}

	private void fillDataFromFields() throws DatatypeConfigurationException {
		data = new RecyclingDetailsType();
		data.setDocumentModeID("1002048E");
		data.setDocumentID(UUID.randomUUID().toString());
		data.setDocType(BigDecimal.ONE);

		List<PayerTPOType> payers = data.getPayer();
		PayerTPOType payer;
		if (payers.isEmpty()) {
			payer = new PayerTPOType();
			payers.add(payer);
		} else {
			payer = payers.get(0);
		}
		PersonType personType = payer.getPerson();
		if (personType == null) {
			personType = new PersonType();
		}
		personType.setPersonSurname(surNameInput.getText());
		personType.setPersonName(nameInput.getText());
		if (StringUtils.isNotEmpty(middleNameInput.getText()))
			personType.setPersonMiddleName(middleNameInput.getText());
		payer.setPerson(personType);

		if (data.getCustomsPersonName() == null && data.getApproverPerson() == null) {
			PersonSignatureType pst = new PersonSignatureType();
			pst.setPersonSurname(surNameInput.getText());
			pst.setPersonName(nameInput.getText());
			data.setApproverPerson(pst);
		}

		RFOrganizationFeaturesType rfOrganizationFeaturesType = payer.getRFOrganizationFeatures();
		if (rfOrganizationFeaturesType == null)
			rfOrganizationFeaturesType = new RFOrganizationFeaturesType();
		if (StringUtils.isNotEmpty(innInput.getText()))
			rfOrganizationFeaturesType.setINN(innInput.getText());
		payer.setRFOrganizationFeatures(rfOrganizationFeaturesType);

		RUAddressType address = payer.getTPOAddress();
		if (address == null)
			address = new RUAddressType();
		if (registrationInput.getSelectedItem() != null)
			address.setAddressKindCode((String) registrationInput.getSelectedItem());
		if (countryCodeInput.getSelectedItem() != null)
			address.setCountryCode((String) countryCodeInput.getSelectedItem());
		if (StringUtils.isNotEmpty(countryNameInput.getText()))
			address.setCounryName(countryNameInput.getText());
		if (StringUtils.isNotEmpty(regionNameInput.getText()))
			address.setRegion(regionNameInput.getText());
		if (StringUtils.isNotEmpty(townNameInput.getText()))
			address.setTown(townNameInput.getText());
		if (StringUtils.isNotEmpty(streetNameInput.getText()))
			address.setStreetHouse(streetNameInput.getText());
		if (StringUtils.isNotEmpty(houseNumberInput.getText()))
			address.setHouse(houseNumberInput.getText());
		if (StringUtils.isNotEmpty(roomInput.getText()))
			address.setRoom(roomInput.getText());
		payer.setTPOAddress(address);

		RUIdentityCardType identity = payer.getIdentityDoc();
		if (identity == null)
			identity = new RUIdentityCardType();
		if (identityCardCodeInput.getSelectedItem() != null) {
			identity.setIdentityCardCode(((IdentityCardCode) identityCardCodeInput.getSelectedItem()).value());
			identity.setFullIdentityCardName(((IdentityCardCode) identityCardCodeInput.getSelectedItem()).description());
		}
		if (StringUtils.isNotEmpty(identityCardSeriesInput.getText()))
			identity.setIdentityCardSeries(identityCardSeriesInput.getText());
		if (StringUtils.isNotEmpty(identityCardNumberInput.getText()))
			identity.setIdentityCardNumber(identityCardNumberInput.getText());
		{
			Date d = (Date) identityCardDateInput.getValue();
			if (d != null) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				identity.setIdentityCardDate(d2);
			}
		}
		if (StringUtils.isNotEmpty(identityOrganisationNameInput.getText()))
			identity.setOrganizationName(identityOrganisationNameInput.getText());
		if (StringUtils.isNotEmpty(identityIssuerCodeInput.getText()))
			identity.setIssuerCode(identityIssuerCodeInput.getText());
		if (identityCountryCodeInput.getSelectedItem() != null)
			identity.setCountryCode((String) identityCountryCodeInput.getSelectedItem());
		payer.setIdentityDoc(identity);

		payer.setPersonIDIndicator(true);
		payer.setIEPersonIDIndicator(false);
		payer.setFactPayerIndicator(true);
		payer.setDebtorPayerIndicator(false);

		List<UtilCollDetailsType> utilCollDetailsTypes = data.getUtilCollDetails();
		UtilCollDetailsType utilDetails;
		if (utilCollDetailsTypes.isEmpty()) {
			utilDetails = new UtilCollDetailsType();
			utilCollDetailsTypes.add(utilDetails);
		} else {
			utilDetails = utilCollDetailsTypes.get(0);
		}

		utilDetails.setGoodsRecNumber(BigInteger.ONE);

		if (StringUtils.isNotEmpty(udVehicleEPassportIdInput.getText()))
			utilDetails.setVehicleEPassportId(udVehicleEPassportIdInput.getText());
		utilDetails.setSign((String) udSignInput.getSelectedItem());
		if (udTransportKindCodeInput.getSelectedItem() != null)
			utilDetails.setTransportKindCode(((TransportKind) udTransportKindCodeInput.getSelectedItem()).value());

		VehicleType vehicleType = utilDetails.getVehicle();
		if (vehicleType == null) {
			vehicleType = new VehicleType();
			utilDetails.setVehicle(vehicleType);
		}
		if (StringUtils.isNotEmpty(udTransportCategoryCodeInput.getText()))
			vehicleType.setTransportCategoryCode(udTransportCategoryCodeInput.getText());
		if (udMarkCodeInput.getSelectedItem() != null) {
			vehicleType.setMarkCode(((MarkKind) udMarkCodeInput.getSelectedItem()).code());
			vehicleType.setMark(((MarkKind) udMarkCodeInput.getSelectedItem()).name());
		}
		if (StringUtils.isNotEmpty(udModelInput.getText()))
			vehicleType.setModel(udModelInput.getText());
		if (StringUtils.isNotEmpty(udEngineVolumeQuantityInput.getText()))
			vehicleType.setEngineVolumeQuanity(new BigDecimal(udEngineVolumeQuantityInput.getText()));

		List<EngineType> engines = vehicleType.getEngine();
		EngineType engine;
		if (engines.isEmpty()) {
			engine = new EngineType();
			engines.add(engine);
		} else {
			engine = engines.get(0);
		}
		if (udEngineModelCodeInput.getSelectedItem() != null) {
			engine.setEngineModeCode(((EngineCode) udEngineModelCodeInput.getSelectedItem()).value());
			engine.setEngineModeName(((EngineCode) udEngineModelCodeInput.getSelectedItem()).description());
		}
		if (udElectricEngineYN.isSelected()) {
			vehicleType.setEngineTypeIndicator(true);
		} else {
			vehicleType.setEngineTypeIndicator(false);
		}
		if (udPersonalUseYN.isSelected()) {
			vehicleType.setPersonalUseIndicator(true);
		} else {
			vehicleType.setPersonalUseIndicator(false);
		}
		if (StringUtils.isNotEmpty(udEngineModelInput.getText()))
			engine.setEngineModel(udEngineModelInput.getText());
		if (StringUtils.isNotEmpty(udEnginePowerKvtInput.getText()))
			engine.setEnginePowerKvtQuanity(new BigDecimal(udEnginePowerKvtInput.getText()));
		if (StringUtils.isNotEmpty(udTotalWeightInput.getText()))
			vehicleType.setTotalWeight(new BigDecimal(udTotalWeightInput.getText()));
		{
			Date d = (Date) udManufactureDateInput.getValue();
			if (d != null) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				VehicleProdDateType vehicleProdDateType = new VehicleProdDateType();
				vehicleProdDateType.setManufactureDate(d2);
				vehicleType.setVehicleProdDate(vehicleProdDateType);
			}
		}
		if (StringUtils.isNotEmpty(udVinInput.getText()))
			utilDetails.setVINID(udVinInput.getText());
		if (StringUtils.isNotEmpty(payImportCustomsDutyInput.getText()))
			utilDetails.setImportCustomsDuty(new BigDecimal(payImportCustomsDutyInput.getText()));
		if (StringUtils.isNotEmpty(payExciseInput.getText()))
			utilDetails.setExcise(new BigDecimal(payExciseInput.getText()));
		if (StringUtils.isNotEmpty(payVatInput.getText()))
			utilDetails.setVAT(new BigDecimal(payVatInput.getText()));
		{
			Date d = (Date) payBorderCrossingDateInput.getValue();
			if (d != null) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				utilDetails.setBorderCrossingDate(d2);
			}
		}
		if (StringUtils.isNotEmpty(payDutyTaxFeeRateInput.getText()))
			utilDetails.setDutyTaxFeeRateValue(new BigDecimal(payDutyTaxFeeRateInput.getText()));
		if (StringUtils.isNotEmpty(payCoefficientInput.getText()))
			utilDetails.setCoefficient(new BigDecimal(payCoefficientInput.getText()));

		List<AttachedDocumentType> newDocuments = new ArrayList<>();
		fillDoc(newDocuments, doc1KindCodeInput, doc1NameInput, doc1NumberInput, doc1DateInput);
		fillDoc(newDocuments, doc2KindCodeInput, doc2NameInput, doc2NumberInput, doc2DateInput);
		fillDoc(newDocuments, doc3KindCodeInput, doc3NameInput, doc3NumberInput, doc3DateInput);
		fillDoc(newDocuments, doc4KindCodeInput, doc4NameInput, doc4NumberInput, doc4DateInput);
		fillDoc(newDocuments, doc5KindCodeInput, doc5NameInput, doc5NumberInput, doc5DateInput);
		utilDetails.getPresentedDocument().clear();
		utilDetails.getPresentedDocument().addAll(newDocuments);
	}

	private void fillDoc(List<AttachedDocumentType> newDocuments, JComboBox<String> docKindCodeInput, JTextField doc5NameInput, JTextField doc5NumberInput, JFormattedTextField doc5DateInput) throws DatatypeConfigurationException {
		if (StringUtils.isNotEmpty((CharSequence) docKindCodeInput.getSelectedItem())) {
			AttachedDocumentType doc = new AttachedDocumentType();
			doc.setDocKindCode((String) docKindCodeInput.getSelectedItem());
			doc.setPrDocumentName(doc5NameInput.getText());
			doc.setPrDocumentNumber(doc5NumberInput.getText());
			Date d = (Date) doc5DateInput.getValue();
			if (d != null) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				doc.setPrDocumentDate(d2);
			}
			newDocuments.add(doc);
		}
	}

	public void createRequest(File xml) throws IOException, ParseException {
		try (Workbook document = new XSSFWorkbook(Thread.currentThread().getContextClassLoader().getResourceAsStream("templates/doc.xlsx"))) {

			String brokerFio = StringUtils.defaultString(brokerSurNameInput.getText()) + " " +
					StringUtils.defaultString(brokerNameInput.getText()) + " " +
					StringUtils.defaultString(brokerMiddleNameInput.getText());
			String brokerBd = StringUtils.defaultString(brokerBdInput.getText());
			String brokerPass = StringUtils.defaultString(brokerPassportInput.getText());
			String brokerPassIssue = StringUtils.defaultString(brokerPassportIssueInput.getText());
			String brokerAddress = StringUtils.defaultString(brokerAddressInput.getText());

			String payerFio = StringUtils.defaultString(surNameInput.getText()) + " " +
					StringUtils.defaultString(nameInput.getText()) + " " +
					StringUtils.defaultString(middleNameInput.getText());

			String passport = StringUtils.defaultString(identityCardSeriesInput.getText()) + " № " + StringUtils.defaultString(identityCardNumberInput.getText())
					+ " выдан " + StringUtils.defaultString(identityOrganisationNameInput.getText()) + " " + StringUtils.defaultString(identityCardDateInput.getText());

			StringBuilder addressSb = new StringBuilder();
			addressSb.append(data.getPayer().getFirst().getTPOAddress().getRegion());
			addressSb.append(" ");
			addressSb.append(data.getPayer().getFirst().getTPOAddress().getTown());
			addressSb.append(" ");
			addressSb.append(data.getPayer().getFirst().getTPOAddress().getStreetHouse());
			addressSb.append(" ");
			addressSb.append(data.getPayer().getFirst().getTPOAddress().getHouse());
			addressSb.append(" ");
			addressSb.append(data.getPayer().getFirst().getTPOAddress().getRoom());
			String payerAddress = addressSb.toString();


			String brokerCountryStr = countryOfImport.getSelectedItem() == null ? "" : (String) countryOfImport.getSelectedItem();
			String c = "";
			if ("KZ".equals(brokerCountryStr)) {
				c = "Казахстан";
			} else if ("KG".equals(brokerCountryStr)) {
				c = "Кыргызстан";
			} else if ("AM".equals(brokerCountryStr)) {
				c = "Армения";
			} else if ("BY".equals(brokerCountryStr)) {
				c = "Беларусь";
			}

			{
				Sheet dov = document.getSheet("ДОВ");

				Cell date = dov.getRow(0).getCell(0);
				date.setCellValue(StringUtils.defaultString(calculationDate.getText()));

				Cell payer = dov.getRow(6).getCell(1);
				payer.setCellValue(payerFio);

				Cell bd = dov.getRow(7).getCell(0);
				if (StringUtils.isNotEmpty(bdInput.getText())) {
					bd.setCellValue(new SimpleDateFormat("dd.MM.yyyy").parse(bdInput.getText()));
				} else {
					bd.setCellValue("");
				}

				Cell passportCell = dov.getRow(8).getCell(5);
				passportCell.setCellValue(passport);

				Cell addressCell = dov.getRow(9).getCell(8);
				addressCell.setCellValue(payerAddress);

				Cell dovText = dov.getRow(10).getCell(0);
				dovText.setCellValue(String.format(Constants.dovText, brokerFio, brokerBd, brokerPass, brokerPassIssue, brokerAddress));

				Cell mark = dov.getRow(25).getCell(0);
				if (udMarkCodeInput.getSelectedItem() != null) {
					mark.setCellValue(((MarkKind) udMarkCodeInput.getSelectedItem()).name());
				} else {
					mark.setCellValue("");
				}

				Cell model = dov.getRow(25).getCell(4);
				model.setCellValue(StringUtils.defaultString(udModelInput.getText()));

				Cell vin = dov.getRow(26).getCell(8);
				vin.setCellValue(StringUtils.defaultString(udVinInput.getText()));

				Cell dateOfProduction = dov.getRow(27).getCell(4);
				dateOfProduction.setCellValue(StringUtils.defaultString(udManufactureDateInput.getText()));

				Cell signature = dov.getRow(31).getCell(1);
				signature.setCellValue(payerFio);
			}

			{
				Sheet zayava = document.getSheet("ЗАЯВА");

				Cell from = zayava.getRow(3).getCell(40);
				from.setCellValue(payerFio);

				Cell p = zayava.getRow(5).getCell(37);
				p.setCellValue(passport);

				Cell a = zayava.getRow(8).getCell(37);
				a.setCellValue(payerAddress);

				Cell phone = zayava.getRow(10).getCell(42);
				phone.setCellValue(StringUtils.defaultString(brokerPhoneInput.getText()));

				Cell email = zayava.getRow(10).getCell(59);
				email.setCellValue(StringUtils.defaultString(brokerEmailInput.getText()));

				Cell mark = zayava.getRow(14).getCell(0);
				if (udMarkCodeInput.getSelectedItem() != null) {
					mark.setCellValue(((MarkKind) udMarkCodeInput.getSelectedItem()).name());
				} else {
					mark.setCellValue("");
				}

				Cell model = zayava.getRow(14).getCell(10);
				model.setCellValue(StringUtils.defaultString(udModelInput.getText()));

				Cell vin = zayava.getRow(14).getCell(44);
				vin.setCellValue(StringUtils.defaultString(udVinInput.getText()));

				Cell dateOfProduction = zayava.getRow(15).getCell(7);
				dateOfProduction.setCellValue(StringUtils.defaultString(udManufactureDateInput.getText()));

				Cell country = zayava.getRow(15).getCell(37);
				country.setCellValue(c);

				Cell paymentDateCell = zayava.getRow(16).getCell(49);
				paymentDateCell.setCellValue(StringUtils.defaultString(paymentDate.getText()));

				Cell paymentNumberCell = zayava.getRow(17).getCell(3);
				paymentNumberCell.setCellValue(StringUtils.defaultString(paymentNumber.getText()));

				Cell paymentDateCell2 = zayava.getRow(23).getCell(26);
				paymentDateCell2.setCellValue(StringUtils.defaultString(paymentDate.getText()));

				Cell paymentNumberCell2 = zayava.getRow(23).getCell(39);
				paymentNumberCell2.setCellValue(StringUtils.defaultString(paymentNumber.getText()));

				var presentedDocs = data.getUtilCollDetails().get(0).getPresentedDocument();
				for (var doc : presentedDocs) {
					if (StringUtils.defaultString(udVehicleEPassportIdInput.getText()).equals(doc.getPrDocumentNumber())) {
						Cell eptsDate = zayava.getRow(24).getCell(20);
						eptsDate.setCellValue(new SimpleDateFormat("dd.MM.yyyy").format(doc.getPrDocumentDate().toGregorianCalendar().getTime()));
						Cell eptsNumber = zayava.getRow(24).getCell(33);
						eptsNumber.setCellValue(doc.getPrDocumentNumber());
					}
				}

				Cell broker = zayava.getRow(32).getCell(45);
				broker.setCellValue(brokerFio);
			}

			{
				Sheet calc = document.getSheet("Расчет");
				Cell calcDate = calc.getRow(6).getCell(12);
				calcDate.setCellValue(StringUtils.defaultString(calculationDate.getText()));

				Cell vin = calc.getRow(11).getCell(1);
				vin.setCellValue(StringUtils.defaultString(udVinInput.getText()));

				Cell mark = calc.getRow(11).getCell(2);
				if (udMarkCodeInput.getSelectedItem() != null) {
					mark.setCellValue(((MarkKind) udMarkCodeInput.getSelectedItem()).name());
				} else {
					mark.setCellValue("");
				}

				Cell model = calc.getRow(11).getCell(3);
				model.setCellValue(StringUtils.defaultString(udModelInput.getText()));

				Cell dateOfProduction = calc.getRow(11).getCell(4);
				dateOfProduction.setCellValue(StringUtils.defaultString(udManufactureDateInput.getText()));

				Cell kategory = calc.getRow(11).getCell(5);
				kategory.setCellValue(StringUtils.defaultString(udTransportCategoryCodeInput.getText()));

				Cell engineVolume = calc.getRow(11).getCell(6);
				engineVolume.setCellValue(StringUtils.defaultString(udEngineVolumeQuantityInput.getText()));

				Cell engineNumber = calc.getRow(11).getCell(7);
				engineNumber.setCellValue(StringUtils.defaultString(udEngineModelInput.getText()));

				Cell engineType = calc.getRow(11).getCell(8);
				if (udEngineModelCodeInput.getSelectedItem() != null) {
					engineType.setCellValue(((EngineCode) udEngineModelCodeInput.getSelectedItem()).description());
				} else {
					engineType.setCellValue("");
				}

				Cell mass = calc.getRow(11).getCell(9);
				mass.setCellValue(StringUtils.defaultString(udTotalWeightInput.getText()));

				Cell stavka = calc.getRow(11).getCell(10);
				stavka.setCellValue(StringUtils.defaultString(payDutyTaxFeeRateInput.getText()));

				Cell koef = calc.getRow(11).getCell(11);
				if (StringUtils.isNotEmpty(payCoefficientInput.getText())) {
					koef.setCellValue(Double.parseDouble(payCoefficientInput.getText()));
				} else {
					koef.setCellValue("");
				}


				BigDecimal payDuty = new BigDecimal(payDutyTaxFeeRateInput.getText());
				BigDecimal payCoef = new BigDecimal(payCoefficientInput.getText());
				BigDecimal mul = payDuty.multiply(payCoef);
				if (StringUtils.isNotEmpty(payImportCustomsDutyInput.getText()) || StringUtils.isNotEmpty(payVatInput.getText()) || StringUtils.isNotEmpty(payExciseInput.getText())) {
					BigDecimal b1 = StringUtils.isNotEmpty(payImportCustomsDutyInput.getText()) ? new BigDecimal(payImportCustomsDutyInput.getText()) : BigDecimal.ZERO;
					BigDecimal b2 = StringUtils.isNotEmpty(payVatInput.getText()) ? new BigDecimal(payVatInput.getText()) : BigDecimal.ZERO;
					BigDecimal b3 = StringUtils.isNotEmpty(payExciseInput.getText()) ? new BigDecimal(payExciseInput.getText()) : BigDecimal.ZERO;
					BigDecimal sum = b1.add(b2).add(b3);
					BigDecimal val = sum.add(mul);

					Cell total = calc.getRow(11).getCell(14);
					total.setCellValue(val.setScale(2, RoundingMode.HALF_UP).toString());
				} else {
					Cell total = calc.getRow(11).getCell(14);
					total.setCellValue(mul.setScale(2, RoundingMode.HALF_UP).toString());
				}
				Cell total = calc.getRow(11).getCell(13);
				total.setCellFormula(mul.setScale(2, RoundingMode.HALF_UP).toString());

				Cell epts = calc.getRow(11).getCell(15);
				epts.setCellValue(StringUtils.defaultString(udVehicleEPassportIdInput.getText()));

				Cell date = calc.getRow(18).createCell(7);
				date.setCellValue(StringUtils.defaultString(calculationDate.getText()));

				Cell payer = calc.getRow(19).getCell(7);
				payer.setCellValue(payerFio);

				Cell inn = calc.getRow(20).getCell(7);
				inn.setCellValue(StringUtils.defaultString(innInput.getText()));

				Cell passportCell = calc.getRow(21).getCell(7);
				passportCell.setCellValue(passport);

				Cell addressCell = calc.getRow(22).getCell(7);
				addressCell.setCellValue(payerAddress);

				Cell crossingDate = calc.getRow(24).getCell(7);
				if (StringUtils.isNotEmpty(payBorderCrossingDateInput.getText())) {
					crossingDate.setCellValue(payBorderCrossingDateInput.getText());
				} else {
					crossingDate.setCellValue("");
				}

				Cell personalUse = calc.getRow(25).getCell(7);
				if (this.udPersonalUseYN.isSelected()) {
					personalUse.setCellValue("да: V нет:   ");
				} else {
					personalUse.setCellValue("да:   нет: V ");
				}

				Cell fromBy = calc.getRow(26).getCell(7);
				if ("Беларусь".equals(c)) {
					fromBy.setCellValue("да: V нет:   ");
				} else {
					fromBy.setCellValue("да:   нет: V ");
				}

				Cell dtCell = calc.getRow(27).getCell(7);
				dtCell.setCellValue(StringUtils.defaultString(dt.getText()));

				var presentedDocs = data.getUtilCollDetails().get(0).getPresentedDocument();
				for (var doc : presentedDocs) {
					if ("03011".equals(doc.getDocKindCode())) {
						Cell contract = calc.getRow(28).getCell(12);
						contract.setCellValue(doc.getPrDocumentDate().toGregorianCalendar());
					}
					if (StringUtils.defaultString(udVehicleEPassportIdInput.getText()).equals(doc.getPrDocumentNumber())) {
						Cell eptsBottom = calc.getRow(28).getCell(9);
						eptsBottom.setCellValue(doc.getPrDocumentNumber());
						Cell eptsBottomDate = calc.getRow(28).getCell(10);
						eptsBottomDate.setCellValue("от " + new SimpleDateFormat("dd.MM.yyyy").format(doc.getPrDocumentDate().toGregorianCalendar().getTime()));
					}
				}

				Cell paymentDateCell = calc.getRow(29).getCell(4);
				paymentDateCell.setCellValue(StringUtils.defaultString(paymentDate.getText()));

				Cell paymentNumberCell = calc.getRow(29).getCell(5);
				paymentNumberCell.setCellValue(StringUtils.defaultString(paymentNumber.getText()));

				Cell phone = calc.getRow(34).getCell(0);
				phone.setCellValue("       по телефону " + StringUtils.defaultString(brokerPhoneInput.getText()) + " посредством СМС     или   Telegram");

				Cell email = calc.getRow(35).getCell(0);
				email.setCellValue("       по адресу электронной почты:  " + StringUtils.defaultString(brokerEmailInput.getText()));

				Cell broker = calc.getRow(36).getCell(0);
				broker.setCellValue(brokerFio);

				Cell calcDate2 = calc.getRow(36).getCell(12);
				calcDate2.setCellValue(StringUtils.defaultString(calculationDate.getText()));
			}

			document.setForceFormulaRecalculation(true);
			document.getCreationHelper().createFormulaEvaluator().evaluateAll();

			File xlsx = new File(xml.getParentFile(), xml.getName().replace(".xml", ".xlsx"));
			try (FileOutputStream out = new FileOutputStream(xlsx)) {
				document.write(out);
			}
		}
	}
}