package ch04_03;

class Clock {
    String time;

    void setTime(String time) {
        this.time = time;
    }

    String getTime() {
        return time;
    }
}

public class ClockTestDrive {
    public static void main(String[] args) {
        Clock c = new Clock();
        c.setTime("1245");
        String tod = c.getTime();
        System.out.println("Time: " + tod);
    }
}