/**
 * This class builds the node structure for a simple binary tree.
 * 
 * @author akaszczuk
 *
 */
public class Node<T>
{

   public Node()
   {
   }
   
   public Node(T data)
   {
      this.data = data;
   }
   
   public Node(T data, Node<T> left, Node<T> right)
   {
      this.data = data;
      this.leftChild = left;
      this.rightChild = right;
   }
   
   /**
    * Returns the data in this node.
    *
    * @return Returns the data for the node.
    */
   public T getData()
   {
      return data;
   }
   
   /**
    * Sets the data in this node.
    */
   public void setData(T data)
   {
      this.data = data;
   }
   
   /**
    *  Returns the left child.
    *  
    *  @return Returns the left child reference.
    */
   public Node<T> getLeftChild()
   {
      return leftChild;
      
   }
   
   /**
    * Sets the left child.
    */
   public void setLeftChild(Node<T> left)
   {
      this.leftChild = left;
   }
   
   /**
    * Returns the right child.
    * 
    * @return Returns the right child reference.
    */
   public Node<T> getRightChild()
   {
      return rightChild;
   }
   
   /**
    * Sets the right child.
    */
   public void setRightChild(Node<T> right)
   {
      this.rightChild = right;
   }
   
   @Override
   public String toString()
   {
      String leftChild = (this.leftChild != null) ? " and has a left child " + this.leftChild.getData() : null;
      String rightChild = (this.rightChild != null) ? " and has a right child " + this.rightChild.getData() : null;
      
      StringBuilder string = new StringBuilder("The node is " + this.data);
      if (leftChild != null)
         string.append(leftChild);
      if (rightChild != null)
         string.append(rightChild);
         
      return string.toString();
   }
   
   /** The left child node object. */
   private Node<T> leftChild;
   
   /** The right child node object. */
   private Node<T> rightChild;
   
   /** The stored data for this node. */
   private T data;
}
