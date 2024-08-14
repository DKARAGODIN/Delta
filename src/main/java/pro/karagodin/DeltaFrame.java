package pro.karagodin;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
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
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.file.Files;
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
				saveFile();
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
			d.setSize(500, 500);
			d.setLocationRelativeTo(null);
			d.setVisible(true);
		}
	}

	private void saveFile() throws JAXBException, DatatypeConfigurationException, IOException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Сохранить файл");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			fillDataFromFields();
			OfficeUtils.createDoc(data);
			OfficeUtils.createCalc(data);
			File file = fileChooser.getSelectedFile();
			JAXBElement<RecyclingDetailsType> element = new ObjectFactory().createRecyclingDetails(data);
			XmlUtils.marshall(element, file);
		}
	}

	private void openFile() throws IOException, SAXException, JAXBException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Выберите файл");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String xml = Files.readString(fileChooser.getSelectedFile().toPath());
			XmlUtils.validate(xml);
			data = XmlUtils.unMarshall(new StreamSource(new StringReader(xml)), RecyclingDetailsType.class).getValue();

			fillFieldsFromData();
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
				registrationInput.setText(address.getAddressKindCode());
				countryCodeInput.setText(address.getCountryCode());
				countryNameInput.setText(address.getCounryName());
				regionNameInput.setText(address.getRegion());
				townNameInput.setText(address.getTown());
				streetNameInput.setText(address.getStreetHouse());
				houseNumberInput.setText(address.getHouse());
				roomInput.setText(address.getRoom());
			}
			RUIdentityCardType card = payer.getIdentityDoc();
			if (card != null) {
				identityCardCodeInput.setText(card.getIdentityCardCode());
				fullIdentityCardNameInput.setText(card.getFullIdentityCardName());
				identityCardSeriesInput.setText(card.getIdentityCardSeries());
				identityCardNumberInput.setText(card.getIdentityCardNumber());
				XMLGregorianCalendar calendar = card.getIdentityCardDate();
				if (calendar != null) {
					identityCardDateInput.setValue(calendar.toGregorianCalendar().getTime());
				}
				identityOrganisationNameInput.setText(card.getOrganizationName());
				identityIssuerCodeInput.setText(card.getIssuerCode());
				identityCountryCodeInput.setText(card.getCountryCode());
			}
		}
		List<UtilCollDetailsType> utils = data.getUtilCollDetails();
		if (!utils.isEmpty()) {
			UtilCollDetailsType util = utils.get(0);
			udVehicleEPassportIdInput.setText(util.getVehicleEPassportId());
			udSignInput.setText(util.getSign());
			udTransportKindCodeInput.setText(util.getTransportKindCode());
			VehicleType vehicleType = util.getVehicle();
			if (vehicleType != null) {
				udTransportCategoryCodeInput.setText(vehicleType.getTransportCategoryCode());
				udMarkCodeInput.setText(vehicleType.getMarkCode());
				udMarkInput.setText(vehicleType.getMark());
				udModelInput.setText(vehicleType.getModel());
				BigDecimal engineVolumeQuanity = vehicleType.getEngineVolumeQuanity();
				if (engineVolumeQuanity != null) {
					udEngineVolumeQuantityInput.setText(engineVolumeQuanity.toPlainString());
				}
				List<EngineType> engines = vehicleType.getEngine();
				if (!engines.isEmpty()) {
					EngineType engine = engines.get(0);
					udEngineModelCodeInput.setText(engine.getEngineModeCode());
					udEngineModelNameInput.setText(engine.getEngineModeName());
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
			for (int i = 0; i < 5 || documents.size() < i; i++) {
				if (i == 0) {
					AttachedDocumentType doc = documents.get(0);
					doc1KindCodeInput.setText(doc.getDocKindCode());
					doc1NameInput.setText(doc.getPrDocumentName());
					doc1NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc1DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 1) {
					AttachedDocumentType doc = documents.get(1);
					doc2KindCodeInput.setText(doc.getDocKindCode());
					doc2NameInput.setText(doc.getPrDocumentName());
					doc2NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc2DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 2) {
					AttachedDocumentType doc = documents.get(2);
					doc3KindCodeInput.setText(doc.getDocKindCode());
					doc3NameInput.setText(doc.getPrDocumentName());
					doc3NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc3DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 3) {
					AttachedDocumentType doc = documents.get(3);
					doc4KindCodeInput.setText(doc.getDocKindCode());
					doc4NameInput.setText(doc.getPrDocumentName());
					doc4NumberInput.setText(doc.getPrDocumentNumber());
					XMLGregorianCalendar cal = doc.getPrDocumentDate();
					if (cal != null) {
						doc4DateInput.setValue(cal.toGregorianCalendar().getTime());
					}
				} else if (i == 4) {
					AttachedDocumentType doc = documents.get(4);
					doc5KindCodeInput.setText(doc.getDocKindCode());
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
		if (data == null) {
			data = new RecyclingDetailsType();
			data.setDocumentModeID("1002048E");
			data.setDocumentID(UUID.randomUUID().toString());
			data.setDocType(BigDecimal.ONE);
		}
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
		personType.setPersonMiddleName(middleNameInput.getText());
		payer.setPerson(personType);

		RFOrganizationFeaturesType rfOrganizationFeaturesType = payer.getRFOrganizationFeatures();
		if (rfOrganizationFeaturesType == null)
			rfOrganizationFeaturesType = new RFOrganizationFeaturesType();
		rfOrganizationFeaturesType.setINN(innInput.getText());
		payer.setRFOrganizationFeatures(rfOrganizationFeaturesType);

		RUAddressType address = payer.getTPOAddress();
		if (address == null)
			address = new RUAddressType();
		address.setAddressKindCode(registrationInput.getText());
		address.setCountryCode(countryCodeInput.getText());
		address.setCounryName(countryNameInput.getText());
		address.setRegion(regionNameInput.getText());
		address.setTown(townNameInput.getText());
		address.setStreetHouse(streetNameInput.getText());
		address.setHouse(houseNumberInput.getText());
		address.setRoom(roomInput.getText());
		payer.setTPOAddress(address);

		RUIdentityCardType identity = payer.getIdentityDoc();
		if (identity == null)
			identity = new RUIdentityCardType();
		identity.setIdentityCardCode(identityCardCodeInput.getText());
		identity.setFullIdentityCardName(fullIdentityCardNameInput.getText());
		identity.setIdentityCardSeries(identityCardSeriesInput.getText());
		identity.setIdentityCardNumber(identityCardNumberInput.getText());
		{
			Date d = (Date) identityCardDateInput.getValue();
			if (d != null) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				identity.setDocValidityDate(d2);
			}
		}
		identity.setOrganizationName(identityOrganisationNameInput.getText());
		identity.setIssuerCode(identityIssuerCodeInput.getText());
		identity.setCountryCode(identityCountryCodeInput.getText());
		payer.setIdentityDoc(identity);

		List<UtilCollDetailsType> utilCollDetailsTypes = data.getUtilCollDetails();
		UtilCollDetailsType utilDetails;
		if (utilCollDetailsTypes.isEmpty()) {
			utilDetails = new UtilCollDetailsType();
			utilCollDetailsTypes.add(utilDetails);
		} else {
			utilDetails = utilCollDetailsTypes.get(0);
		}
		utilDetails.setVehicleEPassportId(udVehicleEPassportIdInput.getText());
		utilDetails.setSign(udSignInput.getText());
		utilDetails.setTransportKindCode(udTransportKindCodeInput.getText());

		VehicleType vehicleType = utilDetails.getVehicle();
		if (vehicleType == null) {
			vehicleType = new VehicleType();
		}
		vehicleType.setTransportCategoryCode(udTransportCategoryCodeInput.getText());
		vehicleType.setMarkCode(udMarkCodeInput.getText());
		vehicleType.setMark(udMarkInput.getText());
		vehicleType.setModel(udModelInput.getText());
		vehicleType.setEngineVolumeQuanity(StringUtils.isEmpty(udEngineVolumeQuantityInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(udEngineVolumeQuantityInput.getText()));
		utilDetails.setVehicle(vehicleType);

		List<EngineType> engines = vehicleType.getEngine();
		EngineType engine;
		if (engines.isEmpty()) {
			engine = new EngineType();
			engines.add(engine);
		} else {
			engine = engines.get(0);
		}
		engine.setEngineModeCode(udEngineModelCodeInput.getText());
		engine.setEngineModeName(udEngineModelNameInput.getText());
		engine.setEngineModel(udEngineModelInput.getText());
		engine.setEnginePowerKvtQuanity(StringUtils.isEmpty(udEnginePowerKvtInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(udEnginePowerKvtInput.getText()));
		vehicleType.setTotalWeight(StringUtils.isEmpty(udTotalWeightInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(udTotalWeightInput.getText()));
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
		utilDetails.setVINID(udVinInput.getText());
		utilDetails.setImportCustomsDuty(StringUtils.isEmpty(payImportCustomsDutyInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(payImportCustomsDutyInput.getText()));
		utilDetails.setExcise(StringUtils.isEmpty(payExciseInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(payExciseInput.getText()));
		utilDetails.setVAT(StringUtils.isEmpty(payVatInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(payVatInput.getText()));
		{
			Date d = (Date) payBorderCrossingDateInput.getValue();
			if (d != null) {
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(d);
				XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				utilDetails.setBorderCrossingDate(d2);
			}
		}
		utilDetails.setDutyTaxFeeRateValue(StringUtils.isEmpty(payDutyTaxFeeRateInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(payDutyTaxFeeRateInput.getText()));
		utilDetails.setCoefficient(StringUtils.isEmpty(payCoefficientInput.getText()) ?
				BigDecimal.ZERO : new BigDecimal(payCoefficientInput.getText()));

		List<AttachedDocumentType> newDocuments = new ArrayList<>();
		fillDoc(newDocuments, doc1KindCodeInput, doc1NameInput, doc1NumberInput, doc1DateInput);
		fillDoc(newDocuments, doc2KindCodeInput, doc2NameInput, doc2NumberInput, doc2DateInput);
		fillDoc(newDocuments, doc3KindCodeInput, doc3NameInput, doc3NumberInput, doc3DateInput);
		fillDoc(newDocuments, doc4KindCodeInput, doc4NameInput, doc4NumberInput, doc4DateInput);
		fillDoc(newDocuments, doc5KindCodeInput, doc5NameInput, doc5NumberInput, doc5DateInput);
		utilDetails.getPresentedDocument().clear();
		utilDetails.getPresentedDocument().addAll(newDocuments);
	}

	private void fillDoc(List<AttachedDocumentType> newDocuments, JTextField doc5KindCodeInput, JTextField doc5NameInput, JTextField doc5NumberInput, JFormattedTextField doc5DateInput) throws DatatypeConfigurationException {
		if (StringUtils.isNotEmpty(doc5KindCodeInput.getText())) {
			AttachedDocumentType doc = new AttachedDocumentType();
			doc.setDocKindCode(doc5KindCodeInput.getText());
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
}