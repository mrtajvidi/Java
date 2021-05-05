import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;


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


}