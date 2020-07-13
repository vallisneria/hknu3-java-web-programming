package ch08_02;

public class Triangle implements Shape {
    private double width, height;

    public double area() {
        return this.width * this.height / 2;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
