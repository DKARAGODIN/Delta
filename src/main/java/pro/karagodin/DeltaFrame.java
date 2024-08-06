package pro.karagodin;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;
import ru.customs.commonaggregatetypes._5_22.RFOrganizationFeaturesType;
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
import javax.swing.JTextArea;
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


public class DeltaFrame extends BaseFrame implements ActionListener {

	private final XsdValidator xsdValidator = new XsdValidator();
	private final Unmarshaller jaxbUnmarshaller;
	private final Marshaller jaxbMarshaller;

	private RecyclingDetailsType data;

	public DeltaFrame() throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(RecyclingDetailsType.class);
		this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		this.jaxbMarshaller = jaxbContext.createMarshaller();

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
			messages.add(e.getMessage());
			messages.add("");
			for (StackTraceElement elem : e.getStackTrace()) {
				messages.add(elem.toString());
			}
			String message = String.join("\n", messages);

			JDialog d = new JDialog(this, "Ошибка");
			JTextArea a = new JTextArea();
			a.setEditable(false);
			a.setText(message);
			d.add(a);
			d.setSize(500, 500);
			d.setLocationRelativeTo(null);
			d.setVisible(true);
		}
	}

	private void saveFile() throws JAXBException, DatatypeConfigurationException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Сохранить файл");
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			fillDataFromFields();
			File file = fileChooser.getSelectedFile();
			JAXBElement<RecyclingDetailsType> element = new ObjectFactory().createRecyclingDetails(data);
			jaxbMarshaller.marshal(element, file);
		}
	}

	private void openFile() throws IOException, SAXException, JAXBException {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Выберите файл");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String xml = Files.readString(fileChooser.getSelectedFile().toPath());
			xsdValidator.validate(xml);
			data = jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml)), RecyclingDetailsType.class).getValue();

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
				countryNameInput.setText(address.getAddressText());
				regionNameInput.setText(address.getRegion());
				cityNameInput.setText(address.getCity());
				streetNameInput.setText(address.getStreetHouse());
				houseNumberInput.setText(address.getHouse());
				roomInput.setText(address.getRoom());
			}
			RUIdentityCardType card = payer.getIdentityDoc();
			if (card != null) {
				identityCardCodeInput.setText(card.getIdentityCardCode());
				identityCardNameInput.setText(card.getIdentityCardName());
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
				BigDecimal enginePowerQuantity = vehicleType.getEnginePowerQuanityType();
				if (enginePowerQuantity != null) {
					udEngineVolumeQuantityInput.setText(enginePowerQuantity.toPlainString());
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
		}
		surNameInput.setText(data.getPayer().get(0).getPerson().getPersonSurname());
	}

	private void fillDataFromFields() throws DatatypeConfigurationException {
		if (data == null)
			data = new RecyclingDetailsType();
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
		address.setCity(cityNameInput.getText());
		address.setStreetHouse(streetNameInput.getText());
		address.setHouse(houseNumberInput.getText());
		address.setRoom(roomInput.getText());
		payer.setTPOAddress(address);

		RUIdentityCardType identity = payer.getIdentityDoc();
		if (identity == null)
			identity = new RUIdentityCardType();
		identity.setIdentityCardCode(identityCardCodeInput.getText());
		identity.setIdentityCardName(identityCardNameInput.getText());
		identity.setIdentityCardSeries(identityCardSeriesInput.getText());
		identity.setIdentityCardNumber(identityCardNumberInput.getText());
		{
			Date d = (Date) identityCardDateInput.getValue();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(d);
			XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
			identity.setDocValidityDate(d2);
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
		vehicleType.setMark(udModelInput.getText());
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
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(d);
			XMLGregorianCalendar d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
			VehicleProdDateType vehicleProdDateType = new VehicleProdDateType();
			vehicleProdDateType.setManufactureDate(d2);
			vehicleType.setVehicleProdDate(vehicleProdDateType);
		}
		utilDetails.setVINID(udVinInput.getText());
	}
}
