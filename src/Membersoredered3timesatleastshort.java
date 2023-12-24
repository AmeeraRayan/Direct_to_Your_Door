import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class Membersoredered3timesatleastshort extends JFrame {

	private JPanel contentPane;
    private SubManager submanagerCheck;
	private static Integer temp;
	public SubManager getSubmanagerCheck() {
		return submanagerCheck;
	}

	public void setSubmanagerCheck(SubManager submanagerCheck) {
		this.submanagerCheck = submanagerCheck;
	}

	public Membersoredered3timesatleastshort(SubManager submanagerCheck) {
		this.submanagerCheck= submanagerCheck;
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 521);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShowAllThe = new JLabel("Show all the members thats ordered at least 3 times short delivery");
		lblShowAllThe.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblShowAllThe.setBounds(24, 25, 548, 56);
		contentPane.add(lblShowAllThe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 146, 769, 277);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.activeCaption);
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String line=null;
					Integer count=0;
					Members tempmemb=null;
					  BufferedReader  reader = new BufferedReader(new FileReader("shortDeliveries&detailsaboutrmember.txt"));
					  if(reader!=null) {
						  
						  while((line = reader.readLine()) != null){
						  StringTokenizer st = new StringTokenizer(line);
						  if(st.countTokens() != 19) {
							  System.out.println("Error line2");}
						  else { 
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
							  String  area=st.nextToken();
							  Integer id_member=Integer.parseInt(st.nextToken());
							  Integer id_subManager=Integer.parseInt(st.nextToken());
								for(int i=0;i<DataBase.alltheshortDeliveries.size();i++)
								{
									if(DataBase.alltheshortDeliveries.get(i).getMember().getId()==id_member)
									{
										count++;
										 tempmemb=DataBase.alltheshortDeliveries.get(i).getMember();
									}
								}
								if(count>=3) {
									  textArea.append("Name: "+tempmemb.getFirstName()+" ,lastName: "+tempmemb.getLastName()+" ,id:"+tempmemb.getId()+"\n");   
								}	
					  }
							 
								
						  }//
						 
						  reader.close();
						  
					  } 
					
					  }catch(FileNotFoundException f)
				  {
							 f.getStackTrace(); 
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
		
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setBounds(597, 41, 114, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membersoredered3timesatleastshort.this.setVisible(false);
				new SubManagerMenu(submanagerCheck).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setBounds(687, 450, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
