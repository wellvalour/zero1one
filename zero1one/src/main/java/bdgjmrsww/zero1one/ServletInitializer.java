package bdgjmrsww.zero1one;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Für Start auf Server
 * Wird bei lokalem Start nicht benötigt
 * @author wellvalour
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Zero1oneApplication.class);
	}

}
