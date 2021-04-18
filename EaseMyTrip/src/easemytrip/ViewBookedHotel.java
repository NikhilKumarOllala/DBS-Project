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
public class ViewBookedHotel extends JFrame {
	private JPanel contentPane;
        Choice c1;
        
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBookedHotel frame = new ViewBookedHotel("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewBookedHotel(String username)  {
		setBounds(580, 220, 850, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/bookedDetails.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel la1 = new JLabel(i2);
                la1.setBounds(450,50,350,350);
                add(la1);
              
                
                BookHotel bh = new BookHotel(username);
                int goldCount= bh.goldCount;
                int silverCount = bh.silverCount;
                int bronzeCount = bh.bronzeCount;
                int basicCount  =  bh.basicCount;
	
            	
                JLabel lblName = new JLabel("VIEW BOOKED HOTEL DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(88, 11, 350, 53);
		contentPane.add(lblName);
                
                JLabel lb3 = new JLabel("Customer id :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);
                
                JLabel l1 = new JLabel();
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);
                
                JLabel lblId = new JLabel("Username :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);
                
                JLabel lb2 = new JLabel("Order id :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);
                
                JLabel l3 = new JLabel();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);
		
		JLabel lblName_1 = new JLabel("Hotel booked :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

                
		JLabel lblGender = new JLabel("Packages booked :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                JLabel lg = new JLabel("Gold : ");
		lg.setBounds(35, 270, 200, 14);
		contentPane.add(lg);
		

        JLabel l5 = new JLabel();
          l5.setBounds(100, 270, 200, 14);
         contentPane.add(l5);
         String g = String.valueOf(goldCount);
        l5.setText(g);


		JLabel l1s = new JLabel("Silver : ");
		l1s.setBounds(271, 270, 200, 14);
		contentPane.add(l1s);
		

		JLabel l11 = new JLabel();
		l11.setBounds(371, 270, 200, 14);
		contentPane.add(l11);
		String s = String.valueOf(silverCount);
		 l11.setText(s);


		JLabel lba = new JLabel("Basic : ");
		lba.setBounds(271, 310, 200, 14);
		contentPane.add(lba);
		
		JLabel l12 = new JLabel();
		l12.setBounds(371, 310, 200, 14);
		contentPane.add(l12);
		String ba = String.valueOf(basicCount);
		 l12.setText(ba);
		 
		JLabel lbr = new JLabel("Bronze : ");
		lbr.setBounds(35, 310, 200, 14);
		contentPane.add(lbr);
		

		JLabel l13 = new JLabel();
		l13.setBounds(100, 310, 200, 14);
		contentPane.add(l13);
		String br = String.valueOf(bronzeCount);
		 l13.setText(br);
		 
		JLabel lblCountry = new JLabel("Booking date :");
		lblCountry.setBounds(35, 350, 200, 14);
		contentPane.add(lblCountry);
                
                JLabel l6 = new JLabel();
		l6.setBounds(271, 350, 200, 14);
		contentPane.add(l6);
		
		JLabel lblReserveRoomNumber = new JLabel("Checkin date :");
		lblReserveRoomNumber.setBounds(35, 390, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                JLabel l7 = new JLabel();
		l7.setBounds(271, 390, 200, 14);
		contentPane.add(l7);
           	
		JLabel lblCheckInStatus = new JLabel("Hotel Number :");
		lblCheckInStatus.setBounds(35, 430, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                JLabel l8 = new JLabel();
		l8.setBounds(271, 430, 200, 14);
		contentPane.add(l8);

		
		JLabel lblDeposite = new JLabel("Total cost :");
		lblDeposite.setBounds(35, 470, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l9 = new JLabel();
		l9.setBounds(271, 470, 200, 14);
		contentPane.add(l9);
                
            
		
		JLabel l10 = new JLabel();
		l10.setBounds(271, 510, 200, 14);
		contentPane.add(l10);
	
                
		
		String customer_id = null,order_id = null,package_name=null;
				int hotel_id=0;
                Conn c = new Conn();
                try{

                    ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                    while(rs.next()){
                        l1.setText(rs.getString(1));
                        l2.setText(rs.getString(2));
                        customer_id = rs.getString(1);
                    }

                    rs.close();
                    
                    

                    ResultSet rs1 = c.s.executeQuery("select * from orders where customer_id = '"+customer_id+"'");
                    while(rs1.next()){
                    	
                        l3.setText(rs1.getString(1));
                        order_id=rs1.getString(1);
                        hotel_id=rs1.getInt("hotel_id");
                        l6.setText(rs1.getString("date_of_booking"));
                        l7.setText(rs1.getString("checkin_date"));
                        l9.setText(rs1.getString("total_cost"));
                        
                   
                    }

                    rs1.close();
                    

                    ResultSet rs2 = c.s.executeQuery("select * from hotels where hotel_id = '"+hotel_id+"'");
                    while(rs2.next()){
                    	
                        l4.setText(rs2.getString("hotel_name"));
                        l8.setText(rs2.getString("hotel_phone"));
                       
                   
                    }

                    rs2.close();
                    
                       }
                   
                   catch(SQLException e){}

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(160, 550, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}