package bdgjmrsww.zero1one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Wird für den lokalen Start der Spring-Boot-Anwendung gestartet,
 * 
 * @author wellvalour
 *
 */
@SpringBootApplication
public class Zero1oneApplication {

	public static void main(String[] args) {
//		lustiger Roboter der vor lokalem Start der Anwendung ausgegeben wird
		File file = new File("src/main/resources/static/start.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
				
			}
		} catch (FileNotFoundException e) {
			// Ignored if it fails
		}

//		Start der Spring Anwendung
		SpringApplication.run(Zero1oneApplication.class, args);
	}

}
