package easemytrip;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JButton b1, b2;
    private JComboBox comboBox;
    

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        setBounds(600, 150, 700, 606);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.DARK_GRAY);
	lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblEmail = new JLabel("Email :");
	lblEmail.setForeground(Color.DARK_GRAY);
	lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblEmail.setBounds(99, 123, 92, 26);
	contentPane.add(lblEmail);

	JLabel lblPhone = new JLabel("Phone :");
	lblPhone.setForeground(Color.DARK_GRAY);
	lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPhone.setBounds(99, 160, 92, 26);
	contentPane.add(lblPhone);

	JLabel lblPassword = new JLabel("Password :");
	lblPassword.setForeground(Color.DARK_GRAY);
	lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblPassword.setBounds(99, 234, 92, 26);
	contentPane.add(lblPassword);
	

	JLabel lbldob = new JLabel("Birth Date :");
	lbldob.setForeground(Color.DARK_GRAY);
	lbldob.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbldob.setBounds(99, 271, 92, 26);
	contentPane.add(lbldob);


	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"MALE","FEMALE","OTHER" }));
	comboBox.setBounds(265, 202, 148, 20);
	contentPane.add(comboBox);

	JLabel lblSecurityQuestion = new JLabel("Gender :");
	lblSecurityQuestion.setForeground(Color.DARK_GRAY);
	lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(99, 197, 140, 26);
	contentPane.add(lblSecurityQuestion);
        

	JLabel lblcity = new JLabel("City :");
	lblcity.setForeground(Color.DARK_GRAY);
	lblcity.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblcity.setBounds(99, 308, 92, 26);
	contentPane.add(lblcity);


        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("easemytrip/icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(440, 90, 200, 200);
        add(l6);

        textField = new JTextField();
	textField.setBounds(265, 91, 148, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 128, 148, 20);
	contentPane.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 165, 148, 20);
	contentPane.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 239, 148, 20);
	contentPane.add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setUI(new JTextFieldHintUI("dd-mm-yyyy", Color.gray));
	textField_4.setBounds(265, 274, 148, 20);
	contentPane.add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(265,311, 148, 20);
	contentPane.add(textField_5);

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(140, 359, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(300, 359, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(31, 30, 640, 410);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            String uuid=UUID.randomUUID().toString(); //Generates random UUID
            uuid = uuid.substring(0, Math.min(uuid.length(), 8));
            if(ae.getSource() == b1){
                String sql = "insert into customer( customer_id, username, email, phone, password, dateOfBirth, gender, city) values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		
		st.setString(1, uuid);
		st.setString(2, textField.getText().toUpperCase());
        st.setString(3, textField_1.getText().toLowerCase());
		st.setString(4, textField_2.getText());
		st.setString(5, textField_3.getText());
		st.setString(6, textField_4.getText());
		st.setString(7, (String) comboBox.getSelectedItem());
		st.setString(8, textField_5.getText().toUpperCase());

		

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                    setVisible(false);
                    new Loading(textField.getText()).setVisible(true);
                }

                textField.setText("");
                textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login().setVisible(true);
			
            }
        }catch(Exception e){
                System.out.println(e);
        }
    }
}