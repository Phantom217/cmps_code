/**
 *  Main.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0 2018-10-11
 */

package ScaryList;

import java.util.*;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		List list = new List();
		Index [] myIndices = new Index[26];
		ReadFile file = new ReadFile();
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Node node;
		String name = "";
		String nameToDelete = "";
		int usersChoice = 0;
		int nameCode = 0;
		String names[];
		int nameCodes[];
		char chosenLetter;
		
		file.getClass();
		names = file.readFileContents();
		nameCodes = new int[names.length];
		
//		System.out.println("SORTED LIST");
		
		//Sorted list
		for(int i = 0; i < names.length; i++)
		{
			//Set up easy variables
			name = names[i]; 
			nameCodes[i] = list.convertName(name);
			nameCode = nameCodes[i];
			node = new  Node(name, nameCode);
			list.compareNameCodes(node);
		}
		
		myIndices = list.createIndex();
		
		System.out.println("Which command would you like to issue?");
		while(usersChoice != 6)
		{
			printCommandPrompt();
			usersChoice = input.nextInt();
			
			switch(usersChoice)
			{
			case 1:
				System.out.println("SORTED LIST");
				list.printList();
				break;
			case 2:
				list.getLength();
				break;
			case 3: 
				System.out.print("\nType a name you want to delete: ");
				
				nameToDelete = input2.nextLine();
				node = list.searchForNode(nameToDelete);
				list.delete(node);
				
				System.out.println("\nHere is the list with the node deleted: ");
				
				list.printList();
				break;
			case 4:
				System.out.print("\nSelect which letter: ");
				chosenLetter = input.next().charAt(0);
				chosenLetter = Character.toLowerCase(chosenLetter);
				
				list.printLengthOfSection(myIndices, chosenLetter);
				break;
			case 5:
				System.out.print("\nSelect which letter: ");
				chosenLetter = input.next().charAt(0);
				chosenLetter = Character.toLowerCase(chosenLetter);
				
				list.printNamesInSection(myIndices, chosenLetter);
				break;
			case 6:
				System.out.println("\nGoodbye!");
				break;
			}
		}
	}
	public static void printCommandPrompt()
	{
		System.out.println("\n####################################################################");
		System.out.println("##  Enter one of the following commands.                          ##");
		System.out.println("##  1 - Display list                                              ##");
		System.out.println("##  2 - Request length of list                                    ##");
		System.out.println("##  3 - Delete a name from the list                               ##");
		System.out.println("##  4 - Request a length of the section of the list(by letter)    ##");
		System.out.println("##  5 - Request names in the list starting with a certain letter  ##");
		System.out.println("##  6 - Exit.                                                     ##");
		System.out.println("####################################################################\n");
	}
}
