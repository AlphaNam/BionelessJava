import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


public class MyServerAndroid extends JFrame {

	private JPanel contentPane;
	private static ServerSocket ss;
	private static Socket s;
	private static BufferedReader br;
	private static InputStreamReader isr;
	private static String message="";
	private static JLabel jlabel = new JLabel("SERVER");
	private static String lastMouvement;
	private static String uriGen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MyServerAndroid frame = new MyServerAndroid();
					URL urlWalking = new URL("https://upload.wikimedia.org/wikipedia/commons/4/43/4-frame-walk-cycle.gif");
					URL urlRunning = new URL("https://i.gifer.com/7LD1.gif");
					URL urlUpstairs = new URL("https://i.gifer.com/7LD1.gif");
					URL urlDownstairs = new URL("https://i.gifer.com/7LD1.gif");
					URL urlImmobile = new URL("https://i.gifer.com/7LD1.gif");
					
					
					
					
					
					//URL url = this.getClass().getResource("C:\\Users\\Kevin\\eclipse-workspace\\BionelessJava\\res\\7LD1.gif");
			        /*
					Icon icon = new ImageIcon(urlWalking);
			        JLabel label = new JLabel(icon);

			        JFrame f = new JFrame("Animation");
			        f.getContentPane().add(label);
			        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        f.pack();
			        f.setLocationRelativeTo(null);
			        f.setVisible(true);
			        */
					//frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Kevin\\Downloads\\chromedriver_win32_reel\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:3000/index");
			//JFrame f = new JFrame("Animation");
			while(true)
			{
				ss = new ServerSocket(5000);
				//System.out.println("Server running at port 5000");
				s = ss.accept();
				
				
				isr = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(isr);
				message = br.readLine();
				
				System.out.println(message);
				
				if( lastMouvement==null ||lastMouvement.compareTo(message)!=0) {
					lastMouvement = message;
					uriGen = "http://localhost:3000/" + message.toLowerCase();
					driver.get(uriGen);
				}
				
				/*
				driver.get("http://localhost:3000/marcher");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://localhost:3000/courir");
				*/
				/*URI myUri;
				try {
					myUri = new URI("http://localhost:3000/marcher");
					Desktop.getDesktop().browse(myUri);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				
				/*
				for(int i = 0; i< f.getContentPane().getComponentCount(); i++) {
					JLabel label = (JLabel) f.getContentPane().getComponent(i);
					label.setIcon(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/4/43/4-frame-walk-cycle.gif")));
					
				}
				
				
				
		        //f.getContentPane().add(new JLabel(new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/4/43/4-frame-walk-cycle.gif"))));
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.pack();
		        f.setLocationRelativeTo(null);
		        f.setVisible(true);
		        */
		        
				
				isr.close();
				br.close();
				ss.close();
				s.close();
				
				
				
				
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MyServerAndroid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//JLabel lblNewLabel = new JLabel("SERVER");
		//jlabel = lblNewLabel;
		//contentPane.add(jlabel, BorderLayout.CENTER);
		
		//if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
        	//Desktop.getDesktop().browse(new URI("http://localhost:3000/marcher"));
	}

}
