package Test20190713;

public class Main {

    public static void main(String[] args) {
        Character[] data=new Character[] {'A','B','C','D',null,'E','F',null,'G','s'};

        BiTree tree=new BiTree();
        tree.createTree(data);
        System.out.println("先序遍历");
        tree.preOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.println("中序遍历");
        tree.inOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.println("后序遍历");
        tree.postOrderTraverse(tree.getRoot());
        System.out.println();
        System.out.println("层序遍历");
        tree.levelOrderTraverse(tree.getRoot());

    }
}
