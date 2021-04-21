package easemytrip;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class ForgotPassword extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
	new ForgotPassword().setVisible(true);
    }

    public ForgotPassword() {

        setBounds(500, 200, 850, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Username");
	l1.setFont(new Font("Tahoma", Font.BOLD, 13));
	l1.setBounds(109, 83, 87, 29);
	contentPane.add(l1);

	JLabel l4 = new JLabel("Email");
	l4.setFont(new Font("Tahoma", Font.BOLD, 13));
	l4.setBounds(109, 132, 104, 21);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Password");
	l5.setFont(new Font("Tahoma", Font.BOLD, 13));
	l5.setBounds(109, 184, 104, 21);
	contentPane.add(l5);

	t1 = new JTextField();
	t1.setFont(new Font("Tahoma", Font.BOLD, 13));
	t1.setForeground(new Color(105, 105, 105));
	t1.setBounds(277, 88, 139, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	
	t4 = new JTextField();
	t4.setFont(new Font("Tahoma", Font.BOLD, 13));
	t4.setForeground(new Color(205, 92, 92));
	t4.setColumns(10);
	t4.setBounds(277, 132, 139, 20);
	contentPane.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);
	t5.setFont(new Font("Tahoma", Font.BOLD, 13));
	t5.setForeground(new Color(50, 205, 50));
	t5.setColumns(10);
	t5.setBounds(277, 184, 139, 20);
	contentPane.add(t5);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(560, 70, 200, 200);
        add(l6);

	

	b2 = new JButton("Retrieve");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 12));
	b2.setBounds(333, 270, 105, 32);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.BOLD, 13));
	b3.setBounds(133, 270, 105, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);

	JPanel panel = new JPanel();
	panel.setBounds(47, 45, 508, 281);
        panel.setBackground(Color.PINK);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
           

		
            if(ae.getSource() == b2){
            	  String sql = "select * from customer where username=? and email=?";
          		PreparedStatement st = con.c.prepareStatement(sql);

          		st.setString(1, t1.getText().toUpperCase());
          		st.setString(2, t4.getText());
          		ResultSet rs = st.executeQuery();
                   if(!rs.next())
                	   JOptionPane.showMessageDialog(null, "Enter Valid Credentials");
                   else
                	   t5.setText(rs.getString("password"));
		

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Login().setVisible(true);
			
            }
           
        	  
           
           
        }catch(Exception e){
        	
        }
    }

}