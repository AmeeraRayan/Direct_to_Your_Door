import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TablesOffshortDelivery extends JFrame {

	private JPanel contentPane;
	   private Managers managerCheck;


	public TablesOffshortDelivery(Managers managerCheck) {
		this.managerCheck= managerCheck;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] columns= {"address","numItems","price","isDelivered","deliverydate","startingPoint","pointOfDisembarkation","distination","priceKm","member"};
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
		panel_2.setBounds(0, 0, 777, 406);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JTable table_1 = new JTable();
		table_1.setBounds(0, 11, 600, 500);
		table_1.setModel(model);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(473);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(120);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(120);
		table_1.getColumnModel().getColumn(8).setPreferredWidth(200);
		table_1.getColumnModel().getColumn(9).setPreferredWidth(500);

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
		pane.setBounds(0, 0, 777, 406);
		panel_2.add(pane);
		pane.setForeground(Color.red);
		pane.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 777, 287);
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("This table will show all the short deliveries thats exit in system :");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 30));
		lblNewLabel.setBounds(25, 30, 756, 50);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablesOffshortDelivery.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(712, 537, 89, 23);
		panel.add(btnNewButton);
		
		Object[] row = new Object[10];
		for(int i=0;i<DataBase.alltheshortDeliveries.size();i++)
		{
			row[0]=DataBase.alltheshortDeliveries.get(i).getArea();
			row[1]=DataBase.alltheshortDeliveries.get(i).getNumItems();
			row[2]=DataBase.alltheshortDeliveries.get(i).getPrice();
			row[3]=DataBase.alltheshortDeliveries.get(i).isDelivered();
			row[4]=DataBase.alltheshortDeliveries.get(i).getDeliverydate();
			row[5]=DataBase.alltheshortDeliveries.get(i).getStartingPoint();
			row[6]=DataBase.alltheshortDeliveries.get(i).getPointOfDisembarkation();
			row[7]=DataBase.alltheshortDeliveries.get(i).getDistination();
			row[8]=DataBase.alltheshortDeliveries.get(i).getPriceKm();
			row[9]=DataBase.alltheshortDeliveries.get(i).getMember().toString();
			model.addRow(row);
		}
		
		
	}

}
