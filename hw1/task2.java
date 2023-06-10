package hw1;

public class task2 {
    public static void main(String[] args) {
        String[][] arr = new String[][] {
            {"4", "3", "2", "7", "8"},
            {"4", "5", "1", "8", "8"},
            {"1", "3", "6", "7", "8"},
            {"1", "3", "2", "2", "6"},
            {"5", "2", "3", "4", "8"}
        }; 
        System.out.println(sum2d(arr));
    }
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

}
