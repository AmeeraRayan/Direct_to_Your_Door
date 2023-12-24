import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class deliveriesaboutspicificarea extends JFrame {

	private JPanel contentPane;
	private Managers managerCheck;	


	public deliveriesaboutspicificarea(Managers managerCheck) {
		this.managerCheck=managerCheck;  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String[] columns= {"idMember","DeliveryDetails"};
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
		table_1.getColumnModel().getColumn(1).setPreferredWidth(700);

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
		Object[] row = new Object[2];
		JLabel lblNewLabel = new JLabel("This table will show all the  deliveries about spicific area that exit in system :");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 23));
		lblNewLabel.setBounds(25, 30, 749, 28);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliveriesaboutspicificarea.this.setVisible(false);
				new Menu(managerCheck).setVisible(true);
			}
		});
		btnNewButton.setBounds(813, 327, 67, 74);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("press to show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
    			{
    				if(mEntry.getKey()!=null)//if2
    				{
    					if(((Members)mEntry.getValue()).getArea().equals(managerCheck.getArea()))//if3
    					{
    						if(DataBase.ourMembersAndDeluveries.get(mEntry.getKey())!=null)//if the member deleted as there is no key to map to the delivery there is no member that exit in the system now ,so he does not have a delivery
    						{
    							 row[0]=DataBase.ourMembersAndDeluveries.get(mEntry.getKey()).getId();
    							 row[1]=DataBase.ourMembersAndDeluveries.get(mEntry.getKey()).toString();
    							 model.addRow(row);
    						}
    					}//if3
    				}//if2
    			}
			}
		});
		btnNewButton_1.setBounds(712, 54, 130, 38);
		panel.add(btnNewButton_1);
		
		
	}

}
