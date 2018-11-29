/**
 *  List.java
 *
 *
 *  @author Tyler Oalman
 *  @version 2.0 2018-10-11
 */

package ScaryList;

class List
{
	int size = 0;
	Node front;
	
	public List()
	{
		//Creates an empty list
		this.front = null;
		this.size = 0;
	}
	//GET AND SET SIZE
	public void setSize(int size)
	{
		this.size = size;
	}
	public int getSize()
	{
		return size;
	}
	//GET AND SET FRONT
	public void setFront(Node node)
	{
		this.front = node;
	}
	
	public Node getFront()
	{
		return front;
	}
	//BASIC LIST METHODS
	public boolean isListEmpty()
	{
		boolean result = false;
		
		if(this.getFront() == null)
		{
			result = true;
		}
		
		return result;
	}
	public Node findTail()
	{
		Node current = getFront();
		
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		
		return current;
	}
	//CONVERT NAMES TO NAMECODES
	public int convertName(String name)
	{
		int i, exponent, nameCode = 0;
		char character;
		
		for(i = 0, exponent = 2; i < 3; i++, exponent--)
		{
			character = name.charAt(i);
			nameCode += ((character - 'a') * Math.pow(26, exponent));
		}
		
		return nameCode;
	}
	//COMPARE NAMECODES TO DETERMINE INSERT FUNCTION
	public void compareNameCodes(Node nodeToInsert)
	{
		Node front;
		Node current;
		Node nodeAfterCurrent;
		Node tail;
				
		//Check if the list is empty before we start comparing
		if(isListEmpty())
		{
			setFront(nodeToInsert);
			return;
		}
		
		//Initialize down here to avoid nullPointerException
		front = getFront();
		current = getFront();
		tail = findTail();
		
		//Iterate through list
		while(current != null)
		{		//Will stop at tail.
			if(nodeToInsert.getNameCode() < front.getNameCode())
			{ 	//What if nameCode is smaller than the front of the list?
				insertAtFront(nodeToInsert);	//Insert nodeToInsert at the front of the list
				break;
			}
/*
			else if (nodeToInsert.getNameCode() == current.getNameCode())
			{
				insertAfterCurrent(nodeToInsert, current);
				break;
			}
*/			
			else if(nodeToInsert.getNameCode() > tail.getNameCode())
			{ 		//Check the tail
				insertAtEnd(nodeToInsert);		//Insert at the end of the list
				break;
			}
			//What if I need to insert something in the middle?
			else if(nodeToInsert.getNameCode() > current.getNameCode())
			{
				nodeAfterCurrent = current.getNext();
				
				//Have to check this way to avoid nullPointerException
				if((nodeAfterCurrent != null) && (nodeToInsert.getNameCode() < nodeAfterCurrent.getNameCode()))
				{	
					insertAfterCurrent(nodeToInsert, current);
					break;
				}
			}

			else if (nodeToInsert.getNameCode() == current.getNameCode())
			{
				insertAfterCurrent(nodeToInsert, current);
				break;
			}

			front = getFront();
			current = current.getNext();
			tail = findTail();
		}
	}
	//INSERT FUNCTIONS
	public void insertAtFront(Node newFront)
	{
		Node front = getFront();
		
		newFront.setNext(front);
		setFront(newFront);
	}
	
	public void insertAfterCurrent(Node node, Node curr)
	{
		Node current = curr;
		
		node.setNext(current.getNext());
		current.setNext(node);
	}
	
