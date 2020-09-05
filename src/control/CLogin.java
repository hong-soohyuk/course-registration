package control;


import java.io.FileNotFoundException;

import dao.ELogin;

public class CLogin {

	private ELogin eLogin;
	public CLogin() {
		this.eLogin = new ELogin();
	}
	public String authenticate(String userId, String password) {
		String duserId = null;
		try {
			duserId = this.eLogin.authenticate(userId, password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return duserId;
	}
}