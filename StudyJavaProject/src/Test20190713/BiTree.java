package  Test20190713;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 二叉树的创建，先序、中序、后序、层次序遍历
 * @author Jing*/
public class BiTree {
    private BiTreeNode root;

    public BiTree() {
        root=new BiTreeNode();
        //root=null;
    }


    public BiTreeNode getRoot() {
        return root;
    }


    /**根据数组值创建二叉树*/
    public void createTree(Object[] tree) {//数组按照从上至下、从左至右的顺序存储节点，为null时表示节点不存在
        LinkedList<BiTreeNode> list=new LinkedList<>();
        for(int i=0;i<tree.length;i++) {//将数据生成为节点
            list.add(new BiTreeNode(tree[i]));
        }
        //根据完全二叉树性质，按照层序从0编号，对于序号为i的节点
        //若i>0,i的双亲序号为（i-1）/2;若i=0，无双亲
        //若(2i+1)<n,i的左孩子序号为（2i+1），若(2i+1)>=n,无左孩子
        //若(2i+2)<n,i的右孩子序号为(2i+2),否则无右孩子

        root=list.get(0);
        for(int i=0;i<list.size()/2-1;i++){
            list.get(i).lChild=list.get(2*i+1);
            list.get(i).rChild=list.get(2*i+2);
        }
        //单独处理最后一个父节点  因为它有可能没有右子节点
        int i = list.size()/2-1;
        list.get(i).lChild=list.get(2*i+1);
        if(list.size() % 2 == 1) {
            list.get(i).rChild=list.get(2*i+2);
        }
    }
    /**访问节点，此处仅简单输出节点数据值*/
    public void visit(BiTreeNode node) {
        System.out.print(node.data+"\t");
    }

    /**递归先序遍历*/
    public void preOrderTraverse(BiTreeNode r) {
        if(r==null)
            return;
        visit(r);
        preOrderTraverse(r.lChild);
        preOrderTraverse(r.rChild);
    }
    /**递归中序遍历*/
    public void inOrderTraverse(BiTreeNode r) {
        if(r==null)
            return;
        inOrderTraverse(r.lChild);
        visit(r);
        inOrderTraverse(r.rChild);
    }

    /**递归后序遍历*/
    public void postOrderTraverse(BiTreeNode r) {
        if(r==null)
            return;
        postOrderTraverse(r.lChild);
        postOrderTraverse(r.rChild);
        visit(r);
    }
    /**层序遍历，借助队列*/
    public void levelOrderTraverse(BiTreeNode root) {

        BiTreeNode temp=null;
        if(root==null)
            return;
        Queue<BiTreeNode> biQueue=new LinkedList<>();
        biQueue.offer(root);
        while(!biQueue.isEmpty()) {
            temp=biQueue.poll();
            visit(temp);
            if(temp.lChild!=null) {
                biQueue.offer(temp.lChild);
            }
            if(temp.rChild!=null) {
                biQueue.offer(temp.rChild);
            }
        }

    }
}

class BiTreeNode{
    Object data;
    BiTreeNode lChild,rChild;

    public BiTreeNode() {
        // TODO Auto-generated constructor stub
        lChild=null;
        rChild=null;
        data=null;
    }
    public BiTreeNode(Object data,BiTreeNode left,BiTreeNode right) {
        lChild=left;
        rChild=right;
        this.data=data;
    }
    public BiTreeNode(Object data) {
        this.data=data;
        lChild=null;
        rChild=null;
    }
}
