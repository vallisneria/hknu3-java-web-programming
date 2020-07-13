package ch09_01;

public class TestDuck {
    public static void main(String[] args) {
        int weight = 8;
        float density = 2.3F;
        String name = "Donald";
        long[] feathers = {1, 2, 3, 4, 5, 6};
        boolean canFly = true;
        int airspeed = 22;

        Duck[] d = new Duck[7];
        d[0] = new Duck();
        d[1] = new Duck(density, weight);
        d[2] = new Duck(name, feathers);
        d[3] = new Duck(canFly);
        d[4] = new Duck(3.3F, airspeed);
        d[5] = new Duck(false);
        d[6] = new Duck(airspeed, density);
    }
}

class Duck {
    int pounds = 6;
    float floatability = 2.1F;
    String name = "Generic";
    long[] feathers = {1, 2, 3, 4, 5, 6, 7};
    boolean canFly = true;
    int maxSpeed = 25;

    public Duck() {
        System.out.println("Type 1 Duck");
    }

    public Duck(boolean fly) {
        canFly = fly;
        System.out.println("Type 2 Duck");
    }

    public Duck(String n, long[] f) {
        name = n;
        feathers = f;
        System.out.println("Type 3 Duck");
    }

    public Duck(int w, float f) {
        pounds = w;
        floatability = f;
        System.out.println("Type 4 Duck");
    }

    public Duck(float density, int max) {
        floatability = density;
        maxSpeed = max;
        System.out.println("Type 5 Duck");
    }
}