/*
    Author: Gyeongmuk Lee (이경묵)
    Student ID: 2018250038
    email: moogi3469@hknu.ac.kr

    Course: Java Programming
    Assignment: Programming Assignment 1
    Due Date: 2020/May/28

    File: OrderItem.java
    Purpose: Main 클래스에서 사용자가 주문한 피자를 저장

    Compiler/IDE: Openjdk 1.8.0 / Intellij IDEA
    OS: Microsoft Windows 10
*/

public class OrderItem {
    private String type;
    private String size;
    private int quantity;
    private double price;
    private static double totalPrice = 0;

    /**
     *
     * @return
     */
    public String toString() {
        return String.format("%-20s %-20s %-20d $ %-20.2f", this.type, this.size, this.quantity, this.price);
    }

    public boolean isVoid() {
        return (this.type.equals("end") & this.price == 0.0 & this.size.equals("0") & this.quantity == 0);
    }

    /**
     * 항이 0개인 OrderItem 생성자.
     * <p>
     * 해당 생성자를 통해 생성한 객체는 주문 목록에서 마침표처럼 사용됩니다.
     */
    public OrderItem() {
        this.type = "end";
        this.price = 0.0;
        this.quantity = 0;
        this.size = "0";
    }

    /**
     * 항이 4개인 OrderItem 생성자
     *
     * @param type     피자의 이름
     * @param size     피자의 크기
     * @param quantity 피자의 개수
     * @param price    피자의 가격
     */
    public OrderItem(String type, String size, int quantity, double price) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.price = price;

        OrderItem.totalPrice += price;
    }

    public static double getTotalPrice() {
        return totalPrice;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
