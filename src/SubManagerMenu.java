import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;

public class SubManagerMenu extends JFrame {

	private JPanel contentPane;
    private SubManager submanagerCheck; 


	public SubManagerMenu(SubManager submanagerCheck) {
		this.submanagerCheck= submanagerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 519);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Short Delivery");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Short Delivery");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag=true;
				for(Managers m: DataBase.managersSys) {
					if(!m.members.isEmpty()) {
							SubManagerMenu.this.setVisible(false);
				new AddShortDelivery(submanagerCheck).setVisible(true);
				flag=false;
					}
				}
				if(flag)
				{
					  JOptionPane.showMessageDialog(getContentPane(),"There is no members to add shortdelievery!, carfull!");	
				}
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete Short Delivery");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(submanagerCheck.getShortDeliveries().isEmpty())
				{
					  JOptionPane.showMessageDialog(getContentPane(),"There is no short Deliveries  to delete!, carfull!");	
				}
				else {SubManagerMenu.this.setVisible(false);
				new DeleteshortDeliveryfromsubb(submanagerCheck).setVisible(true);}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Log out");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("LogOut");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(getContentPane(),"Are you sure you want to exit!!","LogOut",
						JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION)
					{
						SubManagerMenu.this.setVisible(false);
						new ManagerForm().setVisible(true);							
					}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("save details aboiut short delivery");
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter bw1 = null;
				try {
					File file = new File("shortDeliveries&detailsaboutrmember.txt");
					   bw1=new FileWriter(file);
					   bw1.write("");
					   bw1.close();
							for(int i=0;i<DataBase.alltheshortDeliveries.size();i++)
							{
								FileWriter bw=new FileWriter(file,true);
								bw.write(DataBase.alltheshortDeliveries.get(i).getArea());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getNumItems());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getPrice());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).isDelivered());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getDeliverydate());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getStartingPoint());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getPointOfDisembarkation());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getDistination());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getPriceKm());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getMember().getFirstName());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getMember().getLastName());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getMember().getArea());
								bw.write(" "+DataBase.alltheshortDeliveries.get(i).getMember().getId());
					    	    bw.write(" "+submanagerCheck.getiD());//to know for me the delivery 
					             bw.write("\n");
					             bw.close();
							}
				} catch (IOException e1) {
					e1.printStackTrace();
				}	 
				 
				 JOptionPane.showMessageDialog(getContentPane(),"The Deatils about all the short deliveries in the system saved successfuly with details about every member that ordered delivery:)");
			}
		});
		btnNewButton.setBounds(25, 33, 298, 54);
		contentPane.add(btnNewButton);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 853, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnNewButton_1 = new JButton("press");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubManagerMenu.this.setVisible(false);
				new Membersoredered3timesatleastshort(submanagerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(494, 153, 132, 28);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("if you wanna to show all the members that ordered short delivery at least 3  times press :");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 67, 739, 75);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("spicific date about the delivieries");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubManagerMenu.this.setVisible(false);
				new Allthedeliveriesinthisdatesub(submanagerCheck).setVisible(true);				
			}
		});
		btnNewButton_2.setBounds(10, 206, 258, 46);
		panel.add(btnNewButton_2);
		
				
	}


	public SubManager getSubmanagerCheck() {
		return submanagerCheck;
	}


	public void setSubmanagerCheck(SubManager submanagerCheck) {
		this.submanagerCheck = submanagerCheck;
	}
}
