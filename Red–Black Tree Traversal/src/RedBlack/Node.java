
package RedBlack;

public class Node {
       Node left,right;
        int data;
        int color;
        
        public Node(int data){
            this(data,null,null);
        }
        public Node(int data,Node left,Node right){
            this.left=left;
            this.right=right;
            this.data=data;
            color=1; // We assume Black is 1 and red is 0
        }
}
