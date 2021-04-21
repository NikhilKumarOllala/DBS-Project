package easemytrip;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomer frame = new UpdateCustomer("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateCustomer(String username) throws SQLException {
		System.out.println(username);
                setBounds(580, 220, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/man.png"));
                Image i3 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,40,200,400);
                add(l1);
		
		JLabel lblName = new JLabel("My Profile");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Customer id :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
		
		JLabel t1 = new JLabel("");
		 t1.setBounds(271, 70, 150, 20);
		 contentPane.add(t1);
		 
		
		
		
                
                JLabel lblId = new JLabel("username :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                t2 = new JTextField();
		t2.setBounds(271, 110, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                
                JLabel l2 = new JLabel("Email :");
		l2.setBounds(35, 150, 250, 14);
		contentPane.add(l2);
                
		 JLabel t3 = new JLabel("");
		 t3.setBounds(271, 150, 150, 20);
			contentPane.add(t3);
			
		
		JLabel lblName_1 = new JLabel("Phone :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t4 = new JTextField();
		t4.setBounds(271, 190, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);

                
		JLabel lblGender = new JLabel("Password :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                t5 = new JTextField();
		t5.setBounds(271, 230, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
                
		JLabel lblCountry = new JLabel("Date of Birth :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
             
		JLabel t6 = new JLabel("");
		t6.setBounds(271, 270, 150, 20);
		contentPane.add(t6);
               
		
		JLabel lblReserveRoomNumber = new JLabel("Gender:");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
		JLabel t7 = new JLabel("");
		t7.setBounds(271, 310, 150, 20);
		contentPane.add(t7);
		
              
           	
		JLabel lblCheckInStatus = new JLabel("City :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t8 = new JTextField();
		t8.setBounds(271, 350, 150, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		
		
		
	
		
		
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                    if(rs.next()){
                        t1.setText(rs.getString(1));  
                        t2.setText(rs.getString(2));
                        t3.setText(rs.getString(3));  
                        t4.setText(rs.getString(4));
                        t5.setText(rs.getString(5));  
                        t6.setText(rs.getString(6));
                        t7.setText(rs.getString(7));  
                        t8.setText(rs.getString(8));
                        t9.setText(rs.getString(9));
                    }
                }catch(Exception e){ }
		
		

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = t1.getText();
                                String s2 = t2.getText(); 
	    			String s3 =  t3.getText();
	    			String s4 =  t4.getText();
                                String s5 =  t5.getText();
	    			String s6 =  t6.getText();
	    			String s7 =  t7.getText(); 
                                String s8 =  t8.getText();
                              
                                
                                String q1 = "update customer set email = '"+s3+"', username = '"+s2+"', gender = '"+s7+"', password = '"+s5+"', city = '"+s8+"', phone = '"+s4+"' where customer_id = '"+s1+"'";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    			JOptionPane.showMessageDialog(null, "Username unavailable!");
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
