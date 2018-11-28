/**
 *  Node.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0.0 2018
 */

package BubbleTree;

public class Node
{
    int data;
    int frequency = 1;
    Node left, right;

    public Node(int number)
    {
	this.data = number;
	this.left = null;
	this.right = null;
    }

    public void setFrequency()
    {
	this.frequency++;
    }

    public void setLeft(Node node)
    {
	this.left = node;
    }

    public void setRight(Node node)
    {
	this.right = node;
    }

    public Node getLeft()
    {
	return left;
    }

    public Node getRight()
    {
	return right;
    }

    public int getData()
    {
	return data;
    }

    public int getFrequency()
    {
	return frequency;
    }
}
