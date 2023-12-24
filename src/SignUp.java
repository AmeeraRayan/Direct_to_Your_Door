import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private Managers managerCheck;	
	/**
	 * Create the frame.
	 */
	public SignUp(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 112, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(233, 150, 122));
		comboBox.addItem("north");
		comboBox.addItem("south");
		comboBox.addItem("central");
		comboBox.setBounds(57, 321, 90, 22);
		contentPane.add(comboBox);
		JLabel lblNewLabel = new JLabel("Signup:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblNewLabel.setBounds(22, 25, 103, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 82, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(89, 79, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 114, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 139, 77, 26);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 138, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Salary");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 204, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Entered the highest salary you got paid");
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 167, 299, 26);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_3.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_3.setEditable(true);
				}
				else{
					textField_3.setEditable(false);
					
				}}
			}
		});
		textField_3.setBounds(69, 201, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Seniority");
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 275, 77, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_4.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_4.setEditable(true);
				}
				else{
					textField_4.setEditable(false);
					
				}}
			}
		});
		textField_4.setBounds(89, 272, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Number Phone");
		lblNewLabel_7.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 300, 115, 23);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(121, 297, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Area");
		lblNewLabel_8.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 325, 49, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Entered how many of seniority do you have");
		lblNewLabel_9.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 229, 299, 32);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.setBackground(new Color(255, 20, 147));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(495, 370, 148, 39);
		contentPane.add(btnNewButton);
		passwordField = new JPasswordField();
		passwordField.setBounds(89, 111, 96, 20);
		contentPane.add(passwordField);
		JButton btnNewButton_1 = new JButton("signup");//there is no manager like the other because each one has different id absulotely 
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(205, 92, 92));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 FileWriter fw=null;
				if(textField.getText().equals("")||String.valueOf(passwordField.getPassword()).equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")
						||textField_4.getText().equals("")||textField_5.getText().equals("")
						)
				{
					throw new NullPointerException();
				}
              Managers manager=new Managers(textField.getText(),String.valueOf(passwordField.getPassword()),textField_2.getText(),Double.valueOf(textField_3.getText()),Double.valueOf(textField_4.getText()),textField_5.getText(),(String)comboBox.getSelectedItem());
              Boolean check1=DataBase.addManagers(manager);
              if(!check1)
              {
            	  throw new managerException();
              }
        	  try{
        		  File file = new File("dataManagers.txt");
        			   fw=new FileWriter(file,true);
        				 manager.save(fw);  	
        		  } catch (IOException e1) {
					e1.printStackTrace();
				}  finally 
        		  {
        			if (fw != null) 
        			{
						try {
							fw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
        			}
              JOptionPane.showMessageDialog(getContentPane(),"You added successfully,Congrats");
						
			}catch(NullPointerException d)
			{
				JOptionPane.showMessageDialog(getContentPane(),"You should fill all the fileds,there is missing informations");		
			}
			catch(managerException d)
				{
				JOptionPane.showMessageDialog(getContentPane(),d.getMessage());
				}
				textField.setText("");
				passwordField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			
		}});
		btnNewButton_1.setBounds(35, 370, 112, 39);
		contentPane.add(btnNewButton_1);

		
	}
}
