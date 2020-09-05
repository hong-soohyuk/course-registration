package dao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
//import entity.EDirectory;
import entity.ELecture;
public class DAOLecture {
	public Vector<ELecture> eLecture;

	public Vector<ELecture> getItems(String fileName) throws FileNotFoundException{
		Vector<ELecture> eLectures = new Vector<ELecture>();
		Scanner scanner = new Scanner(new File(fileName));
		
		while(scanner.hasNext()) {
			ELecture eLecture = new ELecture();
			eLecture.read(scanner);
			eLectures.add(eLecture);
		}
		scanner.close();
		return eLectures;
	}
}