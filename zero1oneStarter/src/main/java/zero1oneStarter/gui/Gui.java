package zero1oneStarter.gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.*;

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
//				try {
//					startGedrueckt();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				seiteAufrufen("http://localhost:8080/dashboard/");
			}
		};
		buttonStart.addActionListener(al1);

		
		buttonAbbrechen = new JButton("ENDE");
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			} 
		}; 
		buttonAbbrechen.addActionListener(al2);

		buttonGit = new JButton("Git");
		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				seiteAufrufen("https://github.com/wellvalour/zero1one");
			} 
		}; 
		buttonGit.addActionListener(al3);
		
//		JPanel panel = new JPanel();
//		JLabel label = new JLabel(showImg());
//		panel.add(label);
//
//		panel.setBounds(5, 10, 150, 100);
//		this.add(panel);
		
		labelText.setBounds(5, 10, 200, 30);
		buttonStart.setBounds(5, 60, 100, 30);
		buttonAbbrechen.setBounds(125, 60, 100, 30);
		buttonGit.setBounds(245, 60, 100, 30);
		
		
		this.getContentPane().add(labelText);
		this.getContentPane().add(buttonAbbrechen);
		this.getContentPane().add(buttonStart);
		this.getContentPane().add(buttonGit);
		this.pack();
	}

	public ImageIcon showImg() {

		 BufferedImage img = null;
	        try {
	        	img = ImageIO.read(getClass().getResource("zero1oneBild.jpg"));
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new ImageIcon(img);
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
	

	public void startGedrueckt() throws IOException {
		try {
			Runtime.getRuntime().exec("cmd /c start C:/zero1one/zero1one/zero1one/src/main/java/StartSpring.bat");
			
		} catch (Exception e) {
			System.out.println("Uppps Fehler beim Ausführen der Spring Applikation");
		}
		
	}
	

	public static void main(String[] args) {
		Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
		Gui gui = new Gui();
		gui.setBounds((bildschirm.width-300)/2, (bildschirm.height-300)/2, 380, 150);//280, 200
		gui.setVisible(true);
		//gui.initialisiereFenster();
	}
}


