/**
 *  ReadFile.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0 2018-10-11
 */

package ScaryList;

import java.io.*;
import java.util.Scanner;

public class ReadFile 
{
	String file;

    public ReadFile() 
    {
    	getFileName();
    	readFileContents();
    }
    public String[] readFileContents()
    {
    	boolean looping;
    	BufferedReader in;
    	String line;
    	String doc[] = new String[73];
    	int j=0;
    	/* Read input from file and process. */
        try 
        {
            in = new BufferedReader(new FileReader(file));

            looping = true;
            while(looping) 
            {
                /* Get a line of input from the file. */
                if (null == (line = in.readLine())) 
                {
                    looping = false;
                    /* Close and free up system resource. */
                    in.close();
                }
                else 
                {
//                	System.out.println(line);
                	doc[j] = line;
                	j++;
                }
            }/* End while. */
        } /* End try. */ 
        catch(IOException e) 
        {
            System.out.println("Error " + e);
        } /* End catch. */
        return doc;
    }

    public void getFileName()
    {
    	Scanner in = new Scanner(System.in);

        System.out.print("Enter the file name containing names you want to sort (including extension): ");
    	file = in.nextLine();
    	System.out.println("\nSorting names in "+ file + "\n");
    }
}
