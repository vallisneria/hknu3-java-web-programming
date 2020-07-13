package ch06_02;

import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("go2.com");
        this.dotComList.add(one);
        this.dotComList.add(two);
        this.dotComList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("pets.com, eToys.com, go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        for (DotCom dotComToSet : this.dotComList) {
            ArrayList<String> newLocation = this.helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!this.dotComList.isEmpty()) {
            String userGuess = this.helper.getUserInput("Enter a guess");
            this.checkUserGuess(userGuess);
        }
        this.finishGame();
    }

    private void checkUserGuess(String userGuess) {
        this.numOfGuesses++;
        String result = "miss";
        for (DotCom dotComToTest : this.dotComList) {
            result = dotComToTest.checkYourSelf(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                this.dotComList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (this.numOfGuesses <= 18) {
            System.out.println("It only took you " + this.numOfGuesses + " guesses.");
            System.out.println("You Got one before you options sank.");
        } else {
            System.out.println("Took you long enough. " + this.numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your option.");
        }
    }

    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");

        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
