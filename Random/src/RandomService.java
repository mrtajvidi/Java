import java.util.ArrayList;
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


    public static boolean isPalindrome(String s) {
        int headIndex = 0;
        int tailIndex = s.length() - 1;
        char[] chars = s.toCharArray();

        while (headIndex < tailIndex) {
            if (!Character.isLetterOrDigit(chars[headIndex])) {
                headIndex++;
                continue;
            }

            if (!Character.isLetterOrDigit(chars[tailIndex])) {
                tailIndex--;
                continue;
            }

            if (Character.toLowerCase(chars[headIndex]) != Character.toLowerCase(chars[tailIndex])) {
                return false;
            }
            headIndex++;
            tailIndex--;
        }
        return true;
    }


    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            output[j] = R * output[j];
            R *= nums[j];
        }
        return output;
    }

    public int missingNumber(int[] nums) {
        int l = nums.length;
        int expectedSum = l * (l + 1) / 2;

        for (int i = 0; i < l; i++) {
            expectedSum -= nums[i];
        }
        return expectedSum;
    }

    public int firstUniqChar(String s)
    {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int left = 0;
        int right = n - 1;

        int square = 0;
        for (int i = n -1; i >= 0; i--)
        {
            if (Math.abs(nums[left]) < Math.abs(nums[right]))
            {
                square = nums[right];
                right--;
            }
            else
            {
                square = nums[left];
                left++;
            }

            output[i] = square * square;
        }
        return output;

    }

}
