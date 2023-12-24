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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class AdddMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Managers managerCheck; 
	/**
	 * Launch the application.
	 */
    
	public AdddMember(Managers managerCheck) {
		this.managerCheck= managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter a member to add:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 298, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter first name:");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 38, 107, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 43, 124, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the last name:");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 76, 124, 14);
		contentPane.add(lblNewLabel_2);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 74, 107, 20);
		contentPane.add(textField_1);
		JLabel lblNewLabel_3 = new JLabel("Enter from where the member:");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 115, 194, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(153, 255, 0));
		btnNewButton.setBounds(626, 396, 194, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add member");
		btnNewButton_1.setBackground(new Color(102, 102, 0));
		btnNewButton_1.setBounds(24, 155, 155, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(153, 102, 51));
		comboBox.addItem("north");
		comboBox.addItem("south");
		comboBox.addItem("central");
		comboBox.setBounds(202, 109, 94, 22);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 51));
		panel.setBounds(10, 248, 718, 134);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 698, 99);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(204, 255, 0));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("Details about the member you added:");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 212, 402, 31);
		contentPane.add(lblNewLabel_5);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					 FileWriter fw=null;
					if(textField.getText().equals("")||textField_1.getText().equals(""))
					{
                        throw new NullPointerException();
					}
					Boolean flag1=true;	
					if(managerCheck.getArea().equals((String)comboBox.getSelectedItem()))
					{
						Members member=new Members(textField.getText(),textField_1.getText(),(String)comboBox.getSelectedItem());
			       	    boolean check=managerCheck.addMmember(member);//return true if succeeded to add
			       	    if(check)// if true if the member has a same area		    		 
			     	    {
			       	     try{ 
			        		  File file = new File("dataMembers.txt");
			        			   fw=new FileWriter(file,true);
			        			   member.save(fw,managerCheck);  
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
						 JOptionPane.showMessageDialog(getContentPane(),"The member was added successfully!"+"\n" +"And Member's Details in the box below");
						 textArea.append(member.toString());			     	    
			     	    }
			       	   else
			 	       {
					    JOptionPane.showMessageDialog(getContentPane(),member.getFirstName()+" was not add successfully!"+"\n"+"Shoud to check it");
					    textArea.append("The is no member to show details about him");
			 	       }
				        flag1=false; 
					}
			  	  if(flag1)//if we did not find member that's his area suitable to the area's manager to add
				  {
						 JOptionPane.showMessageDialog(getContentPane(),"You have a problem ,or you entered an area that does not fit your area or "+"\n"+
								 "you selected an area that is not  north or south or central,try again and check your choice very well:)");  
				  }
				}catch(NullPointerException d)
				{
				  JOptionPane.showMessageDialog(getContentPane(),"Missing Information,should fill all the feilds!");
				
				textField.setText("");
				textField_1.setText("");


			}
		}});
			
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdddMember.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});

	}

	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
}
