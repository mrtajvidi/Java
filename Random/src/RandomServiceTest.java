import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RandomServiceTest {
    private RandomService _randomService;

    public RandomServiceTest() {
        this._randomService = new RandomService();
    }

    @Test
    public void countSubArrays_Pass() throws Exception {
        int[] input = {2, 4, 7, 1, 5, 3};
        int[] expectedOutput = {1, 2, 6, 1, 3, 1};
        int[] actualOutput = _randomService.countSubArrays(input);
        Assert.assertTrue(Arrays.equals(expectedOutput, actualOutput));
    }

    @Test
    public void isSameTreeRecursion_True() {

        var p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        var q = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        var actualOutput = _randomService.isSameTreeRecursion(p, q);
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void isSameTreeRecursion_False() {

        var p = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        var q = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        var actualOutput = _randomService.isSameTreeRecursion(p, q);
        Assert.assertFalse(actualOutput);
    }

    @Test
    public void inorderTraversalRecursion_True() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(2, 1, 3));
        var actualOutput = _randomService.inorderTraversalRecursion(root);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void inorderTraversalIteration_True() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(2, 1, 3));
        var actualOutput = _randomService.inorderTraversalIteration(root);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void preorderTraversalRecursion_True() {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;

        List<Integer> expectedOutput = new ArrayList<>(Arrays.asList(1, 2, 3));
        var actualOutput = _randomService.preorderTraversal(root);
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void twoSum_True() {

        int[] input = {2, 7, 11, 15};
        Integer target = 9;
        int[] expectedOutput = {0, 1};
        int[] actualOutput = _randomService.twoSum(input, target);
        var actualString = Arrays.toString(actualOutput);
        var expectedString = Arrays.toString(expectedOutput);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void groupAnagrams_True() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<List<String>> expectedOutput = new ArrayList<List<String>>() {
            {
                add(new ArrayList<>(List.of("eat", "tea", "ate")));
                add(new ArrayList<>(List.of("bat")));
                add(new ArrayList<>(List.of("tan", "nat")));
            }
        };
        List<List<String>> actualOutput = _randomService.groupAnagrams(input);
        var actualString = Arrays.toString(actualOutput.toArray());
        var expectedString = Arrays.toString(expectedOutput.toArray());
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void isPalindrome_True() {
        String input = "A man, a plan, a canal: Panama";
        boolean result = _randomService.isPalindrome(input);
        Assert.assertTrue(result);
    }


    @Test
    public void isPalindrome_False() {
        String input = "A man, a plan, a canal: Panamat";
        boolean result = _randomService.isPalindrome(input);
        Assert.assertFalse(result);
    }

    @Test
    public void productExceptSelf_True() {
        int[] input = {1, 2, 3, 4};
        int[] expectedOutput = {24, 12, 8, 6};
        int[] result = _randomService.productExceptSelf(input);
        var actualString = Arrays.toString(result);
        var expectedString = Arrays.toString(expectedOutput);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void productExceptSelf_True2() {
        int[] input = {-1, 1, 0, -3, 3};
        int[] expectedOutput = {0, 0, 9, 0, 0};
        int[] result = _randomService.productExceptSelf(input);
        var actualString = Arrays.toString(result);
        var expectedString = Arrays.toString(expectedOutput);
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void missingNumber_True() {
        int[] input = {3, 0, 1};
        int expectedOutput = 2;
        int actualOutput = _randomService.missingNumber(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void missingNumber_True2() {
        int[] input = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int expectedOutput = 8;
        int actualOutput = _randomService.missingNumber(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void missingNumber_True3() {
        int[] input = {0, 1};
        int expectedOutput = 2;
        int actualOutput = _randomService.missingNumber(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void firstUniqChar_True1() {
        String input = "leetcode";
        int expectedOutput = 0;
        int actualOutput = _randomService.firstUniqChar(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void firstUniqChar_True2() {
        String input = "loveleetcode";
        int expectedOutput = 2;
        int actualOutput = _randomService.firstUniqChar(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void firstUniqChar_True3() {
        String input = "aabb";
        int expectedOutput = -1;
        int actualOutput = _randomService.firstUniqChar(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void sortedSquares_True() {
        int[] input = {-4, -1, 0, 3, 10};
        int[] expectedOutput = {0, 1, 9, 16, 100};
        int[] actualOutput = _randomService.sortedSquares(input);
        String actualOutputString = Arrays.toString(actualOutput);
        String expectedOutputString = Arrays.toString(expectedOutput);
        Assert.assertEquals(expectedOutputString, actualOutputString);
    }


    @Test
    public void matchingPairs_True1() {
        String input1 = "abcde";
        String input2 = "adcbe";
        int expectedOutput = 5;
        int actualOutput = _randomService.matchingPairs(input1, input2);
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void matchingPairs_True2() {
        String input1 = "abcdef";
        String input2 = "adcfeg";
        int expectedOutput = 3;
        int actualOutput = _randomService.matchingPairs(input1, input2);
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void matchingPairs_True3() {
        String input1 = "mno";
        String input2 = "mno";
        int expectedOutput = 1;
        int actualOutput = _randomService.matchingPairs(input1, input2);
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void minLengthSubstring_True1() {
        String input1 = "dcbefebce";
        String input2 = "fd";
        int expectedOutput = 5;
        int actualOutput = _randomService.minLengthSubstring(input1, input2);
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void minLengthSubstring_True2() {
        String input1 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String input2 = "cbccfafebccdccebdd";
        int expectedOutput = -1;
        int actualOutput = _randomService.minLengthSubstring(input1, input2);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getPermutations_Case1() {
        String input1 = "a";
        ArrayList<String> expectedOutput = new ArrayList<>() {
            {
                add("a");
            }
        };

        ArrayList<String> actualOutput = _randomService.getPermutations(input1);
        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void minOverallAwkwardness_True() {
       // int[] input = {5, 10, 6, 8};
        int[] input = {1, 2, 5, 3, 7};
        int expectedOutput = 4;
        int actualOutput = _randomService.minOverallAwkwardness(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

}