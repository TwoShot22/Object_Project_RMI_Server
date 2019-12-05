package home.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import home.frameworks.CheckDuplicationInterface;

public class CheckDuplicationDao implements CheckDuplicationInterface{

	public boolean checkOverLapData(String str1, String str2) {
		return str1.equals(str2);
	}
	
	@SuppressWarnings("resource")
	public void manageLectureFile(String selectedLectures, String targetFileName, String mode) {
		try {
			Vector<String> beforeContents = new Vector<String>();
			File targetFile = new File(targetFileName);
			
			//Read All Row
			Scanner scanner = new Scanner(targetFile);
			while(scanner.hasNextLine()) {
				beforeContents.add(scanner.nextLine());
			}
			
			//Clear File & Write Content Except Target Row
			FileWriter fileWriter = new FileWriter(targetFile, false);
			for(String row : beforeContents) {
				if(!row.equals(selectedLectures)) {
					fileWriter.write(row+"\r\n");
				}
			}
			
			if(mode.equals("AddLecture")) {
				fileWriter.write(selectedLectures);				
			}
			
			fileWriter.flush();
			
		} catch(Exception e) {
			System.out.println(targetFileName);
			System.out.println("File Not Founded");
		}
	}
	
	public void manageUserFile(String userInfo, String TargetFileName) {		
		try {
			File targetFile = new File(TargetFileName);
			
			FileWriter fileWriter = new FileWriter(targetFile, true);
			fileWriter.write(userInfo+"\r\n");
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Founded");
		}
	}
	
	public void manageCurrentUser(String userInfo, String TargetFileName) {		
		try {
			File targetFile = new File(TargetFileName);
			
			FileWriter fileWriter = new FileWriter(targetFile, false);
			fileWriter.write(userInfo);
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Founded");
		}
	}
}
