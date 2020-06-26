package LargestValue;
import java.util.*;

public class Largestvalue {
	static class Node  
	{  
	    int val;  
	    Node left, right;  
	};  

	static void helper(Vector<Integer> res, Node root, int d)  
	{  
	    if (root == null)  
	        return;  
	    if (d == res.size())  
	        res.add(root.val);  
	  
	    else
	        res.set(d, Math.max(res.get(d), root.val));  
	    helper(res, root.left, d + 1);  
	    helper(res, root.right, d + 1);  
	}    
	static Vector<Integer> largestValues(Node root)  
	{  
	    Vector<Integer> res = new Vector<>();  
	    helper(res, root, 0);  
	    return res;  
	}  
	static Node newNode(int data)  
	{  
	    Node temp = new Node();  
	    temp.val = data;  
	    temp.left = temp.right = null;  
	    return temp;  
	}  
	  
	
}
