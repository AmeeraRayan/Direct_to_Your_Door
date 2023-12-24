import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

public class Express extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Create the frame.
	 */
	public Express(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the id-member for which member wants to give him a delivery");
		lblNewLabel.setBounds(10, 11, 375, 14);
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
				}}
					
			}
		});
		textField.setColumns(10);
		textField.setBounds(20, 29, 96, 20);
		contentPane.add(textField);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(228, 141, 96, 22);
		contentPane.add(comboBox);
		comboBox.addItem("true");
		comboBox.addItem("false");
		JButton btnNewButton = new JButton("Add delivery");
		btnNewButton.setBounds(14, 191, 142, 23);
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
					    		GeneralDelivery deliver1=new ExpressDelivery(textField_1.getText(),Integer.valueOf(textField_2.getText()),Double.valueOf(textField_3.getText()),Boolean.valueOf((String)comboBox.getSelectedItem()),Double.valueOf(textField_4.getText()));
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
				    	btnNewButton.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent e)					
						    {
						  
						    	try {
						    		if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||(textField_4.getText().equals("")))
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
		btnNewButton_2.setBounds(131, 28, 127, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Enter for delivery: address,numItems,price,and if is delivered!");
		lblNewLabel_1.setBounds(10, 60, 375, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Also you have to add AdditionalPay");
		lblNewLabel_2.setBounds(20, 91, 214, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("address:");
		lblNewLabel_2_1.setBounds(10, 116, 75, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(80, 116, 96, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("numItems:");
		lblNewLabel_3.setBounds(186, 116, 75, 14);
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
		textField_2.setBounds(250, 113, 96, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("price:");
		lblNewLabel_4.setBounds(10, 141, 49, 14);
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
		textField_3.setBounds(60, 138, 96, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("isDelivered");
		lblNewLabel_5.setBounds(166, 141, 65, 14);
		contentPane.add(lblNewLabel_5);

	
		
		JButton btnNewButton_1 = new JButton("Back To Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Express.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(637, 333, 114, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("AdditionalPay");
		lblNewLabel_6.setBounds(10, 166, 89, 14);
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
		textField_4.setBounds(130, 160, 76, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Express.class.getResource("/Photo/8.png")));
		lblNewLabel_8.setBounds(378, 0, 464, 418);
		contentPane.add(lblNewLabel_8);
		
	}
	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
	

}
