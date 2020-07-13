package ch10_05;

import java.util.HashSet;

public class LotteryGenerator {
    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");
        Lottery l1 = new Lottery();
        System.out.println(l1.getNumbers());
    }
}

class Lottery {
    private HashSet<Integer> numbers;
    private final int MaxNum = 45;
    private final int MinNum = 1;

    public Lottery() {
        numbers = new HashSet<Integer>();
        addNumbers();
    }

    private int randNum() {
        return (int) (Math.random() * (this.MaxNum - this.MinNum)) + this.MinNum;
    }

    public HashSet<Integer> getNumbers() {
        return this.numbers;
    }

    private void addNumbers() {
        while (this.numbers.size() < 6) {
            int rand = this.randNum();
            if (!this.numbers.contains(rand)) {
                this.numbers.add(rand);
            }
        }
    }
}