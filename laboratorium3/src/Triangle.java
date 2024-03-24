import java.util.Scanner;

public class Triangle {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int N = scan.nextInt();
        print_triangle(N);
    }


    public static void print_triangle(int N) {

        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    triangle[i][j] = 1;
                }
                else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                System.out.printf("%5d ", triangle[i][j]);
            }
            System.out.println();
        }

    }

}