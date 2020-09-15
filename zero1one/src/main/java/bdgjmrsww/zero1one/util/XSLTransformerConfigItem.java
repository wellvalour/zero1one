package bdgjmrsww.zero1one.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import bdgjmrsww.zero1one.controller.ConfigItemErgebnis;

public class XSLTransformerConfigItem {

	public String toHtml(ConfigItemErgebnis data) throws JAXBException, TransformerException {
		
		Source xml = readObject(data);
		Source xsl = readFile("templates/xsl/html-item.xsl");
		
		String result = transform(xml, xsl);
		
		return result;
	}

	private String transform(Source xml, Source xsl) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(xsl);
		
		StringWriter outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		transformer.transform(xml, result);
		
		return outWriter.getBuffer().toString();
		
	}

	private Source readFile(String name) {
		InputStream resource = this.getClass().getClassLoader().getResourceAsStream(name);
		return new StreamSource(resource);
	}

	private Source readObject(ConfigItemErgebnis data) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ConfigItemErgebnis.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		StringWriter out = new StringWriter();
		marshaller.marshal(data, out);
		String xml = out.toString();
		
		InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
		return new StreamSource(stream);
	}
	
	
}
