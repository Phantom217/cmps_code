/**
 *  Node.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0 2018-10-11
 */

package ScaryList;

class Node 
{
	String name;
	int nameCode;
	Node next;
	
	public Node(String name, int nameCode)
	{
		this.name = name;
		this.nameCode = nameCode;
		this.next = null;
	}
	public String getName()
	{
		return name;
	}
	public int getNameCode()
	{
		return nameCode;
	}
	public void setNext(Node next)
	{
		this.next = next;
	}
	public Node getNext()
	{
		return next;
	}
}
