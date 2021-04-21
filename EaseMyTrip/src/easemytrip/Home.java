package easemytrip;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class Home extends JFrame{
    String username;
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
    
    public Home(String username) {
        super("Ease My Trip");
	this.username = username;
        setForeground(Color.CYAN);
        setLayout(null); 
	  
        
      
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/Hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 950, 500); 
        add(NewLabel);
        
        JLabel l1 = new JLabel("Ease My Trip");
	l1.setForeground(Color.WHITE);
        l1.setFont(new Font("robonto", Font.BOLD, 45));
	l1.setBounds(40, 30, 1000, 100);
	NewLabel.add(l1);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu m1 = new JMenu("PROFILE");
	menuBar.add(m1);
		
 
        
        JMenuItem mi1 = new JMenuItem("View Profile");
	m1.add(mi1);
        
       
        
    
        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new UpdateCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
  
        
		
	JMenu m2 = new JMenu("PACKAGES");
	menuBar.add(m2);
        
        JMenuItem mi6 = new JMenuItem("CHECK PACKAGE");
	m2.add(mi6);
        
        
        mi6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                   new CheckPackage().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

  
        


        
        JMenu m3 = new JMenu("HOTELS");
     	menuBar.add(m3);
        
        JMenuItem mi8 = new JMenuItem("BOOK HOTELS");
	m3.add(mi8);
        
        JMenuItem mi9 = new JMenuItem("VIEW HOTELS");
	m3.add(mi9);
        
        JMenuItem mi10 = new JMenuItem("VIEW BOOKED HOTEL");
	m3.add(mi10);
        
        mi8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BookHotel(username).setVisible(true);
            }
	});
        
        
        
	mi9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                   new CheckHotels().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewBookedHotel(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
      
        
        JMenu m5 = new JMenu("PAYMENT");
	menuBar.add(m5);
        
        JMenuItem mi12 = new JMenuItem("PAY USING PAYTM");
	m5.add(mi12);
        
        mi12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Payment().setVisible(true);
            }
	});
        
        JMenu m6 = new JMenu("UTILITY");
	menuBar.add(m6);
        
        JMenuItem mi13 = new JMenuItem("NOTEPAD");
	m6.add(mi13);
        
        JMenuItem mi14 = new JMenuItem("CALCULATOR");
	m6.add(mi14);
        
        mi13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){ }
            }
	});
        
        
        mi14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
	});
        
  
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 150, 700, 606);
    }
}