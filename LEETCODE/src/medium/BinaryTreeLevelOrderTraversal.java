package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nikoo28 on 12/19/17 1:01 AM
 */

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

    if (root == null)
      return wrapList;

    queue.add(root);

    while (!queue.isEmpty()) {

      int levelNum = queue.size();
      List<Integer> subList = new LinkedList<Integer>();

      for (int i = 0; i < levelNum; i++) {

        if (queue.peek().left != null)
          queue.add(queue.peek().left);
        if (queue.peek().right != null)
          queue.add(queue.peek().right);

        subList.add(queue.remove().val);
      }
      wrapList.add(subList);
    }
    return wrapList;
  }

}
