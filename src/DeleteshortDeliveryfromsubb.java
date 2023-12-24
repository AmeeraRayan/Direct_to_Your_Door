import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class DeleteshortDeliveryfromsubb extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

    private SubManager submanagerCheck; 

	public DeleteshortDeliveryfromsubb(SubManager submanagerCheck) {
		this.submanagerCheck= submanagerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 551);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteshortDeliveryfromsubb.this.setVisible(false);
				new SubManagerMenu(submanagerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(547, 383, 198, 70);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(36, 127, 634, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter id  Member to delete short delivery from him !");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
		lblNewLabel.setBounds(24, 11, 330, 14);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(381, 21, 81, 22);
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
		JLabel lblNewLabel_1 = new JLabel("You select member which his code is:");
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 86, 236, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(248, 83, 170, 20);
		panel.add(textField);
		textField.setColumns(10);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox)
				{
					try {
						
					String d=(String)comboBox.getSelectedItem();
					if(d.equals(""))
					{
						throw new NullPointerException();
					}
					textField.setText(d);
					Boolean flag=true;
					
					if(!submanagerCheck.getShortDeliveries().isEmpty()) {
					for(int i=0;i<submanagerCheck.getShortDeliveries().size();i++) 
					{
					if(submanagerCheck.getShortDeliveries().get(i).getMember().getId()==Integer.valueOf(textField.getText()))
					{
						flag=false;
				 		  
					    			for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
					    			{
					    				if(mEntry.getKey()!=null)
					    				{
					    					if(((Members)mEntry.getValue()).getId()==Integer.valueOf(textField.getText()))//if there a member that make an order he the same member that deleted as should delete it also from this dataBase 
					    					{
					    						//removes a key value pair from the map
					    						if(DataBase.ourMembersAndDeluveries.get(mEntry.getKey())instanceof ShortDelivery)
					    						{					    						

					    						submanagerCheck.getShortDeliveries().get(i).getMember().getDeliveries().remove(DataBase.ourMembersAndDeluveries.get(mEntry.getKey()));	
					    						submanagerCheck.getShortDeliveries().remove(DataBase.ourMembersAndDeluveries.get(mEntry.getKey()));
					    						DataBase.ourMembersAndDeluveries.remove(mEntry.getKey());
					    						DataBase.alltheshortDeliveries.remove(DataBase.ourMembersAndDeluveries.get(mEntry.getKey()));

					    						}
					    						if(DataBase.ourLastDeliveries.get(mEntry.getValue())instanceof ShortDelivery ) {
					    						DataBase.ourLastDeliveries.remove(mEntry.getValue());
					    						}
					    					}
					    				}
					    			}

				 		 // }						
					    JOptionPane.showMessageDialog(getContentPane(), " The delivery was deleted successfully!");
					}
					
					
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
									 else if(DataBase.ourMembersAndDeluveries.get(m1.getKey())instanceof ShortDelivery) {
										 bw.write(DataBase.ourMembersAndDeluveries.get(m1.getKey()).getArea());
	    									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getNumItems());
	    									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).getPrice());
	    									bw.write(" "+DataBase.ourMembersAndDeluveries.get(m1.getKey()).isDelivered());
	    									bw.write(" "+((ShortDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getDeliverydate());
	    									bw.write(" "+((ShortDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getStartingPoint());
	    									bw.write(" "+((ShortDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getPointOfDisembarkation());
	    									bw.write(" "+((ShortDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getDistination());
	    									bw.write(" "+((ShortDelivery)DataBase.ourMembersAndDeluveries.get(m1.getKey())).getPriceKm());
	    									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getFirstName());
	    									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getLastName());
	    									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getArea());
	    									bw.write(" "+DataBase.ourMembers.get(m1.getKey()).getId());
	    						    		bw.write(" "+"ShortDelivery");
	    						            bw.write(" "+submanagerCheck.getiD());
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
						throw new NODeliveries();
					}
					if(flag)
					{
					    JOptionPane.showMessageDialog(getContentPane()," The member you selected does not has a short delivery ");
		
					}
					}catch (NullPointerException d)
					{
						JOptionPane.showMessageDialog(getContentPane(),"There is no member to delete so it does not has delivery");
					}
					catch(NODeliveries d)
					{
						JOptionPane.showMessageDialog(getContentPane(),d.getMessage());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				
			}
		});
		


		
		
	}
}
