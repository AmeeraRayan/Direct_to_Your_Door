import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeleteShortDeliveryfromManager extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;

	public DeleteShortDeliveryfromManager(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(100, 110, 215));
			panel.setBounds(10, 11, 602, 517);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(10, 105, 669, 243);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Choose Member To Delete his Short Delivery");
			lblNewLabel_3.setFont(new Font("Viner Hand ITC", Font.BOLD, 11));
			lblNewLabel_3.setBounds(10, 24, 282, 43);
			panel_1.add(lblNewLabel_3);
			
			JTextField textField = new JTextField();
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
			textField.setBounds(330, 24, 140, 30);
			panel_1.add(textField);
			
			JButton btnDeleteShortDelivery = new JButton("Delete Short Delivery");
			btnDeleteShortDelivery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean flag=true,flag1=true;
		try {
			if(!managerCheck.getMembers().containsKey(Integer.parseInt(textField.getText())))
			{
			  throw new MemberIsnotFoundexception();	
			}
				
					for(Map.Entry<Integer, Members> m :managerCheck.getMembers().entrySet())
					{
					if(managerCheck.getMembers().get(Integer.parseInt(textField.getText())).getDeliveries().size()!=0) {
					for(Integer j=0;j<DataBase.alltheshortDeliveries.size();) {
						System.out.println(DataBase.alltheshortDeliveries.size());
						if(DataBase.alltheshortDeliveries.get(j) instanceof ShortDelivery)
						{System.out.println("true");
							Integer d=j;
							flag=false;
							for(Integer g=0;g<DataBase.submanagersSys.size();g++)
							{
						    	if(DataBase.submanagersSys.get(g).getShortDeliveries().contains(m.getValue().getDeliveries().get(j))) {
					    		//DataBase.submanagersSys.get(g).getShortDeliveries().remove(managerCheck.getMembers().get(Integer.parseInt(textField.getText())).getDeliveries().get(d));
						    		DataBase.submanagersSys.get(g).getShortDeliveries().remove(DataBase.alltheshortDeliveries.get(d));    	
						    		m.getValue().getDeliveries().remove(m.getValue().getDeliveries().get(j));
						    		d++;
						    	}
							}
							for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
			    			{
	
			    				if(mEntry.getKey()!=null)
			    				{
			    					if(((Members)mEntry.getValue()).getId()==Integer.valueOf(textField.getText()))//if there a member that make an order he the same member that deleted as should delete it also from this dataBase 
			    					{
			    						//removes a key value pair from the map
			    						if(DataBase.ourMembersAndDeluveries.get(mEntry.getKey())instanceof ShortDelivery)
			    						{
			    						DataBase.ourMembersAndDeluveries.remove(mEntry.getKey());
			    						}
			    						if(DataBase.ourLastDeliveries.get(mEntry.getValue())instanceof ShortDelivery ) {
			    						DataBase.ourLastDeliveries.remove(mEntry.getValue());
			    						
			    						}
			    					}
			    				}
			    			
							
		 		 
			    JOptionPane.showMessageDialog(getContentPane(), " The delivery was deleted successfully!");
			    			    
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
						break;
			}
			
			if(flag)
			{
			    JOptionPane.showMessageDialog(getContentPane()," The member you selected does not has a short delivery ");

			}
			
							
				}
					else
					{
					    JOptionPane.showMessageDialog(getContentPane()," The member you selected does not has deliveries ");
					    break;
					}
					
				}//
		}catch (MemberIsnotFoundexception d)
		{
		    JOptionPane.showMessageDialog(getContentPane(),d.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				}});
			btnDeleteShortDelivery.setFont(new Font("SimSun-ExtB", Font.BOLD, 19));
			btnDeleteShortDelivery.setBounds(10, 106, 292, 43);
			panel_1.add(btnDeleteShortDelivery);
			
			JButton btnNewButton_1 = new JButton("Back to Menu");
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteShortDeliveryfromManager.this.setVisible(false);
					new Menu(managerCheck).setVisible(true);	
				}
			});
			btnNewButton_1.setBounds(369, 155, 182, 50);
			panel_1.add(btnNewButton_1);
			
			JLabel lblDeleteSubMember = new JLabel("Delete Short Delivery From Member");
			lblDeleteSubMember.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
			lblDeleteSubMember.setBounds(10, 11, 404, 46);
			panel.add(lblDeleteSubMember);
	
			
		
	
		
	}

}

