
public class FunctionalArray {
    private BinaryTreeNode root;
    private int size;

    public FunctionalArray(int size){
        root = create(size);    //initialises root node to 0?
        this.size=size;
    }

    private static BinaryTreeNode create(int size){
        BinaryTreeNode theNode = new BinaryTreeNode(0);
        for (int j=1; j<=size;j++){
            int i=j;     //copies value
            BinaryTreeNode newNode = theNode;      //makes a copy of the reference
            while (i!=1){
                if(i%2 == 0){
                    if(newNode.getLeft()!=null) {
                        newNode = theNode.getLeft();
                    }else{
                        newNode.setLeft(new BinaryTreeNode(0));
                    }
                }else{
                    if(newNode.getRight()!=null) {
                        newNode = newNode.getRight();
                    }else{
                        newNode.setRight(new BinaryTreeNode(0));
                    }
                }
                i=i/2;
            }
        }
        return theNode;
    }

    public void set(int index, int value){
        if (index>size-1 || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            BinaryTreeNode nextNode= root;

            if(index!=0) {
                String path = Integer.toBinaryString(index+1);   //index +1 because starting at 0, normal functional arrays start at 1
                //first find the first 1,
                int i = 0;
                while (path.charAt(i) != '1') {
                    //increments
                    i++;
                }


                // discards leading 1
                // loops through remaining bits in path, in reverse: 0 means left, 1 means right
                for (int j = path.length() - 1; j > i; j--) {
                    if (path.charAt(j) == '0') {
                        nextNode = nextNode.getLeft();
                    } else {    //is '1'
                        nextNode = nextNode.getRight();
                    }
                }
            }
            nextNode.setValue(value);

        }
    }

    public int get(int index){
        int i = index+1;   //because the functional array starts at 0 here
        BinaryTreeNode newNode = root;      //makes a copy of the reference
        if (index>size-1 || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            while (i != 1) {
                if (i % 2 == 0) {
                        newNode = newNode.getLeft();
                } else {
                        newNode = newNode.getRight();
                }
                i = i / 2;
            }
            return newNode.getValue();
        }
    }

    @Override
    public String toString() {
        return "FunctionalArray{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        FunctionalArray functionalArray = new FunctionalArray(6);
        functionalArray.set(0,3);
        functionalArray.set(3,5);
        functionalArray.set(4,10);
        functionalArray.set(5,3);

        System.out.println(functionalArray);

        System.out.println(functionalArray.get(0));
        System.out.println(functionalArray.get(1));
        System.out.println(functionalArray.get(2));
        System.out.println(functionalArray.get(3));
        System.out.println(functionalArray.get(4));
        System.out.println(functionalArray.get(5));


    }


}
