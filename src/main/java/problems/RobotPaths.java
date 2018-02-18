package problems;

import java.awt.Point;
import java.util.ArrayList;

public class RobotPaths
{
	public boolean getPath(int x, int y, ArrayList<Point> path)
	{
		if (x < 0 || y < 0)
			return false;
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		
		if (isAtOrigin || getPath(x, y-1, path) || getPath(y, x-1, path))
		{
			Point p = new Point(x,y);
			path.add(p);
			return true;
		}
		
		return false;
	}
}
