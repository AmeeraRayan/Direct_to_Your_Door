import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
public class Menu extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;	
	public Menu(Managers managerCheck) {
		this.managerCheck=managerCheck;  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 486);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("Managers");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Add manager");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new SignUp(managerCheck).setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Add submanager");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new AddSubManager(managerCheck).setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_3 = new JMenu("Members");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add member");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new AdddMember(managerCheck).setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Delete member");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(managerCheck.getMembers().isEmpty())
				{
					  JOptionPane.showMessageDialog(getContentPane(),"There is no members to delete in your area!, carfull!");	
				}
				else {Menu.this.setVisible(false);
				new DeleteeMember(managerCheck).setVisible(true);}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu = new JMenu("Show");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Select");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ShortDeliveries");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new TablesOffshortDelivery(managerCheck).setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("MembersOfshortDelivery");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new ShowingallMembofshortdeliveries(managerCheck).setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("TownsOf30days");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new ShortDeliveryabout30days(managerCheck).setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("add New Delivery");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(managerCheck.getMembers().isEmpty())
				{
					  JOptionPane.showMessageDialog(getContentPane(),"There is no members to add delievery!, carfull!");	
				}
				
				else {Menu.this.setVisible(false);
				new AddDelivery(managerCheck).setVisible(true);}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Show datails about lastDelivery and all the deliveries");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new ShowDetails(managerCheck).setVisible(true);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Delete shortDelivery");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new DeleteShortDeliveryfromManager(managerCheck).setVisible(true);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Show all the deliveries about spicific area");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new DetailsAboutArea(managerCheck).setVisible(true);
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Show All the members and the deliveries");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new ShowEverything(managerCheck).setVisible(true);
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Log out");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Exit");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(getContentPane(),"Are you sure you want to exit!!","LogOut",
						JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION)
					{
						Menu.this.setVisible(false);
						new ManagerForm().setVisible(true);
						
					}
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
	
		

		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Show all the deliveries of spicific member");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new DeliveriesOfspicificmemb(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(23, 85, 406, 45);
		contentPane.add(btnNewButton_1);

		
		
		JButton btnNewButton = new JButton("welcome to our Company's menu:");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(169, 22, 531, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("spicific date about the delivieries");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new Allthedeliveriesinthisdate(managerCheck).setVisible(true);
			}
		});
		btnNewButton_2.setBounds(20, 137, 409, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("press to show all the deliveries that you responsible of");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.this.setVisible(false);
				new deliveriesaboutspicificarea(managerCheck).setVisible(true);
			}
		});
		btnNewButton_3.setBounds(23, 200, 406, 45);
		contentPane.add(btnNewButton_3);
		
		
		}
	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
	}

