import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class ShowEverything extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck; 

	public ShowEverything(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("show all the members and all the deliveries if there");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 11, 416, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Back to Menu");
		btnNewButton_3.setBackground(new Color(60, 179, 113));
		btnNewButton_3.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowEverything.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
					}
				});
		btnNewButton_3.setBounds(653, 317, 127, 50);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Show");
		btnNewButton_4.setBackground(new Color(95, 158, 160));
		btnNewButton_4.setFont(new Font("Sylfaen", Font.BOLD, 13));
		btnNewButton_4.setBounds(458, 12, 110, 50);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("Managers:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 51, 127, 27);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 92, 760, 205);
		contentPane.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(95, 158, 160));
		scrollPane.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					for(int i=0;i<DataBase.managersSys.size();i++)
					{
						if(DataBase.managersSys.get(i).getMembers().size()!=0) //if there at least one member then print the member and his deliveries 
				  		 {	
					  		  JOptionPane.showMessageDialog(getContentPane(),"The members for the manager "+ DataBase.managersSys.get(i).toString());
					 		  textArea_1.append(DataBase.managersSys.get(i).getMembers().toString());

				  		 }
						else
				  		  {
					  		JOptionPane.showMessageDialog(getContentPane(),"The manager "+ DataBase.managersSys.get(i).getName().toUpperCase()+" dose not have members yet to show!");
					 		  textArea_1.setEditable(false);
				  		  }
					}
			  		  			  		  			  		  
				
			  		  

		}});
	}
			}
	

