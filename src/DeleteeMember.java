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
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class DeleteeMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Managers managerCheck;
	/**
	 * Create the frame.
	 */
	public DeleteeMember(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 482);
		contentPane = new JPanel();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		panel.setBounds(10, 103, 720, 221);
		contentPane.add(panel);
		panel.setLayout(null);
		
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(334, 20, 143, 22);
		panel.add(comboBox);
		for(int i=0;i<DataBase.managersSys.size();i++)
		{
			if(DataBase.managersSys.get(i).getMembers().size()!=0) {
		for (Map.Entry<Integer, Members> m : DataBase.managersSys.get(i).getMembers().entrySet())
		{
			comboBox.addItem(String.valueOf(m.getKey()));	
		}
		}
		}
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteeMember.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);	
			}
		});
		btnNewButton.setBounds(567, 366, 226, 53);
		contentPane.add(btnNewButton);
		
	
		JLabel lblNewLabel = new JLabel("you selected a choice to delete a member!");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 326, 38);
		panel.add(lblNewLabel);

		
		JLabel lblNewLabel_1 = new JLabel("The code of the member you selected to delete");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 78, 393, 27);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(22, 131, 96, 20);
		panel.add(textField);
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
		
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Delete Member ");
				lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 16));
				lblNewLabel_2.setBounds(28, 43, 213, 34);
				contentPane.add(lblNewLabel_2);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox)
				{
					String d=(String)comboBox.getSelectedItem();
					Members member1=null;
					try {
						if(d.equals(""))
						{
					  	   throw new NullPointerException();
						}
						textField.setText(d);
						Integer temp=0;
						for (Map.Entry<Integer, Members> m : DataBase.ourMembers.entrySet())
						{
							if(m.getValue().getId()==Integer.valueOf(d))
							{
								
								temp=m.getKey();
								member1=m.getValue();
								if(DataBase.ourMembersAndDeluveries.get(temp)instanceof ShortDelivery)
								{
									throw new DeleteshortDeliveriesfirstException();
								}
							}
						}
						textField.setText(d);
						
	                   //if the member does not have a shortdelivery
			  	    if(managerCheck.delMember(Integer.valueOf(d)))//if we here as there is a member to delete
			  	    {		//checking if the member is already exit in his system 
			  	  	  /*The function delMember returning true if succeeded to delete 
			  	  	   checking if there is a member thats already exits in system 
			  	  	   by code the member 
			  	  	   other it is returning false because there is nothing to delete if he is not exit
			  	  	    */
			  	    	
					    JOptionPane.showMessageDialog(getContentPane(),"The member with code: "+d+" was deleted successfully");
					    if(DataBase.ourMembers.containsValue(new Members(Integer.valueOf(d))))//if deleted a member should to delete from all the DataBase that we have 
					    	{
				    			for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
				    			{
				    				if(mEntry.getKey()!=null)
				    				{
				    					if(((Members)mEntry.getValue()).getId()==Integer.valueOf(d))//if there a member that make an order he the same member that deleted as should delete it also from this dataBase 
				    					{
				    						//removes a key value pair from the map
				    						DataBase.ourMembersAndDeluveries.remove(mEntry.getKey());
				    						
				    					}
				    				}
				    			}

			 		  }
					    if(managerCheck.getMembers().size()==0) {
                            BufferedWriter bw=new BufferedWriter(new FileWriter("dataMembers.txt"));
                            bw.write("");
                            bw.close();
                        }
					    
                        for(Map.Entry<Integer, Members> m:managerCheck.getMembers().entrySet()) {
                            BufferedWriter bw=new BufferedWriter(new FileWriter("dataMembers.txt"));
                            bw.write("");
                            bw.close();
                        }
                        for(Map.Entry<Integer, Members> m:managerCheck.getMembers().entrySet()) {
                            BufferedWriter pw=new BufferedWriter(new FileWriter("dataMembers.txt",true));
                          pw.write(m.getValue().getFirstName());	
                      	  pw.write(" "+m.getValue().getLastName());
                      	  pw.write(" "+m.getValue().getArea());
                      	  pw.write(" "+m.getValue().getId());
                      	  pw.write(" "+managerCheck.getiD());//מכניסה פרטים המנהל שהכניס אותו
                      	  pw.write("\n"); 
                          pw.close();
                        }
                        if(DataBase.ourMembersAndDeluveries.size()==0) {
    						BufferedWriter bw=new BufferedWriter(new FileWriter("deliveries.txt"));
    						bw.write("");
    						bw.close();
    					}
    					for(Map.Entry<Integer, Members> m1:DataBase.ourMembers.entrySet()){
    						BufferedWriter bw=new BufferedWriter(new FileWriter("deliveries.txt"));
    						bw.write("");
    						bw.close();
    					}
    					for(Map.Entry<Integer, Members> m1:DataBase.ourMembers.entrySet())
    					{
    						BufferedWriter	bw=new BufferedWriter(new FileWriter("deliveries.txt",true));
    									 if(DataBase.ourMembersAndDeluveries.get(m1.getKey())instanceof ExpressDelivery) {
    										bw.write(DataBase.ourMembersAndDeluveries.get(m1.getKey()).getArea());
        									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getNumItems());
        									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getPrice());
        									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).isDelivered());
        									bw.write(" "+((ExpressDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getAdditionalPay());
        									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getId());
        									bw.write(" "+"ExpressDelivery");
        									bw.write("\n");
    									}
    									 else if(DataBase.ourMembersAndDeluveries.get(m1.getKey())instanceof BusinessDelivery) {
    										bw.write(DataBase.ourMembersAndDeluveries.get(m1.getKey()).getArea());
        									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getNumItems());
        									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getPrice());
        									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).isDelivered());
        									bw.write(" "+((BusinessDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getNumPhone());
        									bw.write(" "+((BusinessDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getEmail());
        									bw.write(" "+((BusinessDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getTaxes());
        									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getId());
        									bw.write(" "+"BusinessDelivery");
    										bw.write("\n");
    									}
    									 else if(DataBase.ourMembersAndDeluveries.get(m1.getKey())instanceof GeneralDelivery ) {
    	    									bw.write(DataBase.ourMembersAndDeluveries.get(m1.getKey()).getArea());
    	    									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getNumItems());
    	    									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getPrice());
    	    									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).isDelivered());
    	    									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getId());
    	    									bw.write(" "+"GeneralDelivery");
    	    									bw.write("\n");
    	    									}
    				    					bw.close();
    						}  
					 
			  	    }
			  	  else
				   {
			  		  throw new DeleteMemberException(managerCheck.getName());
				   }
			  	    }
					catch(NullPointerException g) {
						JOptionPane.showMessageDialog(getContentPane(),"You should fill the filed,there is missing informations");		
					}
					catch(DeleteMemberException v)
					{
						JOptionPane.showMessageDialog(getContentPane(),v.getMessage());	
					}
					catch(DeleteshortDeliveriesfirstException v)
					{
						JOptionPane.showMessageDialog(getContentPane(),v.getMessage());	
					
					}catch(FileNotFoundException s)
					  {
						 s.getStackTrace(); 
					  }
					catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}

			}
		});
		

		
	}
}
