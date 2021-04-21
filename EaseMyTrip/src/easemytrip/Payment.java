package easemytrip;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Payment extends JFrame {
	
	
	
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
      


	public Payment() {
            
	setBackground(new Color(255, 255, 204));	
        setBounds(550, 250, 700, 400);
		
        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("BOOK  "
			+ " NOW   "
			+ " PAY  "
			+ " AT  "
			+ " HOTEL ");
	l1.setBounds(224, 19, 195, 324);
		panel.add(l1);

	

      
        
    

	

	}
        
      
        
  	public static void main(String[] args) {
                new Payment().setVisible(true);
	}

}
