import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ShowingallMembofshortdeliveries extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck; 

	/**
	 * Create the frame.
	 */
	public ShowingallMembofshortdeliveries(Managers managerCheck) {
		this.managerCheck= managerCheck;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 771, 279);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.activeCaption);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Show all the members thats ordered short delivery");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 50, 438, 56);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowingallMembofshortdeliveries.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(660, 429, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setBackground(Color.MAGENTA);
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					for(int i=0;i<DataBase.alltheshortDeliveries.size();i++)
					{
						textArea.append(" Member: "+ (i+1)+" ,"+DataBase.alltheshortDeliveries.get(i).getMember().toString()+"\n");	
					}
					if(textArea.getText().equals(""))
					{
						  JOptionPane.showMessageDialog(getContentPane(),"There is no member that ordered short delivery to show");
					}

			
			}
		});
		btnNewButton_1.setBounds(458, 52, 114, 50);
		contentPane.add(btnNewButton_1);
		
	}
}
