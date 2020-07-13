package ch03_06;

import java.util.Scanner;

public class PlanetWeight {
    public static void main(String[] args) {
        do {
            Scanner s = new Scanner(System.in);
            Planet p = new Planet();

            System.out.print("행성의 이름을 입력해주세요: ");
            p.name = s.nextLine();

            System.out.print("행성의 무게를 입력해주세요: ");
            p.weight = s.nextDouble();

            System.out.println(p.name + "의 무게는 " + p.weight + "입니다.");
        } while (Continue());
    }

    public static boolean Continue() {
        System.out.print("계속하시겠습니까?(Y/N) ");
        String input = new Scanner(System.in).nextLine();
        return input.equals("Y") || input.equals("y");
    }
}
