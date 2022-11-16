public class BinaryTreeNode {
    private int mValue;
    private BinaryTreeNode mRight;
    private BinaryTreeNode mLeft;

    public BinaryTreeNode(int mValue) {
        this.mValue = mValue;
        mRight = null;
        mLeft = null;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int mValue) {
        this.mValue = mValue;
    }

    public BinaryTreeNode getRight() {
        return mRight;
    }

    public void setRight(BinaryTreeNode mRight) {
        this.mRight = mRight;
    }

    public BinaryTreeNode getLeft() {
        return mLeft;
    }

    public void setLeft(BinaryTreeNode mLeft) {
        this.mLeft = mLeft;
    }

//    @Override
//    public String toString(){
//        if (mLeft == null || mRight==null) {
//            return String.valueOf(mValue);
//        }
//
//        return "("+ mLeft + ","+ mValue + "," + mRight+")";
//
//    }


    @Override
    public String toString() {
        return "Node(" + mValue +
                ", "+ mLeft +
                ", " + mRight +
                ')';
    }
}
