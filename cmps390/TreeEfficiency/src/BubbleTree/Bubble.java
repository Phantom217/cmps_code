/**
 *  Bubble.java
 *
 *
 *  Tyler Oalman
 *  @version 2.0.0 2018
 */

package BubbleTree;

public class Bubble
{
    public static int bubbleMe(int[] nums, int len)
    {
	boolean swapping = true;
	int i, tmp, comp = 0;

	while (swapping)
	{
	    swapping = false;

	    for (i = 0; i < (len - 1); i++)
	    {
		if (nums[i] > nums[i + 1])
		{
		    tmp = nums[i];
		    nums[i] = nums[i + 1];
		    nums[i + 1] = tmp;

		    swapping = true;
		}
		comp++;
	    }
	}

	printNums(nums);

	return comp;
    }

    public static void printNums(int[] nums)
    {
	for (int i = 0; i < nums.length; i++)
	{
	    System.out.println(nums[i]);
	}
    }
}
