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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class General extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JComboBox comboBox;
	/**
	 * Create the frame.
	 */
	
	public General( Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the id-member for which member wants to give him a delivery");
		lblNewLabel.setBounds(26, 25, 375, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField.setEditable(true);
				}
				else{
					textField.setEditable(false);
				}
					
				}
			}
		});
		textField.setBounds(36, 41, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Enter for delivery: address,numItems,price,and if is delivered!");
		lblNewLabel_1.setBounds(21, 72, 336, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("address:");
		lblNewLabel_2.setBounds(21, 99, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 96, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("numItems:");
		lblNewLabel_3.setBounds(217, 99, 75, 14);
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
				}
					
				}
			}
		});
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("true");
		comboBox.addItem("false");
		comboBox.setBounds(259, 124, 96, 22);
		contentPane.add(comboBox);
		textField_2.setBounds(315, 97, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_4 = new JLabel("price:");
		lblNewLabel_4.setBounds(21, 123, 49, 14);
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
		textField_3.setBounds(67, 120, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_5 = new JLabel("isDelivered");
		lblNewLabel_5.setBounds(201, 123, 75, 14);
		contentPane.add(lblNewLabel_5);

		btnNewButton_1 = new JButton("Back To Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				General.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(542, 315, 127, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_2 = new JButton("find member");
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
					    		if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals(""))
					    		{
					    			throw new NullPointerException();
					    		}
								// if we here as the manager succeeded to add a delivery ,then entering what's the details's delivery 
					    		GeneralDelivery deliver1=new GeneralDelivery(textField_1.getText(),Integer.valueOf(textField_2.getText()),Double.valueOf(textField_3.getText()),Boolean.valueOf((String)comboBox.getSelectedItem()));
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
						}});

					}
					}
					if(flag1)
					{
						JOptionPane.showMessageDialog(getContentPane(),"We didn't find a member to add a delivery for him,it doesn't exit, try again,so you can't fill the fields below");	
					  	textField_1.setEditable(false);
				    	textField_2.setEditable(false);
				    	textField_3.setEditable(false);
						btnNewButton.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e)					
					    {
					  
					    	try {
					    		if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals(""))
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
		btnNewButton_2.setBounds(155, 40, 127, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton = new JButton("Add delivery");

		btnNewButton.setBounds(21, 148, 142, 23);
		contentPane.add(btnNewButton);

		

		}
	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
	
	}

