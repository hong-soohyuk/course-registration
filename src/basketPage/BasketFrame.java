package basketPage;
import javax.swing.JFrame;

public class BasketFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private SelectedBasket selectedBasket;
	
	public BasketFrame(String userID){
		this.setLocation(115, 115);
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.selectedBasket = new SelectedBasket(userID);
		this.add(this.selectedBasket);
	}
	
}