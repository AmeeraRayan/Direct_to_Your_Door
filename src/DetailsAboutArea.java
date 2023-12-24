import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class DetailsAboutArea extends JFrame {

	private JPanel contentPane;
   private Managers managerCheck;
   private JTextField textField;


	/**
	 * Create the frame.
	 */
	public DetailsAboutArea( Managers managerCheck) {
		this.managerCheck= managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter an area please to show many detalis about all the deliveries in this area");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 587, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(169, 169, 169));
		textField.setBounds(30, 80, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Select north , south or central :)");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 49, 294, 20);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 111, 629, 136);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(100, 149, 237));
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				  if(textField.getText().equals(""))
				  {
                      throw new NullPointerException();
				  }
				 boolean flag3=true;//checking if the area appropriate for each manager  
		    	  boolean flag6=true;//if member was deleted as print a Appropriate message 
		    	  boolean check5=textField.getText().equals("north")||textField.getText().equals("central")||textField.getText().equals("south");
		    	  if(check5)
                  {
		    	  for(int i=0;i<DataBase.managersSys.size();i++)
		    	  {
		    		  if(DataBase.managersSys.get(i).getArea().equals(textField.getText()))//if1
		    		  {
		    			for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
		    			{
		    				if(mEntry.getKey()!=null)//if2
		    				{
		    					if(((Members)mEntry.getValue()).getArea().equals(textField.getText()))//if3
		    					{
		    						if(DataBase.ourMembersAndDeluveries.get(mEntry.getKey())!=null)//if the member deleted as there is no key to map to the delivery there is no member that exit in the system now ,so he does not have a delivery
		    						{
		    							 JOptionPane.showMessageDialog(getContentPane(),"Unique code for this delivery is " + mEntry.getKey()+
		    									 " ,and the delivery's details: is ine the box below");
		    							 textArea.append(DataBase.ourMembersAndDeluveries.get(mEntry.getKey()).toString());
				    			      flag3=false;
		    						}
		    						else
		    						{
		    							JOptionPane.showMessageDialog(getContentPane(),"The delivery thats code "+ mEntry.getKey() +" was deleted so ,there is no deliveries to show");
		    							flag6=false;
		    						}
		    					}//if3
		    				}//if2
		    			}//for
		    			break;
		    		  }//if1		    
		    	  }	//for	    		  
		    	  if(flag3&&flag6) 
		    	  {
		    		  JOptionPane.showMessageDialog(getContentPane(),"This area : "+ textField.getText()+" does not have an orderes yet!");
		    	  }
		    	  }//check5
		    	  else
		    	  {
		    		  JOptionPane.showMessageDialog(getContentPane(),"You entered an area thats does not exit in each manager");
		    	  }
			}catch(NullPointerException d)
				{
				  JOptionPane.showMessageDialog(getContentPane(),"Missing Information,should fill all the feilds!");
				}
			}
		});
		btnNewButton.setBounds(287, 55, 171, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back To Menu");
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(127, 255, 212));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetailsAboutArea.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(608, 289, 163, 54);
		contentPane.add(btnNewButton_1);

	
		
		
		
	}
}
