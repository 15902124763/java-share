package com.niki.algorithm.binary;

/**
 * Created by IntelliJ IDEA.
 * User: niki.yang
 * Date: 2020/11/18
 */
public class BinaryTree {
    public static int index = 0;
    public static final int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};

    public static BinTree createTree(BinTree node, int i) {
        if (0 == BinaryTree.TREE_VALUE[i]) {
            return null;
        } else {
            node.setData(BinaryTree.TREE_VALUE[i]);
        }

        BinTree leftChild = new BinTree();
        node.setLeft(createTree(leftChild, ++BinaryTree.index));
        BinTree rightChild = new BinTree();
        node.setRight(createTree(rightChild, ++BinaryTree.index));
        return node;
    }
    /**
     * @Description :计算叶子节点
     * @Author : yarm.yang
     * @Date : 2020/11/18 16:04
    */
    public static int countChildTree(BinTree node, int count){
        if(node == null || node.getData() == null){
            return 0;
        }
        if(node.getLeft() != null){
           countChildTree(node.getLeft(), count++);
        }
        if(node.getRight() != null){
            countChildTree(node.getRight(), count ++);
        }
        return count;
    }
    
    /**
     * @Description :统计二叉树中有2个非空子树的节点
     * @Author : yarm.yang
     * @Date : 2020/11/23 16:46
    */
    public static int countIsAllNullChildTree(BinTree node){
        int count = 0;
        if (node == null){
            return 0;
        }
        if(node.getLeft() == null && node.getRight() == null){
            return 1;
        }else {
            count = 1 + countIsAllNullChildTree(node.getRight()) + countIsAllNullChildTree(node.getLeft());
        }
        return count;
    }

    /**
     * @Description :统计二叉树中有一个子树为非空的节点个数
     * @Author : yarm.yang
     * @Date : 2020/11/24 16:59
    */
    public static int countIsNullChildTree(BinTree node){
        int count = 0;
        if (node == null){
            return 0;
        }
        if (node.getLeft() == null || node.getRight() == null){
            return 1;
        }else {
            count = 1 + countIsNullChildTree(node.getLeft()) + countIsNullChildTree(node.getRight());
        }
        return count;
    }

    public static void main(String[] args) {
        BinTree tree = createTree(new BinTree(), 0);
        System.out.println(tree);
        int i = countChildTree(tree, 0);
        System.out.println(i);

        System.out.println(countIsAllNullChildTree(tree));
        System.out.println(countIsNullChildTree(tree));
    }
}
