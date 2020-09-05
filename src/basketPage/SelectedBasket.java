package basketPage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rowMethod.Deleterow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
public class SelectedBasket extends JPanel{
	private static final long serialVersionUID = 1L;
	private BasketFrameTable baskettable;
	private BasketFrameTable sincheongTable;
	private JButton btnRegister;
	private JButton btnBasDelete;
	private JButton btnShinDelete;
	private JScrollPane scrollpane;

	
	private int selectedRowIndexinBas;
	private int selectedRowIndexinReg;
	private Deleterow deleterow;
	public SelectedBasket(String userId) {
		JLabel lblBasketStatus = new JLabel("Hello, This is Student" + userId + "'s Basket Status");
		LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(layoutManager);
		
		
		this.add(lblBasketStatus);


		scrollpane = new JScrollPane();
		this.baskettable = new BasketFrameTable();
		baskettable.basketRefresh(userId);
		scrollpane.setViewportView(this.baskettable);
		this.add(scrollpane);

		scrollpane = new JScrollPane();
		this.sincheongTable = new BasketFrameTable();
		sincheongTable.sincheongRefresh(userId);
		scrollpane.setViewportView(this.sincheongTable);
		this.add(scrollpane);
		
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("data/" + userId + "_sincheong");
					if(file.exists() == false){
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw,true);

					int selectedRowIndex = baskettable.getSelectedRow();
					for(int i = 0; i < baskettable.getColumnCount(); i++) {
						pw.write(baskettable.getModel().getValueAt(selectedRowIndex, i)+ " ");
					}
					pw.write("\r");
					pw.flush();
					pw.close();
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "The lecture is registered successfully, Go for the A+!!");
					
					
					deleterow = new Deleterow(userId);
					deleterow.removeBasRecord(userId, selectedRowIndex);
					
					baskettable.basketRefresh(userId);
					sincheongTable.sincheongRefresh(userId);

				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(null,"Please select a specific lecture!","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		this.add(btnRegister);
		
		btnBasDelete = new JButton("Delete from Basket");
		btnBasDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRowIndexinBas = baskettable.getSelectedRow();
				deleterow = new Deleterow(userId);
				deleterow.removeBasRecord(userId, selectedRowIndexinBas);

				baskettable.basketRefresh(userId);
				sincheongTable.sincheongRefresh(userId);
			}
		});
		this.add(btnBasDelete);

		btnShinDelete = new JButton("Delete from Registered Item");
		btnShinDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ereg) {
				selectedRowIndexinReg = sincheongTable.getSelectedRow();
				deleterow = new Deleterow(userId);
				deleterow.removeShinRecord(userId, selectedRowIndexinReg);

				baskettable.basketRefresh(userId);
				sincheongTable.sincheongRefresh(userId);
			}
		});
		this.add(btnShinDelete);
	}
}