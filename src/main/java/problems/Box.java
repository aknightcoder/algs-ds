package problems;

public class Box 
{
	private int Width;
	
	private int Height;
	
	private int Depth;
	
	public Box(int width, int height, int depth)
	{
		this.Width = width;

		this.Height = height;

		this.Depth = depth;
	}
	
	public int getBoxHeight()
	{
		return this.Height;
	}
	
	public boolean isLargerBox(Box otherBox)
	{
		return (this.Width >= otherBox.Width && this.Height >= otherBox.Height && this.Depth >= otherBox.Depth);
	}
	
	public String toString()
	{
		return "Height: " + this.Height;
	}
}
