package finder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Reader{
	public int reader(String password) throws IOException{
		// input of the user password
	    try {
		    File passFile = new File("list.txt");
		    Scanner scanFile = new Scanner(passFile);
		    while(scanFile.hasNextLine()) {
			    String passInFile = scanFile.nextLine();
			    System.out.println(passInFile);
			    if(passInFile.equals(password)) {
			    	System.out.println("Warning! Your password was found in the wordlist! Your password is: " + password);
			    	scanFile.close();
			    	return 0;
			    }else if(!passInFile.equals(password) && !scanFile.hasNextLine()) {
			    	System.out.println("Your password isn't in the wordlist. You're safe!");
			    	scanFile.close();
			    	return 1;
			    }
		    }
	    }catch(FileNotFoundException nf) {
	    	System.out.println("File not found!");
	    }
		return 0;
	}
}
