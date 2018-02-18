package problems;

import java.util.ArrayList;

public class MaxBoxStack 
{
	private Box[] boxes = new Box[4];

	public ArrayList<Box>createStack(Box box)
	{
		int maxHeight = 0;
		
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < this.boxes.length; i++)
		{
			if (!this.boxes[i].isLargerBox(box))
			{
				ArrayList<Box> new_stack = createStack(boxes[i]);
				int maxStackHeight = getHeight(new_stack);
				if (maxStackHeight > maxHeight)
				{
					maxHeight = maxStackHeight;
					max_stack = new_stack;
				}
			}
		}
		
		if (max_stack == null)
			max_stack = new ArrayList<Box>();
		
		if(box != null)
			max_stack.add(0,box);
		
		return max_stack;
	}
	
	private int getHeight(ArrayList<Box> stack)
	{
		if (stack == null) return 0;
		
		int stackHeight = 0;
		for(Box box : stack)
		{
			stackHeight+= box.getBoxHeight();
		}
		
		return stackHeight;
	}

	public ArrayList<Box> getMaxStack()
	{
		boxes[0] = new Box(10,10,10);
		boxes[2] = new Box(5,5,5);
		boxes[3] = new Box(2,2,2);
		boxes[1] = new Box(8,8,8);

		return createStack(boxes[0]);
	}
	
	public static void main(String[] args) 
	{
		MaxBoxStack m = new MaxBoxStack();
		ArrayList<Box> result = m.getMaxStack();
		
		for (Box box : result)
			System.out.println(box.toString());
	}
}
