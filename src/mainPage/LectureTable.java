package mainPage;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import entity.ELecture;
public class LectureTable extends JTable {
	private static final long serialVersionUID = 1L;
	private Vector<ELecture> eLectures;
	private DefaultTableModel tableModel;
	
	public LectureTable() {
		this.setPreferredSize(new Dimension(100,200));
		String[] columnNames = new String[] {"Lecture Number", "Lecture Name",
				"Professor", "Credit", "Time"};
		this.tableModel = new DefaultTableModel(null, columnNames);
		this.setModel(tableModel);
	}
	
	public Vector<ELecture> getSelectedLectures() {
		return null;
	}
	
	public void refresh(String fileName){
		this.tableModel.setNumRows(0);
		CLecture cLecture = new CLecture();
		eLectures = cLecture.getItems("data/" + fileName);
		
		for(ELecture eLecture:eLectures) {
			Vector<Object> record = new Vector<Object>();
			record.addElement(eLecture.getLecNumber());
			record.addElement(eLecture.getLecName());
			record.addElement(eLecture.getProfName());
			record.addElement(eLecture.getCreditNumber());
			record.addElement(eLecture.getLecInfo());
			tableModel.addRow(record);
		}
		this.updateUI();
	}
}