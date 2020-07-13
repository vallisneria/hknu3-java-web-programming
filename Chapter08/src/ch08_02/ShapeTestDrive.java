package ch08_02;

import java.util.Scanner;

public class ShapeTestDrive {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Rectangle r = new Rectangle();
        Triangle t = new Triangle();
        Circle c = new Circle();

        System.out.println("=== 사각형의 넓이 구하기 ===");
        System.out.print("Height = ");
        r.setHeight(s.nextDouble());
        System.out.print("Width = ");
        r.setWidth(s.nextDouble());
        System.out.println("Area = " + r.area());

        System.out.println("=== 삼각형의 넓이 구하기 ===");
        System.out.print("Width = ");
        t.setWidth(s.nextDouble());
        System.out.print("Height = ");
        t.setHeight(s.nextDouble());
        System.out.println("Area = " + t.area());

        System.out.println("=== 원의 넓이 구하기 ===");
        System.out.print("Radius = ");
        c.setRadius(s.nextDouble());
        System.out.println("Area = " + c.area());
    }
}
