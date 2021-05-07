import java.util.ArrayList;
import java.util.Deque;
import java.util.*;


public class RandomService {

    public int[] countSubArrays(int[] arr) {
        ArrayList<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            Integer countSubArrays = 1;
            Integer prevIndx = i;
            while (prevIndx - 1 >= 0) {
                if (arr[prevIndx - 1] > arr[i]) {
                    break;
                }
                prevIndx--;
            }
            countSubArrays += i - (prevIndx > 0 ? prevIndx : 0);

            Integer nextIndx = i;
            while (nextIndx + 1 < arr.length) {
                if (arr[nextIndx + 1] > arr[i]) {
                    break;
                }
                nextIndx++;
            }
            countSubArrays += (nextIndx > 0 ? nextIndx : 0) - i;
            output.add(countSubArrays);
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    public boolean isSameTreeRecursion(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if ((p == null && q != null) || (p != null && q == null)) return false;

        if (p.val == q.val) {
            return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
        }
        return false;
    }

    public boolean isSameTreeIteration(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if ((p == null && q != null) || (p != null && q == null)) return false;

       // Deque<TreeNode> queueP = new <>();

        if (p.val == q.val) {
            return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
        }
        return false;
    }


    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();

        if (root == null)
        {
            return output;
        }

        if (root.left != null)
        {
            output.addAll(inorderTraversalRecursion(root.left));
        }
        output.add(root.val);
        if(root.right != null)
        {
            output.addAll(inorderTraversalRecursion(root.right));
        }

        return output;
    }



}
