public class SearchSet {
    private int mElements;    //no. of elements?
    private BinaryTreeNode mHead;

    public void insert(int num){
        if (num!= mHead.getValue()){    //if same value, don't need to add again
            if(num< mHead.getValue()){
                if(mHead.getLeft() == null){
                    mHead.setLeft(new BinaryTreeNode(num));
                }else{
                    SearchSet searchSetLeft= new SearchSet();
                    searchSetLeft.mHead = this.mHead.getLeft();
                    searchSetLeft.insert(num);
                }
            }else{
                if(mHead.getRight() == null){
                    mHead.setRight(new BinaryTreeNode(num));
                }else{
                    SearchSet searchSetRight = new SearchSet();
                    searchSetRight.mHead = this.mHead.getRight();
                    searchSetRight.insert(num);
                }
            }
        }
    }

    public int getNumberElements(){

        SearchSet searchSetLeft = new SearchSet();
        SearchSet searchSetRight = new SearchSet();
        if(mHead==null){
            return mElements;
        }
        if(mHead.getLeft()!=null) {
            searchSetLeft.mHead = mHead.getLeft();
        }
        if(mHead.getRight()!=null) {
            searchSetRight.mHead = mHead.getRight();
        }
        mElements=1+ searchSetLeft.getNumberElements()+ searchSetRight.getNumberElements();
        return mElements;

    }

    @Override
    public String toString() {
        return String.format("[%s]", mHead== null ? "" : mHead.toString());
    }

    public boolean contains(int num){
        if (num== mHead.getValue()) {    //if same value, don't need to add again
            return true;
        }else{
            if(num< mHead.getValue()){
                if(mHead.getLeft() == null){
                    return false;
                }else{
                    SearchSet searchSetLeft= new SearchSet();
                    searchSetLeft.mHead = this.mHead.getLeft();
                    return searchSetLeft.contains(num);
                }
            }else{
                if(mHead.getRight() == null){
                   return false;
                }else{
                    SearchSet searchSetRight = new SearchSet();
                    searchSetRight.mHead = this.mHead.getRight();
                    return searchSetRight.contains(num);
                }
            }
        }
    }

    public static void main(String[] args) {

        SearchSet searchSet = new SearchSet();
        searchSet.mHead = new BinaryTreeNode(5);
        System.out.println(searchSet.getNumberElements());

        searchSet.mHead.setLeft(new BinaryTreeNode(3));
        System.out.println(searchSet.getNumberElements());

        searchSet.mHead.setRight(new BinaryTreeNode(7));
        searchSet.mHead.getLeft().setLeft(new BinaryTreeNode(1));
        searchSet.mHead.getLeft().setRight(new BinaryTreeNode(4));

        System.out.println(searchSet);
        System.out.println(searchSet.getNumberElements());
        System.out.println(searchSet.contains(2));

        searchSet.insert(9);
        searchSet.insert(3);
        searchSet.insert(2);


        System.out.println(searchSet);
        System.out.println(searchSet.getNumberElements());
        System.out.println(searchSet.contains(2));

    }
}
