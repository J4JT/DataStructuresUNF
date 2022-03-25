//Made by Jon Mikael Barreto Transfiguracion for Data Structures Spring 2020
import java.util.Stack;

public class BET {
    BinaryNode root;
    //node class builds node
   public class BinaryNode{
       String value;
BinaryNode leftChild;
BinaryNode rightChild;

public BinaryNode(){

        }
public BinaryNode(String s){
this.value=s;
leftChild=rightChild=null;
    }
    }

//BET constructor
    public BET() {
    }
//BET constructor that takes in 2 types of arguments and evaluates them
    public BET(String exp, char type) {
if(type=='p')
    buildFromPostfix(exp);
if(type=='i')
    buildFromInfix(exp);


    }
  public int size(){
       return size(root);
    }




    //building post fix takes the exp, tokenize it, and passes it through to the printPostFix for output

    boolean buildFromPostfix(String postfix) throws IllegalStateException{
        Stack<BinaryNode> postStack = new Stack();
        String[] Token = postfix.split(" ");
        if(!isEmpty())
            makeEmpty( root);

        for(int i=0;i<Token.length;i++)
        {
            if(Token[i].equals("+") || Token[i].equals("-") || Token[i].equals( "*") || Token[i].equals("/")) {

                root=new BinaryNode(Token[i]);

                root.rightChild = postStack.pop();
                if(!postStack.isEmpty())
                root.leftChild= postStack.pop();

                postStack.push(root);
            } else{
                postStack.push(new BinaryNode(Token[i]));

                }
            }

//check if the only object in Stack is root

if(postStack.peek()==root && postStack.elementAt(0)==root) {
    System.out.println("Successful Build");
    return true;
}
else {
    throw new IllegalStateException("invalid Notation");


}

    }
    //uses private helper methods to print PostFix outputs
       public void printPostfixExpression()
       {
printPostfixExpression(root);
           System.out.println(" ");
        }






//Builds 2 stacks, pushes operands in operandStack, pushes operator in operatorStack, uses precedence() to evaluate value and to indicate when to pop.
    boolean buildFromInfix(String exp)  {
        Stack<BinaryNode> operatorStack = new Stack<>();
        Stack<BinaryNode> operandStack = new Stack<>();
        String[] Token = exp.split(" ");

        //if Tree is occupied, clear it
if(!isEmpty())
        makeEmpty( root);

        for (int i = 0; i < Token.length; i++) {

            //if ) is reached then while the top of the Stack is not ( then keep popping root and popping left and right then if top of stack is (, pop it.
            if (Token[i].equals(")")) {
                while (!operatorStack.peek().value.equals("(")) {
                    root = operatorStack.pop();
                    root.rightChild = operandStack.pop();

                    root.leftChild = operandStack.pop();
                    operandStack.push(root);
                }
                if(operatorStack.peek().value.equals("("))
                    operatorStack.pop();
            }


            //if Token[i]=+, -, *, /, or (   then check if OperatorStack is empty, push if it is.
            // if not then check precedence value of top value and Token[i], push if precendence(top) > precendence(Token[i])
            //at the end check if Operator Stack is empty or not, if it is not then push and pop until it is empty.
            if (Token[i].equals("+") || Token[i].equals("-") || Token[i].equals("*") || Token[i].equals("/") || Token[i].equals("(") ) {
                if (operatorStack.isEmpty())
                    operatorStack.push(new BinaryNode(Token[i]));
                else {
                    int a = precedence(operatorStack.peek().value);
                    int b = precedence(Token[i]);
                    if (a == b || a > b ) {
                        root = operatorStack.pop();
                        root.rightChild = operandStack.pop();
                        root.leftChild = operandStack.pop();
                        operandStack.push(root);
                        operatorStack.push(new BinaryNode (Token[i]));

                    } else

                        operatorStack.push(new BinaryNode(Token[i]));
                }

            } else
                operandStack.push(new BinaryNode(Token[i]));


        }


        while (!operatorStack.isEmpty()) {

            root = operatorStack.pop();
            root.rightChild = operandStack.pop();
            if(!operandStack.isEmpty())
            root.leftChild = operandStack.pop();
            operandStack.push(root);
        }



        if(operandStack.peek()==root && operandStack.elementAt(0)==root && operatorStack.isEmpty())
        {
            System.out.println("Build Successful");
            return true;
        }
        else
        {
            throw new IllegalStateException("invalid Notation");
        }

    }




//print InFix
    public void printInfixExpression(){
       printInfixExpression(root);
        System.out.println(" ");
    }





//uses private method to return sum of leaf nodes
    public int leafNodes()
    {
      return  leafNodes(root);
    }


//checks if tree is empty
    public boolean isEmpty()
    {
        if(size(root)==0)
            return true;
        else
            return false;
    }


//**************************************************PRIVATE METHODS**************************************************



    //takes te rootnode and calls postorder method
    private  void printPostfixExpression(BinaryNode n)
    {
        if(n==null)
            return;
        else{
            PostOrder(n);
        }

    }

    //Tranverses left to right to root and takes value
    private void PostOrder(BinaryNode post)
    {
        if(post!=null) {

            PostOrder(post.leftChild);
            PostOrder(post.rightChild);

            System.out.print(" " +post.value);

        }
        else
            return;

    }

    //Prints in order
    private void printInfixExpression(BinaryNode n)
    {
        if(n==null)
            return;
        else{
            inOrder(n);
        }

    }


    //Helper builds inOrder transversal
    private void inOrder(BinaryNode in)
    {
        if(in==null)
            return;

        if(in.leftChild!=null) {
            System.out.print("( ");
            inOrder(in.leftChild);
        }
        System.out.print(in.value + " ");

        if(in.rightChild!=null) {
            inOrder(in.rightChild);
            System.out.print(")");
        }
    }
//returns how many leafNodes are in the tree
    private int leafNodes(BinaryNode t)
    {
        if(t==null)
            return 0;
        if (isLeaf(t))
            return 1;


        return leafNodes(t.leftChild)+leafNodes(t.rightChild);
    }




    //goes through all nodes and if its not null, add 1 to size
   private int size(BinaryNode t){
       if(t==null)
           return 0;
       else
       return 1+size(t.leftChild)+ size(t.rightChild);


    }
    //determines if node is a leaf
    private boolean isLeaf(BinaryNode root)
    {
        if(root==null)
            return false;
        if(root.leftChild==null && root.rightChild==null)
        return true;
                else
                    return false;
    }




    //Helper evaluates value of the each character and indicates whether pop is necessary
    private int precedence(String x)
    {
        if(x.equals("+") || x.equals("-"))
            return 1;
        else if(x.equals("*") || x.equals("/"))
            return 2;
        else
            return 0;
    }
//deletes everything in the tree, visits node post order and nulls nodes
   private void makeEmpty(BinaryNode t) {
       if (t == null)
           return;
       else {
           makeEmpty(t.leftChild);
           makeEmpty(t.rightChild);
           t=null;
       }
   }

}
