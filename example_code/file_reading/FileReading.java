import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class FileReading {

    public static void main(String[] args) {
	// a quick intro to file reading with comments from me to help
	// it's also worth taking a look at Chapter 7 of the text book
	
	// Every file needs a name, this is more complicated than just 
	String filename = "notest.file";
	
	// File object allows us to play with files that are part of the file system 
	File file = new File(filename);
	
	System.out.println(file.isFile());
	
	System.out.println(file.getAbsolutePath());
	
	try {
	    // scanner is the "new" java file management tool
	    Scanner scanner = new Scanner(file);
	    // scanner can check if it has more lines to read from the file
	    while (scanner.hasNextLine()) {
		// and read them and we can print them with sysout
		System.out.println(scanner.nextLine());
		// you can also get scanner to look for the next word with .next()
		// or you can get an int with .nextInt() or a double with .nextDouble()
		// and so on.
	    }
	    scanner.close();
	} catch (FileNotFoundException e) {
	    // we can actually look at the stack trace to see all the method
	    // java calls from the library.
	    e.printStackTrace();
	}
    }

}
