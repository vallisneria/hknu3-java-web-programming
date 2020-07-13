package ch08_02;

public class Circle implements Shape {
    private double radius;

    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
