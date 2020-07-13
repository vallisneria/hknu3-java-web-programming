package ch04_01;

public class Dog {
    int size;
    String name;

    void Bark() {
        if (this.size > 60) {
            System.out.println("Woof! Woof!");
        } else if (this.size > 14) {
            System.out.println("Ruff! Ruff!");
        } else {
            System.out.println("Yip! Yip!");
        }
    }
}
