import java.util.HashSet;


public class BinaryTree<T extends Comparable<? super T>> implements Tree<T>
{
   /**
    *  Add a node with the current data. If the root is empty, we are creating a new tree.
    */
   public void add(T currentData)
   {
      if(this.root == null)
      {
         this.root = new Node<T>(currentData);
      }
      else
      {
         add(currentData, this.root);
      }
   }

   private void add(T currentData, Node<T> position)
   {
      if (compare(currentData, position.getData()) < 1)
      {
         if(position.getLeftChild() == null)
         {
            position.setLeftChild(new Node<T>());
            position.getLeftChild().setData(currentData);
         }
         else
         {
            add(currentData, position.getLeftChild());
         }
      }
      else
      {
         if(position.getRightChild() == null)
         {
            position.setRightChild(new Node<T>());
            position.getRightChild().setData(currentData);
         }
         else
         {
            add(currentData, position.getRightChild());
         }
      }
   }

   /**
    * Searches for the desired node.
    *  
    * O(log n) on average case.
    * 
    * @return Returns the node that is being sought.
    */
   public Node<T> search(T searchData)
   {
      Node<T> focusNode = this.root;
      
      while (focusNode.getData() != searchData)
      {
         // searchData < focusNode.getData())
         if (compare(focusNode.getData(), searchData) > 0)
         {
            focusNode = focusNode.getLeftChild();
         }
         else
         {
            focusNode = focusNode.getRightChild();
         }

         if (focusNode == null)
         {
            return null;
         }
      }

      return focusNode;
   }

   public void printOrdered()
   {
      if(root == null)
      {
         return;
      }

      printOrdered(root);
   }

   /**
    * In order traversal. Left, then root, then right.
    * 
    * @param node The starting node.
    */
   public void printOrdered(Node<T> node)
   {
      if(node.getLeftChild() != null)
      {
         printOrdered(node.getLeftChild());
      }

      System.out.println(node.getData());

      if(node.getRightChild() != null)
      {
         printOrdered(node.getRightChild());
      }
   }

   public void printValues()
   {
      print(root);
   }

   private void print(Node<T> node)
   {
      if(node == null)
      {
         return;
      }
      else
      {
         print(node.getLeftChild());
         print(node.getRightChild());
      }
   }

   public int compare(T a, T b)
   {
      return a.compareTo(b);
   }

   public Node<T> getRoot()
   {
      return this.root;
   }
   
   public static void main(String args[])
   {
      BinaryTree<Integer> bTree = new BinaryTree<>();
      HashSet<Integer> nodeCollection = new HashSet<>(20);
      
      for (int i = 0; i < 20; i++)
      {
         final Integer data = (int)(Math.random() * 50 + 1);
         nodeCollection.add(data);
         bTree.add(data);
         System.out.println("Added: " + data);
      }

      bTree.printValues();
      for(Integer node : nodeCollection)
      {
         System.out.println(bTree.search(node));
      }
   }

   /** The root node. */
   private Node<T> root;
}
