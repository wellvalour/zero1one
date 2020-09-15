package bdgjmrsww.zero1one.util;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import bdgjmrsww.zero1one.controller.ConfigItemErgebnis;

@Component
public class XSLMessageConverterConfigItem extends AbstractHttpMessageConverter<ConfigItemErgebnis> {

	public XSLMessageConverterConfigItem() {
		super(MediaType.TEXT_HTML);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return ConfigItemErgebnis.class.isAssignableFrom(clazz);
	}

	@Override
	protected ConfigItemErgebnis readInternal(Class<? extends ConfigItemErgebnis> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		throw new HttpMessageNotReadableException("Die Richtung HTML -> Java wird nicht unterstützt (vorerst)",
				inputMessage);
	}

	@Override
	protected void writeInternal(ConfigItemErgebnis data, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		XSLTransformerConfigItem trans = new XSLTransformerConfigItem();

		try {
			outputMessage.getBody().write(trans.toHtml(data).getBytes());
		} catch (TransformerException | JAXBException e) {
			throw new IOException("Fehler bei erstellen des HTMLs", e);
		}
	}
}
