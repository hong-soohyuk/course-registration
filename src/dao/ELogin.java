package dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ELogin {
	// ��ƼƼ�� ���� ������ �Ȱ��� ���ܾ��Ѵ�.
	private String UserId;
	private String password;// �ϳ��� �ο�row ���, �ϳ��� ���ڵ��, ���Ͽ� ����Ǵ� �� ��.
	
	public void read(Scanner scanner) {
		this.UserId = scanner.next();
		this.password = scanner.next();
	}// ������ ���̵� �н����� �о���� ��ɾ�.1 a, 2 b... ������� �о�´�.

	public String authenticate(String userId, String password) throws FileNotFoundException {
		//file open
		Scanner scanner = new Scanner(new File("data/login"));
		//String���� ��ȯ.
		while (scanner.hasNext()) {
			this.read(scanner);
			if (this.UserId.equals(userId) && this.password.equals(password)) {
				scanner.close();
				return userId;
			}
		}
		//������� �Դٴ� ��, Ʋ�� id pw �Է��ߴٴ� ��.
		scanner.close();//Ŭ�ο�� ������ ����
		return null;
	}

}

