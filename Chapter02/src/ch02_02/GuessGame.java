package ch02_02;

import java.util.Random;

public class GuessGame {
    private int TargetNumber;
    private int MaxNumber = 10;
    public Player[] player;

    public GuessGame(int NumOfPlayer) {
        this.TargetNumber = this.SetTargetNumber();
        this.player = new Player[NumOfPlayer];
        for (int i = 0; i < this.player.length; i++) {
            this.player[i] = new Player("플레이어" + i);
        }
    }

    public void Game() {
        System.out.println("숫자 맞추기 게임입니다. 최대 숫자는 " + this.MaxNumber + "입니다.");
        boolean GameOver;

        do {
            GameOver = this.Turn();
        } while (!GameOver);
    }

    private int SetTargetNumber() {
        return (new Random().nextInt(this.MaxNumber + 1));
    }

    private boolean Turn() {
        boolean result = false;
        for (Player value : this.player) {
            int SubmitAnswer = value.GuessNumber();
            if (SubmitAnswer == this.TargetNumber) {
                value.Answer();
                result = true;
                break;
            } else {
                value.Wrong();
            }
        }
        return result;
    }
}
