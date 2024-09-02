package pro.karagodin;

import java.util.LinkedHashMap;
import java.util.Map;

public record MarkKind(String code, String name) {

	public static Map<String, MarkKind> cache = new LinkedHashMap<>();
	static {
		cache.put("001", new MarkKind("001", "ABARTH"));
		cache.put("002", new MarkKind("002", "ABG"));
		cache.put("003", new MarkKind("003", "AC CARS"));
		cache.put("004", new MarkKind("004", "ACERBI"));
		cache.put("005", new MarkKind("005", "ACKERMANN"));
		cache.put("006", new MarkKind("006", "ACTM"));
		cache.put("007", new MarkKind("007", "ACURA"));
		cache.put("008", new MarkKind("008", "ADIVA"));
		cache.put("009", new MarkKind("009", "ADLY"));
		cache.put("010", new MarkKind("010", "ADR TRAILERS"));
		cache.put("011", new MarkKind("011", "ADRIA"));
		cache.put("012", new MarkKind("012", "AEON"));
		cache.put("013", new MarkKind("013", "AERMACCHI"));
		cache.put("014", new MarkKind("014", "AJP"));
		cache.put("015", new MarkKind("015", "AJS"));
		cache.put("016", new MarkKind("016", "ALBAR"));
		cache.put("017", new MarkKind("017", "ALFA ROMEO"));
		cache.put("018", new MarkKind("018", "ALI RIZA USTA"));
		cache.put("019", new MarkKind("019", "ALLIGATOR"));
		cache.put("020", new MarkKind("020", "ALPINA"));
		cache.put("021", new MarkKind("021", "ALPINE"));
		cache.put("022", new MarkKind("022", "AMC"));
		cache.put("023", new MarkKind("023", "AMERICAN EAGLE"));
		cache.put("024", new MarkKind("024", "AMMANN"));
		cache.put("025", new MarkKind("025", "ANKAI"));
		cache.put("026", new MarkKind("026", "ANNABURGER"));
		cache.put("027", new MarkKind("027", "APRILIA"));
		cache.put("028", new MarkKind("028", "ARCTIC CAT"));
		cache.put("029", new MarkKind("029", "ARDOR"));
		cache.put("030", new MarkKind("030", "ARIEL"));
		cache.put("031", new MarkKind("031", "ARO"));
		cache.put("032", new MarkKind("032", "ARQIN"));
		cache.put("033", new MarkKind("033", "ARTEGA"));
		cache.put("034", new MarkKind("034", "ASCARI"));
		cache.put("035", new MarkKind("035", "ASIA"));
		cache.put("036", new MarkKind("036", "ASPES"));
		cache.put("037", new MarkKind("037", "ASTON MARTIN"));
		cache.put("038", new MarkKind("038", "ASTRA"));
		cache.put("039", new MarkKind("039", "ATEK"));
		cache.put("040", new MarkKind("040", "ATK"));
		cache.put("041", new MarkKind("041", "ATLAS"));
		cache.put("042", new MarkKind("042", "ATLAS HONDA"));
		cache.put("043", new MarkKind("043", "AUDI"));
		cache.put("044", new MarkKind("044", "AUSTIN"));
		cache.put("045", new MarkKind("045", "AUTOSAN"));
		cache.put("046", new MarkKind("046", "AVIA"));
		cache.put("047", new MarkKind("047", "AVTOTREIDING"));
		cache.put("048", new MarkKind("048", "BAJAJ"));
		cache.put("049", new MarkKind("049", "BALKANCAR"));
		cache.put("050", new MarkKind("050", "BALTMOTORS"));
		cache.put("051", new MarkKind("051", "BAMX"));
		cache.put("052", new MarkKind("052", "BAROSSA"));
		cache.put("053", new MarkKind("053", "BARYVAL"));
		cache.put("054", new MarkKind("054", "BAW"));
		cache.put("055", new MarkKind("055", "BAZ"));
		cache.put("056", new MarkKind("056", "BEIFANG BENCHI"));
		cache.put("057", new MarkKind("057", "BEIJING"));
		cache.put("058", new MarkKind("058", "BELAZ"));
		cache.put("059", new MarkKind("059", "BENALU"));
		cache.put("060", new MarkKind("060", "BENELLI"));
		cache.put("061", new MarkKind("061", "BENNCHE"));
		cache.put("062", new MarkKind("062", "BENTLEY"));
		cache.put("063", new MarkKind("063", "BERGER"));
		cache.put("064", new MarkKind("064", "BETA"));
		cache.put("065", new MarkKind("065", "BIG BEAR CHOPPERS"));
		cache.put("066", new MarkKind("066", "BIG DOG"));
		cache.put("067", new MarkKind("067", "BIMOTA"));
		cache.put("068", new MarkKind("068", "BITTER"));
		cache.put("069", new MarkKind("069", "BLATA"));
		cache.put("070", new MarkKind("070", "BMW"));
		cache.put("071", new MarkKind("071", "BOBCAT"));
		cache.put("072", new MarkKind("072", "BOCKMANN"));
		cache.put("073", new MarkKind("073", "BODEX"));
		cache.put("074", new MarkKind("074", "BOGDAN"));
		cache.put("075", new MarkKind("075", "BOMAG"));
		cache.put("076", new MarkKind("076", "BOOM TRIKES"));
		cache.put("077", new MarkKind("077", "BOVA"));
		cache.put("078", new MarkKind("078", "BPG RECREATIONAL"));
		cache.put("079", new MarkKind("079", "BRAMMO"));
		cache.put("080", new MarkKind("080", "BRIAB"));
		cache.put("081", new MarkKind("081", "BRILLIANCE"));
		cache.put("082", new MarkKind("082", "BRISTOL"));
		cache.put("083", new MarkKind("083", "BROOKE"));
		cache.put("084", new MarkKind("084", "BROSHUIS"));
		cache.put("085", new MarkKind("085", "BSA"));
		cache.put("086", new MarkKind("086", "BSLT"));
		cache.put("087", new MarkKind("087", "BSS"));
		cache.put("088", new MarkKind("088", "BUCCIMOTO"));
		cache.put("089", new MarkKind("089", "BUELL"));
		cache.put("090", new MarkKind("090", "BUGATTI"));
		cache.put("091", new MarkKind("091", "BUICK"));
		cache.put("092", new MarkKind("092", "BURG"));
		cache.put("093", new MarkKind("093", "BYD"));
		cache.put("094", new MarkKind("094", "CADILLAC"));
		cache.put("095", new MarkKind("095", "CAGIVA"));
		cache.put("096", new MarkKind("096", "CALIFORNIA SCOOTER"));
		cache.put("097", new MarkKind("097", "CALLAWAY"));
		cache.put("098", new MarkKind("098", "CAMC"));
		cache.put("099", new MarkKind("099", "CAMPTOURIST"));
		cache.put("100", new MarkKind("100", "CAN-AM"));
		cache.put("101", new MarkKind("101", "CARBODIES"));
		cache.put("102", new MarkKind("102", "CARDI"));
		cache.put("103", new MarkKind("103", "CARGOBIKE"));
		cache.put("104", new MarkKind("104", "CARNEHL"));
		cache.put("105", new MarkKind("105", "CASE"));
		cache.put("106", new MarkKind("106", "CATERHAM"));
		cache.put("107", new MarkKind("107", "CATERPILLAR"));
		cache.put("108", new MarkKind("108", "CCM"));
		cache.put("109", new MarkKind("109", "CECTEK"));
		cache.put("110", new MarkKind("110", "CFMOTO"));
		cache.put("111", new MarkKind("111", "CH RACING"));
		cache.put("112", new MarkKind("112", "CHAMPION"));
		cache.put("113", new MarkKind("113", "CHANA"));
		cache.put("114", new MarkKind("114", "CHANG JIANG"));
		cache.put("115", new MarkKind("115", "CHANGAN"));
		cache.put("116", new MarkKind("116", "CHANGFENG"));
		cache.put("117", new MarkKind("117", "CHANGHE"));
		cache.put("118", new MarkKind("118", "CHANGLIN"));
		cache.put("119", new MarkKind("119", "CHENGGONG"));
		cache.put("120", new MarkKind("120", "CHEREAU"));
		cache.put("121", new MarkKind("121", "CHERY"));
		cache.put("122", new MarkKind("122", "CHEVAL LIBERTE"));
		cache.put("123", new MarkKind("123", "CHEVROLET"));
		cache.put("124", new MarkKind("124", "CHRYSLER"));
		cache.put("125", new MarkKind("125", "CIFA"));
		cache.put("126", new MarkKind("126", "CIMC"));
		cache.put("127", new MarkKind("127", "CIMC SILVERGREEN"));
		cache.put("128", new MarkKind("128", "CITROEN"));
		cache.put("129", new MarkKind("129", "CIZETA"));
		cache.put("130", new MarkKind("130", "COBRA"));
		cache.put("131", new MarkKind("131", "COGGIOLA"));
		cache.put("132", new MarkKind("132", "CPI"));
		cache.put("133", new MarkKind("133", "CR&S"));
		cache.put("134", new MarkKind("134", "DACIA"));
		cache.put("135", new MarkKind("135", "DADI"));
		cache.put("136", new MarkKind("136", "DAEWOO"));
		cache.put("137", new MarkKind("137", "DAF"));
		cache.put("138", new MarkKind("138", "DAIHATSU"));
		cache.put("139", new MarkKind("139", "DAIMLER"));
		cache.put("140", new MarkKind("140", "DALLAS"));
		cache.put("141", new MarkKind("141", "DATSUN"));
		cache.put("142", new MarkKind("142", "DE TOMASO"));
		cache.put("143", new MarkKind("143", "DELOREAN"));
		cache.put("144", new MarkKind("144", "DEMAG"));
		cache.put("145", new MarkKind("145", "DERWAYS"));
		cache.put("146", new MarkKind("146", "DKW"));
		cache.put("147", new MarkKind("147", "DODGE"));
		cache.put("148", new MarkKind("148", "DOLL"));
		cache.put("149", new MarkKind("149", "DONGFENG"));
		cache.put("150", new MarkKind("150", "DONINVEST"));
		cache.put("151", new MarkKind("151", "DONKERVOORT"));
		cache.put("152", new MarkKind("152", "DOOSAN"));
		cache.put("153", new MarkKind("153", "DRESSTA"));
		cache.put("154", new MarkKind("154", "DYNAPAC"));
		cache.put("155", new MarkKind("155", "E-MAX"));
		cache.put("156", new MarkKind("156", "E-TON"));
		cache.put("157", new MarkKind("157", "ETROPOLIS"));
		cache.put("158", new MarkKind("158", "EAGLE"));
		cache.put("159", new MarkKind("159", "EAGLE WING"));
		cache.put("160", new MarkKind("160", "ECOSSE"));
		cache.put("161", new MarkKind("161", "EDUARD"));
		cache.put("162", new MarkKind("162", "EFINI"));
		cache.put("163", new MarkKind("163", "EIGENBAU"));
		cache.put("164", new MarkKind("164", "ELFIN"));
		cache.put("165", new MarkKind("165", "ERAZ"));
		cache.put("166", new MarkKind("166", "EBR (ERIK BUELL RACING)"));
		cache.put("167", new MarkKind("167", "ESPERO"));
		cache.put("168", new MarkKind("168", "EXCALIBUR"));
		cache.put("169", new MarkKind("169", "EXPLORER"));
		cache.put("170", new MarkKind("170", "FACTORY BIKE"));
		cache.put("171", new MarkKind("171", "FANTIC"));
		cache.put("172", new MarkKind("172", "FAUN"));
		cache.put("173", new MarkKind("173", "FAW"));
		cache.put("174", new MarkKind("174", "FAYMONVILLE"));
		cache.put("175", new MarkKind("175", "FELDBINDER"));
		cache.put("176", new MarkKind("176", "FERRARI"));
		cache.put("177", new MarkKind("177", "FGR"));
		cache.put("178", new MarkKind("178", "FIAT"));
		cache.put("179", new MarkKind("179", "FIAT-HITACHI"));
		cache.put("180", new MarkKind("180", "FIAT KOBELCO"));
		cache.put("181", new MarkKind("181", "FIORI"));
		cache.put("182", new MarkKind("182", "FISCHER"));
		cache.put("183", new MarkKind("183", "FISKER"));
		cache.put("184", new MarkKind("184", "FLIEGL"));
		cache.put("185", new MarkKind("185", "FOKAMO"));
		cache.put("186", new MarkKind("186", "FORD"));
		cache.put("187", new MarkKind("187", "FOSTI"));
		cache.put("188", new MarkKind("188", "FOTON"));
		cache.put("189", new MarkKind("189", "FREIGHTLINER"));
		cache.put("190", new MarkKind("190", "FRUEHAUF"));
		cache.put("191", new MarkKind("191", "FSM"));
		cache.put("192", new MarkKind("192", "FSO"));
		cache.put("193", new MarkKind("193", "FUCHS"));
		cache.put("194", new MarkKind("194", "FUQI"));
		cache.put("195", new MarkKind("195", "FURUKAWA"));
		cache.put("196", new MarkKind("196", "GARELLI"));
		cache.put("197", new MarkKind("197", "GAS"));
		cache.put("198", new MarkKind("198", "GASVI"));
		cache.put("199", new MarkKind("199", "GAZ"));
		cache.put("200", new MarkKind("200", "GEELY"));
		cache.put("201", new MarkKind("201", "GENERAL MOTORS"));
		cache.put("202", new MarkKind("202", "GENERIC"));
		cache.put("203", new MarkKind("203", "GENUINE SCOOTER"));
		cache.put("204", new MarkKind("204", "GEO"));
		cache.put("205", new MarkKind("205", "GIANT"));
		cache.put("206", new MarkKind("206", "GIANTCO"));
		cache.put("207", new MarkKind("207", "GILERA"));
		cache.put("208", new MarkKind("208", "GMC"));
		cache.put("209", new MarkKind("209", "GOES"));
		cache.put("210", new MarkKind("210", "GOFA"));
		cache.put("211", new MarkKind("211", "GOLDEN DRAGON"));
		cache.put("212", new MarkKind("212", "GONOW"));
		cache.put("213", new MarkKind("213", "GOODWILL"));
		cache.put("214", new MarkKind("214", "GOVECS"));
		cache.put("215", new MarkKind("215", "GRAY&ADAMS"));
		cache.put("216", new MarkKind("216", "GRC MOTO"));
		cache.put("217", new MarkKind("217", "GREAT WALL"));
		cache.put("218", new MarkKind("218", "GREENTRANS"));
		cache.put("219", new MarkKind("219", "GROENEWEGEN"));
		cache.put("220", new MarkKind("220", "GROVE"));
		cache.put("221", new MarkKind("221", "GRUNWALD"));
		cache.put("222", new MarkKind("222", "GRYPHON"));
		cache.put("223", new MarkKind("223", "GT"));
		cache.put("224", new MarkKind("224", "GUMPERT"));
		cache.put("225", new MarkKind("225", "GURLESENYIL"));
		cache.put("226", new MarkKind("226", "HAFEI"));
		cache.put("227", new MarkKind("227", "HAIMA"));
		cache.put("228", new MarkKind("228", "HALLER"));
		cache.put("229", new MarkKind("229", "HAMM"));
		cache.put("230", new MarkKind("230", "HANIX"));
		cache.put("231", new MarkKind("231", "HANOMAG"));
		cache.put("232", new MarkKind("232", "HANWOO"));
		cache.put("233", new MarkKind("233", "HAOJIN"));
		cache.put("234", new MarkKind("234", "HAPERT"));
		cache.put("235", new MarkKind("235", "HARLEY-DAVIDSON"));
		cache.put("236", new MarkKind("236", "HBM-NOBAS"));
		cache.put("237", new MarkKind("237", "HDM"));
		cache.put("238", new MarkKind("238", "HEADBANGER"));
		cache.put("239", new MarkKind("239", "HEALEY"));
		cache.put("240", new MarkKind("240", "HENDRICKS"));
		cache.put("241", new MarkKind("241", "HERCULES"));
		cache.put("242", new MarkKind("242", "HERO"));
		cache.put("243", new MarkKind("243", "HERO ELECTRIC"));
		cache.put("244", new MarkKind("244", "HERO HONDA"));
		cache.put("245", new MarkKind("245", "HESKETH"));
		cache.put("246", new MarkKind("246", "HFR"));
		cache.put("247", new MarkKind("247", "HIDROMEK"));
		cache.put("248", new MarkKind("248", "HIGER"));
		cache.put("249", new MarkKind("249", "HIGHLAND"));
		cache.put("250", new MarkKind("250", "HINDUSTAN"));
		cache.put("251", new MarkKind("251", "HINO"));
		cache.put("252", new MarkKind("252", "HISUN"));
		cache.put("253", new MarkKind("253", "HITACHI"));
		cache.put("254", new MarkKind("254", "HM"));
		cache.put("255", new MarkKind("255", "HOBBS"));
		cache.put("256", new MarkKind("256", "HOLDEN"));
		cache.put("257", new MarkKind("257", "HONDA"));
		cache.put("258", new MarkKind("258", "HONGYAN"));
		cache.put("259", new MarkKind("259", "HORCH"));
		cache.put("260", new MarkKind("260", "HOREX"));
		cache.put("261", new MarkKind("261", "HOWO"));
		cache.put("262", new MarkKind("262", "HP"));
		cache.put("263", new MarkKind("263", "HP POWER"));
		cache.put("264", new MarkKind("264", "HUANDA"));
		cache.put("265", new MarkKind("265", "HUANGHAI"));
		cache.put("266", new MarkKind("266", "HUMBAUR"));
		cache.put("267", new MarkKind("267", "HUMMER"));
		cache.put("268", new MarkKind("268", "HUSABERG"));
		cache.put("269", new MarkKind("269", "HUSQVARNA"));
		cache.put("270", new MarkKind("270", "HYDREMA"));
		cache.put("271", new MarkKind("271", "HYOSUNG"));
		cache.put("272", new MarkKind("272", "HYUNDAI"));
		cache.put("273", new MarkKind("273", "IFA"));
		cache.put("274", new MarkKind("274", "IKARBUS"));
		cache.put("275", new MarkKind("275", "IKARUS"));
		cache.put("276", new MarkKind("276", "INDIAN"));
		cache.put("277", new MarkKind("277", "INFINITI"));
		cache.put("278", new MarkKind("278", "INNOCENTI"));
		cache.put("279", new MarkKind("279", "INNOSCOOTER"));
		cache.put("280", new MarkKind("280", "INTERNATIONAL"));
		cache.put("281", new MarkKind("281", "INTERSTATE 1"));
		cache.put("282", new MarkKind("282", "INTREPID"));
		cache.put("283", new MarkKind("283", "INVICTA"));
		cache.put("284", new MarkKind("284", "IPV"));
		cache.put("285", new MarkKind("285", "IRAN KHODRO"));
		cache.put("286", new MarkKind("286", "IRBIS"));
		cache.put("287", new MarkKind("287", "IRISBUS"));
		cache.put("288", new MarkKind("288", "ISDERA"));
		cache.put("289", new MarkKind("289", "ISUZU"));
		cache.put("290", new MarkKind("290", "ITALJET"));
		cache.put("291", new MarkKind("291", "IVECO"));
		cache.put("292", new MarkKind("292", "IZH"));
		cache.put("293", new MarkKind("293", "IZUKA"));
		cache.put("294", new MarkKind("294", "JAC"));
		cache.put("295", new MarkKind("295", "JAGUAR"));
		cache.put("296", new MarkKind("296", "JAWA"));
		cache.put("297", new MarkKind("297", "JCB"));
		cache.put("298", new MarkKind("298", "JEEP"));
		cache.put("299", new MarkKind("299", "JELCZ"));
		cache.put("300", new MarkKind("300", "JIALING"));
		cache.put("301", new MarkKind("301", "JIANGLING"));
		cache.put("302", new MarkKind("302", "JIANGNAN"));
		cache.put("303", new MarkKind("303", "JIANSHE"));
		cache.put("304", new MarkKind("304", "JINBEI"));
		cache.put("305", new MarkKind("305", "JINCHENG"));
		cache.put("306", new MarkKind("306", "JINLUN"));
		cache.put("307", new MarkKind("307", "JOHN DEERE"));
		cache.put("308", new MarkKind("308", "JOHNNY PAG"));
		cache.put("309", new MarkKind("309", "JONWAY"));
		cache.put("310", new MarkKind("310", "JORDAN"));
		cache.put("311", new MarkKind("311", "JRL"));
		cache.put("312", new MarkKind("312", "JUEJIN"));
		cache.put("313", new MarkKind("313", "JUKI"));
		cache.put("314", new MarkKind("314", "JUMBO"));
		cache.put("315", new MarkKind("315", "JYKI"));
		cache.put("316", new MarkKind("316", "K2O"));
		cache.put("317", new MarkKind("317", "KABIRDASS"));
		cache.put("318", new MarkKind("318", "KAMAZ"));
		cache.put("319", new MarkKind("319", "KANGDA"));
		cache.put("320", new MarkKind("320", "KANUNI"));
		cache.put("321", new MarkKind("321", "KASINSKI"));
		cache.put("322", new MarkKind("322", "KASSBOHRER"));
		cache.put("323", new MarkKind("323", "KATO"));
		cache.put("324", new MarkKind("324", "KAVZ"));
		cache.put("325", new MarkKind("325", "KAWASAKI"));
		cache.put("326", new MarkKind("326", "KEEWAY"));
		cache.put("327", new MarkKind("327", "KEL-BERG"));
		cache.put("328", new MarkKind("328", "KENWORTH"));
		cache.put("329", new MarkKind("329", "KIA"));
		cache.put("330", new MarkKind("330", "KINETIC"));
		cache.put("331", new MarkKind("331", "KING LONG"));
		cache.put("332", new MarkKind("332", "KINROAD"));
		cache.put("333", new MarkKind("333", "KIP"));
		cache.put("334", new MarkKind("334", "KOBELCO"));
		cache.put("335", new MarkKind("335", "KOGEL"));
		cache.put("336", new MarkKind("336", "KOENIGSEGG"));
		cache.put("337", new MarkKind("337", "KOMATSU"));
		cache.put("338", new MarkKind("338", "KRAMER"));
		cache.put("339", new MarkKind("339", "KRAZ"));
		cache.put("340", new MarkKind("340", "KRONE"));
		cache.put("341", new MarkKind("341", "KRUPP"));
		cache.put("342", new MarkKind("342", "KTM"));
		cache.put("343", new MarkKind("343", "KUBOTA"));
		cache.put("344", new MarkKind("344", "KUFER"));
		cache.put("345", new MarkKind("345", "KYMCO"));
		cache.put("346", new MarkKind("346", "LADA"));
		cache.put("347", new MarkKind("347", "LAG"));
		cache.put("348", new MarkKind("348", "LAMBERET"));
		cache.put("349", new MarkKind("349", "LAMBORGHINI"));
		cache.put("350", new MarkKind("350", "LAMBRETTA"));
		cache.put("351", new MarkKind("351", "LANCIA"));
		cache.put("352", new MarkKind("352", "LAND ROVER"));
		cache.put("353", new MarkKind("353", "LANDWIND"));
		cache.put("354", new MarkKind("354", "LANGENDORF"));
		cache.put("355", new MarkKind("355", "LANGFELD"));
		cache.put("356", new MarkKind("356", "LATRE"));
		cache.put("357", new MarkKind("357", "LAUGE JENSEN"));
		cache.put("358", new MarkKind("358", "LAVERDA"));
		cache.put("359", new MarkKind("359", "LAZ"));
		cache.put("360", new MarkKind("360", "LDV"));
		cache.put("361", new MarkKind("361", "LECTRIX"));
		cache.put("362", new MarkKind("362", "LEHMAN TRIKES"));
		cache.put("363", new MarkKind("363", "LEM"));
		cache.put("364", new MarkKind("364", "LEONHARDT"));
		cache.put("365", new MarkKind("365", "LEXUS"));
		cache.put("366", new MarkKind("366", "LEYLAND"));
		cache.put("367", new MarkKind("367", "LIAZ"));
		cache.put("368", new MarkKind("368", "LIDER TRADE"));
		cache.put("369", new MarkKind("369", "LIEBHERR"));
		cache.put("370", new MarkKind("370", "LIFAN"));
		cache.put("371", new MarkKind("371", "LINCOLN"));
		cache.put("372", new MarkKind("372", "LINHAI"));
		cache.put("373", new MarkKind("373", "LINTRAILERS"));
		cache.put("374", new MarkKind("374", "LIUGONG"));
		cache.put("375", new MarkKind("375", "LML"));
		cache.put("376", new MarkKind("376", "LOCATELLI"));
		cache.put("377", new MarkKind("377", "LOHIA"));
		cache.put("378", new MarkKind("378", "LOHR"));
		cache.put("379", new MarkKind("379", "LONCIN"));
		cache.put("380", new MarkKind("380", "LONKING"));
		cache.put("381", new MarkKind("381", "LOTUS"));
		cache.put("382", new MarkKind("382", "LTI"));
		cache.put("383", new MarkKind("383", "LUAZ"));
		cache.put("384", new MarkKind("384", "LUNA"));
		cache.put("385", new MarkKind("385", "LUXGEN"));
		cache.put("386", new MarkKind("386", "LYNX"));
		cache.put("387", new MarkKind("387", "MACBOR"));
		cache.put("388", new MarkKind("388", "MACK"));
		cache.put("389", new MarkKind("389", "MAGIRUS"));
		cache.put("390", new MarkKind("390", "MAGNI"));
		cache.put("391", new MarkKind("391", "MAHINDRA"));
		cache.put("392", new MarkKind("392", "MAISONNEUVE"));
		cache.put("393", new MarkKind("393", "MALAGUTI"));
		cache.put("394", new MarkKind("394", "MAN"));
		cache.put("395", new MarkKind("395", "MANAC-AUTO"));
		cache.put("396", new MarkKind("396", "MANITOU"));
		cache.put("397", new MarkKind("397", "MARCOPOLO"));
		cache.put("398", new MarkKind("398", "MARCOS"));
		cache.put("399", new MarkKind("399", "MARINE TURBINE TECHNOLOGIES"));
		cache.put("400", new MarkKind("400", "MARLIN"));
		cache.put("401", new MarkKind("401", "MARUSSIA"));
		cache.put("402", new MarkKind("402", "MARUTI"));
		cache.put("403", new MarkKind("403", "MASERATI"));
		cache.put("404", new MarkKind("404", "MAVIZEN"));
		cache.put("405", new MarkKind("405", "MAYBACH"));
		cache.put("406", new MarkKind("406", "MAZ"));
		cache.put("407", new MarkKind("407", "MAZDA"));
		cache.put("408", new MarkKind("408", "MBK"));
		cache.put("409", new MarkKind("409", "MBS"));
		cache.put("410", new MarkKind("410", "MCLAREN"));
		cache.put("411", new MarkKind("411", "MEGA"));
		cache.put("412", new MarkKind("412", "MEGELLI"));
		cache.put("413", new MarkKind("413", "MEILLER"));
		cache.put("414", new MarkKind("414", "MENCI"));
		cache.put("415", new MarkKind("415", "MERCEDES-BENZ"));
		cache.put("416", new MarkKind("416", "MERCURY"));
		cache.put("417", new MarkKind("417", "MERLO"));
		cache.put("418", new MarkKind("418", "METISSE"));
		cache.put("419", new MarkKind("419", "METROCAB"));
		cache.put("420", new MarkKind("420", "METSAN"));
		cache.put("421", new MarkKind("421", "MEUSBURGER"));
		cache.put("422", new MarkKind("422", "MG"));
		cache.put("423", new MarkKind("423", "MIDUAL"));
		cache.put("424", new MarkKind("424", "MIKILON"));
		cache.put("425", new MarkKind("425", "MINELLI"));
		cache.put("426", new MarkKind("426", "MINI"));
		cache.put("427", new MarkKind("427", "MINSK"));
		cache.put("428", new MarkKind("428", "MISSION"));
		cache.put("429", new MarkKind("429", "MITSUBISHI"));
		cache.put("430", new MarkKind("430", "MITSUOKA"));
		cache.put("431", new MarkKind("431", "MODENAS"));
		cache.put("432", new MarkKind("432", "MONDIAL"));
		cache.put("433", new MarkKind("433", "MONTE CARLO"));
		cache.put("434", new MarkKind("434", "MONTESA"));
		cache.put("435", new MarkKind("435", "MONTRACON"));
		cache.put("436", new MarkKind("436", "MORGAN"));
		cache.put("437", new MarkKind("437", "MOSKVICH"));
		cache.put("438", new MarkKind("438", "MOTO GUZZI"));
		cache.put("439", new MarkKind("439", "MOTO MORINI"));
		cache.put("440", new MarkKind("440", "MOTOCZYSZ"));
		cache.put("441", new MarkKind("441", "MOTORHISPANIA"));
		cache.put("442", new MarkKind("442", "MUDAN"));
		cache.put("443", new MarkKind("443", "MULTICAR"));
		cache.put("444", new MarkKind("444", "MUZ"));
		cache.put("445", new MarkKind("445", "MV AGUSTA"));
		cache.put("446", new MarkKind("446", "MZKT"));
		cache.put("447", new MarkKind("447", "NARKO"));
		cache.put("448", new MarkKind("448", "NCR"));
		cache.put("449", new MarkKind("449", "NEANDER"));
		cache.put("450", new MarkKind("450", "NEOPLAN"));
		cache.put("451", new MarkKind("451", "NESS MOTORCYCLES"));
		cache.put("452", new MarkKind("452", "NEW HOLLAND"));
		cache.put("453", new MarkKind("453", "NEXUS MOTORS"));
		cache.put("454", new MarkKind("454", "NIPPONIA"));
		cache.put("455", new MarkKind("455", "NISSAN"));
		cache.put("456", new MarkKind("456", "NOBLE"));
		cache.put("457", new MarkKind("457", "NOOTEBOOM"));
		cache.put("458", new MarkKind("458", "NORDIC TANK"));
		cache.put("459", new MarkKind("459", "NORTON"));
		cache.put("460", new MarkKind("460", "NYSA"));
		cache.put("461", new MarkKind("461", "O&K"));
		cache.put("462", new MarkKind("462", "O.ME.P.S."));
		cache.put("463", new MarkKind("463", "OFF MECC"));
		cache.put("464", new MarkKind("464", "OLDSMOBILE"));
		cache.put("465", new MarkKind("465", "OLTCIT"));
		cache.put("466", new MarkKind("466", "OMT"));
		cache.put("467", new MarkKind("467", "OPEL"));
		cache.put("468", new MarkKind("468", "ORION"));
		cache.put("469", new MarkKind("469", "OSCA"));
		cache.put("470", new MarkKind("470", "OTOSAN"));
		cache.put("471", new MarkKind("471", "PACTON"));
		cache.put("472", new MarkKind("472", "PAGANI"));
		cache.put("473", new MarkKind("473", "PALFINGER"));
		cache.put("474", new MarkKind("474", "PANNONIA"));
		cache.put("475", new MarkKind("475", "PANOZ"));
		cache.put("476", new MarkKind("476", "PANTHER"));
		cache.put("477", new MarkKind("477", "PARCISA"));
		cache.put("478", new MarkKind("478", "PAYKAN"));
		cache.put("479", new MarkKind("479", "PAZ"));
		cache.put("480", new MarkKind("480", "PERAVES"));
		cache.put("481", new MarkKind("481", "PERODUA"));
		cache.put("482", new MarkKind("482", "PETERBILT"));
		cache.put("483", new MarkKind("483", "PEUGEOT"));
		cache.put("484", new MarkKind("484", "PGO"));
		cache.put("485", new MarkKind("485", "PIAGGIO"));
		cache.put("486", new MarkKind("486", "PITSTER PRO"));
		cache.put("487", new MarkKind("487", "PKW"));
		cache.put("488", new MarkKind("488", "PLYMOUTH"));
		cache.put("489", new MarkKind("489", "PNO"));
		cache.put("490", new MarkKind("490", "POLARIS"));
		cache.put("491", new MarkKind("491", "POLINI"));
		cache.put("492", new MarkKind("492", "POLONEZ"));
		cache.put("493", new MarkKind("493", "PONSSE"));
		cache.put("494", new MarkKind("494", "PONTIAC"));
		cache.put("495", new MarkKind("495", "PORSCHE"));
		cache.put("496", new MarkKind("496", "POWERCAT"));
		cache.put("497", new MarkKind("497", "PRAGA"));
		cache.put("498", new MarkKind("498", "PRC (PRO RACING CYCLES)"));
		cache.put("499", new MarkKind("499", "PCW (PRECISION CYCLE WORKS)"));
		cache.put("500", new MarkKind("500", "PREMIER"));
		cache.put("501", new MarkKind("501", "PRIM-BALL"));
		cache.put("502", new MarkKind("502", "PROTON"));
		cache.put("503", new MarkKind("503", "PUCH"));
		cache.put("504", new MarkKind("504", "PUMA"));
		cache.put("505", new MarkKind("505", "PUTZMEISTER"));
		cache.put("506", new MarkKind("506", "QINGQI"));
		cache.put("507", new MarkKind("507", "QLINK"));
		cache.put("508", new MarkKind("508", "QOROS"));
		cache.put("509", new MarkKind("509", "QUANTYA"));
		cache.put("510", new MarkKind("510", "QVALE"));
		cache.put("511", new MarkKind("511", "RAF"));
		cache.put("512", new MarkKind("512", "RANGE ROVER"));
		cache.put("513", new MarkKind("513", "RAVI PIAGGIO"));
		cache.put("514", new MarkKind("514", "RED WING"));
		cache.put("515", new MarkKind("515", "REDNECK"));
		cache.put("516", new MarkKind("516", "RELIANT"));
		cache.put("517", new MarkKind("517", "RENAISSANCE CARS"));
		cache.put("518", new MarkKind("518", "RENAULT"));
		cache.put("519", new MarkKind("519", "RENDERS"));
		cache.put("520", new MarkKind("520", "RESPO"));
		cache.put("521", new MarkKind("521", "RHINO"));
		cache.put("522", new MarkKind("522", "RIDLEY"));
		cache.put("523", new MarkKind("523", "RIEJU"));
		cache.put("524", new MarkKind("524", "RINSPEED"));
		cache.put("525", new MarkKind("525", "ROAD HOPPER"));
		cache.put("526", new MarkKind("526", "ROBUR"));
		cache.put("527", new MarkKind("527", "ROEHR"));
		cache.put("528", new MarkKind("528", "ROHR"));
		cache.put("529", new MarkKind("529", "ROKON"));
		cache.put("530", new MarkKind("530", "ROLFO"));
		cache.put("531", new MarkKind("531", "ROLLS-ROYCE"));
		cache.put("532", new MarkKind("532", "RONART"));
		cache.put("533", new MarkKind("533", "ROVER"));
		cache.put("534", new MarkKind("534", "ROYAL ENFIELD"));
		cache.put("535", new MarkKind("535", "RUCKER PERFORMANCE"));
		cache.put("536", new MarkKind("536", "SAAB"));
		cache.put("537", new MarkKind("537", "SACHS"));
		cache.put("538", new MarkKind("538", "SACIM"));
		cache.put("539", new MarkKind("539", "SALEEN"));
		cache.put("540", new MarkKind("540", "SAMRO"));
		cache.put("541", new MarkKind("541", "SAMSUNG"));
		cache.put("542", new MarkKind("542", "SAMURAI CHOPPER"));
		cache.put("543", new MarkKind("543", "SANGLAS"));
		cache.put("544", new MarkKind("544", "SANTANA"));
		cache.put("545", new MarkKind("545", "SANY"));
		cache.put("546", new MarkKind("546", "SARIS"));
		cache.put("547", new MarkKind("547", "SATURN"));
		cache.put("548", new MarkKind("548", "SAXON"));
		cache.put("549", new MarkKind("549", "SCANIA"));
		cache.put("550", new MarkKind("550", "SCHMITZ"));
		cache.put("551", new MarkKind("551", "SCHWARZMULLER"));
		cache.put("552", new MarkKind("552", "SCHWINN"));
		cache.put("553", new MarkKind("553", "SCION"));
		cache.put("554", new MarkKind("554", "SCORPA"));
		cache.put("555", new MarkKind("555", "SDLG"));
		cache.put("556", new MarkKind("556", "SEAT"));
		cache.put("557", new MarkKind("557", "SEAZ"));
		cache.put("558", new MarkKind("558", "SEM"));
		cache.put("559", new MarkKind("559", "SENKE"));
		cache.put("560", new MarkKind("560", "SETRA"));
		cache.put("561", new MarkKind("561", "SHAANXI"));
		cache.put("562", new MarkKind("562", "SHANTUI"));
		cache.put("563", new MarkKind("563", "SHELBY"));
		cache.put("564", new MarkKind("564", "SHENLONG"));
		cache.put("565", new MarkKind("565", "SHERCO"));
		cache.put("566", new MarkKind("566", "SHIFENG"));
		cache.put("567", new MarkKind("567", "SHOKEL"));
		cache.put("568", new MarkKind("568", "SHORELANDER"));
		cache.put("569", new MarkKind("569", "SHUANGHUAN"));
		cache.put("570", new MarkKind("570", "SINOMACH"));
		cache.put("571", new MarkKind("571", "SISU"));
		cache.put("572", new MarkKind("572", "SKI-DOO"));
		cache.put("573", new MarkKind("573", "SKIF"));
		cache.put("574", new MarkKind("574", "SKODA"));
		cache.put("575", new MarkKind("575", "SKYTEAM"));
		cache.put("576", new MarkKind("576", "SMA"));
		cache.put("577", new MarkKind("577", "SMART"));
		cache.put("578", new MarkKind("578", "SOKON"));
		cache.put("579", new MarkKind("579", "SOMMER"));
		cache.put("580", new MarkKind("580", "SOUEAST"));
		cache.put("581", new MarkKind("581", "SPECTRE"));
		cache.put("582", new MarkKind("582", "SPIER"));
		cache.put("583", new MarkKind("583", "SPYKER"));
		cache.put("584", new MarkKind("584", "SSANGYONG"));
		cache.put("585", new MarkKind("585", "STANDBIKE"));
		cache.put("586", new MarkKind("586", "STAS"));
		cache.put("587", new MarkKind("587", "STEELBEAR"));
		cache.put("588", new MarkKind("588", "STEINSBERGER"));
		cache.put("589", new MarkKind("589", "STELS"));
		cache.put("590", new MarkKind("590", "STEMA"));
		cache.put("591", new MarkKind("591", "STILL"));
		cache.put("592", new MarkKind("592", "SUBARU"));
		cache.put("593", new MarkKind("593", "SUCKER PUNCH SALLYS"));
		cache.put("594", new MarkKind("594", "SUKIDA"));
		cache.put("595", new MarkKind("595", "SUNDIRO"));
		cache.put("596", new MarkKind("596", "SUNLONG"));
		cache.put("597", new MarkKind("597", "SUPER MOTOR"));
		cache.put("598", new MarkKind("598", "SUZUKI"));
		cache.put("599", new MarkKind("599", "SYM"));
		cache.put("600", new MarkKind("600", "SYRENA"));
		cache.put("601", new MarkKind("601", "TADANO FAUN"));
		cache.put("602", new MarkKind("602", "TALBOT"));
		cache.put("603", new MarkKind("603", "TARPAN"));
		cache.put("604", new MarkKind("604", "TARSUS"));
		cache.put("605", new MarkKind("605", "TATA"));
		cache.put("606", new MarkKind("606", "TATRA"));
		cache.put("607", new MarkKind("607", "TAURAS"));
		cache.put("608", new MarkKind("608", "TAURIS"));
		cache.put("609", new MarkKind("609", "TAYO"));
		cache.put("610", new MarkKind("610", "TCM"));
		cache.put("611", new MarkKind("611", "TEMSA"));
		cache.put("612", new MarkKind("612", "TEREX"));
		cache.put("613", new MarkKind("613", "TERRA MODENA"));
		cache.put("614", new MarkKind("614", "TESLA"));
		cache.put("615", new MarkKind("615", "TGB"));
		cache.put("616", new MarkKind("616", "TIANMA"));
		cache.put("617", new MarkKind("617", "TIANYE"));
		cache.put("618", new MarkKind("618", "TIGER"));
		cache.put("619", new MarkKind("619", "TIKI TREILER"));
		cache.put("620", new MarkKind("620", "TIMBERJACK"));
		cache.put("621", new MarkKind("621", "TITAN"));
		cache.put("622", new MarkKind("622", "TM RACING"));
		cache.put("623", new MarkKind("623", "TOFAS"));
		cache.put("624", new MarkKind("624", "TOMBERLIN"));
		cache.put("625", new MarkKind("625", "TOMOS"));
		cache.put("626", new MarkKind("626", "TONAR"));
		cache.put("627", new MarkKind("627", "TORGAU"));
		cache.put("628", new MarkKind("628", "TOYOTA"));
		cache.put("629", new MarkKind("629", "TRABANT"));
		cache.put("630", new MarkKind("630", "TRACK"));
		cache.put("631", new MarkKind("631", "TRAIL KING"));
		cache.put("632", new MarkKind("632", "TRAILOR"));
		cache.put("633", new MarkKind("633", "TRAVERTSON"));
		cache.put("634", new MarkKind("634", "TRIUMPH"));
		cache.put("635", new MarkKind("635", "TROLL"));
		cache.put("636", new MarkKind("636", "TROLZA"));
		cache.put("637", new MarkKind("637", "TSR"));
		cache.put("638", new MarkKind("638", "TURBO'S HOET"));
		cache.put("639", new MarkKind("639", "TVR"));
		cache.put("640", new MarkKind("640", "TVS"));
		cache.put("641", new MarkKind("641", "UAZ"));
		cache.put("642", new MarkKind("642", "UDS"));
		cache.put("643", new MarkKind("643", "UM"));
		cache.put("644", new MarkKind("644", "UNIMOG"));
		cache.put("645", new MarkKind("645", "URAL"));
		cache.put("646", new MarkKind("646", "UTILITY"));
		cache.put("647", new MarkKind("647", "VALMET"));
		cache.put("648", new MarkKind("648", "VAN HOOL"));
		cache.put("649", new MarkKind("649", "VAN VEEN"));
		cache.put("650", new MarkKind("650", "VAUXHALL"));
		cache.put("651", new MarkKind("651", "VAZ"));
		cache.put("652", new MarkKind("652", "VECTOR"));
		cache.put("653", new MarkKind("653", "VECTRIX"));
		cache.put("654", new MarkKind("654", "VELI"));
		cache.put("655", new MarkKind("655", "VENTO"));
		cache.put("656", new MarkKind("656", "VENTURI"));
		cache.put("657", new MarkKind("657", "VESPA"));
		cache.put("658", new MarkKind("658", "VIBERTI"));
		cache.put("659", new MarkKind("659", "VIBROMAX"));
		cache.put("660", new MarkKind("660", "VICTORY"));
		cache.put("661", new MarkKind("661", "VIPER"));
		cache.put("662", new MarkKind("662", "VIS"));
		cache.put("663", new MarkKind("663", "VMZ"));
		cache.put("664", new MarkKind("664", "VOGELE"));
		cache.put("665", new MarkKind("665", "VOLKSWAGEN"));
		cache.put("666", new MarkKind("666", "VOLVO"));
		cache.put("667", new MarkKind("667", "VORTEX"));
		cache.put("668", new MarkKind("668", "VUKA"));
		cache.put("669", new MarkKind("669", "WABASH"));
		cache.put("670", new MarkKind("670", "WACKER"));
		cache.put("671", new MarkKind("671", "WAKAN"));
		cache.put("672", new MarkKind("672", "WARTBURG"));
		cache.put("673", new MarkKind("673", "WESTFIELD"));
		cache.put("674", new MarkKind("674", "WIELTON"));
		cache.put("675", new MarkKind("675", "WIESMANN"));
		cache.put("676", new MarkKind("676", "WILK"));
		cache.put("677", new MarkKind("677", "WILLIG"));
		cache.put("678", new MarkKind("678", "WIRTGEN"));
		cache.put("679", new MarkKind("679", "WITZCO"));
		cache.put("680", new MarkKind("680", "WT MOTORS"));
		cache.put("681", new MarkKind("681", "WULING"));
		cache.put("682", new MarkKind("682", "XCG"));
		cache.put("683", new MarkKind("683", "XCMG"));
		cache.put("684", new MarkKind("684", "XIN KAI"));
		cache.put("685", new MarkKind("685", "XINGYUE"));
		cache.put("686", new MarkKind("686", "XMOTOS"));
		cache.put("687", new MarkKind("687", "YAMAHA"));
		cache.put("688", new MarkKind("688", "YANMAR"));
		cache.put("689", new MarkKind("689", "YIBEN"));
		cache.put("690", new MarkKind("690", "YOBYKES"));
		cache.put("691", new MarkKind("691", "YORK"));
		cache.put("692", new MarkKind("692", "YUGO"));
		cache.put("693", new MarkKind("693", "YUTONG"));
		cache.put("694", new MarkKind("694", "ZANELLA"));
		cache.put("695", new MarkKind("695", "ZASLAW"));
		cache.put("696", new MarkKind("696", "ZASTAVA"));
		cache.put("697", new MarkKind("697", "ZAZ"));
		cache.put("698", new MarkKind("698", "ZENVO"));
		cache.put("699", new MarkKind("699", "ZEST"));
		cache.put("700", new MarkKind("700", "ZHONG TONG"));
		cache.put("701", new MarkKind("701", "ZIL"));
		cache.put("702", new MarkKind("702", "ZNEN"));
		cache.put("703", new MarkKind("703", "ZONDA"));
		cache.put("704", new MarkKind("704", "ZONGSHEN"));
		cache.put("705", new MarkKind("705", "ZOOMLION"));
		cache.put("706", new MarkKind("706", "ZUK"));
		cache.put("707", new MarkKind("707", "ZUNDAPP"));
		cache.put("708", new MarkKind("708", "ZX AUTO"));
		cache.put("709", new MarkKind("709", "АВТОМАСТЕР"));
		cache.put("710", new MarkKind("710", "АЛЬТЕРНА"));
		cache.put("711", new MarkKind("711", "АМКОДОР"));
		cache.put("712", new MarkKind("712", "БАЛТСПЕЦМАШ"));
		cache.put("713", new MarkKind("713", "БЕЛАРУС"));
		cache.put("714", new MarkKind("714", "БЕЦЕМА"));
		cache.put("715", new MarkKind("715", "БОГДАН-СПЕЦАВТОТЕХНИКА"));
		cache.put("716", new MarkKind("716", "ВЗТМ"));
		cache.put("717", new MarkKind("717", "ГК СОДРУЖЕСТВО"));
		cache.put("718", new MarkKind("718", "ГРАЗ"));
		cache.put("719", new MarkKind("719", "ДЕСНА"));
		cache.put("720", new MarkKind("720", "ДЗ"));
		cache.put("721", new MarkKind("721", "ДИЗЕЛЬ-ТС"));
		cache.put("722", new MarkKind("722", "ДУ"));
		cache.put("723", new MarkKind("723", "ИВАНОВЕЦ"));
		cache.put("724", new MarkKind("724", "КИРОВЕЦ"));
		cache.put("725", new MarkKind("725", "ЛТЗ"));
		cache.put("726", new MarkKind("726", "МАРЗ"));
		cache.put("727", new MarkKind("727", "МТЗ"));
		cache.put("728", new MarkKind("728", "НЕМАН"));
		cache.put("729", new MarkKind("729", "НЕФАЗ"));
		cache.put("730", new MarkKind("730", "ПК"));
		cache.put("731", new MarkKind("731", "ПТЗ"));
		cache.put("732", new MarkKind("732", "ПТК"));
		cache.put("733", new MarkKind("733", "РОАЗ"));
		cache.put("734", new MarkKind("734", "РУССКАЯ МЕХАНИКА"));
		cache.put("735", new MarkKind("735", "СЗАП"));
		cache.put("736", new MarkKind("736", "СПЕЦПРИЦЕП"));
		cache.put("737", new MarkKind("737", "ТАГАЗ"));
		cache.put("738", new MarkKind("738", "ТВЭКС"));
		cache.put("739", new MarkKind("739", "ТРАНСМАШ"));
		cache.put("740", new MarkKind("740", "ТУШИНО-АВТО"));
		cache.put("741", new MarkKind("741", "ЧСДМ"));
		cache.put("742", new MarkKind("742", "ЭО"));
		cache.put("999", new MarkKind("999", "ПРОЧИЕ"));
	}

	@Override
	public String toString() {
		return name;
	}
}