	public void insertAtEnd(Node node)
	{
		Node tail = findTail();
		
		tail.setNext(node);
	}
	//PRINT STUFF
	public void printList()
	{
		Node current = getFront();

		while(current != null)
		{
			System.out.println(current.getName() + " " + current.getNameCode());
			current = current.getNext();
		}
	}
	//SEARCH FOR NODE
	public Node searchForNode(String name)
	{
		Node targetNode;
		Node current = getFront();
		int nameCode = convertName(name);
		
		while(current.getNameCode() != nameCode)
		{
			current = current.getNext();
		}
		
		targetNode = current;
		
		return targetNode; 
	}
	//DELETE
	public void delete(Node nodeToDelete)
	{
		Node front = getFront();
		Node tail = findTail();
		Node current = front;
		Node previous = current;
		
		if(nodeToDelete.getNameCode() == front.getNameCode())
		{	//If node to delete is at the front
			deleteAtFront();
			return;
		}
		
		else if(nodeToDelete.getNameCode() == tail.getNameCode())
		{	//If node to delete is at the end
			deleteAtEnd();
			return;
		}
		
		while(nodeToDelete.getNameCode() != current.getNameCode())
		{
			previous = current;
			current = current.getNext();
		}
		
		nodeToDelete = current;
		deleteInMiddle(previous, nodeToDelete);
		
	}
	//DELETE METHODS
	public void deleteAtFront()
	{
		Node front = getFront();
		
		Node newFront = front.getNext();
		front.setNext(null);
		setFront(newFront);
	}
	public void deleteInMiddle(Node previous, Node nodeToDelete)
	{		
		previous.setNext(nodeToDelete.getNext());
	}
	
	public void deleteAtEnd()
	{
		Node tail = findTail();
		Node current = getFront();
		
		while(current.getNext() != tail)
		{
			current = current.getNext();
		}
		
		current.setNext(null);
	}
	//REQUEST LENGTH
	public void getLength()
	{
		int size = getSize();
		Node current = getFront();
		
		while(current != null)
		{
			size++;
			current = current.getNext();
		}
		
		setSize(size);
		System.out.println("\nThe list contains " + getSize() + " names");
	}
	//CREATE INDEX
	public Index[] createIndex()
	{
		Index [] myIndices = new Index[26];
		Index spot;
		int counter = 0;
		
		for(char letter = 'a'; letter <= 'z'; letter++)
		{
			spot = new Index();		//Create new spot index here
			
			//Set its variables
			spot.setFirstCharOfName(letter);
			spot.setFirstNodeOfSection(findFirstNameWith(letter));
			spot.setLengthOfSection(findNumberNamesBeginWith(letter));
			
			//Put into the array
			myIndices[counter] = spot;
			counter++;
		}
		return myIndices;
	}
	//FIND THE FIRST NAME WITH PASSED LETTER
	public Node findFirstNameWith(char letter)
	{
		Node current = getFront();
		
		while(current != null)
		{
			if(current.getName().charAt(0) == letter)
			{
				break;
			}
			
			else
			{
				current = current.getNext();
			}
		}
		return current;		
	}
	//FIND LENGTH OF EACH SECTION
	public int findNumberNamesBeginWith(char letter)
	{
		int count = 0;
		Node current = getFront();
		
		while(current != null)
		{
			if(current.getName().charAt(0) == letter)
			{
				count++;
			}
			
			current = current.getNext();
		}
		
		return count;
	}
	//PRINT NAMES OF SECTION
	public void printNamesInSection(Index [] indices, char letter)
	{
		int placeOfLetter = getPlaceOfLetter(letter);		//To determine what numeric spot the letter is in
		Index spot = indices[placeOfLetter];
		Node node = spot.getFirstNodeOfSection();
		spot.setLengthOfSection(getCurrentLength(indices, letter));

		if (spot.getLengthOfSection() == 0)
		{
			System.out.println("\nNo name with that letter exists in the list.");
		}
		
		for(int i = 0; i < spot.getLengthOfSection(); i++)
		{
			System.out.println(node.getName());
			node = node.getNext();
		}
	}
	public void printLengthOfSection(Index [] indices, char letter)
	{
		int placeOfLetter = getPlaceOfLetter(letter);		//To determine what numeric spot the letter is in
		Index spot = indices[placeOfLetter];

		spot.setLengthOfSection(getCurrentLength(indices, letter));

		if (spot.getLengthOfSection() == 0)
		{
			System.out.println("\nLength is 0, no names exist within that section.");
		}

		else
		{
			System.out.println("\nLength of section " + letter + " is " + spot.getLengthOfSection());	
		}
		
	}

	public int getCurrentLength(Index[] indices, char letter)
	{
		return findNumberNamesBeginWith(letter);
	}
	
	public int getPlaceOfLetter(char letter)
	{
		int place = letter - 'a';
		
		return place;
	}
}
