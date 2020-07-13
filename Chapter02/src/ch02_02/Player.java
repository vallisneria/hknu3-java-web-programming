package ch02_02;

import java.util.Scanner;

public class Player {
    private String UserName;

    public Player(String name) {
        this.UserName = name;
    }

    public int GuessNumber() {
        int result;
        System.out.print(this.UserName + "님, 숫자를 입력해 주세요: ");
        Scanner s = new Scanner(System.in);
        result = s.nextInt();
        return result;
    }

    public void Answer() {
        System.out.println("정답입니다!");
    }

    public void Wrong() {
        System.out.println("틀렸습니다!");
    }
}
