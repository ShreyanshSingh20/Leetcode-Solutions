/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String str) {
        char c[]=str.toCharArray();
        Stack<Node> nums=new Stack<>();
        Stack<Node> operators=new Stack<>();
        
        int brackets=0;
        
        for(int i=0;i<c.length;i++){
            char ch=c[i];
            
            Node newNode=new Node(ch);
            
            boolean isDigit=(ch>=48&&ch<=57)?true:false;
            
            if(isDigit){
                nums.push(newNode);
                continue;
            }
            
            if(operators.isEmpty()){
                if(ch=='(') {
                    brackets++;
                }
                
                operators.push(newNode);
                continue;
            }
            
            if(ch=='('){
                brackets++;
                operators.push(newNode);
                continue;
            }
            
            
            if(ch==')'&&brackets>0){
                while(operators.peek().val!='('){
                    Node rightNode=nums.pop();
                    Node leftNode=nums.pop();
                    Node rootNode=operators.pop();
                    rootNode.left=leftNode;
                    rootNode.right=rightNode;
                    nums.push(rootNode);
                }
                operators.pop();
                brackets--;
                continue;
            }
            
            int prec=precedence(ch,operators.peek().val);
            
            if(prec==1){
                operators.push(newNode);
                continue;
            }else{
                while(operators.isEmpty()==false&&prec==-1){
                    if(operators.peek().val=='(') break;
                    Node rightNode=nums.pop();
                    Node leftNode=nums.pop();
                    Node rootNode=operators.pop();
                    rootNode.left=leftNode;
                    rootNode.right=rightNode;
                    nums.push(rootNode);
                }
            }
            
            operators.push(newNode);
            
        }
        
        while(!operators.isEmpty()){
            Node rightNode=nums.pop();
            Node leftNode=nums.pop();
            Node rootNode=operators.pop();
            rootNode.left=leftNode;
            rootNode.right=rightNode;
            nums.push(rootNode);
        }
        
        
        
        return nums.pop();
    }
    
    
    /*
    1-safe to insert
    -1-not safe to insert, clear backlog
    */
    
    public int precedence(char ins,char peek){
        if(ins=='*'||ins=='/'){
            if(peek=='+'||peek=='-'||peek=='(') return 1;
            else return -1;
        }else if(ins=='-'||ins=='+'){
            if(peek=='(') return 1;
            else if(peek=='-'||peek=='+'||peek=='*'||peek=='/') return -1;
        }
        
        return 0;
    }
}