package MaxPathSum;
import java.util.*;
class Node { 
	  
    int data; 
    Node lf, rt; 
  
    public Node(int item) { 
        data = item; 
        lf = rt = null; 
    } 
} 
class Result { 
    public int val; 
} 
class MaxpathSum { 
    Node root;  
    int findMax(Node node, Result res) 
    { 
        if (node == null) 
            return 0; 
        int l = findMax(node.lf, res); 
        int r = findMax(node.rt, res); 
        int max_single = Math.max(Math.max(l, r) + node.data, node.data); 
        int max_top = Math.max(max_single, l + r + node.data);  
        res.val = Math.max(res.val, max_top);   
        return max_single; 
    } 
  
    int findMaxSum() { 
        return findMaxSum(root); 
    } 
    int findMaxSum(Node node) {  
        Result res = new Result(); 
        res.val = Integer.MIN_VALUE; 
        findMax(node, res); 
        return res.val; 
    }  
} 