package rowMethod;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import entity.ELecture;
public class Deleterow{
	Vector<ELecture> eLectures = new Vector<ELecture>();
	String userId;
	int removeTerm;
	public Deleterow(String userId) {
		this.userId = userId;
	}
	public void removeBasRecord(String userId, int selectedRowIndexinBas) {
		removeTerm = selectedRowIndexinBas;
		try {
			Scanner x = new Scanner(new File("data/"+ userId +"_basket"));

			while(x.hasNext()) {
				ELecture eLecture = new ELecture();
				eLecture.read(x);
				eLectures.add(eLecture);
			}
			
			eLectures.removeElementAt(removeTerm);
			FileWriter fw = new FileWriter(new File("data/"+ userId +"_basket"));
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(ELecture eLecture1:eLectures) {
				pw.write(eLecture1.getLecNumber()+ " " +eLecture1.getLecName()+
						" " +eLecture1.getProfName()+ " "+eLecture1.getCreditNumber()+ " "+eLecture1.getLecInfo()+ "\r");
			}
			x.close();
			pw.flush();
			pw.close();
			
		}
		catch(ArrayIndexOutOfBoundsException e2) {
			JOptionPane.showMessageDialog(null, "Please select a specific lecture!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong, try again.");
		}
	}
////////////////////////////////////////////
////////////////////////////////////////////
	public void removeShinRecord(String userId, int selectedRowIndexinReg) {
		removeTerm = selectedRowIndexinReg;
		try {
			Scanner y = new Scanner(new File("data/" + userId + "_sincheong"));
			while(y.hasNext()) {
				ELecture eLecture = new ELecture();
				eLecture.read(y);
				eLectures.add(eLecture);
			}
			//oldFile.delete();
//			File newFile = new File("data/"+ userId +"_basket");
//			newFile.createNewFile();
			eLectures.removeElementAt(removeTerm);
			FileWriter fw = new FileWriter(new File("data/" + userId + "_sincheong"));
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for(ELecture eLecture1:eLectures) {
				pw.write(eLecture1.getLecNumber()+ " " +eLecture1.getLecName()+
						" " +eLecture1.getProfName()+ " "+eLecture1.getCreditNumber()+ " "+eLecture1.getLecInfo()+ "\r");
			}
			y.close();
			pw.flush();
			pw.close();
			
		}
		catch(ArrayIndexOutOfBoundsException e2) {
			JOptionPane.showMessageDialog(null, "Please select a specific lecture!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong, try again.");
		}
	}

}