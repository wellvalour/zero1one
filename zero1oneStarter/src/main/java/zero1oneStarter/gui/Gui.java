package zero1oneStarter.gui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui extends JFrame {
	JButton buttonStart, buttonAbbrechen, buttonGit;

	public Gui() {
		this.getContentPane().setLayout(null);
		this.initialisiereFenster();
	}

	protected void initialisiereFenster() {
      
		JLabel labelText = new JLabel("Start zero1one Application");
		
		buttonStart = new JButton("Start");
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				seiteAufrufen("http://localhost:8080/dashboard/");
				System.exit(0);
			}
		};
		buttonStart.addActionListener(al1);

		
//		buttonAbbrechen = new JButton("ENDE");
//		ActionListener al2 = new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				System.exit(0);
//			} 
//		}; 
//		buttonAbbrechen.addActionListener(al2);

		buttonGit = new JButton("Git");
		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				seiteAufrufen("https://github.com/wellvalour/zero1one");
			} 
		}; 
		buttonGit.addActionListener(al3);
		
		labelText.setBounds(5, 10, 200, 30);
		buttonStart.setBounds(5, 60, 100, 30);
//		buttonAbbrechen.setBounds(125, 60, 100, 30);
		buttonGit.setBounds(245, 60, 100, 30);
		
		
		this.getContentPane().add(labelText);
//		this.getContentPane().add(buttonAbbrechen);
		this.getContentPane().add(buttonStart);
		this.getContentPane().add(buttonGit);
		this.pack();
	}
	
	public void seiteAufrufen(String seite) {
		
		 try {
	            Desktop.getDesktop().browse(new URI(seite));
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (URISyntaxException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		  Process p = Runtime.getRuntime().exec("java -jar zero1one-1.0.0.war");
		  
		
//		Runtime.getRuntime().exec("java -jar zero1one-1.0.0.war");
		
		Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
		Gui gui = new Gui();
		gui.setBounds((bildschirm.width-300)/2, (bildschirm.height-300)/2, 380, 150);//280, 200
		gui.setVisible(true);
	}
}


