package acwing.每日一题2023春季;

import java.util.*;

/**
 * @ClassName T1497
 * @Description 树的遍历
 * @Author yiling
 * @date 2023/2/19 19:23
 */
public class T1497 {
    //不用BFS
/*    static int N;
    static int[] postOrder; //后序遍历
    static int[] inOrder; //中序遍历
    static LinkedList<Tree> trees = new LinkedList<>();
    static HashMap<Integer,Integer> inOrderNum = new HashMap<>(); //记录中序遍历的位置

    public static void buildTree(int postL,int postR,int inL,int inR,int layer){
        //无左子树
        if(postR<postL) {
            return;
        }
        int root = postOrder[postR]; //根节点是后序遍历的最后一个结点
        Tree tree = new Tree(layer, root);
        trees.add(tree);
        int k = inOrderNum.get(root); // 找到根节点在中序遍历中的位置
        //先递归左子树后递归右子树
        buildTree(postL,postL+(k-1)-inL,inL,k-1,layer+1);
        buildTree(postL+k-inL,postR-1,k+1,inR,layer+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        postOrder = new int[N+5];
        inOrder = new int[N+5];
        for(int i = 0;i<N;++i){
            postOrder[i] = scanner.nextInt();
        }
        for(int i = 0;i<N;++i){
            inOrder[i] = scanner.nextInt();
            inOrderNum.put(inOrder[i],i);
        }

        buildTree(0,N-1,0,N-1,0);
        for (int i =0;i<N;++i){
            for (Tree tree:trees){
                if(tree.layer==i){
                    System.out.print(tree.num+" ");
                }
            }
        }
    }

    static class Tree{
        private int layer;
        private int num;

        public Tree(int layer, int num) {
            this.layer = layer;
            this.num = num;
        }

        public int getLayer() {
            return layer;
        }

        public int getNum() {
            return num;
        }
    }*/

    //用BFS
    static int N;
    static int[] postOrder; //后序遍历
    static int[] inOrder; //中序遍历
    static int[] left;//该节点的左子树的根节点
    static int[] right;//该节点的右子树的根节点
    static HashMap<Integer, Integer> inOrderNum = new HashMap<>(); //记录中序遍历的位置

    public static int buildTree(int postL, int postR, int inL, int inR) {
        if (postL > postR) {
            return -1; //没有左子树
        }
        int root = postOrder[postR]; //根节点是后序遍历的最后一个结点
        int k = inOrderNum.get(root); // 找到根节点在中序遍历中的位置
        left[root] = buildTree(postL, postL + (k - 1) - inL, inL, k - 1);
        right[root] = buildTree(postL + k - inL, postR - 1, k + 1, inR);
        return root;
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(postOrder[N - 1]);
        while (!queue.isEmpty()) {
            int t = queue.poll(); //返回队头同时移出队列
            System.out.print(t + " ");

            //因为是二叉树，左右子树根节点最多各自有一个
            if (left[t] != -1) {
                queue.add(left[t]);
            }
            if (right[t] != -1) {
                queue.add(right[t]);
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        postOrder = new int[N];
        inOrder = new int[N];
        left = new int[N + 1]; //因为根节点权值是1~N
        right = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            postOrder[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; ++i) {
            inOrder[i] = scanner.nextInt();
            inOrderNum.put(inOrder[i], i);
        }

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        buildTree(0, N - 1, 0, N - 1);
        bfs();
    }
}

