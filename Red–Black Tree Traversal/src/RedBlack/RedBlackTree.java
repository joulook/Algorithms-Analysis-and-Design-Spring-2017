
package RedBlack;


public class RedBlackTree {
    
    private Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;
    
    private static Node nullNode;
    static{
        nullNode=new Node(0);
        nullNode.left=nullNode;
        nullNode.right=nullNode;
    }
    
    static final int BLACK=1;
    static final int RED=0;
    
    public RedBlackTree(int data){
        header=new Node(data);
        header.left=nullNode;
        header.right=nullNode;
    }
    
    public void clraer(){
        header.right=nullNode;
    }
    
    public boolean isEmpty(){
        return header.right==nullNode;
    }
    
    public void insert(int item){
        current=parent=grand=header;
        nullNode.data=item;
        while(current.data!=item){
            great=grand;
            grand=parent;
            parent=current;
            
            if(current.data>item)
                current=current.left;
            else
                current=current.right;
            //check if two red children and fix if so
            if(current.left.color==RED && current.right.color==RED)
                handleReorient(item);
        }
        //insertion fails if already present
        if(current!=nullNode)
            return;
        current=new Node(item,nullNode,nullNode);
        // Attach to parent
        if(item<parent.data)
            parent.left=current;
        else
            parent.right=current;
        handleReorient(item);
    }
    public void handleReorient(int item){
        //Do the color flip 
        current.color=RED;
        current.left.color=BLACK;
        current.right.color=RED;
        
        if(parent.color==RED){
            //have to rotate
            grand.color=RED;
            if(item < grand.data != item < parent.data){
                parent=rotate(item,grand);
                current=rotate(item,great);
                current.color=BLACK;
            }
            // Make root black 
            header.right.color=BLACK;
        }
    }
    private Node rotate(int item,Node parent){
        if(item<parent.data){
            if(item<parent.left.data)
                parent.left=rotateWithLeftChild(parent.left);
            else
                parent.left=rotateWithRightChild(parent.left);
            return parent.left;
        }
        else{
            if(item<parent.right.data)
                parent.right=rotateWithLeftChild(parent.right);
            else
                parent.right=rotateWithRightChild(parent.right);
            return parent.right;
        }  
    }
    
    // rotate Binary tree Node with right child
    private Node rotateWithRightChild(Node k1){
        Node k2=k1.right;
        k1.right=k2.left;
        k2.left=k1;
        return k2;
    }
    
    // rotate Binary tree Node with left child 
    private Node rotateWithLeftChild(Node k2){
        Node k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        return k1;
    }
    
    public boolean search(int val){
        return search(header.right,val);
    }
    
    private boolean search(Node r,int val){
        boolean found=false;
        while(r!=nullNode && !found){
            int rval=r.data;
            if(val<rval)
                r=r.left;
            else if(val>rval)
                r=r.right;
            else{
                found=true;
                break;
            }
            found=search(r,val);
        }
        return found;
    }
    // Function for inorder traversal
    public void inorder(){
        inorder(header.right);
    }
    
    private void inorder(Node r){
        if(r!=nullNode){
            inorder(r.left);
            char c='B';
            if(r.color==0)
                c='R';
            System.out.print(r.data+""+c+" ");
            inorder(r.right);
        }
    }
    
    // Function for preorder traversal 
    public void preorder(){
        preorder(header.right);
    }
    
    private void preorder(Node r){
        if(r!=nullNode){
            char c='B';
            if(r.color==0)
                c='R';
            System.out.print(r.data+""+c+" ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    
    // Function for postorder traversal 
    public void postorder(){
        postorder(header.right);
    }
    
    private void postorder(Node r){
        if(r!=nullNode){
            postorder(r.left);
            postorder(r.right);
            char c='B';
            if(r.color==0)
                c='R';
            System.out.print(r.data+""+c+" ");
        }
    }
    
    
}
