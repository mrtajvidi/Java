import com.sun.source.doctree.LinkTree;

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

    public List<Integer> inorderTraversalIteration(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> output = new ArrayList<>();

        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            output.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return output;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> output = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var currNode = stack.pop();
            output.add(currNode.val);

            if (currNode.right != null) {
                stack.push(currNode.right);
            }

            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        return output;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {

                var currNode = queue.poll();
                levels.get(level).add(currNode.val);

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            level++;
        }
        return levels;

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

    public int firstUniqChar(String s) {
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
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }

            output[i] = square * square;
        }
        return output;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int Y = (q != null) ? q.val : 0;

            int sum = x + Y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public int matchingPairs(String s, String t) {
        int countOfMatchedPairs = 0;
        int countOfMismatches = 0;
        HashMap<Character, ArrayList<Character>> mismatchedPairs = new HashMap<>();

        int countOfSwaps = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAtS = s.charAt(i);
            char charAtT = t.charAt(i);

            if (charAtS == charAtT) {
                countOfMatchedPairs++;
                continue;
            } else if (countOfSwaps == 0) {
                countOfMismatches++;
                if (mismatchedPairs.containsKey(charAtT)) {
                    ArrayList<Character> value = mismatchedPairs.get(charAtT);
                    if (value.contains(charAtS)) {
                        countOfSwaps = 1;
                        countOfMatchedPairs += 2;
                    }
                } else {
                    ArrayList<Character> value = mismatchedPairs.getOrDefault(charAtS, new ArrayList<>());
                    value.add(charAtT);
                    mismatchedPairs.put(charAtS, value);
                }
            }
        }
        return ( countOfMismatches > 0 ) ? countOfMatchedPairs : countOfMatchedPairs - 2;
    }

    public int minLengthSubstring(String s, String t) {

        // Write your code here
        HashMap<Character, Integer> charIndexes = new HashMap<>();

        for (int i = 0; i < t.length(); i++)
        {
            char thisChar = t.charAt(i);
            if (charIndexes.containsKey(thisChar))
            {
                charIndexes.replace(thisChar, charIndexes.get(thisChar) + 1);
            }
            else
            {
                charIndexes.put(thisChar, 1);
            }
        }

        int minIndex = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        for (int j = 0; j < s.length(); j++)
        {
            Character theOtherChar = s.charAt(j);
            if (charIndexes.containsKey(theOtherChar) && charIndexes.get(theOtherChar) > 0)
            {
                if (minIndex == Integer.MIN_VALUE)
                {
                    minIndex = j;
                }

                if (j > maxIndex)
                {
                    maxIndex = j;
                }
                charIndexes.replace(theOtherChar, charIndexes.get(theOtherChar) - 1);
            }
        }

        for (Integer item : charIndexes.values())
        {
            if (item > 0)
                return -1;
        }

        if (maxIndex == Integer.MIN_VALUE || minIndex == Integer.MIN_VALUE) return -1;

        return maxIndex - minIndex + 1;
    }

    public int tripleSteps(int input)
    {
        Integer[] memo = new Integer[input + 1];
        Arrays.fill(memo, 0);
        return tripleStepsHelper(input, memo);
    }

    private int tripleStepsHelper(int n, Integer[] memo)
    {
        if ( n < 0 ) return 0;
        else if (n == 0)
        {
            return 1;
        }
        else if (memo[n] != 0)
        {
            return memo[n];
        }
        else {
            memo[n] = tripleStepsHelper(n - 3, memo) + tripleStepsHelper(n - 2, memo) + tripleStepsHelper(n - 1, memo);
            return memo[n];
        }
    }

    public ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index)
        {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = powerSet(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<>();

            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubset.add(newSubset);
            }

            allSubsets.addAll(moreSubset);
        }
        return allSubsets;
    }
    

}
