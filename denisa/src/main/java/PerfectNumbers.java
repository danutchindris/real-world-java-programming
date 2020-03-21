import java.util.Scanner;

public class PerfectNumbers {
    private static Scanner sc;

    public static void main(String[] args) {
        int Nr;
        int Sum = 0;
        sc = new Scanner(System.in);
        System.out.println(" Please enter a number: ");
        Nr = sc.nextInt();


        for (int i = 1; i < Nr / 2; i++) {
            if (Nr % i == 0) {
                Sum = Sum + i;
            }
        }
        if (Sum == Nr) {
            System.out.println("the input number is perfect: " + Nr);
        } else {
            System.out.println("the input number is Not perfect: " + Nr);
        }


    }
}
