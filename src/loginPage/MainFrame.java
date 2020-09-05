package loginPage;
import javax.swing.JFrame;

import mainPage.SelectionPanel;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private SelectionPanel selectionPanel;
	
	public MainFrame(String userId){
		this.setLocation(100, 100);
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.selectionPanel = new SelectionPanel(userId);
		this.add(this.selectionPanel);
	}
}