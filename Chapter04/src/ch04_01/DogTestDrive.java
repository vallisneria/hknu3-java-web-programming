package ch04_01;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog();
        one.size = 70;
        Dog two = new Dog();
        two.size = 8;
        Dog three = new Dog();
        three.size = 35;

        one.Bark();
        two.Bark();
        three.Bark();
    }
}
