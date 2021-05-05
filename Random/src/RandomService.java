import java.util.ArrayList;

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
}
