import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeliveriesOfspicificmemb extends JFrame {

	private JPanel contentPane;
	   private Managers managerCheck;
	   private JTextField textField;

	public DeliveriesOfspicificmemb(Managers managerCheck) {
		this.managerCheck= managerCheck;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String[] columns= {"address","numItems","price","isDelivered","additionalPay","numPhone","email","taxes","deliverydate","startingPoint","pointOfDisembarkation","distination","priceKm"};
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(15, 11, 1000, 584);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(24, 106, 777, 406);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, -43, 767, 366);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 743, 287);
		panel_2.add(scrollPane);
		
				JTable table_1 = new JTable();
				table_1.setBounds(0, 11, 600, 500);
				table_1.setModel(model);
				table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(3).setPreferredWidth(473);
				table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(5).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(6).setPreferredWidth(120);
				table_1.getColumnModel().getColumn(7).setPreferredWidth(120);
				table_1.getColumnModel().getColumn(8).setPreferredWidth(200);
				table_1.getColumnModel().getColumn(10).setPreferredWidth(500);
				table_1.getColumnModel().getColumn(11).setPreferredWidth(500);
				table_1.getColumnModel().getColumn(12).setPreferredWidth(500);
			

				
						table_1.setBackground(Color.white);
						table_1.setForeground(Color.black);
						panel_2.add(table_1);
						table_1.setSelectionForeground(Color.WHITE);
						table_1.setSelectionBackground(Color.BLUE);
						table_1.setRowHeight(30);
						table_1.setGridColor(Color.RED);
						table_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
						table_1.setAutoCreateRowSorter(true);
						JScrollPane pane =new JScrollPane(table_1);
						scrollPane.setViewportView(pane);
						pane.setForeground(Color.red);
						pane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("This table will show all the  deliveries thats exit in system of spicific member:");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 23));
		lblNewLabel.setBounds(25, 30, 756, 25);
		panel.add(lblNewLabel);
		
		
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
		textField.setBounds(405, 66, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Eneter the id-member you wanna to show the deliveries that he order");
		lblNewLabel_1.setBounds(24, 66, 371, 29);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("press ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 if(textField.getText().equals(""))
					 {
						 throw new NullPointerException();
					 }
					   BufferedReader reader = new BufferedReader(new FileReader("deliveries.txt"));
		               String line;
						  if(reader!=null) {
							  while((line = reader.readLine()) != null){
								  Object[] row = new Object[14];
					        	  Integer id_member=null;
							          StringTokenizer st = new StringTokenizer(line);
							          if(st.countTokens() != 6&&st.countTokens() != 7&&st.countTokens() != 9&&st.countTokens() != 20) {
										  System.out.println("Error line4");}
							          else {
							          }
							        	 if(st.countTokens() == 6) {
									  String address=st.nextToken();
									  Integer numItems=Integer.parseInt(st.nextToken());
									  Double price=Double.parseDouble(st.nextToken());
									  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
									   id_member=Integer.parseInt(st.nextToken());
									  String type=st.nextToken();
						        		 if(id_member==Integer.valueOf(textField.getText())){
											row[0]=address;
											row[1]=numItems;
											row[2]=price;
											row[3]=isDelivered;
											row[4]="--";
											row[5]="--";
											row[6]="--";
											row[7]="--";
											row[8]="--";
											row[9]="--";
											row[10]="--";
											row[11]="--";
											row[12]="--";
											model.addRow(row);							  
							          }
							        	 }
							        	 else if(st.countTokens() == 7)
							        	 {
							        		 String address=st.nextToken();
											  Integer numItems=Integer.parseInt(st.nextToken());
											  Double price=Double.parseDouble(st.nextToken());
											  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
											   Double additionalPay =Double.parseDouble(st.nextToken());
											   id_member=Integer.parseInt(st.nextToken());
											    String type=st.nextToken();
								        		if(id_member==Integer.valueOf(textField.getText())){
											    row[0]=address;
												row[1]=numItems;
												row[2]=price;
												row[3]=isDelivered;
												row[4]=additionalPay;
												row[5]="--";
												row[6]="--";
												row[7]="--";
												row[8]="--";
												row[9]="--";
												row[10]="--";
												row[11]="--";
												row[12]="--";
												model.addRow(row);		
												} 
							        	 }
							        	 else if(st.countTokens() == 9)
							        	 {
							        		  String address=st.nextToken();
											  Integer numItems=Integer.parseInt(st.nextToken());
											  Double price=Double.parseDouble(st.nextToken());
											  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
											  String numPhone =st.nextToken();
											  String email =st.nextToken();
											  Double taxes=Double.parseDouble(st.nextToken());
											   id_member=Integer.parseInt(st.nextToken());
											  String type=st.nextToken();
								        		 if(id_member==Integer.valueOf(textField.getText())){
											  row[0]=address;
												row[1]=numItems;
												row[2]=price;
												row[3]=isDelivered;
												row[4]=numPhone;
												row[5]=email;
												row[6]=taxes;
												row[7]="--";
												row[8]="--";
												row[9]="--";
												row[10]="--";
												row[11]="--";
												row[12]="--";
												model.addRow(row);	
							        		 }
							        	 }
							        	 else if(st.countTokens() ==20)
							        	 {
							        		 String address=st.nextToken();
											  Integer numItems=Integer.parseInt(st.nextToken());
											  Double price=Double.parseDouble(st.nextToken());
											  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
											  String s1=st.nextToken();
											  String month=st.nextToken();
											  if(month.equals("Jan"))
											  {
												  month="01";
											  }
											  else if(month.equals("Feb"))
											  {
												  month="02";  
											  }
											  else if(month.equals("Mar"))
											  {
												  month="03";  
											  } else if(month.equals("Apr"))
											  {
												  month="04";  
											  } else if(month.equals("May"))
											  {
												  month="05";  
											  } else if(month.equals("June"))
											  {
												  month="06";  
											  } else if(month.equals("July"))
											  {
												  month="07";  
											  } else if(month.equals("Aug"))
											  {
												  month="08";  
											  } else if(month.equals("Sep"))
											  {
												  month="09";  
											  } else if(month.equals("Oct"))
											  {
												  month="10";  
											  }else if(month.equals("Nov"))
											  {
												  month="11";  
											  } else if(month.equals("Dec"))
											  {
												  month="12";  
											  }
											  String day=st.nextToken();
											  String s4=st.nextToken();
											  String s5=st.nextToken();
											  String year=st.nextToken();
						                      String date=year+"/"+month+"/"+day;
											  Date deliverydate=new Date(date);
											  String startingPoint=st.nextToken();
											  String pointOfDisembarkation=st.nextToken();
											  Integer distination=Integer.parseInt(st.nextToken());
											  Double priceKm=Double.parseDouble(st.nextToken());
											  String f_name=st.nextToken();//member
											  String l_name=st.nextToken();
											   String area1=st.nextToken();
											   id_member=Integer.parseInt(st.nextToken());
											  String type=st.nextToken();
											  Integer id_subManager=Integer.parseInt(st.nextToken());
								        		 if(id_member==Integer.valueOf(textField.getText())){
								        			    row[0]=address;
														row[1]=numItems;
														row[2]=price;
														row[3]=isDelivered;
														row[4]="--";
														row[5]="--";
														row[6]="--";
														row[7]="--";
														row[8]=deliverydate;
														row[9]=startingPoint;
														row[10]=pointOfDisembarkation;
														row[11]=distination;
														row[12]=priceKm;
														model.addRow(row);	
							        		 }
									
							        	 }
							  }
							  reader.close();
							  }
							  
				   }catch(FileNotFoundException s)
					  {
							 s.getStackTrace(); 
						  }
						  catch(IOException f)
						  {
							  f.getStackTrace();
						  }
						  catch(NullPointerException d)//בהתחלה אין שורות לקרוא בפעם בראשונה לפני שאכניס מנהל ואסויף פרטיו לקובץ ההדפסה
						  {
							  System.out.println(d.getStackTrace());
						  }
			}
		});
		btnNewButton_1.setBounds(511, 66, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveriesOfspicificmemb.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);

			}
		});
		btnNewButton_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnNewButton_2.setBackground(Color.MAGENTA);
		btnNewButton_2.setBounds(807, 381, 89, 23);
		panel.add(btnNewButton_2);
		 
		 
		
	}
}
