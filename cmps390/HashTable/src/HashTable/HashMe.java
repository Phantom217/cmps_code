/**
 *  HashMe.java
 *
 *
 *  @author Tyler Oalman
 *  @version 2.5.5 2018-11-20
 */

package HashTable;

import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class HashMe
{
	String file;
	String[] hashTable;
	int tabLen;
	int numSmashes;

	public HashMe(int hashTableLen)
	{
		int j;

		/* Initialize variables */
		tabLen = hashTableLen;
		numSmashes = 0;

		/* Initialize hash table */
		hashTable = new String[tabLen];

		for (j = 0; j < tabLen; j++)
		{
			hashTable[j] = "#";
		}

		getFileName();
		readFileContents();
		showHashTable();
	}

	public void readFileContents()
	{
	 	boolean looping;
		BufferedReader in;
		String line;
		int j, len, hashIndex, hInc, spot;

		/* Read input from file and process */
		try
		{
			in = new BufferedReader(new FileReader(file));

			looping = true;
			while (looping)
			{
				/* Get a line of input from the file */
				if (null == (line = in.readLine()))
				{
					looping = false;
					/* Close and free up resource */
					in.close();
				}

				else
				{
					hashIndex = hashFun(line);

					while (hashTable[hashIndex] != "#")
					{
						hashIndex++;
						numSmashes++;
					}

						for (j = hashIndex; j < tabLen; j++)
						{
							if (hashTable[j] == "#")
							{
								hashTable[j] = line;
								break;
							}

	/* 						else */
	/* 						{ */
	/* 							numSmashes++; */
	/* 						} */
						}
					}

	/* 				else */
	/* 				{ */
	/* 					hashTable[hashIndex] = line; */
	/* 				} */
	/* 			} */
			} /* end while */
		} /* end try */

		catch (IOException e)
		{
			System.out.println("Error " + e);
		}
	}

	public void showHashTable()
	{
		int j;

		System.out.println("\nNumber of Hash Clashes = " + numSmashes + "\n");

		for (j = 0; j < tabLen; j++)
		{
			/* Clean up display output */
			if (hashTable[j] != "#")
			{
				System.out.println(hashTable[j]);
			}
		}
	}

	public int hashFun(String name)
	{
		int hashVal = 0;
		int i, exp;
		int denom = 0;
		char letter;

		/* Get denominator for any given tabLen */
		if (denom == 0)
		{
			/* should give optimal denom for less wasted memory */
			/* ie tabLen of 200 would give denom 88, 400: 44 and 700: 25 */
			denom = (int) Math.ceil((double)17500 / tabLen);
		}

		/* name code generation (first 3 letters) */
		for (i = 0, exp = 2; i < 3; i++, exp--)
		{
			letter = name.charAt(i);
			hashVal += ((letter - 'a') * Math.pow(26, exp));
		}

		hashVal = hashVal / denom;

		return hashVal;
	}

	public void getFileName()
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Enter file name: ");
		file = in.nextLine();
		System.out.println("You entered " + file);
	}

	public static void main(String[] args)
	{
	System.out.println("Hash Table for size 200...");
	HashMe hash1 = new HashMe(200);
	System.out.println("\nHash Table for size 400...");
	HashMe hash2 = new HashMe(400);
	System.out.println("\nHash Table for size 700...");
	HashMe hash3 = new HashMe(700);
	}
}
