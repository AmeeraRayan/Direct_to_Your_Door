import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class AddShortDelivery extends JFrame {

	private JPanel contentPane;
    private SubManager submanagerCheck; 
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_11;
    private JTextField textField_12;
	/**
	 * Create the frame.
	 */
	public AddShortDelivery(SubManager submanagerCheck) {
		this.submanagerCheck= submanagerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select a member:");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblNewLabel.setBounds(22, 11, 253, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.setBackground(new Color(153, 102, 0));
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnNewButton_1.setBounds(32, 449, 155, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.setBackground(new Color(204, 204, 0));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnNewButton.setBounds(620, 440, 140, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("create a short delivery:");
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblNewLabel_5.setBounds(22, 128, 216, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("address:");
		lblNewLabel_2_1.setBounds(22, 172, 75, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(81, 172, 96, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("numItems:");
		lblNewLabel_3_1.setBounds(200, 175, 75, 14);
		contentPane.add(lblNewLabel_3_1);
		
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
		textField_4.setBounds(270, 175, 96, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("price:");
		lblNewLabel_4_1.setBounds(389, 181, 49, 14);
		contentPane.add(lblNewLabel_4_1);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_5.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_5.setEditable(true);
				}
				else{
					textField_5.setEditable(false);
				}}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(433, 178, 96, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("isDelivered");
		lblNewLabel_5_1.setBounds(554, 184, 75, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("startingPoint");
		lblNewLabel_6.setBounds(30, 229, 95, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(128, 226, 56, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("pointOfDisembarkation");
		lblNewLabel_7.setBounds(200, 229, 154, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(339, 226, 95, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Distination");
		lblNewLabel_8.setBounds(469, 229, 75, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_9.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_9.setEditable(true);
				}
				else{
					textField_9.setEditable(false);
				}}
			}
		});
		textField_9.setBounds(541, 226, 56, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Price in Km");
		lblNewLabel_9.setBounds(620, 229, 88, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_10.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_10.setEditable(true);
				}
				else{
					textField_10.setEditable(false);
				}}
			}
		});
		textField_10.setBounds(688, 226, 103, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 369, 522, 72);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(204, 204, 0));
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		
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
				}}
				
			}
		});
		textField.setBounds(22, 68, 88, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JLabel lblNewLabel_1 = new JLabel("Entered the day,month,and the year of arriving the delivery:");
		lblNewLabel_1.setBounds(10, 256, 374, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Day");
		lblNewLabel_2.setBounds(10, 281, 34, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_1.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_1.setEditable(true);
				}
				else{
					textField_1.setEditable(false);
				}}
			}
		});
		textField_1.setBounds(54, 278, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("month");
		lblNewLabel_3.setBounds(175, 281, 49, 14);
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
		textField_2.setBounds(220, 278, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("year");
		lblNewLabel_4.setBounds(339, 281, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyChar()>='0'&& evt.getKeyChar()<='9') {// checking if its only number... no string or chars
					textField_11.setEditable(true);
			}else{ 
				if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE ||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE ) {
					textField_11.setEditable(true);
				}
				else{
					textField_11.setEditable(false);
				}}
			}
		});
		textField_11.setBounds(393, 278, 96, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Date of arriving the delivery:");
		lblNewLabel_10.setBounds(10, 316, 177, 14);
		contentPane.add(lblNewLabel_10);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setBounds(22, 338, 96, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
	
		
		JButton btnNewButton_2 = new JButton("Find");
		btnNewButton_2.setBackground(new Color(204, 204, 0));
		btnNewButton_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnNewButton_2.setBounds(138, 56, 137, 44);
		contentPane.add(btnNewButton_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(204, 204, 0));
		comboBox.addItem("true");
		comboBox.addItem("false");
		comboBox.setBounds(639, 180, 88, 22);
		contentPane.add(comboBox);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag1=true,flag2=true;
				
				try {
					if(textField.getText().equals(""))
					{
				  	   throw new NullPointerException();
					}
					for(Integer i=0;i<DataBase.managersSys.size()&&flag2;i++)
					{
						for(Integer j=0;j<DataBase.managersSys.get(i).getMembers().size()&&flag1;j++) {
					    if(DataBase.managersSys.get(i).getMembers().containsKey(Integer.valueOf(textField.getText())))//if already there is a member thats have a same code 
						{
					    	Managers managertemp=DataBase.managersSys.get(i);
					    	flag1=false;
					  

						    JOptionPane.showMessageDialog(getContentPane(),"The member with code: "+textField.getText()+" was founded!, so we can give him a delivery");
						    btnNewButton_1.addActionListener(new ActionListener() 
							{
						    
								public void actionPerformed(ActionEvent e) 
								{
									try {
										if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_11.getText().equals("")||
								    			textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals("")
												||textField_7.getText().equals("")||textField_8.getText().equals("")
												||textField_9.getText().equals("")||textField_10.getText().equals("")
								    	)
									{
				                        throw new NullPointerException();
									}
									
									if(Integer.valueOf(textField_9.getText())>30)
									        throw new DistinationException();
								
									if(Integer.valueOf(textField_1.getText())<1||Integer.valueOf(textField_1.getText())>31||Integer.valueOf(textField_2.getText())<1||Integer.valueOf(textField_2.getText())>12||
											Integer.valueOf(textField_11.getText())>2021)
									{
										throw new DayMOnthYearException();
									}
										
								    String s =textField_11.getText()+"/"+textField_2.getText()+"/"+textField_1.getText();
									Date today = new Date(s);
								  	ShortDelivery shortDelivery =new ShortDelivery(textField_3.getText(),Integer.valueOf(textField_4.getText()),Double.valueOf(textField_5.getText()),Boolean.valueOf((String)comboBox.getSelectedItem()),today,
								  			textField_7.getText(),textField_8.getText(),Integer.valueOf(textField_9.getText()),Double.valueOf(textField_10.getText()),managertemp.getMembers().get(Integer.valueOf(textField.getText())));
								  	textField_12.setText(s);
								  	boolean flag6=true;
								 Boolean check=submanagerCheck.addshortDelivery(shortDelivery);
								 try {
									if(submanagerCheck.getShortDeliveries().size()<=submanagerCheck.getDeliveriesHandle())
									{
										textField.setEditable(false);
										textField_5.setEditable(false);
								    	textField_3.setEditable(false);
								    	textField_4.setEditable(false);
								    	textField_7.setEditable(false);
								    	textField_8.setEditable(false);
								    	textField_9.setEditable(false);
								    	textField_10.setEditable(false);
								    	textField_11.setEditable(false);
								    	textField_1.setEditable(false);
								    	textField_2.setEditable(false);
								    	btnNewButton_1.addActionListener(new ActionListener() {
										    public void actionPerformed(ActionEvent e)					
										    {
										      try {
										    	if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_11.getText().equals("")||
										    			textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals("")
														||textField_7.getText().equals("")||textField_8.getText().equals("")
														||textField_9.getText().equals("")||textField_10.getText().equals("")||
										    	textField_12.getText().equals(""))
												{
							                        throw new NullPointerException();
												}
												if(e.getSource()==btnNewButton_1)
												{
												  throw new NullPointerException();
												}}
												catch(NullPointerException d)
												{
													JOptionPane.showMessageDialog(getContentPane(),
															"The fields will be empty because there is no member to add for him delivery, and if you selected option which is find member and you didnt find as you willl didnt add delivery"
															+ "or a different reason ,check!, maybe you can not handle more delivery! so if already this reason so will see an appropriate  massege "); 										
												}

										     }
											});
								    	if(submanagerCheck.getShortDeliveries().size()==submanagerCheck.getDeliveriesHandle()) {
										throw new DeliveriesHandleException();}
									}
									else
									{
										throw new MoreDeliveries();
									}
								 } catch (DeliveriesHandleException d)
									{
						         	 JOptionPane.showMessageDialog(getContentPane(),d.getMessage());
						            }
								 catch (MoreDeliveries f)
								 {
									 flag6=false;
						         	 JOptionPane.showMessageDialog(getContentPane(),f.getMessage());
								 }
								 if(!flag6)
								 {
									 throw new MassegeforHandlingmore();
								 }
								  if(check)
								 {
									  
							        		  FileWriter fw = null;
											try {
												File file = new File("deliveries.txt");
							        			   fw=new FileWriter(file,true);
								        		  shortDelivery.save(fw,submanagerCheck);  
											} catch (IOException e1) {
												e1.printStackTrace();
											}	finally 
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
							        		  
									 JOptionPane.showMessageDialog(getContentPane(),"The delivery was added successfully!"
									 		+ "\n"+"And Delivery's details in the box below");
									 textArea_1.append(shortDelivery.toString());
									 managertemp.getMembers().get(Integer.valueOf(textField.getText())).addNewDelivery(shortDelivery);
									 DataBase.addLastDelivery(managertemp.getMembers().get(Integer.valueOf(textField.getText())), shortDelivery);
									 DataBase.addourMembers(managertemp.getMembers().get(Integer.valueOf(textField.getText())));
									 DataBase.addourMembersAndDeluveries(shortDelivery);
									 DataBase.addalltheshortDeliveries(shortDelivery);
									 
								 }
				
								 else {
									    JOptionPane.showMessageDialog(getContentPane(),"The delivery  was not add successfully!"+"\n"+"Shoud to check it");
									    textArea_1.append("There is no delivery to show details about it");
								 }
									textField.setText("");
									textField_1.setText("");
									textField_2.setText("");
									textField_11.setText("");
									textField_3.setText("");
									textField_4.setText("");
									textField_5.setText("");
									textField_7.setText("");
									textField_8.setText("");
									textField_9.setText("");
									textField_10.setText("");
								}
									catch(DistinationException d)
									{
										JOptionPane.showMessageDialog(getContentPane(),d.getMessage());		
									}
							
									catch(NullPointerException d)
									{
										JOptionPane.showMessageDialog(getContentPane(),"You should fill the filed,there is missing informations");		
									}
									catch (DayMOnthYearException d)
									{
										JOptionPane.showMessageDialog(getContentPane(),d.getMessage());

									}
									catch(MassegeforHandlingmore f)
									{
										JOptionPane.showMessageDialog(getContentPane(),f.getMessage());
									} 
					
								
							}});
						    
						    flag2=false;
						    break;
						}
				}					
			} if(flag1)
			{
				JOptionPane.showMessageDialog(getContentPane(),"We didn't find a member to add a delivery for him,it doesn't exit, try again,so you can't fill the fields below");	
				textField_5.setEditable(false);
		    	textField_3.setEditable(false);
		    	textField_4.setEditable(false);
		    	textField_7.setEditable(false);
		    	textField_8.setEditable(false);
		    	textField_9.setEditable(false);
		    	textField_10.setEditable(false);
		    	textField_11.setEditable(false);
		    	textField_1.setEditable(false);
		    	textField_2.setEditable(false);

		    	btnNewButton_1.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e)					
				    {
				      try {
				    	if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_11.getText().equals("")||
				    			textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals("")
								||textField_7.getText().equals("")||textField_8.getText().equals("")
								||textField_9.getText().equals("")||textField_10.getText().equals("")||
				    	textField_12.getText().equals(""))
						{
	                        throw new NullPointerException();
						}
						if(e.getSource()==btnNewButton_1)
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
				}				
			catch(NullPointerException d)
			{
				JOptionPane.showMessageDialog(getContentPane(),"You should fill the filed,there is missing informations");		
			}
	 
			
			}
	});

	
			
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddShortDelivery.this.setVisible(false);
				new SubManagerMenu(submanagerCheck).setVisible(true);
			}
		});

	}
	public SubManager getSubmanagerCheck() {
		return submanagerCheck;
	}
	public void setSubmanagerCheck(SubManager submanagerCheck) {
		this.submanagerCheck = submanagerCheck;
	}
	
	}
