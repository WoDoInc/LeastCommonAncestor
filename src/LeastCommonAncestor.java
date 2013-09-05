import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LeastCommonAncestor
{

   public Stack<Node<Integer>> trace(BinaryTree<Integer> tree, Node<Integer> node)
   {
      mainStack = new Stack<Node<Integer>>();
      trace(tree.getRoot(), node);
      return mainStack;
   }

   private boolean trace(Node<Integer> parent, Node<Integer> node)
   {
      mainStack.push(parent);
      if(node.equals(parent))
      {
         return true;
      }
      
      if(parent.getLeftChild() != null)
      {
         if (trace(parent.getLeftChild(), node))
            return true;
      }
      
      if(parent.getRightChild() != null)
      {
         if (trace(parent.getRightChild(), node))
            return true;
      }
      
      mainStack.pop();
      return false;
   }

   /**
    * Finds the nodes' common parent in the tree. 
    */
   public void find()
   {
      BinaryTree<Integer> tree = getSampleTree();
      Node<Integer> commonParent = findCommonParent(tree, node1, node2);
      if(commonParent == null)
      {
         System.out.println("Common Parent for " + node1.getData() + " and " + node2.getData() + " is null");
      }
      else
      {
         System.out.println("Common Parent for " + node1.getData() + " and " + node2.getData() + " is " + commonParent.getData());
      }
   }

   private BinaryTree<Integer> getSampleTree()
   {
      BinaryTree<Integer> binaryTree = new BinaryTree<>();
      int randomData[] = {43,887,11,3,8,33,6,0,46,32,78,76,334,45};
      for(int i=0 ; i < randomData.length; i++)
      {
         binaryTree.add(randomData[i]);
      }
      node1 = binaryTree.search(76);
      node2 = binaryTree.search(334);
      return binaryTree;
   }

   public Node<Integer> findCommonParent(BinaryTree<Integer> tree, Node<Integer> node1, Node<Integer> node2)
   {
      /**
       * If either of the nodes is root, then there is no common
       * parent
       */
      if(node1.equals(tree.getRoot()) || node2.equals(tree.getRoot()))
      {
         return null;
      }
	  
      //Using the path tracer, find the path of two nodes in 2*O(n) time.
      Stack<Node<Integer>> path1 = trace(tree, node1);
      Stack<Node<Integer>> path2 = trace(tree, node2);
	   
      //All that is left to do is to find the common parent now.
      Set<Node<Integer>> firstPath = new HashSet<>();
      for(Node<Integer> iNode : path1)
      {
         firstPath.add(iNode);
      }

      while(!path2.isEmpty())
      {
         Node<Integer> currentNode = path2.pop();
         if(firstPath.contains(currentNode))
         {
            if(!path2.isEmpty() && firstPath.contains(currentNode = path2.peek()))
            {
               return path2.peek();
            }
            return currentNode;
         }
      }
      return null;
   }

	//SAMPLE OUTPUTS
	//Common Parent for 887 and 334 is 43
	//Common Parent for 43 and 334 is null
	//Common Parent for 6 and 334 is 43
	//Common Parent for 76 and 334 is 46
   public static void main(String args[])
   {
      LeastCommonAncestor nodeFinder = new LeastCommonAncestor();
      nodeFinder.find();
   }

   private Stack<Node<Integer>> mainStack = null;
   private Node<Integer> node1, node2;
}
