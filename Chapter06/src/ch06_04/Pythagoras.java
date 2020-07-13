package ch06_04;

public class Pythagoras {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                for (int k = 1; k < 100; k++) {
                    if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) {
                        System.out.println("a=" + i + " b=" + j + " c=" + k);
                        count++;
                    }
                }
            }
        }
        System.out.println("count="+count);
        System.out.println("2018250038 이경묵");
    }
}
