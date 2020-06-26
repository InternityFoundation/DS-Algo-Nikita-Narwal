import java.util.*; 
	class Node { 

		int data; 
		Node left, right; 
		public Node(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 
	public class MaximumAbsDiff {
		Node root; 

		public MaximumAbsDiff() 
		{
			root = null;
		} 

		
		public int maxAbsDiffLevelSum() 
		{ 
			int maxsum = Integer.MIN_VALUE; 
			int minsum = Integer.MAX_VALUE; 

			Queue<Node> qu = new LinkedList<>(); 
			qu.offer(root); 
			while (!qu.isEmpty()) { 
				int sz = qu.size(); 
				int sum = 0; 
				for (int i = 0; i < sz; i++) { 
					Node t = qu.poll(); 
					sum += t.data; 
					if (t.left != null) 
						qu.offer(t.left); 

					if (t.right != null) 
						qu.offer(t.right); 
				} 
				maxsum = Math.max(maxsum, sum);  
				minsum = Math.min(minsum, sum); 
			} 
			return Math.abs(maxsum - minsum); 
		} 
		public static void main(String[] args) 
		{ 
			MaximumAbsDiff tree = new MaximumAbsDiff(); 
			tree.root = new Node(4); 
			tree.root.left = new Node(2); 
			tree.root.right = new Node(-5); 
			tree.root.left.left = new Node(-1); 
			tree.root.left.right = new Node(3); 
			tree.root.right.left = new Node(-2); 
			tree.root.right.right = new Node(6); 
			System.out.println( 
				tree.maxAbsDiffLevelSum()); 
		} 
} 
