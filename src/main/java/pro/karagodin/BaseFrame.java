package pro.karagodin;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.DateFormatter;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public abstract class BaseFrame extends JFrame implements ActionListener {
	private static final Font appFont = new Font("Arial", Font.PLAIN, 15);

	protected final JButton save = new JButton("Сохранить");
	protected final JButton open = new JButton("Открыть");

	protected final JTextField surNameInput = new JTextField();
	protected final JTextField nameInput = new JTextField();
	protected final JTextField middleNameInput = new JTextField();
	protected final JTextField innInput = new JTextField();
	protected final JLabel innLabel = new JLabel();
	{
		innInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = innInput.getText();
				if (value != null) {
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
			}
		});
	}
	protected final JTextField registrationInput = new JTextField();
	protected final JTextField countryCodeInput = new JTextField();
	protected final JTextField countryNameInput = new JTextField();
	protected final JTextField regionNameInput = new JTextField();
	protected final JTextField cityNameInput = new JTextField();
	protected final JTextField streetNameInput = new JTextField();
	protected final JTextField houseNumberInput = new JTextField();
	protected final JTextField roomInput = new JTextField();
	protected final JTextField identityCardCodeInput = new JTextField();
	protected final JTextField identityCardNameInput = new JTextField();
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
	protected final JTextField identityCountryCodeInput = new JTextField();
	protected final JTextField udVehicleEPassportIdInput = new JTextField();
	protected final JTextField udSignInput = new JTextField();
	protected final JTextField udTransportKindCodeInput = new JTextField();
	protected final JTextField udTransportCategoryCodeInput = new JTextField();
	protected final JTextField udMarkCodeInput = new JTextField();
	protected final JTextField udMarkInput = new JTextField();
	protected final JTextField udModelInput = new JTextField();
	protected final JTextField udEngineVolumeQuantityInput = new JTextField();
	protected final JTextField udEngineModelCodeInput = new JTextField();
	protected final JTextField udEngineModelNameInput = new JTextField();
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


	public BaseFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(900,1000);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		Container c = getContentPane();

		open.setFont(appFont);
		open.setSize(120, 20);
		open.setLocation(650, 0);
		open.addActionListener(this);
		c.add(open);

		save.setFont(appFont);
		save.setSize(120, 20);
		save.setLocation(650, 20);
		save.addActionListener(this);
		c.add(save);

		addComponentToFrame(new JLabel("Фамилия плательщика"), 5, 0);
		addComponentToFrame(surNameInput, 250, 0);
		addComponentToFrame(new JLabel("Имя плательщика"), 5, 20);
		addComponentToFrame(nameInput, 250, 20);
		addComponentToFrame(new JLabel("Отчество плательщика"), 5, 40);
		addComponentToFrame(middleNameInput, 250, 40);
		addComponentToFrame(new JLabel("ИНН"), 5, 60);
		addComponentToFrame(innInput, 250, 60);
		addComponentToFrame(innLabel, 500, 60);
		innLabel.setSize(300, 20);
		addComponentToFrame(new JLabel("Признак постоянной регистрации"), 5, 80);
		addComponentToFrame(registrationInput, 250, 80);
		addComponentToFrame(new JLabel("Код страны"), 5, 100);
		addComponentToFrame(countryCodeInput, 250, 100);
		addComponentToFrame(new JLabel("Наименование страны"), 5, 120);
		addComponentToFrame(countryNameInput, 250, 120);
		addComponentToFrame(new JLabel("Наименование региона"), 5, 140);
		addComponentToFrame(regionNameInput, 250, 140);
		addComponentToFrame(new JLabel("Наименование города"), 5, 160);
		addComponentToFrame(cityNameInput, 250, 160);
		addComponentToFrame(new JLabel("Наименование улицы"), 5, 180);
		addComponentToFrame(streetNameInput, 250, 180);
		addComponentToFrame(new JLabel("Номер дома"), 5, 200);
		addComponentToFrame(houseNumberInput, 250, 200);
		addComponentToFrame(new JLabel("Номер квартиры"), 5, 220);
		addComponentToFrame(roomInput, 250, 220);
		addComponentToFrame(new JLabel("Код документа УЛ"), 5, 240);
		addComponentToFrame(identityCardCodeInput, 250, 240);
		addComponentToFrame(new JLabel("Наименование документа УЛ"), 5, 260);
		addComponentToFrame(identityCardNameInput, 250, 260);
		addComponentToFrame(new JLabel("Серия документа УЛ"), 5, 280);
		addComponentToFrame(identityCardSeriesInput, 250, 280);
		addComponentToFrame(new JLabel("Номер документа УЛ"), 5, 300);
		addComponentToFrame(identityCardNumberInput, 250, 300);
		addComponentToFrame(new JLabel("Дата документа УЛ (dd.MM.yyyy)"), 5, 320);
		addComponentToFrame(identityCardDateInput, 250, 320);
		addComponentToFrame(new JLabel("Орган выдавший документ УЛ"), 5, 340);
		addComponentToFrame(identityOrganisationNameInput, 250, 340);
		addComponentToFrame(new JLabel("Код подразделения выдавшего УЛ"), 5, 360);
		addComponentToFrame(identityIssuerCodeInput, 250, 360);
		addComponentToFrame(new JLabel("Код страны органа выдавшего УЛ"), 5, 380);
		addComponentToFrame(identityCountryCodeInput, 250, 380);
		//Раздел 2
		addComponentToFrame(new JLabel("Номер ЭПТС"), 5, 420);
		addComponentToFrame(udVehicleEPassportIdInput, 250, 420);
		addComponentToFrame(new JLabel("Признак ТС"), 5, 440);
		addComponentToFrame(udSignInput, 250, 440);
		addComponentToFrame(new JLabel("Вид ТС"), 5, 460);
		addComponentToFrame(udTransportKindCodeInput, 250, 460);
		addComponentToFrame(new JLabel("Категория ТС"), 5, 480);
		addComponentToFrame(udTransportCategoryCodeInput, 250, 480);
		addComponentToFrame(new JLabel("Код марки ТС"), 5, 500);
		addComponentToFrame(udMarkCodeInput, 250, 500);
		addComponentToFrame(new JLabel("Наименование марки ТС"), 5, 520);
		addComponentToFrame(udMarkInput, 250, 520);
		addComponentToFrame(new JLabel("Модель ТС"), 5, 540);
		addComponentToFrame(udModelInput, 250, 540);
		addComponentToFrame(new JLabel("Объем двигателя"), 5, 560);
		addComponentToFrame(udEngineVolumeQuantityInput, 250, 560);
		addComponentToFrame(new JLabel("Код типа двигателя"), 5, 580);
		addComponentToFrame(udEngineModelCodeInput, 250, 580);
		addComponentToFrame(new JLabel("Наименование двигателя"), 5, 600);
		addComponentToFrame(udEngineModelNameInput, 250, 600);
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
	}

	private void addComponentToFrame(Component c, int x, int y) {
		c.setFont(appFont);
		c.setSize(250, 20);
		c.setLocation(x, y);
		getContentPane().add(c);
	}
}
