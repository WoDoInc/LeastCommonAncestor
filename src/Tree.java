/**
 * BinaryTree interface for creating trees.
 * 
 * @author akaszczuk
 *
 */
public interface Tree<T>
{
   /** Add a node */
   public void add(T currentData);
   
   /** Search for a particular piece of data */
   public Node<T> search(T data);
}
