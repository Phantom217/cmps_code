/**
 *  ReadFile.java
 *
 *
 *  Tyler Oalman
 *  @version 3.0.0 2018
 */

package BubbaMerge;

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

    public int[] readFileContents()
    {
	try
	{
	    File content = new File(file);
	    Scanner scan = new Scanner(content);
	    Scanner scan2 = new Scanner(content);
	    int count = 0;
	    int[] nums;

	    while (scan.hasNextInt())
	    {
		count++;
		scan.nextInt();
	    }
	    System.out.println(count);

	    nums = new int[count];

	    for (int i = 0; i < nums.length; i++)
	    {
		nums[i] = scan2.nextInt();
	    }

	    return nums;
	}

	catch(Exception e)
	{
	    return null;
	}
    }

    public void getFileName()
    {
        Scanner in = new Scanner(System.in);
	System.out.print("Enter the file name: ");
	file = in.nextLine();
    }
}

