import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Loginsubmanagerr extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    private SubManager submanagerCheck; 
	public Loginsubmanagerr() {
		  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delivery's Company On Time");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setBounds(21, 11, 653, 75);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back ");
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(173, 255, 47));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(getContentPane(),"Are you sure you want to back?","LogOut",
						JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION)
				{
					Loginsubmanagerr.this.setVisible(false);
					new ManagerForm().setVisible(true);							
			}
			}
		});
		btnNewButton_1.setBounds(548, 411, 226, 57);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(21, 162, 747, 238);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(70, 138, 146, 78);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Username please:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 29, 246, 29);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(278, 32, 157, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your password:");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 69, 190, 25);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.inactiveCaption);
		passwordField.setBounds(210, 77, 146, 20);
		panel.add(passwordField);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
				try {
					
					if(textField.getText().equals("")||Arrays.toString(passwordField.getPassword()).equals(""))
					{
						throw new NullPointerException();
					}
					Boolean flag2=true;
					    for(int i=0;i<DataBase.submanagersSys.size();i++)
					    {
					    	if(DataBase.submanagersSys.get(i).getUserName().equals(textField.getText())
					        		&&DataBase.submanagersSys.get(i).getPassword().equals(String.valueOf(passwordField.getPassword())))
					        {
					    		setSubmanagerCheck(DataBase.submanagersSys.get(i));//saving the same reference to use soon
								flag2=false;
								  Loginsubmanagerr.this.setVisible(false);
									new SubManagerMenu(submanagerCheck).setVisible(true);
					        }
					    }
					    if(flag2)//if we here as the manager entered a wrong  UserName or a wrong Password
						{
						    throw new ManagerNotFoundException();
						}
					}
				catch(NullPointerException d)
				{
					JOptionPane.showMessageDialog(getContentPane(),"Missing Information,should fill all the feilds!");
				}
				catch(ManagerNotFoundException d)
				{
					JOptionPane.showMessageDialog(getContentPane(),d.getMessage());	
				}
				}
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
