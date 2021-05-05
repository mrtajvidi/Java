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

}