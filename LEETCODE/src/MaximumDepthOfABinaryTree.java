import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nikoo28 on 9/16/17
 */
public class MaximumDepthOfABinaryTree {

  public int maxDepth(TreeNode root) {

    if (root == null)
      return 0;

    Queue<TreeNode> nodes = new LinkedList<>();

    nodes.add(root);
    int levels = 0;

    boolean flag = false;
    while (!nodes.isEmpty()) {

      levels++;
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode poppedNode = nodes.poll();
        if (poppedNode.left != null) nodes.add(poppedNode.left);
        if (poppedNode.right != null) nodes.add(poppedNode.right);
      }

    }

    return levels;
  }

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    root.left = left;
    root.right = right;

    MaximumDepthOfABinaryTree maximumDepthOfABinaryTree = new MaximumDepthOfABinaryTree();
    System.out.println(maximumDepthOfABinaryTree.maxDepth(root));

  }

}
