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
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Color;

public class ManagerForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton ;
    private Managers managerCheck; 
    private JPasswordField passwordField;
    private JLabel lblNewLabel;
    private JButton btnNewButton_3;
	public ManagerForm()
	
	{	
		  
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
	                                 
				    int confirmed = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you wanna exit? Carfuel you will Lose the Data!","EXIT",JOptionPane.YES_NO_OPTION);
				    if(confirmed == JOptionPane.YES_OPTION)
				    {
				        dispose();
				    }
				else {setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();

		textField.setColumns(10);
		textField.setBounds(210, 12, 157, 20);
		contentPane.add(textField);
	    btnNewButton = new JButton("Login");
		btnNewButton.setBounds(20, 343, 277, 121);
		contentPane.add(btnNewButton);		
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 43, 146, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton_2 = new JButton("SubManager");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerForm.this.setVisible(false);
				new Loginsubmanagerr().setVisible(true);	
			}
		});
		btnNewButton_2.setBounds(118, 108, 191, 58);
		contentPane.add(btnNewButton_2);
	
		
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					if(textField.getText().equals("")||Arrays.toString(passwordField.getPassword()).equals(""))
					{
						throw new NullPointerException();
					}
				if(e.getSource()==btnNewButton)
				{
					Boolean flag2=true;
					for(int i=0;i<DataBase.managersSys.size();i++) 
				    {
				        if(DataBase.managersSys.get(i).getUserName().equals(textField.getText())
				        		&&DataBase.managersSys.get(i).getPassword().equals(String.valueOf(passwordField.getPassword())))
				        {
				    	    setManagerCheck(DataBase.managersSys.get(i));//saving the same reference to use soon
							flag2=false;
							ManagerForm.this.setVisible(false);
							new Menu(managerCheck).setVisible(true);
				        }
				    }
					if(flag2)//if we here as the manager entered a wrong  UserName or a wrong Password
					{
					    throw new ManagerNotFoundException();
					}
				}
				}
				catch(ManagerNotFoundException d)
					{
						JOptionPane.showMessageDialog(getContentPane(),d.getMessage());	
					}
				catch(NullPointerException d)
				{
					JOptionPane.showMessageDialog(getContentPane(),"Missing Information,should fill all the feilds!");
				}
				}});
		
		btnNewButton_3 = new JButton("Enter your password:");
		btnNewButton_3.setBounds(20, 43, 209, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_1 = new JButton("Enter your Username :");
		btnNewButton_1.setBounds(10, 11, 190, 23);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ManagerForm.class.getResource("/Photo/3.png")));
		lblNewLabel_3.setBounds(-43, 65, 520, 467);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManagerForm.class.getResource("/Photo/1.png")));
		lblNewLabel.setBounds(161, -12, 1043, 877);
		contentPane.add(lblNewLabel);

}
	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
	
	}
