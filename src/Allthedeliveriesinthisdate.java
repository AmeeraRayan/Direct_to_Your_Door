import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Allthedeliveriesinthisdate extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Allthedeliveriesinthisdate(Managers managerCheck) {
		this.managerCheck=managerCheck;  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String[] columns= {"address","some details about delivery"};
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
		Object[] row = new Object[2];
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 743, 287);
		panel_2.add(scrollPane);
		
				JTable table_1 = new JTable();
				table_1.setBounds(0, 11, 600, 500);
				table_1.setModel(model);
				table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
				table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
				
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
		
		JLabel lblNewLabel = new JLabel("This table will show all the  deliveries thats exit in system of spicific date:");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 23));
		lblNewLabel.setBounds(25, 30, 756, 25);
		panel.add(lblNewLabel);
	
		textField_2 = new JTextField();
		textField_2.setBounds(226, 66, 71, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter day,month and year:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 66, 156, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("day");
		lblNewLabel_2.setBounds(176, 73, 50, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(350, 66, 96, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("month");
		lblNewLabel_3.setBounds(307, 66, 50, 29);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("year");
		lblNewLabel_4.setBounds(474, 66, 50, 29);
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(523, 66, 96, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {// i did the buffer here just to get the User name of the ShortDelivery so ican show the shortdelivery in the text area only for the specific subManger :S
	if(textField_1.getText().equals("")||textField_2.getText().equals("")||textField_2.getText().equals(""))
	{
        throw new NullPointerException();
	}
	if(Integer.valueOf(textField_2.getText())<1||Integer.valueOf(textField_2.getText())>31||Integer.valueOf(textField.getText())<1||Integer.valueOf(textField.getText())>12||
			Integer.valueOf(textField_1.getText())>2021)
	{
		throw new DayMOnthYearException();
	}
					BufferedReader br=new BufferedReader(new FileReader("deliveries.txt"));
					String line=new String();
					while((line=br.readLine())!=null) {
						StringTokenizer st=new StringTokenizer(line);
				          if(st.countTokens() != 6&&st.countTokens() != 7&&st.countTokens() != 9&&st.countTokens() != 20) {
							JOptionPane.showMessageDialog(null,"Error Line","Something WRONG!",JOptionPane.ERROR_MESSAGE);}
						else {
							if(st.countTokens()==20) //shortdelivery
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
								  Date deliverydate11=new Date(date);
								  String startingPoint=st.nextToken();
								  String pointOfDisembarkation=st.nextToken();
								  Integer distination=Integer.parseInt(st.nextToken());
								  Double priceKm=Double.parseDouble(st.nextToken());
								  String f_name=st.nextToken();//member
								  String l_name=st.nextToken();
								   String area1=st.nextToken();
								  Integer id_member=Integer.parseInt(st.nextToken());
								  String type=st.nextToken();
								  Integer id_subManager=Integer.parseInt(st.nextToken());
								    String s =textField_1.getText()+"/"+textField.getText()+"/"+textField_2.getText();
									Date deliverydate = new Date(s);
									
									if(deliverydate11.equals(deliverydate)) {
										row[0]=deliverydate;
										row[1]="address: "+address+" Destination: "+distination+" ,"+priceKm;
										model.addRow(row);
									}else JOptionPane.showMessageDialog(getContentPane(),"The date of this short Delivery is not the same date you entered");
							}
							 
						}
			  }
					br.close();
}
			catch(NullPointerException d)
			{
				JOptionPane.showMessageDialog(getContentPane(),"You should fill the filed,there is missing informations");		
			}
               catch (DayMOnthYearException d)
            {
	        JOptionPane.showMessageDialog(getContentPane(),d.getMessage());

                }
			 catch (Exception e1) {
					e1.printStackTrace();
				}


				
			}
		});
		btnNewButton_1.setBounds(653, 72, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allthedeliveriesinthisdate.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton_2.setBounds(765, 72, 89, 23);
		panel.add(btnNewButton_2);
		
		
		
	
	}
}
