import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddDelivery extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;
	/**
	 * Create the frame.
	 */
	
	public AddDelivery(Managers managerCheck) {
		this.managerCheck=managerCheck;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 478);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter a delivery to add:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel.setBounds(24, 11, 315, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("choose if you want a General or Express or Buisness delivery! to add");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1.setBounds(34, 42, 596, 53);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("GeneralDelivery");
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(184, 134, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDelivery.this.setVisible(false);
				new General(managerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(40, 106, 202, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BusinessDelivery");
		btnNewButton_1.setBackground(new Color(205, 133, 63));
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDelivery.this.setVisible(false);
				new Business(managerCheck).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(153, 174, 186, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ExpressDelivery");
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(184, 134, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDelivery.this.setVisible(false);
				new Express(managerCheck).setVisible(true);
			}
		});
		btnNewButton_2.setBounds(310, 266, 202, 53);
		contentPane.add(btnNewButton_2);
		
		
	}
	public Managers getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(Managers managerCheck) {
		this.managerCheck = managerCheck;
	}

}
