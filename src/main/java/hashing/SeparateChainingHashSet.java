package hashing;

public class SeparateChainingHashSet<Key,Value>
{
	private int size;
	
	private Node[] st;
	
	public SeparateChainingHashSet(int size)
	{
		this.size = size;
		
		st = new Node[size];
	}

	private static class Node 
	{
		private Object key;
		private Object value;
		private Node next;
		
		public Node(Object key, Object value, Node next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	    
	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff % size);
	}
	
	public void put(Key key, Value value)
	{
		int i = hash(key);

				
		for (Node node = st[i]; node != null; node = node.next)
		{
			if (node.key.equals(key))
			{
				node.value = value;
				return;
			}
		}
		
		st[i] = new Node(key, value, st[i]);
	}
	
	public Value get(Key key)
	{
		int i = hash(key);

		for (Node node = st[i]; node != null; node = node.next)
			if (node.key.equals(key)) return (Value) node.value;
		
		return null;
	}
}