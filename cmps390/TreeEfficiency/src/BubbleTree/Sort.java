/**
 *  Sort.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0.0 2018
 */

package BubbleTree;

import java.util.*;

public class Sort
{
    public static void displayConsole() 
    {
	int choice = 0;
	Scanner input = new Scanner(System.in);

	System.out.println("Which sorting method would you like to use?");
	while (choice != 3)
	{
	    displayPrompt();
	    choice = input.nextInt();

	    switch(choice)
	    {
		case 1:
		    System.out.println("Sorting using tree sort...");
		    treeSort();
		    break;
		case 2:
		    System.out.println("Sorting using bubble sort...");
		    bubbleSort();
		    break;
		case 3:
		    System.out.println("\nGoodbye.");
		    break;
	    }
	}
    }

    public static void displayPrompt()
    {
	System.out.println("\n###################################");
	System.out.println("##  Enter one of the following:  ##");
	System.out.println("##  1 - Tree Sort                ##");
	System.out.println("##  2 - Bubble Sort              ##");
	System.out.println("##  3 - Exit                     ##");
	System.out.println("###################################\n");
    }

    public static void treeSort()
    {
	Tree tree = new Tree();
	Node root;
	ReadFile file = new ReadFile();

	int[] nums;
	int compSum = 0;

	file.getClass();
	nums = file.readFileContents();

	compSum = tree.makeTree(nums);
	root = tree.getRoot();
	/* System.out.println(root); */
	/* System.out.println(nums[13]+"\n\n\n"); */
	tree.printLowHigh(root);

	System.out.println("Total Comparisons: " + compSum);
    }

    public static void bubbleSort()
    {
	ReadFile file = new ReadFile();

	int[] nums;
	int compSum;

	file.getClass();
	nums = file.readFileContents();

	compSum = Bubble.bubbleMe(nums, nums.length);

	System.out.println("Total Comparisons: " + compSum);
    }
}
