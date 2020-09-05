package loginPage;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	private JLabel lblLoginMessage;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JButton btnLogin;
	private JButton btnExit;
	private JFrame SurelyExit;
	private ActionListener buttonHandler;

	public LoginFrame() {
		this.setTitle("Login");
		this.setBounds(100, 200, 1000, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		buttonHandler = new ButtonHandler();
		
		lblLoginMessage = new JLabel("Welcome, Please enter your username and password.");
		
		this.lblUsername = new JLabel("Username");

		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(buttonHandler);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SurelyExit = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(SurelyExit, "Are you sure you want to exit?", "Login System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		LayoutManager layoutManager = new FlowLayout(FlowLayout.CENTER, 10, 10);
		this.setLayout(layoutManager);
		this.add(lblLoginMessage);
		this.add(lblUsername);
		this.add(usernameTextField);
		this.add(lblPassword);
		this.add(passwordTextField);
		this.add(btnLogin);
		this.add(btnExit);
		}
	private void authenticate() {
		CLogin clogin = new CLogin();
		String userId = null;
		userId = clogin.authenticate(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()));
		if(userId != null) {
			MainFrame mainFrame = new MainFrame(userId);
		    mainFrame.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null,"Invalid Username/Password.","Login Error",JOptionPane.WARNING_MESSAGE);
		}
	}
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			authenticate();
		}
	}
}