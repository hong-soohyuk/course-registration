package basketPage;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import entity.ELecture;

public class BasketFrameTable extends JTable{
	private DefaultTableModel btableModel;
	private Vector<ELecture> eLectures;
	private static final long serialVersionUID = 1L;
	
	public BasketFrameTable(){
		this.setPreferredSize(new Dimension(100,200));
		String[] columnNames = new String[] {"Lecture Number", "Lecture Name",
				"Professor", "Credit", "Time"};
		this.btableModel = new DefaultTableModel(null, columnNames);
		this.setModel(btableModel);
	}
	
	public void basketRefresh(String userId){
		this.btableModel.setNumRows(0);
		CLecture cLecture = new CLecture();
		eLectures = cLecture.getItems("data/" +userId+ "_basket");
		
		for(ELecture eLecture:eLectures) {
			Vector<Object> record = new Vector<Object>();
			record.addElement(eLecture.getLecNumber());
			record.addElement(eLecture.getLecName());
			record.addElement(eLecture.getProfName());
			record.addElement(eLecture.getCreditNumber());
			record.addElement(eLecture.getLecInfo());
			btableModel.addRow(record);
		}
		this.updateUI();
	}

	public void sincheongRefresh(String userId) {
		this.btableModel.setNumRows(0);
		CLecture cLecture = new CLecture();
		eLectures = cLecture.getItems("data/" +userId+ "_sincheong");
		
		
		for(ELecture eLecture:eLectures) {
			Vector<Object> record = new Vector<Object>();
			record.addElement(eLecture.getLecNumber());
			record.addElement(eLecture.getLecName());
			record.addElement(eLecture.getProfName());
			record.addElement(eLecture.getCreditNumber());
			record.addElement(eLecture.getLecInfo());
			btableModel.addRow(record);
		}
		this.updateUI();
	}
}
