import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

public class Business extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public Business(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the id-member for which member wants to give him a delivery");
		lblNewLabel.setBounds(10, 11, 375, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 34, 96, 20);
		contentPane.add(textField);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(72, 219, 96, 22);
		contentPane.add(comboBox);
		comboBox.addItem("true");
		comboBox.addItem("false");
		JButton btnNewButton = new JButton("Add delivery");

		btnNewButton.setBounds(26, 275, 142, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("find member");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag1=true;
				try {
					if(textField.getText().equals(""))
					{
				  	   throw new NullPointerException();
					}
					for(int j=0;j<managerCheck.getMembers().size()&&flag1;j++)//checking a member in system's manager 
					{
					if(managerCheck.getMembers().containsKey(Integer.valueOf(textField.getText())))//if already there is a member thats have a same code 
					{
						flag1=false;
					    JOptionPane.showMessageDialog(getContentPane(),"The member with code: "+textField.getText()+" was founded!, so we can give him a delivery");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// if we here as the manager succeeded to add a delivery ,then entering what's the details's delivery 
					    		GeneralDelivery deliver1=new BusinessDelivery(textField_1.getText(),Integer.valueOf(textField_2.getText()),Double.valueOf(textField_3.getText()),Boolean.valueOf(comboBox.getActionCommand()),textField_5.getText(),textField_6.getText(),Double.valueOf(textField_4.getText()));
					    		//if we already succeeded to add a new delivery for member then check is true 
								boolean check1=managerCheck.getMembers().get(Integer.valueOf(textField.getText())).addNewDelivery(deliver1);
								if(check1)//if we are here as succeeded to add a delivery
								{
									FileWriter fw=null;
									   try{ 
							        		  File file = new File("deliveries.txt");
							        			   fw=new FileWriter(file,true);
							        			   deliver1.save(fw,managerCheck.getMembers().get(Integer.valueOf(textField.getText())));  
							        		  } catch (IOException e1) {
												e1.printStackTrace();
											}  finally 
							        		  {
							        			if (fw != null) 
							        			{
													try {
														fw.close();
													} catch (IOException e1) {
														e1.printStackTrace();
													}
												}
							        		  }	
									JOptionPane.showMessageDialog(getContentPane(),"adding a new delivery is succeeded");
									DataBase.addLastDelivery(managerCheck.getMembers().get(Integer.valueOf(textField.getText())), deliver1);//added a member with his delivery and actually the last one added 
									DataBase.addourMembers(managerCheck.getMembers().get(Integer.valueOf(textField.getText())));//all the members that have a delivery is in this DataBase
									DataBase.addourMembersAndDeluveries(deliver1);//the database has all the deliveries that ordered the members , also if member ordered more than one  delivery , each order has a unique code 
								}
								else
								{
									JOptionPane.showMessageDialog(getContentPane(),"sorry we didn't succeed! to add a Generaldelivery");
								}
						    	textField.setText("");
						    	textField_1.setText("");
						    	textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField_6.setText("");
							}
						});
					}
					}
					if(flag1)
					{
						JOptionPane.showMessageDialog(getContentPane(),"We didn't find a member to add a delivery for him,it doesn't exit, try again");
						textField_1.setEditable(false);
				    	textField_2.setEditable(false);
				    	textField_3.setEditable(false);
				    	textField_4.setEditable(false);
				    	textField_5.setEditable(false);
				    	textField_6.setEditable(false);
				    	btnNewButton.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent e)					
						    {
						  
						    	try {
						    		if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||(textField_4.getText().equals("")||textField_5.getText().equals("")||textField_6.getText().equals("")))
						    		{
										  throw new NullPointerException();
						    		}
								if(e.getSource()==btnNewButton)
								{
								  throw new NullPointerException();
								}}
								catch(NullPointerException d)
								{
									JOptionPane.showMessageDialog(getContentPane(),
											"The fields will be empty because there is no member to add for him delivery, and if you selected option which is find member and you didnt find as you willl didnt add delivery"); 										
								}
	
						     }
							});
					}

				}catch(NullPointerException d)
				{
					JOptionPane.showMessageDialog(getContentPane(),"You should fill the filed,there is missing informations");		
				}
			}
		});
		btnNewButton_2.setBounds(137, 33, 127, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Also you have to add numPhone,email and taxes");
		lblNewLabel_1.setBounds(10, 80, 293, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter for delivery: address,numItems,price,and if is delivered!");
		lblNewLabel_1_1.setBounds(10, 59, 375, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("address:");
		lblNewLabel_2.setBounds(10, 105, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 102, 96, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("numItems:");
		lblNewLabel_3.setBounds(191, 105, 65, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_2.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_2.setEditable(true);
				}
				else{
					textField_2.setEditable(false);
					
				}}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(250, 102, 96, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("price:");
		lblNewLabel_4.setBounds(10, 130, 49, 14);
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
		textField_3.setBounds(72, 127, 96, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_6 = new JLabel("numPhone");
		lblNewLabel_6.setBounds(10, 155, 95, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("email");
		lblNewLabel_7.setBounds(10, 191, 52, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(115, 152, 81, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(55, 188, 272, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("isDelivered");
		lblNewLabel_8.setBounds(10, 225, 65, 14);
		contentPane.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("taxes");
		lblNewLabel_9.setBounds(201, 133, 65, 14);
		contentPane.add(lblNewLabel_9);

		
		JButton btnNewButton_1 = new JButton("Back To Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Business.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(552, 256, 152, 60);
		contentPane.add(btnNewButton_1);
		
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
		textField_4.setBounds(250, 130, 67, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}

	public Managers getManagerCheck() {
		return managerCheck;
	}

	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
	
}
