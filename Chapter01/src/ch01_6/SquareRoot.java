package ch01_6;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println("2018250038 이경묵\n");

        System.out.print("계산할 숫자를 입력해주세요: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.println(num + "의 제곱근은 " + Math.sqrt(num) + "입니다.");
    }
}
