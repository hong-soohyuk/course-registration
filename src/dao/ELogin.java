package dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ELogin {
	// 엔티티는 파일 구조가 똑같이 생겨야한다.
	private String UserId;
	private String password;// 하나의 로우row 담당, 하나의 레코드라, 파일에 저장되는 한 줄.
	
	public void read(Scanner scanner) {
		this.UserId = scanner.next();
		this.password = scanner.next();
	}// 파일의 아이디 패스워드 읽어오는 명령어.1 a, 2 b... 순서대로 읽어온다.

	public String authenticate(String userId, String password) throws FileNotFoundException {
		//file open
		Scanner scanner = new Scanner(new File("data/login"));
		//String으로 변환.
		while (scanner.hasNext()) {
			this.read(scanner);
			if (this.UserId.equals(userId) && this.password.equals(password)) {
				scanner.close();
				return userId;
			}
		}
		//여기까지 왔다는 건, 틀린 id pw 입력했다는 뜻.
		scanner.close();//클로우즈를 먼저쓴 이유
		return null;
	}

}

