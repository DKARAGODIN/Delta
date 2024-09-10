package pro.karagodin;

import org.apache.commons.lang3.StringUtils;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.DateFormatter;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public abstract class BaseFrame extends JFrame implements ActionListener {
	private static final Font appFont = new Font("Arial", Font.PLAIN, 15);

	protected final JButton save = new JButton("Сохранить XML");
	protected final JButton open = new JButton("Открыть XML");
	protected final JButton clear = new JButton("Очистить");
	protected final JButton saveBroker = new JButton("Сохранить Брокера");
	protected final JButton openBroker = new JButton("Открыть Брокера");

	protected final JTextField surNameInput = new JTextField();
	protected final JLabel surNameLabel = new JLabel();

	protected final JTextField nameInput = new JTextField();
	protected final JLabel nameLabel = new JLabel();

	protected final JTextField middleNameInput = new JTextField();

	protected final JTextField innInput = new JTextField();
	protected final JLabel innLabel = new JLabel();

	protected final JComboBox<String> registrationInput = new JComboBox<>();
	protected final JComboBox<String> countryCodeInput = new JComboBox<>();
	protected final JTextField countryNameInput = new JTextField();
	protected final JTextField regionNameInput = new JTextField();
	protected final JTextField townNameInput = new JTextField();
	protected final JTextField streetNameInput = new JTextField();
	protected final JTextField houseNumberInput = new JTextField();
	protected final JTextField roomInput = new JTextField();
	protected final JComboBox<IdentityCardCode> identityCardCodeInput = new JComboBox<>();
	protected final JTextField identityCardSeriesInput = new JTextField();
	protected final JTextField identityCardNumberInput = new JTextField();
	protected final JFormattedTextField identityCardDateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		identityCardDateInput = new JFormattedTextField(df);
	}
	protected final JTextField identityOrganisationNameInput = new JTextField();
	protected final JTextField identityIssuerCodeInput = new JTextField();
	protected final JComboBox<String> identityCountryCodeInput = new JComboBox<>();
	protected final JFormattedTextField bdInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		bdInput = new JFormattedTextField(df);
	}
	protected final JTextField udVehicleEPassportIdInput = new JTextField();
	protected final JComboBox<String> udSignInput = new JComboBox<>();
	protected final JComboBox<TransportKind> udTransportKindCodeInput = new JComboBox<>();

	protected final JTextField udTransportCategoryCodeInput = new JTextField();
	protected final JLabel udTransportCategoryCodeLabel = new JLabel();

	protected final JComboBox<MarkKind> udMarkCodeInput = new JComboBox<>();
	protected final JTextField udModelInput = new JTextField();
	protected final JTextField udEngineVolumeQuantityInput = new JTextField();
	protected final JComboBox<EngineCode> udEngineModelCodeInput = new JComboBox<>();
	protected final JCheckBox udElectricEngineYN = new JCheckBox();
	protected final JCheckBox udPersonalUseYN = new JCheckBox();
	protected final JTextField udEngineModelInput = new JTextField();
	protected final JTextField udEnginePowerKvtInput = new JTextField();
	protected final JTextField udTotalWeightInput = new JTextField();
	protected final JFormattedTextField udManufactureDateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		udManufactureDateInput = new JFormattedTextField(df);
	}
	protected final JTextField udVinInput = new JTextField();
	protected final JLabel udVinLabel = new JLabel();
	protected final JTextField payImportCustomsDutyInput = new JTextField();
	protected final JTextField payExciseInput = new JTextField();
	protected final JTextField payVatInput = new JTextField();
	protected final JFormattedTextField payBorderCrossingDateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		payBorderCrossingDateInput = new JFormattedTextField(df);
	}
	protected final JTextField payDutyTaxFeeRateInput = new JTextField();
	protected final JTextField payCoefficientInput = new JTextField();
	protected final JComboBox<String> doc1KindCodeInput = new JComboBox<>();
	protected final JTextField doc1NameInput = new JTextField();
	protected final JTextField doc1NumberInput = new JTextField();
	protected final JFormattedTextField doc1DateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		doc1DateInput = new JFormattedTextField(df);
	}
	protected final JComboBox<String> doc2KindCodeInput = new JComboBox<>();
	protected final JTextField doc2NameInput = new JTextField();
	protected final JTextField doc2NumberInput = new JTextField();
	protected final JFormattedTextField doc2DateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		doc2DateInput = new JFormattedTextField(df);
	}
	protected final JComboBox<String> doc3KindCodeInput = new JComboBox<>();
	protected final JTextField doc3NameInput = new JTextField();
	protected final JTextField doc3NumberInput = new JTextField();
	protected final JFormattedTextField doc3DateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		doc3DateInput = new JFormattedTextField(df);
	}
	protected final JComboBox<String> doc4KindCodeInput = new JComboBox<>();
	protected final JTextField doc4NameInput = new JTextField();
	protected final JTextField doc4NumberInput = new JTextField();
	protected final JFormattedTextField doc4DateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		doc4DateInput = new JFormattedTextField(df);
	}
	protected final JComboBox<String> doc5KindCodeInput = new JComboBox<>();
	protected final JTextField doc5NameInput = new JTextField();
	protected final JTextField doc5NumberInput = new JTextField();
	protected final JFormattedTextField doc5DateInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		doc5DateInput = new JFormattedTextField(df);
	}
	protected final JTextField brokerSurNameInput = new JTextField();
	protected final JTextField brokerNameInput = new JTextField();
	protected final JTextField brokerMiddleNameInput = new JTextField();
	protected final JFormattedTextField brokerBdInput;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		brokerBdInput = new JFormattedTextField(df);
	}
	protected final JTextField brokerPassportInput = new JTextField();
	protected final JTextField brokerPassportIssueInput = new JTextField();
	protected final JTextField brokerAddressInput = new JTextField();
	protected final JTextField brokerEmailInput = new JTextField();
	protected final JTextField brokerPhoneInput = new JTextField();
	protected final JComboBox<String> countryOfImport = new JComboBox<>();
	protected final JFormattedTextField calculationDate;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		calculationDate = new JFormattedTextField(df);
	}
	protected final JTextField dt = new JTextField();
	protected final JFormattedTextField paymentDate;
	{
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		DateFormatter df = new DateFormatter(format);
		paymentDate = new JFormattedTextField(df);
	}
	protected final JTextField paymentNumber = new JTextField();

	private final List<JLabel> labels;
	private final List<Runnable> checkers;

	public BaseFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1400,920);
		setLayout(null);
		setResizable(true);
		setLocationRelativeTo(null);

		Container container = getContentPane();

		open.setFont(appFont);
		open.setSize(150, 20);
		open.setLocation( 800, 800);
		open.addActionListener(this);
		container.add(open);

		save.setFont(appFont);
		save.setSize(150, 20);
		save.setLocation(950, 800);
		save.addActionListener(this);
		container.add(save);

		clear.setFont(appFont);
		clear.setSize(150, 20);
		clear.setLocation(1100, 800);
		clear.addActionListener(this);
		container.add(clear);

		openBroker.setFont(appFont);
		openBroker.setSize(175, 20);
		openBroker.setLocation( 800, 820);
		openBroker.addActionListener(this);
		container.add(openBroker);

		saveBroker.setFont(appFont);
		saveBroker.setSize(175, 20);
		saveBroker.setLocation(975, 820);
		saveBroker.addActionListener(this);
		container.add(saveBroker);


		// Фамилия плательщика
		addComponentToFrame(new JLabel("Фамилия плательщика"), 5, 0);
		addComponentToFrame(surNameInput, 250, 0);
		addComponentToFrame(surNameLabel, 500, 0);
		surNameLabel.setSize(300, 20);
		surNameLabel.setText("Обязательное поле");
		Runnable surNameChecker = () -> {
			String value = surNameInput.getText();
			if (StringUtils.isEmpty(value)) {
				surNameLabel.setText("Обязательное поле");
			} else {
				surNameLabel.setText("");
			}
		};
		surNameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				surNameChecker.run();
			}
		});

		//Имя плательщика
		addComponentToFrame(new JLabel("Имя плательщика"), 5, 20);
		addComponentToFrame(nameInput, 250, 20);
		addComponentToFrame(nameLabel, 500, 20);
		nameLabel.setSize(300, 20);
		nameLabel.setText("Обязательное поле");
		Runnable nameChecker = () -> {
			String value = nameInput.getText();
			if (StringUtils.isEmpty(value)) {
				nameLabel.setText("Обязательное поле");
			} else {
				nameLabel.setText("");
			}
		};
		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nameChecker.run();
			}
		});

		//Отчество плательщика
		addComponentToFrame(new JLabel("Отчество плательщика"), 5, 40);
		addComponentToFrame(middleNameInput, 250, 40);

		//ИНН
		addComponentToFrame(new JLabel("ИНН"), 5, 60);
		addComponentToFrame(innInput, 250, 60);
		addComponentToFrame(innLabel, 500, 60);
		innLabel.setSize(300, 20);
		Runnable innChecker = () -> {
			String value = innInput.getText();
			if (StringUtils.isEmpty(value)) {
				innLabel.setText("");
			} else {
				int l = value.length();
				if (l == 10 || l == 12) {
					innLabel.setText("");
				} else {
					innLabel.setText("ИНН должен быть 10 или 12 символов");
				}
				for (char c : value.toCharArray()) {
					if (!Character.isDigit(c)) {
						innLabel.setText("ИНН должен состоять только из цифр");
					}
				}
			}
		};
		innInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				innChecker.run();
			}
		});

		//Признак постоянной регистрации
		JLabel registrationHeader = new JLabel("Признак постоянной регистрации");
		registrationHeader.setToolTipText("\"1\" - адрес регистрации; \"2\" - фактический адрес; \"3\" - почтовый адрес");
		registrationInput.setToolTipText("\"1\" - адрес регистрации; \"2\" - фактический адрес; \"3\" - почтовый адрес");
		addComponentToFrame(registrationHeader, 5, 80);
		registrationInput.addItem(null);
		registrationInput.addItem("1");
		registrationInput.addItem("2");
		registrationInput.addItem("3");
		addComponentToFrame(registrationInput, 250, 80);
		addComponentToFrame(new JLabel("Код страны"), 5, 100);
		addComponentToFrame(countryCodeInput, 250, 100);
		countryCodeInput.addItem(null);
		countryCodeInput.addItem("RU");
		countryCodeInput.addItem("KZ");
		countryCodeInput.addItem("KG");
		countryCodeInput.addItem("BY");
		countryCodeInput.addItem("AM");
		countryCodeInput.addItemListener(e -> {
			if (e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
					String value = (String) cb.getSelectedItem();
					switch (value) {
						case "RU":
							countryNameInput.setText("Россия");
							break;
						case "KZ":
							countryNameInput.setText("Казахстан");
							break;
						case "KG":
							countryNameInput.setText("Кыргызстан");
							break;
						case "BY":
							countryNameInput.setText("Беларусь");
							break;
						case "AM":
							countryNameInput.setText("Армения");
							break;
						default:
							countryNameInput.setText("");
					}
				} else {
					countryNameInput.setText(null);
				}
			}
		});
		addComponentToFrame(new JLabel("Наименование страны"), 5, 120);
		addComponentToFrame(countryNameInput, 250, 120);
		countryNameInput.setEditable(false);
		addComponentToFrame(new JLabel("Наименование региона"), 5, 140);
		addComponentToFrame(regionNameInput, 250, 140);
		addComponentToFrame(new JLabel("Наименование города"), 5, 160);
		addComponentToFrame(townNameInput, 250, 160);
		addComponentToFrame(new JLabel("Наименование улицы"), 5, 180);
		addComponentToFrame(streetNameInput, 250, 180);
		addComponentToFrame(new JLabel("Номер дома"), 5, 200);
		addComponentToFrame(houseNumberInput, 250, 200);
		addComponentToFrame(new JLabel("Номер квартиры"), 5, 220);
		addComponentToFrame(roomInput, 250, 220);

		addComponentToFrame(new JLabel("Наименование документа УЛ"), 5, 240);
		identityCardCodeInput.setFont(appFont);
		identityCardCodeInput.setSize(500, 20);
		identityCardCodeInput.setLocation(250, 240);
		getContentPane().add(identityCardCodeInput);
		identityCardCodeInput.addItem(null);
		IdentityCardCode.cache.values().forEach(identityCardCodeInput::addItem);

		addComponentToFrame(new JLabel("Серия документа УЛ"), 5, 260);
		addComponentToFrame(identityCardSeriesInput, 250, 260);
		addComponentToFrame(new JLabel("Номер документа УЛ"), 5, 280);
		addComponentToFrame(identityCardNumberInput, 250, 280);
		addComponentToFrame(new JLabel("Дата документа УЛ (dd.MM.yyyy)"), 5, 300);
		addComponentToFrame(identityCardDateInput, 250, 300);
		addComponentToFrame(new JLabel("Орган выдавший документ УЛ"), 5, 320);
		addComponentToFrame(identityOrganisationNameInput, 250, 320);
		addComponentToFrame(new JLabel("Код подразделения выдавшего УЛ"), 5, 340);
		addComponentToFrame(identityIssuerCodeInput, 250, 340);
		addComponentToFrame(new JLabel("Код страны органа выдавшего УЛ"), 5, 360);
		addComponentToFrame(identityCountryCodeInput, 250, 360);
		identityCountryCodeInput.addItem(null);
		identityCountryCodeInput.addItem("RU");
		identityCountryCodeInput.addItem("KZ");
		identityCountryCodeInput.addItem("KG");
		identityCountryCodeInput.addItem("BY");
		identityCountryCodeInput.addItem("AM");
		addComponentToFrame(new JLabel("Дата рождения"), 5, 380);
		addComponentToFrame(bdInput, 250, 380);

		//Раздел 2
		addComponentToFrame(new JLabel("Номер ЭПТС"), 5, 420);
		addComponentToFrame(udVehicleEPassportIdInput, 250, 420);
		addComponentToFrame(new JLabel("Признак ТС"), 5, 440);
		addComponentToFrame(udSignInput, 250, 440);
		udSignInput.setToolTipText("«К» - колесное транспортное средство, «С» - самоходная машина");
		udSignInput.addItem("К");
		udSignInput.addItem("С");

		addComponentToFrame(new JLabel("Вид ТС"), 5, 460);
		addComponentToFrame(udTransportKindCodeInput, 250, 460);
		udTransportKindCodeInput.addItem(null);
		TransportKind.cache.values().forEach(udTransportKindCodeInput::addItem);
		addComponentToFrame(new JLabel("Категория ТС"), 5, 480);
		addComponentToFrame(udTransportCategoryCodeInput, 250, 480);
		addComponentToFrame(udTransportCategoryCodeLabel, 500, 480);
		Runnable categoryChecker = () -> {
			String value = udTransportCategoryCodeInput.getText();
			if (StringUtils.isEmpty(value)) {
				udTransportCategoryCodeLabel.setText("");
			} else {
				if (value.matches("^[a-zA-Z0-9.]+$")) {
					udTransportCategoryCodeLabel.setText("");
				} else {
					udTransportCategoryCodeLabel.setText("Использованы не латинские символы");
				}
			}
		};
		udTransportCategoryCodeInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				categoryChecker.run();
			}
		});

		addComponentToFrame(new JLabel("Код марки ТС"), 5, 500);
		addComponentToFrame(udMarkCodeInput, 250, 500);
		udMarkCodeInput.addItem(null);
		MarkKind.cache.values().forEach(udMarkCodeInput::addItem);
		AutoCompletion.enable(udMarkCodeInput);

		addComponentToFrame(new JLabel("Модель ТС"), 5, 520);
		addComponentToFrame(udModelInput, 250, 520);
		addComponentToFrame(new JLabel("Объем двигателя"), 5, 540);
		addComponentToFrame(udEngineVolumeQuantityInput, 250, 540);
		addComponentToFrame(new JLabel("Код типа двигателя"), 5, 560);
		addComponentToFrame(udEngineModelCodeInput, 250, 560);
		udEngineModelCodeInput.addItem(null);
		EngineCode.cache.values().forEach(udEngineModelCodeInput::addItem);

		addComponentToFrame(new JLabel("Электрический двигатель"), 5, 580);
		addComponentToFrame(udElectricEngineYN, 250, 580);
		addComponentToFrame(new JLabel("ТС для личного пользования"), 5, 600);
		addComponentToFrame(udPersonalUseYN, 250, 600);

		addComponentToFrame(new JLabel("Модель двигателя"), 5, 620);
		addComponentToFrame(udEngineModelInput, 250, 620);
		addComponentToFrame(new JLabel("Мощность двигателя КВТ"), 5, 640);
		addComponentToFrame(udEnginePowerKvtInput, 250, 640);
		addComponentToFrame(new JLabel("Максимальная масса ТОНН"), 5, 660);
		addComponentToFrame(udTotalWeightInput, 250, 660);
		addComponentToFrame(new JLabel("Дата производства (dd.MM.yyyy)"), 5, 680);
		addComponentToFrame(udManufactureDateInput, 250, 680);
		addComponentToFrame(new JLabel("Идентификационный номер"), 5, 700);
		addComponentToFrame(udVinInput, 250, 700);
		addComponentToFrame(udVinLabel, 500, 700);
		udVinLabel.setSize(300, 20);
		Runnable vinChecker = () -> {
			String value = udVinInput.getText();
			if (value != null && value.length() > 17) {
				udVinLabel.setText("Превышена длинна поля 17");
			} else {
				udVinLabel.setText("");
			}
		};
		udVinInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				vinChecker.run();
			}
		});

		//Раздел 3
		addComponentToFrame(new JLabel("Разница в таможенной пошлине"), 5, 740);
		addComponentToFrame(payImportCustomsDutyInput, 250, 740);
		addComponentToFrame(new JLabel("Разница в акцизе"), 5, 760);
		addComponentToFrame(payExciseInput, 250, 760);
		addComponentToFrame(new JLabel("Разница в НДС"), 5, 780);
		addComponentToFrame(payVatInput, 250, 780);
		addComponentToFrame(new JLabel("Дата пересечения границы (dd.MM.yyyy)"), 5, 800);
		addComponentToFrame(payBorderCrossingDateInput, 250, 800);
		addComponentToFrame(new JLabel("Базовая ставка УС"), 5, 820);
		addComponentToFrame(payDutyTaxFeeRateInput, 250, 820);
		addComponentToFrame(new JLabel("Коэффициент"), 5, 840);
		addComponentToFrame(payCoefficientInput, 250, 840);

		//Раздел 4
		addComponentToFrame(new JLabel("Документ 1. Код"), 800, 0);
		addComponentToFrame(doc1KindCodeInput, 1050, 0);
		fillDocumentComponents(doc1KindCodeInput, doc1NameInput, doc1NumberInput, doc1DateInput);
		addComponentToFrame(new JLabel("Документ 1. Наименование"), 800, 20);
		addComponentToFrame(doc1NameInput, 1050, 20);
		addComponentToFrame(new JLabel("Документ 1. Номер"), 800, 40);
		addComponentToFrame(doc1NumberInput, 1050, 40);
		addComponentToFrame(new JLabel("Документ 1. Дата"), 800, 60);
		addComponentToFrame(doc1DateInput, 1050, 60);

		addComponentToFrame(new JLabel("Документ 2. Код"), 800, 80);
		addComponentToFrame(doc2KindCodeInput, 1050, 80);
		fillDocumentComponents(doc2KindCodeInput, doc2NameInput, doc2NumberInput, doc2DateInput);
		addComponentToFrame(new JLabel("Документ 2. Наименование"), 800, 100);
		addComponentToFrame(doc2NameInput, 1050, 100);
		addComponentToFrame(new JLabel("Документ 2. Номер"), 800, 120);
		addComponentToFrame(doc2NumberInput, 1050, 120);
		addComponentToFrame(new JLabel("Документ 2. Дата"), 800, 140);
		addComponentToFrame(doc2DateInput, 1050, 140);

		addComponentToFrame(new JLabel("Документ 3. Код"), 800, 160);
		addComponentToFrame(doc3KindCodeInput, 1050, 160);
		fillDocumentComponents(doc3KindCodeInput, doc3NameInput, doc3NumberInput, doc3DateInput);
		addComponentToFrame(new JLabel("Документ 3. Наименование"), 800, 180);
		addComponentToFrame(doc3NameInput, 1050, 180);
		addComponentToFrame(new JLabel("Документ 3. Номер"), 800, 200);
		addComponentToFrame(doc3NumberInput, 1050, 200);
		addComponentToFrame(new JLabel("Документ 3. Дата"), 800, 220);
		addComponentToFrame(doc3DateInput, 1050, 220);

		addComponentToFrame(new JLabel("Документ 4. Код"), 800, 240);
		addComponentToFrame(doc4KindCodeInput, 1050, 240);
		fillDocumentComponents(doc4KindCodeInput, doc4NameInput, doc4NumberInput, doc4DateInput);
		addComponentToFrame(new JLabel("Документ 4. Наименование"), 800, 260);
		addComponentToFrame(doc4NameInput, 1050, 260);
		addComponentToFrame(new JLabel("Документ 4. Номер"), 800, 280);
		addComponentToFrame(doc4NumberInput, 1050, 280);
		addComponentToFrame(new JLabel("Документ 4. Дата"), 800, 300);
		addComponentToFrame(doc4DateInput, 1050, 300);

		addComponentToFrame(new JLabel("Документ 5. Код"), 800, 320);
		addComponentToFrame(doc5KindCodeInput, 1050, 320);
		fillDocumentComponents(doc5KindCodeInput, doc5NameInput, doc5NumberInput, doc5DateInput);
		addComponentToFrame(new JLabel("Документ 5. Наименование"), 800, 340);
		addComponentToFrame(doc5NameInput, 1050, 340);
		addComponentToFrame(new JLabel("Документ 5. Номер"), 800, 360);
		addComponentToFrame(doc5NumberInput, 1050, 360);
		addComponentToFrame(new JLabel("Документ 5. Дата"), 800, 380);
		addComponentToFrame(doc5DateInput, 1050, 380);

		//Раздел 5
		addComponentToFrame(new JLabel("Фамилия представителя"), 800, 540);
		addComponentToFrame(brokerSurNameInput, 1050, 540);
		addComponentToFrame(new JLabel("Имя представителя"), 800, 560);
		addComponentToFrame(brokerNameInput, 1050, 560);
		addComponentToFrame(new JLabel("Отчество представителя"), 800, 580);
		addComponentToFrame(brokerMiddleNameInput, 1050, 580);
		addComponentToFrame(new JLabel("Дата рождения представителя"), 800, 600);
		addComponentToFrame(brokerBdInput, 1050, 600);
		addComponentToFrame(new JLabel("Серия и номер паспорта представителя"), 800, 620);
		addComponentToFrame(brokerPassportInput, 1050, 620);
		addComponentToFrame(new JLabel("Когда и кем выдан"), 800, 640);
		addComponentToFrame(brokerPassportIssueInput, 1050, 640);
		addComponentToFrame(new JLabel("Адрес представителя"), 800, 660);
		addComponentToFrame(brokerAddressInput, 1050, 660);
		addComponentToFrame(new JLabel("Контактный e-mail"), 800, 680);
		addComponentToFrame(brokerEmailInput, 1050, 680);
		addComponentToFrame(new JLabel("Контактный номер телефона"), 800, 700);
		addComponentToFrame(brokerPhoneInput, 1050, 700);

		addComponentToFrame(new JLabel("Страна ввоза"), 800, 420);
		addComponentToFrame(countryOfImport, 1050, 420);
		countryOfImport.addItem(null);
		countryOfImport.addItem("KZ");
		countryOfImport.addItem("KG");
		countryOfImport.addItem("AM");
		countryOfImport.addItem("BY");

		addComponentToFrame(new JLabel("Дата расчета"), 800, 440);
		addComponentToFrame(calculationDate, 1050, 440);
		addComponentToFrame(new JLabel("ДТ/ТПО"), 800, 460);
		addComponentToFrame(dt, 1050, 460);
		addComponentToFrame(new JLabel("Подтверждение уплаты УС. Номер"), 800, 480);
		addComponentToFrame(paymentNumber, 1050, 480);
		addComponentToFrame(new JLabel("Подтверждение уплаты УС. Дата"), 800, 500);
		addComponentToFrame(paymentDate, 1050, 500);

		labels = List.of(surNameLabel, nameLabel, innLabel, udTransportCategoryCodeLabel, udVinLabel);
		checkers = List.of(surNameChecker, nameChecker, innChecker, categoryChecker, vinChecker);

		container.setFocusTraversalPolicyProvider(true);
		container.setFocusTraversalPolicy(setUpTraversalPolicy());
	}

	private void fillDocumentComponents(JComboBox<String> docKindCodeInput, JTextField name, JTextField number, JFormattedTextField date) {
		docKindCodeInput.addItem(null);
		docKindCodeInput.addItem("03011");
		docKindCodeInput.addItem("09999");
		name.setEditable(false);
		number.setEditable(false);
		date.setEditable(false);
		docKindCodeInput.addItemListener(e -> {
			if (e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
					String selectedItem = (String) cb.getSelectedItem();
					if ("03011".equals(selectedItem)) {
						name.setText("договор (контракт), заключённый при совершении сделки с товарами");
					} else {
						name.setText("иные документы");
					}
					number.setEditable(true);
					number.setText(null);
					date.setEditable(true);
					date.setText(null);
				} else {
					name.setText(null);
					number.setText(null);
					number.setEditable(false);
					date.setValue(null);
					date.setEditable(false);
				}
			}
		});
	}

	private FocusTraversalPolicy setUpTraversalPolicy() {
		FocusTraversalPolicy p = new FocusTraversalPolicy() {
			private final List<Component> orderedComponents = List.of(
				surNameInput,
				nameInput,
				middleNameInput,
				innInput,
				registrationInput,
				countryCodeInput,
				regionNameInput,
				townNameInput,
				streetNameInput,
				houseNumberInput,
				roomInput,
				identityCardCodeInput,
				identityCardSeriesInput,
				identityCardNumberInput,
				identityCardDateInput,
				identityOrganisationNameInput,
				identityIssuerCodeInput,
				identityCountryCodeInput,
				bdInput,
				udVehicleEPassportIdInput,
				udSignInput,
				udTransportKindCodeInput,
				udTransportCategoryCodeInput,
				udMarkCodeInput,
				udModelInput,
				udEngineVolumeQuantityInput,
				udEngineModelCodeInput,
				udElectricEngineYN,
				udPersonalUseYN,
				udEngineModelInput,
				udEnginePowerKvtInput,
				udTotalWeightInput,
				udManufactureDateInput,
				udVinInput,
				payImportCustomsDutyInput,
				payExciseInput,
				payVatInput,
				payBorderCrossingDateInput,
				payDutyTaxFeeRateInput,
				payCoefficientInput,
				doc1KindCodeInput,
				doc1NumberInput,
				doc1DateInput,
				doc2KindCodeInput,
				doc2NumberInput,
				doc2DateInput,
				doc3KindCodeInput,
				doc3NumberInput,
				doc3DateInput,
				doc4KindCodeInput,
				doc4NumberInput,
				doc4DateInput,
				doc5KindCodeInput,
				doc5NumberInput,
				doc5DateInput,
				countryOfImport,
				calculationDate,
				dt,
				paymentNumber,
				paymentDate,
				brokerSurNameInput,
				brokerNameInput,
				brokerMiddleNameInput,
				brokerBdInput,
				brokerPassportInput,
				brokerPassportIssueInput,
				brokerAddressInput,
				brokerEmailInput,
				brokerPhoneInput
			);

			@Override
			public Component getComponentAfter(Container aContainer, Component aComponent) {
				Component next = null;
				boolean found = false;
				for (Component c : this.orderedComponents) {
					if (found) {
						next = c;
						break;
					}
					if (c == aComponent || c == aComponent.getParent())
						found = true;
				}

				if (next == null)
					return orderedComponents.getFirst();
				return next;
			}

			@Override
			public Component getComponentBefore(Container aContainer, Component aComponent) {
				if (aComponent == orderedComponents.getFirst()) {
					return orderedComponents.getLast();
				}
				Component prev = null;
				for (Component c : orderedComponents) {
					if (c == aComponent || c == aComponent.getParent())
						break;
					prev = c;
				}
				return prev;
			}

			@Override
			public Component getFirstComponent(Container aContainer) {
				return orderedComponents.getFirst();
			}

			@Override
			public Component getLastComponent(Container aContainer) {
				return orderedComponents.getLast();
			}

			@Override
			public Component getDefaultComponent(Container aContainer) {
				return orderedComponents.getFirst();
			}
		};
		return p;
	}

	private void addComponentToFrame(Component c, int x, int y) {
		c.setFont(appFont);
		c.setSize(250, 20);
		c.setLocation(x, y);
		getContentPane().add(c);
	}

	protected boolean isInputValid() {
		return labels.stream().allMatch(jl -> StringUtils.isEmpty(jl.getText()));
	}

	protected void runAllCheckers() {
		checkers.forEach(Runnable::run);
	}

	protected void clearFields() {
		surNameInput.setText(null);
		nameInput.setText(null);
		middleNameInput.setText(null);
		innInput.setText(null);
		registrationInput.setSelectedItem(null);
		countryCodeInput.setSelectedItem(null);
		countryNameInput.setText(null);
		regionNameInput.setText(null);
		townNameInput.setText(null);
		streetNameInput.setText(null);
		houseNumberInput.setText(null);
		roomInput.setText(null);
		identityCardCodeInput.setSelectedItem(null);
		identityCardSeriesInput.setText(null);
		identityCardNumberInput.setText(null);
		identityCardDateInput.setText(null);
		identityOrganisationNameInput.setText(null);
		identityIssuerCodeInput.setText(null);
		identityCountryCodeInput.setSelectedItem(null);
		bdInput.setText(null);
		udVehicleEPassportIdInput.setText(null);
		udSignInput.setSelectedItem("К");
		udTransportKindCodeInput.setSelectedItem(null);
		udTransportCategoryCodeInput.setText(null);
		udMarkCodeInput.setSelectedItem(null);
		udElectricEngineYN.setSelected(false);
		udPersonalUseYN.setSelected(false);
		udModelInput.setText(null);
		udEngineVolumeQuantityInput.setText(null);
		udEngineModelCodeInput.setSelectedItem(null);
		udEngineModelInput.setText(null);
		udEnginePowerKvtInput.setText(null);
		udTotalWeightInput.setText(null);
		udManufactureDateInput.setText(null);
		udVinInput.setText(null);
		payImportCustomsDutyInput.setText(null);
		payExciseInput.setText(null);
		payVatInput.setText(null);
		payBorderCrossingDateInput.setText(null);
		payDutyTaxFeeRateInput.setText(null);
		payCoefficientInput.setText(null);
		doc1KindCodeInput.setSelectedItem(null);
		doc1NameInput.setText(null);
		doc1NumberInput.setText(null);
		doc1DateInput.setText(null);
		doc2KindCodeInput.setSelectedItem(null);
		doc2NameInput.setText(null);
		doc2NumberInput.setText(null);
		doc2DateInput.setText(null);
		doc3KindCodeInput.setSelectedItem(null);
		doc3NameInput.setText(null);
		doc3NumberInput.setText(null);
		doc3DateInput.setText(null);
		doc4KindCodeInput.setSelectedItem(null);
		doc4NameInput.setText(null);
		doc4NumberInput.setText(null);
		doc4DateInput.setText(null);
		doc5KindCodeInput.setSelectedItem(null);
		doc5NameInput.setText(null);
		doc5NumberInput.setText(null);
		doc5DateInput.setText(null);
		countryOfImport.setSelectedItem(null);
		calculationDate.setText(null);
		dt.setText(null);
		paymentDate.setText(null);
		paymentNumber.setText(null);
	}

	protected void upperCase() {
		surNameInput.setText(StringUtils.defaultString(surNameInput.getText()).toUpperCase().trim());
		nameInput.setText(StringUtils.defaultString(nameInput.getText()).toUpperCase().trim());
		middleNameInput.setText(StringUtils.defaultString(middleNameInput.getText()).toUpperCase().trim());
		innInput.setText(StringUtils.defaultString(innInput.getText()).toUpperCase().trim());
		countryNameInput.setText(StringUtils.defaultString(countryNameInput.getText()).toUpperCase().trim());
		regionNameInput.setText(StringUtils.defaultString(regionNameInput.getText()).toUpperCase().trim());
		townNameInput.setText(StringUtils.defaultString(townNameInput.getText()).toUpperCase().trim());
		streetNameInput.setText(StringUtils.defaultString(streetNameInput.getText()).toUpperCase().trim());
		houseNumberInput.setText(StringUtils.defaultString(houseNumberInput.getText()).toUpperCase().trim());
		roomInput.setText(StringUtils.defaultString(roomInput.getText()).toUpperCase().trim());
		identityCardSeriesInput.setText(StringUtils.defaultString(identityCardSeriesInput.getText()).toUpperCase().trim());
		identityCardNumberInput.setText(StringUtils.defaultString(identityCardNumberInput.getText()).toUpperCase().trim());
		identityCardDateInput.setText(StringUtils.defaultString(identityCardDateInput.getText()).toUpperCase().trim());
		identityOrganisationNameInput.setText(StringUtils.defaultString(identityOrganisationNameInput.getText()).toUpperCase().trim());
		identityIssuerCodeInput.setText(StringUtils.defaultString(identityIssuerCodeInput.getText()).toUpperCase().trim());
		bdInput.setText(StringUtils.defaultString(bdInput.getText()).toUpperCase().trim());
		udVehicleEPassportIdInput.setText(StringUtils.defaultString(udVehicleEPassportIdInput.getText()).toUpperCase().trim());
		udTransportCategoryCodeInput.setText(StringUtils.defaultString(udTransportCategoryCodeInput.getText()).toUpperCase().trim());
		udModelInput.setText(StringUtils.defaultString(udModelInput.getText()).toUpperCase().trim());
		udEngineVolumeQuantityInput.setText(StringUtils.defaultString(udEngineVolumeQuantityInput.getText()).toUpperCase().trim());
		udEngineModelInput.setText(StringUtils.defaultString(udEngineModelInput.getText()).toUpperCase().trim());
		udEnginePowerKvtInput.setText(StringUtils.defaultString(udEnginePowerKvtInput.getText()).toUpperCase().trim());
		udTotalWeightInput.setText(StringUtils.defaultString(udTotalWeightInput.getText()).toUpperCase().trim());
		udManufactureDateInput.setText(StringUtils.defaultString(udManufactureDateInput.getText()).toUpperCase().trim());
		udVinInput.setText(StringUtils.defaultString(udVinInput.getText()).toUpperCase().trim());
		payImportCustomsDutyInput.setText(StringUtils.defaultString(payImportCustomsDutyInput.getText()).toUpperCase().trim());
		payExciseInput.setText(StringUtils.defaultString(payExciseInput.getText()).toUpperCase().trim());
		payVatInput.setText(StringUtils.defaultString(payVatInput.getText()).toUpperCase().trim());
		payBorderCrossingDateInput.setText(StringUtils.defaultString(payBorderCrossingDateInput.getText()).toUpperCase().trim());
		payDutyTaxFeeRateInput.setText(StringUtils.defaultString(payDutyTaxFeeRateInput.getText()).toUpperCase().trim());
		payCoefficientInput.setText(StringUtils.defaultString(payCoefficientInput.getText()).toUpperCase().trim());
		doc1NameInput.setText(StringUtils.defaultString(doc1NameInput.getText()).toUpperCase().trim());
		doc1NumberInput.setText(StringUtils.defaultString(doc1NumberInput.getText()).toUpperCase().trim());
		doc1DateInput.setText(StringUtils.defaultString(doc1DateInput.getText()).toUpperCase().trim());
		doc2NameInput.setText(StringUtils.defaultString(doc2NameInput.getText()).toUpperCase().trim());
		doc2NumberInput.setText(StringUtils.defaultString(doc2NumberInput.getText()).toUpperCase().trim());
		doc2DateInput.setText(StringUtils.defaultString(doc2DateInput.getText()).toUpperCase().trim());
		doc3NameInput.setText(StringUtils.defaultString(doc3NameInput.getText()).toUpperCase().trim());
		doc3NumberInput.setText(StringUtils.defaultString(doc3NumberInput.getText()).toUpperCase().trim());
		doc3DateInput.setText(StringUtils.defaultString(doc3DateInput.getText()).toUpperCase().trim());
		doc4NameInput.setText(StringUtils.defaultString(doc4NameInput.getText()).toUpperCase().trim());
		doc4NumberInput.setText(StringUtils.defaultString(doc4NumberInput.getText()).toUpperCase().trim());
		doc4DateInput.setText(StringUtils.defaultString(doc4DateInput.getText()).toUpperCase().trim());
		doc5NameInput.setText(StringUtils.defaultString(doc5NameInput.getText()).toUpperCase().trim());
		doc5NumberInput.setText(StringUtils.defaultString(doc5NumberInput.getText()).toUpperCase().trim());
		doc5DateInput.setText(StringUtils.defaultString(doc5DateInput.getText()).toUpperCase().trim());
		calculationDate.setText(StringUtils.defaultString(calculationDate.getText()).toUpperCase().trim());
		dt.setText(StringUtils.defaultString(dt.getText()).toUpperCase().trim());
		paymentDate.setText(StringUtils.defaultString(paymentDate.getText()).toUpperCase().trim());
		paymentNumber.setText(StringUtils.defaultString(paymentNumber.getText()).toUpperCase().trim());

		brokerSurNameInput.setText(StringUtils.defaultString(brokerSurNameInput.getText()).toUpperCase().trim());
		brokerNameInput.setText(StringUtils.defaultString(brokerNameInput.getText()).toUpperCase().trim());
		brokerMiddleNameInput.setText(StringUtils.defaultString(brokerMiddleNameInput.getText()).toUpperCase().trim());
		brokerBdInput.setText(StringUtils.defaultString(brokerBdInput.getText()).toUpperCase().trim());
		brokerPassportInput.setText(StringUtils.defaultString(brokerPassportInput.getText()).toUpperCase().trim());
		brokerPassportIssueInput.setText(StringUtils.defaultString(brokerPassportIssueInput.getText()).toUpperCase().trim());
		brokerAddressInput.setText(StringUtils.defaultString(brokerAddressInput.getText()).toUpperCase().trim());
		brokerEmailInput.setText(StringUtils.defaultString(brokerEmailInput.getText()).toUpperCase().trim());
		brokerPhoneInput.setText(StringUtils.defaultString(brokerPhoneInput.getText()).toUpperCase().trim());
	}
}
