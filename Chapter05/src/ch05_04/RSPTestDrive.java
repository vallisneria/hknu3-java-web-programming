package ch05_04;

public class RSPTestDrive {
    public static void main(String[] args) {
        RockScissorPaper g = new RockScissorPaper();
        g.start();
        while (g.turn()) {
        }
    }
}
