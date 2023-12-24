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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class ShowDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Managers managerCheck;
	/**
	 * Create the frame.
	 */
	public ShowDetails(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 69, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Details About last Delivery:");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 145, 197, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.activeCaptionBorder);
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
		textField.setBounds(21, 114, 96, 20);
		contentPane.add(textField);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 309, 529, 79);
		contentPane.add(scrollPane_1);
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 0));
		scrollPane_1.setViewportView(textArea);
		textArea.setEditable(false);
		JScrollPane scrollPane_2 = new JScrollPane();
		JButton btnNewButton_1 = new JButton("Back To Menu");
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDetails.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(633, 368, 146, 64);
		contentPane.add(btnNewButton_1);
		scrollPane_2.setBounds(10, 32, 724, 45);
		contentPane.add(scrollPane_2);
		JComboBox<GeneralDelivery> comboBox_1 = new JComboBox<GeneralDelivery>();
		comboBox_1.setBackground(new Color(128, 128, 0));

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 255, 0));
		scrollPane_2.setViewportView(comboBox_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 170, 513, 55);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		for(Map.Entry<Members, GeneralDelivery> mEntry :DataBase.ourLastDeliveries.entrySet())
		{
			if(managerCheck.getMembers().containsKey(mEntry.getKey().getId())) {
			if(DataBase.ourLastDeliveries.containsKey(managerCheck.getMembers().get(mEntry.getKey().getId()))) {
			     comboBox_1.addItem(mEntry.getValue());  
			}
			}
			}
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_1)
				{
				try {
				
					GeneralDelivery temp=(GeneralDelivery)comboBox_1.getSelectedItem();
					textField.setText(String.valueOf(temp.getId()));
					for (Map.Entry<Members, GeneralDelivery> m : DataBase.ourLastDeliveries.entrySet())
					{
						if(DataBase.ourLastDeliveries.containsKey(managerCheck.getMembers().get(m.getKey().getId())))//if we here as there is a delivery to show 
				    	   {

							textArea_1.append("The last Delivery for the member thats name "+ managerCheck.getMembers().get(m.getKey().getId()).getFirstName()
									+"\n"+"And his id: "+ managerCheck.getMembers().get(m.getKey().getId()).getId()
									+"\n"+managerCheck.getMembers().get(m.getKey().getId()).getFirstName()+ " is associated to the manager: "+managerCheck.getName()
									+"\n"+DataBase.ourLastDeliveries.get(managerCheck.getMembers().get(m.getKey().getId())).toString());
							  textArea.append(managerCheck.getMembers().get(m.getKey().getId()).getDeliveries().toString());
				    	   }
		
						
					}					
				}catch(NullPointerException d)
				{
					JOptionPane.showMessageDialog(getContentPane(),"You did not select any delivery to show");	
				}
				
				}	
			}
		});


	

		JLabel lblNewLabel_3 = new JLabel("Details about all the last deliveries to every one has a delivery");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 515, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("now, you will see details about the lastDelivery you selected then it will appeared the id of the delivery you select");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblNewLabel_4.setBounds(20, 88, 763, 15);
		contentPane.add(lblNewLabel_4);
		

				

		

		
		
		JLabel lblNewLabel_1 = new JLabel("And his details about all the deliveries that he ordered");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 12));
		lblNewLabel_1.setBounds(23, 284, 376, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShowDetails.class.getResource("/Photo/\u05D4\u05D5\u05E8\u05D3\u05D4.png")));
		lblNewLabel.setBounds(543, 112, 302, 161);
		contentPane.add(lblNewLabel);
		

		

	
	}
	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}
}
