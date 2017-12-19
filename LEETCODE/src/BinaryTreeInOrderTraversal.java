import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nikoo28 on 12/19/17 1:22 AM
 */

public class BinaryTreeInOrderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {

    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.add(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      cur = cur.right;
    }

    return list;
  }

}
