import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[N][N];

        int top = 0;
        int bottom = N - 1;
        int left = 0;
        int right = N - 1;
        int number = 1;

        while (number <= N * N) { //Dealing with the left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = number;
                number++;
            }
            top++;

            for (int i = top; i <= bottom; i++) { //Dealing with the top to bottom
                matrix[i][right] = number;
                number++;
            }
            right--;

            for (int i = right; i >= left; i--) { //Dealing with the roght to left
                matrix[bottom][i] = number;
                number++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) { //Dealing with the bottom to top
                matrix[i][left] = number;
                number++;
            }
            left++;
        }

        // Print the spiral matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
