
package RedBlack;


public class RBTree {

    
    public static void main(String[] args) {
        RedBlackTree rbt=new RedBlackTree(Integer.MIN_VALUE);
        rbt.insert(1);
        rbt.insert(2);
        rbt.insert(3);
        rbt.insert(4);
        rbt.insert(5);
        rbt.preorder();
        System.out.println();
        rbt.inorder();
        System.out.println();
        rbt.postorder();
        System.out.println();
        
    }
    
}
