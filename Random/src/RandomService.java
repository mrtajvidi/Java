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

        if (root == null) {
            return output;
        }

        if (root.left != null) {
            output.addAll(inorderTraversalRecursion(root.left));
        }
        output.add(root.val);
        if (root.right != null) {
            output.addAll(inorderTraversalRecursion(root.right));
        }

        return output;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List> ans = new HashMap<>();

        for (String item : strs) {
            char[] charArray = item.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<String>() {
                    {
                        add(item);
                    }
                });
            } else {
                ans.get(key).add(item);
            }
        }

        return new ArrayList(ans.values());
    }

}
