package mainPage;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import basketPage.BasketFrame;

public class SelectionPanel extends JPanel {

	// attribute
	private static final long serialVersionUID = 1L;
	private String userId; 

	private DirectoryList campus;
	private DirectoryList college;
	private DirectoryList department;
	private LectureTable lecture;
	
	private JScrollPane scrollpaneCam;
	private JScrollPane scrollpaneCol;
	private JScrollPane scrollpaneDept;
	private JScrollPane scrollpaneLec;
	
	private JButton btnbasket;
	private JButton btnlogout;
	private JButton btnAdding;
	private JFrame logoutFrame;
	private ListSelectionListener listSelectionListener;

	public SelectionPanel(String userId) {
		this.listSelectionListener = new ListSelectionHandler();
		this.userId = userId;

		LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(layoutManager);

		this.scrollpaneCam = new JScrollPane();
		this.campus = new DirectoryList(this.listSelectionListener);
		this.scrollpaneCam.setViewportView(this.campus);
		this.add(this.scrollpaneCam);

		this.scrollpaneCol = new JScrollPane();
		this.college = new DirectoryList(this.listSelectionListener);
		this.scrollpaneCol.setViewportView(this.college);
		this.add(this.scrollpaneCol);

		this.scrollpaneDept = new JScrollPane();
		this.department = new DirectoryList(this.listSelectionListener);
		this.scrollpaneDept.setViewportView(this.department);
		this.add(this.scrollpaneDept);

		this.scrollpaneLec = new JScrollPane();
		this.lecture = new LectureTable();
		this.scrollpaneLec.setViewportView(this.lecture);
		this.add(this.scrollpaneLec);

		//Log Out Button
		btnlogout = new JButton("Logout");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutFrame = new JFrame("Logout");
				if (JOptionPane.showConfirmDialog(logoutFrame, "Student " + userId + ", Are you sure you want to Logout?", "System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		this.add(btnlogout);
		//Log Out Button
		ButtonHandler buttonhandler = new ButtonHandler();
		btnbasket = new JButton("My Basket");
		btnbasket.addActionListener(buttonhandler);
		this.add(btnbasket);

		AddingbuttonHandler addingbuttonhandler = new AddingbuttonHandler();
		btnAdding = new JButton("Add to Basket");
		btnAdding.addActionListener(addingbuttonhandler);
		this.add(btnAdding);

		this.refresh(null);
	}
	private void refresh(Object source) {
		try {
			if(source == null) {
				String fileName = campus.refresh("root");
				fileName = this.college.refresh(fileName);
				fileName = this.department.refresh(fileName);
				this.lecture.refresh(fileName);
			}else if(source == this.campus) {
				String fileName = campus.getSelectedFileName();
				fileName = this.college.refresh(fileName);
				fileName = this.department.refresh(fileName);
				this.lecture.refresh(fileName);
			}else if(source == this.college) {
				String fileName = college.getSelectedFileName();
				fileName = this.department.refresh(fileName);
				this.lecture.refresh(fileName);
			}else if(source == this.department) {
				String fileName = this.department.getSelectedFileName();

				this.lecture.refresh(fileName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public class ListSelectionHandler implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent event) {
			refresh(event.getSource());
		}
	}

	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			gotoBasket();
		}
	}
	private class AddingbuttonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				File file = new File("data/" + userId + "_basket");
				if(file.exists() == false){
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw,true);

				int selectedRowIndex = lecture.getSelectedRow();
				for(int i = 0; i < lecture.getColumnCount(); i++) {
					pw.write(lecture.getModel().getValueAt(selectedRowIndex, i)+ " ");
				}

				pw.write("\r");
				pw.flush();
				pw.close();
				bw.close();
				fw.close();
				JOptionPane.showMessageDialog(null, "The lecture is added to your basket successfully");
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (ArrayIndexOutOfBoundsException e2) {
				JOptionPane.showMessageDialog(null,"Please select a lecture for the basket!","Error",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	private void gotoBasket() {
		BasketFrame basketFrame = new BasketFrame(this.userId);
		basketFrame.setVisible(true);
	}
}

