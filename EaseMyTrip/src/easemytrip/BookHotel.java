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
public class BookHotel extends JFrame {
	private JPanel contentPane;
        JTextField t1,t2;
        Choice c1,c2,c3,C4;
        private JComboBox comboBox;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookHotel frame = new BookHotel("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookHotel(String username) {
		setBounds(420, 220, 1100, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/book.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,100,700,300);
                add(la1);
		
		JLabel lblName = new JLabel("BOOK HOTEL");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel la2 = new JLabel("Username :");
		la2.setBounds(75, 70, 100, 14);
		contentPane.add(la2);
                
                JLabel l1 = new JLabel(username);
		l1.setBounds(271, 70, 100, 14);
		contentPane.add(l1);


         JLabel lcity = new JLabel("Select City :");
	     lcity.setBounds(75, 110, 100, 14);
	     contentPane.add(lcity);
	
		 
		 
                JLabel lblId = new JLabel("Select Hotel :");
		lblId.setBounds(75, 150, 100, 14);
		contentPane.add(lblId);
		

              
           

                
                
         /*       JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 150, 200, 14);
		contentPane.add(la3);
                
                t1 = new JTextField();
                t1.setText("0");
		t1.setBounds(271, 150, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
               
                JLabel la4 = new JLabel("Number of Days");
                la4.setBounds(35, 190, 200, 14);
		contentPane.add(la4);
		
		t2 = new JTextField();
		t2.setText("0");
		t2.setBounds(271, 190, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10); */
		
		
       		 C4 = new Choice();
                C4.add("HYDERABAD");
                C4.add("JAGITYAL");
                C4.add("CHENNAI");
                C4.add("DELHI");
                C4.add("BENGALURU");
                C4.add("MUMBAI");
                 C4.setBounds(250, 110, 150, 30);
                 add(C4);
               
                
		JLabel lbl1 = new JLabel("Rating :");
		lbl1.setBounds(75, 310, 100, 14);
		contentPane.add(lbl1);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 310, 100, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("Pincode :");
		lbl2.setBounds(75, 350, 100, 14);
		contentPane.add(lbl2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 350, 100, 14);
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(75, 390, 100, 14);
		contentPane.add(lbl3);
                
                JLabel l4 = new JLabel();
		l4.setBounds(271, 390, 100, 14);
		contentPane.add(l4);

		
		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(75, 430, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 430, 200, 14);
                l5.setForeground(Color.RED);
		contentPane.add(l5);
                
               
                
                JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                            try{
	    			String s1 = c1.getSelectedItem(); 
                                
                                String q1 = "select * from hotels where name = '"+c1.getSelectedItem()+"'";
                                ResultSet rs = c.s.executeQuery(q1);
                                if(rs.next()){
                                    
                                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                                    int food = Integer.parseInt(rs.getString("food_charges"));
                                    int ac = Integer.parseInt(rs.getString("ac_charges"));
                                    
                                    int persons = Integer.parseInt(t1.getText());
                                    int days = Integer.parseInt(t2.getText());
                                    
                                    String acprice = c2.getSelectedItem();
                                    String foodprice = c3.getSelectedItem();
                                    
                                    
                                    if(persons * days > 0) {
                                        int total = 0;
                                        total += acprice.equals("AC") ? ac : 1;
                                        total += foodprice.equals("Yes") ? food : 1;
                                        total += cost;
                                        total = total * persons * days;
                                        l5.setText("Rs "+total);
                                    }
                                    
                                    
                                }
                                
	    		}catch(Exception ee){
	    			System.out.println(ee.getMessage());
	    		}
                        }
		});
		b1.setBounds(50, 470, 120, 30);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		
		
		JButton ok= new JButton("ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                            try{

                                ResultSet rs = c.s.executeQuery("select * from hotels where hotel_name = '"+(String) c1.getSelectedItem()+"'");
                                while(rs.next()){
                                    l2.setText(rs.getString("ratings"));
                                    l3.setText(rs.getString("hotel_pin"));
                                    l4.setText(rs.getString("hotel_phone"));
                                   
                                    
                                }

                                rs.close();
                            }catch(SQLException e1){}
                           
                          
			}
		});   
 
	
		
		ok.setBounds(450, 150, 80, 20);
       ok.setBackground(Color.BLACK);
        ok.setForeground(Color.WHITE);
contentPane.add(ok);

		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = c1.getSelectedItem(); 
                                
                                String q1 = "insert into bookHotel values('"+l1.getText()+"', '"+s1+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l2.getText()+"', '"+l3.getText()+"', '"+l4.getText()+"', '"+l5.getText()+"')";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }
                            
			}
		});
	     
		
		 c1= new Choice();
		 c1.setBounds(250, 150, 150, 30);
	     add(c1);
	     
	     
		 JButton ok1= new JButton("ok");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.removeAll();
				 Conn c = new Conn();
                           String s2 = setChoice();
                            try{ 
                            	
                            	 ResultSet rs = c.s.executeQuery("select * from hotels where hotel_loc = '"+s2 +"' ");
                            
                                 while(rs.next()){
                                		 c1.add(rs.getString("hotel_name"));
                                     }

                                rs.close();
                            }catch(SQLException e1){}
                          
                   		 
                           
                        	
                            
			}

			private String setChoice() {
				String s2=C4.getSelectedItem();
				return s2;
			}
		});  
		
		
		 ok1.setBounds(450, 110, 80, 20);
         ok1.setBackground(Color.BLACK);
         ok1.setForeground(Color.WHITE);
         contentPane.add(ok1); 
                
		btnNewButton.setBounds(200, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 470, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}