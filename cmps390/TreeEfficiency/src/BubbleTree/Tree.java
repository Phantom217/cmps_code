/**
 *  Tree.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0.0 2018
 */

package BubbleTree;

public class Tree
{
	Node root;

	public Tree()
	{
		this.root = null;
	}

	public void setRoot(Node node)
	{
		this.root = node;
	}

	public Node getRoot()
	{
		return root;
	}

	public void setLeft(Node node, int num)
	{
		Node newLeft = new Node(num);
		
		if (node.getLeft() != null)
		{
			System.out.println("Error: Node Exists.");
		}
		else
		{
			node.setLeft(newLeft);
		}
	}

	public void setRight(Node node, int num)
	{
		Node newRight = new Node(num);

		if (node.getRight() != null)
		{
			System.out.println("Error: Node Exists.");
		}
		else
		{
			node.setRight(newRight);
		}
	}

	public int makeTree(int[] nums)
	{
		int num = 0;
		int comp = 0;

		for (int i = 0; i < nums.length; i++)
		{
			num = nums[i];

			if (i == 0)
			{
	/* 			System.out.println(num); */
				setRoot(new Node(num));
			}
			else
			{
				Node curr = getRoot();
				boolean searching = true;

				while (searching)
				{
					if (num == curr.getData())
					{
						curr.setFrequency();
						searching = false;
					}
					else if (num < curr.getData())
					{
						if (curr.getLeft() != null)
						{
							curr = curr.getLeft();
						}
						else
						{
							setLeft(curr, num);
							searching = false;
						}
					}
					else if (num > curr.getData())
					{
						if (curr.getRight() != null)
						{
							curr = curr.getRight();
						}
						else
						{
							setRight(curr, num);
							searching = false;
						}
					}

					comp++;
				}
			}
		}

		return comp;
	}

	public void printLowHigh(Node root)
	{
		if (root.getLeft() != null)
		{
			printLowHigh(root.getLeft());
		}

		System.out.println(root.getData() + " --> Duplicates: " + root.getFrequency());

		if (root.getRight() != null)
		{
			printLowHigh(root.getRight());
		}
	}
}
