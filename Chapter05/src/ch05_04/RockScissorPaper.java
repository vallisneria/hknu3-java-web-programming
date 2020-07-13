package ch05_04;

import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {
    public void start() {
        System.out.println("<<가위 바위 보 게임>>");
        System.out.println("가위(1), 바위(2), 보(3), 종료(0)");
    }

    public boolean turn() {
        System.out.print("낼 것을 입력해주세요: ");
        int playerSelect = new Scanner(System.in).nextInt();
        int botSelect = this.botSelect();
        if (playerSelect == 0) {
            return false;
        }
        System.out.print("상대방은 " + this.numToText(botSelect)+"을 냈습니다. ");
        this.GameRule(playerSelect, botSelect);
        return true;
    }

    private int botSelect() {
        return new Random().nextInt(3) + 1;
    }

    private void GameRule(int userSelect, int botSelect) {
        if (botSelect - userSelect == 1 || botSelect - userSelect == -2) {
            System.out.println("당신이 졌습니다.");
        } else if (botSelect - userSelect == 2 || botSelect - userSelect == -1) {
            System.out.println("당신이 이겼습니다.");
        } else {
            System.out.println("비겼습니다.");
        }
    }

    public String numToText(int i) {
        if (i == 1) {
            return "가위";
        } else if (i == 2) {
            return "바위";
        } else if (i == 3) {
            return "보";
        }
        return "";
    }
}
