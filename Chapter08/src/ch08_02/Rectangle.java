package ch08_02;

public class Rectangle implements Shape {
    private double width, height;

    public double area() {
        return this.height * this.width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
