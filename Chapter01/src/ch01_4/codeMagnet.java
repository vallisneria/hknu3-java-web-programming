package ch01_4;

public class codeMagnet {
    public static void main(String[] args) {
        System.out.println("2018250038 이경묵\n");

        int x = 3;

        while (x > 0) {
            if (x > 2) {
                System.out.print("a");
            }

            x = x - 1;
            System.out.print("-");

            if (x == 2) {
                System.out.print("b c");
            }

            if (x == 1) {
                System.out.print("d");
                x = x - 1;
            }
        }
    }
}
