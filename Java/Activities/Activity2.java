import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args) {
        int[] intArr = {10, 77, 10, 54, -11, 10};
        System.out.println("All numbers are : " + Arrays.toString(intArr));

        int num = 10;
        int sum = 30;

        System.out.println("Result: " + result(intArr, num, sum));
    }

    public static boolean result(int[] numbers, int num, int sum) {
        int temp_sum = 0;
        //Loop through array
        for (int number : numbers) {
            //If value is 10
            if (number == num) {
                //Add them
                temp_sum += num;
            }

            //Sum should not be more than 30
            if (temp_sum > sum) {
                break;
            }
        }

        //Return true if condition satisfies
        return temp_sum == sum;
    }



}
