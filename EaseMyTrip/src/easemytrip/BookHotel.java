package easemytrip;


import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.sql.*;
import java.util.UUID;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookHotel extends JFrame {
	private JPanel contentPane;
        JTextField t1,t2,t3,t4,t5;
        Choice c1,c2,c3,C4;
        private JComboBox comboBox;
       public static int total_price=0,goldCount=0,silverCount=0,bronzeCount=0,basicCount=0,goldCost=0,silverCost=0,bronzeCost=0,basicCost=0;
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
		lbl1.setBounds(75, 190, 100, 14);
		contentPane.add(lbl1);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 190, 100, 14);
		contentPane.add(l2);
		
		JLabel lbl2 = new JLabel("Pincode :");
		lbl2.setBounds(75, 230, 100, 14);
		contentPane.add(lbl2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 230, 100, 14);
		contentPane.add(l3);
           	
		JLabel lbl3 = new JLabel("Phone :");
		lbl3.setBounds(75, 270, 100, 14);
		contentPane.add(lbl3);
                
                JLabel l4 = new JLabel(" ");
		l4.setBounds(271, 270, 100, 14);
		contentPane.add(l4);
		
		JLabel lblPackage = new JLabel("CHOOSE PACKAGES");
		lblPackage .setBounds(75, 310, 200, 14);
		lblPackage.setForeground(Color.magenta);
		contentPane.add(lblPackage );
		
		
		JLabel lblgold = new JLabel("Gold :");
		lblgold.setBounds(75, 350, 200, 14);
		contentPane.add(lblgold );
		
		JLabel lblgoldp = new JLabel(" ");
		lblgoldp.setBounds(130, 350, 200, 14);
		contentPane.add(lblgoldp );
		
		
		t1 = new JTextField();
        t1.setText("0");
        t1.setBounds(200, 350, 40, 20);
        contentPane.add(t1);
        t1.setColumns(10);
       
		
		JLabel lblSilver = new JLabel("Silver :");
		lblSilver.setBounds(320, 390, 200, 14);
		contentPane.add(lblSilver );
		

		JLabel lblSilverp = new JLabel(" ");
		lblSilverp.setBounds(375, 390, 200, 14);
		contentPane.add(lblSilverp );
		
		t2 = new JTextField();
        t2.setText("0");
        t2.setBounds(445, 390, 40, 20);
        contentPane.add(t2);
        t2.setColumns(10);
		
		JLabel lblBronze= new JLabel("Bronze :");
		lblBronze.setBounds(320, 350, 200, 14);
		contentPane.add(lblBronze );
		
		JLabel lblBronzep= new JLabel(" ");
		lblBronzep.setBounds(375, 350, 200, 14);
		contentPane.add(lblBronzep );
		
		t3 = new JTextField();
        t3.setText("0");
        t3.setBounds(445, 350, 40, 20);
        contentPane.add(t3);
        t3.setColumns(10);
		
		JLabel lblBasic = new JLabel("Basic :");
		lblBasic.setBounds(75, 390, 200, 14);
		contentPane.add(lblBasic );
		
		JLabel lblBasicp = new JLabel(" ");
		lblBasicp.setBounds(130, 390, 200, 14);
		contentPane.add(lblBasicp );
		
		t4 = new JTextField();
        t4.setText("0");
        t4.setBounds(200, 390, 40, 20);
        contentPane.add(t4);
        t4.setColumns(10);
       
    	JLabel lblcheckin = new JLabel("Checkin date :");
		lblcheckin.setBounds(75, 470, 200, 14);
		contentPane.add(lblcheckin);
		
		t5=new JTextField();
		t5.setUI(new JTextFieldHintUI("dd-mm-yyyy", Color.gray));
		t5.setBounds(200, 470, 100, 24);
		contentPane.add(t5);
		
		
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
                           int total_cost=0;
                            try{
	    			
	    	          
                                String q1 = "select package_cost from packages where package_name='GOLD' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                                ResultSet rsG = c.s.executeQuery(q1);
                               if(rsG.next()){
                            	   int costG= rsG.getInt("package_cost");
                            	   int gold = Integer.parseInt(t1.getText());
                            	   goldCount=gold;
                            	   goldCost=costG*gold;
                            	   total_cost += costG*gold;
                            	   lblgoldp.setText("Rs "+costG);
                            	  
                                }
                                String q2 = "select package_cost from packages where package_name='SILVER' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                                ResultSet rsS = c.s.executeQuery(q2);
                                if(rsS.next()){
                                	int costS= rsS.getInt("package_cost");
                             	   int silver = Integer.parseInt(t2.getText());
                             	   silverCount = silver;
                             	   silverCost=costS*silver;
                             	  total_cost +=  costS*silver;
                             	  lblSilverp.setText("Rs "+costS);
                             	  
                                 }
                                String q3 = "select package_cost from packages where package_name='BRONZE' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                                ResultSet rsBR = c.s.executeQuery(q3);
                                if(rsBR.next()){
                                	 int costBR= Integer.parseInt(rsBR.getString("package_cost"));
                             	   int bronze = Integer.parseInt(t3.getText());
                             	   bronzeCount=bronze;
                             	   bronzeCost=costBR*bronze;
                             	  total_cost +=costBR*bronze;
                             	  lblBronzep.setText("Rs "+costBR);
                             	  
                                 }
                                String q4 = "select package_cost from packages where package_name='BASIC' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                                ResultSet rsBA = c.s.executeQuery(q4);
                                if(rsBA.next()){
                                    int costBA= Integer.parseInt(rsBA.getString("package_cost"));
                             	   int basic= Integer.parseInt(t4.getText());
                             	   basicCount=basic;
                             	   basicCost=costBA*basic;
                             	  total_cost += costBA*basic;
                             	  lblBasicp.setText("Rs "+costBA);
                             	  
                                 }
                                
                             
                                
                    
                               l5.setText("Rs "+total_cost); 
                               total_price=total_cost;
                            
	    		}catch(Exception ee){
	    			System.out.println(ee.getMessage());
	    		}
                        }
		});
		b1.setBounds(50, 510, 120, 30);
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
                                
                                
                                String q1 = "select package_cost from packages where package_name='GOLD' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                                ResultSet rsG = c.s.executeQuery(q1);
                               if(rsG.next()){
                            	   int costG= rsG.getInt("package_cost");
                            	   lblgoldp.setText("Rs "+costG);
                            	  
                                }
                               
                               String q2 = "select package_cost from packages where package_name='SILVER' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                               ResultSet rsS = c.s.executeQuery(q2);
                               if(rsS.next()){
                               	int costS= rsS.getInt("package_cost");
                               	lblSilverp.setText("Rs "+costS);
                            	  
                            	  
                                }
                               String q3 = "select package_cost from packages where package_name='BRONZE' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                               ResultSet rsBR = c.s.executeQuery(q3);
                               if(rsBR.next()){
                               	 int costBR= Integer.parseInt(rsBR.getString("package_cost"));
                               	lblBronzep.setText("Rs "+costBR);
                            	  
                            	  
                                }
                               String q4 = "select package_cost from packages where package_name='BASIC' and packages.hotel_id in (select hotel_id from hotels where hotels.hotel_id = packages.hotel_id and hotel_name ='"+(String) c1.getSelectedItem()+"')";
                               ResultSet rsBA = c.s.executeQuery(q4);
                               if(rsBA.next()){
                                   int costBA= Integer.parseInt(rsBA.getString("package_cost"));
                            	   lblBasicp.setText("Rs "+costBA);
                            	  
                                }
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
                            int hotel_id = 0;
                            String customer_id = null; 
                            int package_id = 0;
                            try{ 
                            	
                            	  ResultSet rs = c.s.executeQuery("select * from hotels where hotel_name = '"+(String) c1.getSelectedItem()+"'");
                                  
                                  while(rs.next()){
                                     
                                     hotel_id= rs.getInt("hotel_id");
                                      
                                  }

                                  rs.close();
                                  
                                  ResultSet rs1 = c.s.executeQuery("select customer_id from customer where username = '"+l1.getText().toUpperCase()+"'");
                                  
                                  while(rs1.next()){
                                     
                                    customer_id = rs1.getString("customer_id");
                                   System.out.print(customer_id);
                                      
                                  }

                                  rs1.close();
                           
                                  
                            	 String uuid=UUID.randomUUID().toString(); //Generates random UUID
                                 uuid = uuid.substring(0, Math.min(uuid.length(), 8));
                               
                                String q1 = "insert into orders values('"+uuid+"', '"+customer_id+"', '"+hotel_id+"',CURRENT_TIME(), '"+t5.getText()+"', NULL ,'"+total_price+"')";
                               
                                c.s.executeUpdate(q1);
                                
                                if(goldCount>0) {
                              	  ResultSet rsgC = c.s.executeQuery("select package_id from packages where hotel_id = '"+hotel_id+"' and package_name='GOLD'");
                                    
                                    while(rsgC.next()){
                                       
                                    package_id = rsgC.getInt("package_id");  
                                    }

                                    rsgC.close();
                                    String q2 = "insert into order_package values('"+uuid+"','"+package_id+"','"+goldCount+"', '"+goldCost+"' )";
                                    c.s.executeUpdate(q2);
                                     
                                }
                                
                                if(silverCount>0) {
                                	  ResultSet rsSC = c.s.executeQuery("select package_id from packages where hotel_id = '"+hotel_id+"' and package_name='SILVER'");
                                      
                                      while(rsSC.next()){
                                         
                                      package_id = rsSC.getInt("package_id");  
                                      }

                                      rsSC.close();
                                      String q3 = "insert into order_package values('"+uuid+"','"+package_id+"','"+silverCount+"', '"+silverCost+"' )";
                                      c.s.executeUpdate(q3);
                                       
                                  }
                                
                                if(basicCount>0) {
                                	  ResultSet rsBAC = c.s.executeQuery("select package_id from packages where hotel_id = '"+hotel_id+"' and package_name='BASIC'");
                                      
                                      while(rsBAC.next()){
                                         
                                      package_id = rsBAC.getInt("package_id");  
                                      }

                                      rsBAC.close();
                                      String q4 = "insert into order_package values('"+uuid+"','"+package_id+"','"+basicCount+"', '"+basicCost+"' )";
                                      c.s.executeUpdate(q4);
                                       
                                  }
                                
                                if(bronzeCount>0) {
                                	  ResultSet rsBRC = c.s.executeQuery("select package_id from packages where hotel_id = '"+hotel_id+"' and package_name='BRONZE'");
                                      
                                      while(rsBRC.next()){
                                         
                                      package_id = rsBRC.getInt("package_id");  
                                      }

                                      rsBRC.close();
                                      String q5 = "insert into order_package values('"+uuid+"','"+package_id+"','"+bronzeCount+"', '"+bronzeCost+"' )";
                                      c.s.executeUpdate(q5);
                                       
                                  }
                              
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
                
		btnNewButton.setBounds(200, 510, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}