/**
 *  Index.java
 *
 *
 *  @author Tyler Oalman
 *  @version 2.0 2018-10-11
 */

package ScaryList;

class Index
{
	int lengthOfSection;
	Node firstNodeOfSection;
	char firstCharOfName;
	
	//GET AND SET METHODS
	public void setLengthOfSection(int totalNames)
	{
		this.lengthOfSection = totalNames;
	}

	public int getLengthOfSection(){
		return lengthOfSection;
	}

	public void setFirstNodeOfSection(Node firstNode)
	{
		this.firstNodeOfSection = firstNode;
	}

	public Node getFirstNodeOfSection()
	{
		return firstNodeOfSection;
	}

	public void setFirstCharOfName(char firstChar)
	{
		this.firstCharOfName = firstChar;
	}

	public char getFirstCharOfName()
	{
		return firstCharOfName;
	}
}
