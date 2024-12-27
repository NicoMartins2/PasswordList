package finder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Reader{
	public static void main(String[]args) throws IOException{
		// input of the user password
		Scanner reader = new Scanner(System.in);
		System.out.println("Type your password:");
	    String password = reader.nextLine();
	    try {
		    File passFile = new File("list.txt");
		    Scanner scanFile = new Scanner(passFile);
		    while(scanFile.hasNextLine()) {
			    String passInFile = scanFile.nextLine();
			    System.out.println(passInFile);
			    if(passInFile.equals(password)) {
			    	System.out.println("Warning! Your password was found in the wordlist! Your password is: " + password);
			    	scanFile.close();
			    	break;
			    }else if(!passInFile.equals(password) && !scanFile.hasNextLine()) {
			    	System.out.println("Your password isn't in the wordlist. You're safe!");
			    }
		    }
	    }catch(FileNotFoundException nf) {
	    	System.out.println("File not found!");
	    }
	}
}
