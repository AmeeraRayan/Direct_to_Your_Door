import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ShortDeliveryabout30days extends JFrame {

	private JPanel contentPane;
   private Managers managerCheck;
	/**
	 * Create the frame.
	 */
	public ShortDeliveryabout30days(Managers managerCheck) {
		this.managerCheck= managerCheck;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Show all the towns thats ordered short delivery in the last 30 days");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel.setBounds(22, 29, 519, 33);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 73, 695, 205);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(147, 112, 219));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShortDeliveryabout30days.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(611, 362, 136, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setBackground(new Color(107, 142, 35));
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<DataBase.alltheshortDeliveries.size();i++)
				{
					Date datetemp= new Date();
					int daysdiff = 0;
					long res=datetemp.getTime()-DataBase.alltheshortDeliveries.get(i).getDeliverydate().getTime();
					long diffDays = res / (24 * 60 * 60 * 1000);
					 daysdiff = (int) diffDays;
					 if(daysdiff<30) {
					textArea.append("The Delivery thats arrived in the last 30 days number: "+(i+1)+" ,"+DataBase.alltheshortDeliveries.get(i));	
				}}
				if(textArea.getText().equals(""))
				{
					  JOptionPane.showMessageDialog(getContentPane(),"There is no short delivery thats arrived in last days to show ");
				}
			}
		});
		btnNewButton_1.setBounds(551, 27, 85, 37);
		contentPane.add(btnNewButton_1);

		
	}

}
