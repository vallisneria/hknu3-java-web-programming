package ch06_01;

import java.util.ArrayList;

public class SimpleDotComGame {
    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");

        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        DotCom dotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5);

        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        ArrayList<String> loc = new ArrayList<String>();
        for (int i : locations) {
            loc.add(Integer.toString(i));
        }
        dotCom.setLocationCells(loc);
        boolean isAlive = true;

        while (isAlive) {
            String guess = helper.getUserInput("enter a number");
            String result = dotCom.checkYourself(guess);
            System.out.println(result);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses.");
            }
        }
    }
}
