package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.EDirectory;

public class DAODirectory {

	public Vector<EDirectory> eDirectory;
	
	public Vector<EDirectory> getItems(String fileName) throws FileNotFoundException{
		Vector<EDirectory> eDirectories = new Vector<EDirectory>();
		Scanner scanner = new Scanner(new FileInputStream(new File(fileName)));//mac¿¡¼­ 

		while(scanner.hasNext()) {
			EDirectory eDirectory = new EDirectory();
			eDirectory.read(scanner);
			eDirectories.add(eDirectory);
		}
		scanner.close();
		return eDirectories;
	}
}