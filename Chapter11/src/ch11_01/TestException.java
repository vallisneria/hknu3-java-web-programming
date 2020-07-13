package ch11_01;

public class TestException {
    public static void main(String[] args) {
        System.out.println("2018250038 이경묵");
        String test = "yes";
        try {
            System.out.println("start try");
            doRisky(test);
            System.out.println("end try");
        } catch (ScaryException se) {
            System.out.println("Scary Exception");
        } finally {
            System.out.println("Finally");
        }
    }

    static void doRisky(String test) throws ScaryException {
        System.out.println("Start risky");
        if ("yes".equals(test)) {
            throw new ScaryException();
        }
        System.out.println("end risky");
    }
}

class ScaryException extends Exception {
}