package control;
import java.io.FileNotFoundException;
import java.util.Vector;
//import dao.DAODirectory;
import dao.DAOLecture;
//import entity.EDirectory;
import entity.ELecture;
public class CLecture {
	private DAOLecture dAOLecture;
	public CLecture() {
		this.dAOLecture = new DAOLecture();
	}
	public Vector<ELecture> getItems(String fileName) {

		Vector<ELecture> eLectures = new Vector<ELecture>();
		try {
			eLectures = this.dAOLecture.getItems(fileName);
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("error.");
		}
		return eLectures;
	}
}