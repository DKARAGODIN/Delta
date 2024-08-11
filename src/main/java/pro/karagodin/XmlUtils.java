package pro.karagodin;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;
import ru.customs.information.commercialfinancedocuments.recyclingdetails._5_23.RecyclingDetailsType;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;


public class XmlUtils {

	private static final Validator validator;
	private static final Unmarshaller jaxbUnmarshaller;
	private static final Marshaller jaxbMarshaller;

	static {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			JAXBContext jaxbContext = JAXBContext.newInstance(RecyclingDetailsType.class);

			InputStream is1 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/CategoriesCust.xsd");
			InputStream is2 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/CommonLeafTypesCust.xsd");
			InputStream is3 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/CommonAggregateTypesCust.xsd");
			InputStream is4 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/CUESADCommonLeafTypesCust.xsd");
			InputStream is5 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/RUSCommonLeafTypes.xsd");
			InputStream is6 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/RUSCommonAggregateTypes.xsd");
			InputStream is7 = XmlUtils.class.getClassLoader().getResourceAsStream("xsd/RecyclingDetails.xsd");
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
			validator = schema.newValidator();

			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setSchema(schema);
		} catch (JAXBException | SAXException e) {
			throw new RuntimeException(e);
		}
	}

	public static void validate(String xml) throws IOException, SAXException {
		validator.validate(new StreamSource(new StringReader(xml)));
	}

	public static void marshall(Object o, File file) throws JAXBException {
		jaxbMarshaller.marshal(o, file);
	}

	public static <T> JAXBElement<T> unMarshall(Source source, Class<T> c) throws JAXBException {
		return jaxbUnmarshaller.unmarshal(source, c);
	}
}
