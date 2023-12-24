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

public class AddSubManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private Managers managerCheck;
	private JPasswordField passwordField;

	public AddSubManager(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Sub Manager");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 26, 157, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sub manager UserName");
		lblNewLabel_1.setBounds(27, 78, 157, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(194, 75, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(27, 112, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setBounds(27, 148, 94, 26);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 151, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Entered the highest salary you got paid");
		lblNewLabel_5.setBounds(27, 187, 299, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Salary");
		lblNewLabel_4.setBounds(27, 224, 49, 26);
		contentPane.add(lblNewLabel_4);
		
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
		textField_3.setColumns(10);
		textField_3.setBounds(88, 224, 96, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_9 = new JLabel("Entered how many of seniority do you have");
		lblNewLabel_9.setBounds(27, 261, 299, 32);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6 = new JLabel("Seniority");
		lblNewLabel_6.setBounds(27, 304, 77, 14);
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
		textField_4.setColumns(10);
		textField_4.setBounds(114, 304, 96, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_7 = new JLabel("Number Phone");
		lblNewLabel_7.setBounds(27, 334, 115, 23);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(152, 335, 96, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_8 = new JLabel("Area");
		lblNewLabel_8.setBounds(27, 368, 49, 14);
		contentPane.add(lblNewLabel_8);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(173, 255, 47));
		comboBox.addItem("north");
		comboBox.addItem("south");
		comboBox.addItem("central");
		comboBox.setBounds(69, 368, 86, 22);
		contentPane.add(comboBox);
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 109, 129, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_10 = new JLabel("How many deliveries can handle");
		lblNewLabel_10.setBounds(27, 393, 221, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_7.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_7.setEditable(true);
				}
				else{
					textField_7.setEditable(false);
				}}
					
			}
		});
		textField_7.setBounds(258, 390, 96, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Sub Manager");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 FileWriter fw=null;
				if(textField.getText().equals("")||String.valueOf(passwordField.getPassword()).equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")
						||textField_4.getText().equals("")||textField_5.getText().equals("")
						||textField_7.getText().equals(""))
				{
					throw new NullPointerException();
				}
				
				SubManager subManager=new SubManager(textField.getText(),String.valueOf(passwordField.getPassword()),textField_2.getText(),Double.valueOf(textField_3.getText()),
            		 Double.valueOf(textField_4.getText()),textField_5.getText(),(String)comboBox.getSelectedItem(),Integer.valueOf(textField_7.getText()));
					if(!DataBase.addsubManagers(subManager))
						   throw new SubmanagerException();	
	                JOptionPane.showMessageDialog(getContentPane(),"You added successfully,Congrats");
	                try{
	          		  File file = new File("datasubManagers.txt");
	          			   fw=new FileWriter(file,true);
	          			 subManager.save(fw);  	
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
								
			}catch(NullPointerException d)
			{
				JOptionPane.showMessageDialog(getContentPane(),"You should fill all the fileds,there is missing informations");		
			}
			catch(SubmanagerException d)
			{
					JOptionPane.showMessageDialog(getContentPane(),d.getMessage());	
			}
				textField.setText("");
				passwordField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_7.setText("");


			}
			
		});
		btnNewButton.setBounds(15, 418, 195, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back to Menu");
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(199, 21, 133));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubManager.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);	
			}
		});
		btnNewButton_1.setBounds(625, 393, 129, 71);
		contentPane.add(btnNewButton_1);

	
	}

	public Managers getManagerCheck() {
		return managerCheck;
	}

	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
	

}
