package ch01_3;

public class BeerSong {
    public static void main(String[] args) {
        System.out.println("2018250038 이경묵\n");

        for (int n=99;n>=0;n--){
            if (n == 0) {
                System.out.println(word(0) + " on the wall, " + word(0) + ".");
                System.out.println("Go to the store and buy some more, " + word(n) + " on the wall.");
            } else {
                System.out.println(word(n) + " on the wall, " + word(n) + ".");
                System.out.println("Take one down and pass it around, " + word(n - 1) + " on the wall.\n");
            }
        }
    }

    private static String word(int n) {
        if (n == 0) {
            return "no more bottles of beer";
        } else if (n == 1) {
            return "1 bottle of beer";
        } else {
            return n + " bottles of beer";
        }
    }
}
