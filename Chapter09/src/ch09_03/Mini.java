package ch09_03;

import java.awt.Color;

public class Mini extends Car {
    Color color;

    public Mini() {
        this(Color.red);
    }

    public Mini(Color c) {
        super("mini");
        color = c;
        System.out.println(this.color);
    }

    public Mini(int size) {
        this(Color.red);
    }
}

class MiniTest {
    public static void main(String[] args) {
        Mini m = new Mini(Color.red);
    }
}