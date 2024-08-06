package pro.karagodin;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;


public class XsdValidator {

	private final Validator validator;

	public XsdValidator() throws SAXException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		InputStream is1 = getClass().getClassLoader().getResourceAsStream("xsd/CategoriesCust.xsd");
		InputStream is2 = getClass().getClassLoader().getResourceAsStream("xsd/CommonLeafTypesCust.xsd");
		InputStream is3 = getClass().getClassLoader().getResourceAsStream("xsd/CommonAggregateTypesCust.xsd");
		InputStream is4 = getClass().getClassLoader().getResourceAsStream("xsd/CUESADCommonLeafTypesCust.xsd");
		InputStream is5 = getClass().getClassLoader().getResourceAsStream("xsd/RUSCommonLeafTypes.xsd");
		InputStream is6 = getClass().getClassLoader().getResourceAsStream("xsd/RUSCommonAggregateTypes.xsd");
		InputStream is7 = getClass().getClassLoader().getResourceAsStream("xsd/RecyclingDetails.xsd");
		Source[] schemaFile = {
				new StreamSource(is1),
				new StreamSource(is2),
				new StreamSource(is3),
				new StreamSource(is4),
				new StreamSource(is5),
				new StreamSource(is6),
				new StreamSource(is7),
		};
		Schema schema = factory.newSchema(schemaFile);
		this.validator = schema.newValidator();
	}


	public void validate(String xml) throws IOException, SAXException {
		validator.validate(new StreamSource(new StringReader(xml)));
	}
}
