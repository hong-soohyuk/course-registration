package mainPage;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import control.CDirectory;
import entity.EDirectory;
public class DirectoryList extends JList<String> {
	private static final long serialVersionUID = 1L;

	private CDirectory cDirectory;
	private Vector<EDirectory> eDirectories;
	private Vector<String> listData;

	public DirectoryList(ListSelectionListener listSelectionListener) {
		this.setPreferredSize(new Dimension(100,200));
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.cDirectory = new CDirectory();
		this.listData = new Vector<String>();

		this.setListData(listData);
		this.addListSelectionListener(listSelectionListener);
	}

	public String getSelectedFileName() {
		int selectedIndex = this.getSelectedIndex();
		return this.eDirectories.get(selectedIndex).getHyperLink();
	}

	public String refresh(String fileName) throws FileNotFoundException {
		this.eDirectories = this.cDirectory.getItems("data/" + fileName);
		this.listData.clear();
		for(EDirectory eDirectory:eDirectories) {
			this.listData.add(eDirectory.getName());
		}
		this.setSelectedIndex(0);
		this.updateUI();
		
		return this.eDirectories.get(0).getHyperLink();
	}

}