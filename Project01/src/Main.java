import java.util.ArrayList;
import java.util.Scanner;

/*
    Author: Gyeongmuk Lee (이경묵)
    Student ID: 2018250038
    email: moogi3469@hknu.ac.kr

    Course: Java Programming
    Assignment: Programming Assignment 1
    Due Date: 2020/May/28

    File: Main.java
    Purpose: main() 함수 및

    Compiler/IDE: Openjdk 1.8.0 / Intellij IDEA
    OS: Microsoft Windows 10
*/

public class Main {
    public static final String[] PIZZA_MENU = {"Cheese Pizza", "Pepperoni Pizza", "Bulgogi Pizza", "Hawaiian Pizza", "Mint Chocolate Pizza"};
    public static final double[] PIZZA_PRICE = {15.0, 17.0, 20.0, 23.0, 25.0};
    public static final String[] PIZZA_SIZE_NAME = {"10\" Small", "14\" Medium", "16\" Large", "18\" Extra"};
    public static final double[] PIZZA_PRICE_BY_SIZE = {0.7, 1.0, 1.2, 1.5};
    private static ArrayList<OrderItem> orders;

    public static void main(String[] args) {
        orders = new ArrayList<OrderItem>();

        greeting();

        OrderItem i;
        do {
            i = getPizzaChoice();
            orders.add(i);
        } while (!i.isVoid());

        summary();
        payment();
        thanks();
    }

    /**
     * 피자 메뉴들을 출력합니다.
     */
    public static void displayPizzaMenu() {
        int i;
        for (i = 0; i < PIZZA_MENU.length; i++) {
            System.out.format("%d) %s\n", i + 1, PIZZA_MENU[i]);
        }
    }

    /**
     * 피자의 가격과 사이즈를 출력합니다.
     *
     * @param originalPrice 해당 피자의 원래 가격
     */
    public static void displayPizzaSizeAndPrice(double originalPrice) {
        for (int i = 0; i < PIZZA_PRICE_BY_SIZE.length; i++) {
            System.out.format("%d) %-10s - $%.2f\n", i + 1, PIZZA_SIZE_NAME[i], originalPrice * PIZZA_PRICE_BY_SIZE[i]);
        }
    }

    /**
     * 프로그램을 처음 실행하는 사용자에게 환영 인사를 출력합니다.
     */
    public static void greeting() {
        System.out.println("*****************************************\n2018250038_이경묵");
        System.out.println("Welcome to Lee's Pizza!\n");
    }

    /**
     * 사용자로부터 입력받은 피자의 속성을 바탕으로 객체를 만들어 반환합니다.
     *
     * @return 피자 객체
     */
    public static OrderItem getPizzaChoice() {
        int type = Main.getPizzaType();
        if (type == PIZZA_MENU.length) {
            // 마침표 생성
            return new OrderItem();
        }
        byte size = Main.getPizzaSize(type);
        int quantity = Main.getPizzaQuantity();
        double price = Main.getPizzaPrice(type, size, quantity);

        return new OrderItem(PIZZA_MENU[type], PIZZA_SIZE_NAME[size], quantity, price);
    }

    /**
     * 사용자로부터 피자의 종류를 입력받습니다.
     *
     * @return 입력받은 피자의 종류
     */
    public static int getPizzaType() {
        int result = 0;
        try {
            System.out.println("*****************************************\n");
            System.out.println("원하시는 메뉴를 선택해주세요.\n");
            Main.displayPizzaMenu();
            System.out.format("%d) 선택 종료\n", PIZZA_MENU.length + 1);
            System.out.format("선택(1-%d): ", PIZZA_MENU.length + 1);
            result = new Scanner(System.in).nextInt() - 1;
            if (result < 0 || result > PIZZA_MENU.length) {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.format("%d는 올바른 입력이 아닙니다. 1-%d 사이의 정수를 입력해야 합니다.\n", result + 1, PIZZA_MENU.length + 1);
            return getPizzaType();
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다!");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 사용자로부터 피자의 크기를 입력받습니다.
     *
     * @param type 피자의 종류
     * @return 입력받은 피자의 사이즈
     */
    public static byte getPizzaSize(int type) {
        byte result = 0;

        try {
            System.out.println("*****************************************\n");
            System.out.println("원하시는 사이즈를 선택해주세요");
            Main.displayPizzaSizeAndPrice(PIZZA_PRICE[type]);
            System.out.format("선택(1-%d): ", PIZZA_PRICE_BY_SIZE.length);
            result = (byte) (new Scanner(System.in).nextByte() - 1);
            if (result < 0 || result > PIZZA_PRICE_BY_SIZE.length - 1) {
                throw new InvalidInputException();
            }
        } catch (InvalidInputException e) {
            System.out.format("%d는 올바른 입력이 아닙니다. 1-%d 사이의 정수를 입력해야 합니다.\n", result + 1, PIZZA_PRICE_BY_SIZE.length);
            return getPizzaSize(type);
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다!");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 사용자로부터 피자의 개수를 입력받습니다.
     *
     * @return 입력받은 피자의 개수
     */
    public static int getPizzaQuantity() {
        int result = 0;
        try {
            System.out.println("*****************************************\n");
            System.out.print("수량을 선택해 주십시오: ");
            result = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다!");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 피자의 가격을 계산하는 메소드
     * (피자의 가격) = (피자의 기본 가격) * (피자의 사이즈별 가중치) * (피자의 개수)
     *
     * @param type     피자의 종류
     * @param size     피자의 사이즈
     * @param quantity 피자의 개수
     * @return 피자의 가격
     */
    public static double getPizzaPrice(int type, byte size, int quantity) {
        return PIZZA_PRICE[type] * PIZZA_PRICE_BY_SIZE[size] * quantity;
    }

    /**
     * 주문 요약 페이지
     */
    public static void summary() {
        System.out.println("*****************************************\n");
        System.out.println("주문 요약: \n");

        System.out.format("%-20s %-20s %-20s %-20s\n", "Type", "Size", "Quantity", "Price");
        for (OrderItem order : orders) {
            if (!order.isVoid()) {
                System.out.println(order.toString());
            }
        }
        System.out.println("\n 합계: " + OrderItem.getTotalPrice());
    }

    /**
     * 결제 페이지
     */
    public static void payment() {
        System.out.println("*****************************************\n");
        System.out.print("결제 방법을 선택해주세요(현금 1/카드 2): ");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                CashPayment();
                break;
            case 2:
                CreditCardPayment();
                break;
        }
    }

    /**
     * 현금 결제를 선택했을 때
     */
    public static void CashPayment() {
        System.out.println("총 결제 가격: USD " + OrderItem.getTotalPrice());
        System.out.println("결제가 완료되었습니다!");
    }

    /**
     * 카드 결제를 선택했을 때
     */
    public static void CreditCardPayment() {
        Scanner s = new Scanner(System.in);
        System.out.println("신용카드 정보를 입력해주세요.");
        System.out.print("이름: ");
        String name = s.nextLine();
        System.out.print("카드 번호(16자리): ");
        String cardnum = s.nextLine();
        System.out.print("유효기간(MM/YY): ");
        String exp = s.nextLine();
        System.out.println("*****************************************\n");
        System.out.println("이름: " + name);
        System.out.println("카드 번호(16자리): " + cardnum);
        System.out.println("유효기간: " + exp);
        System.out.println("총 결제 가격: USD " + OrderItem.getTotalPrice());
        System.out.println("결제가 완료되었습니다!");
    }

    /**
     * 마지막 페이지
     */
    public static void thanks() {
        System.out.println("*****************************************\n");
        System.out.println("피자 가게에 방문해주셔서 감사합니다!\n");
        System.out.println("*****************************************\n");
    }
}

/**
 * 사용자가 입력하는 부분에서 잘못된 값를 입력했을 때 호출됨
 */
class InvalidInputException extends Exception {
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String msg) {
        super(msg);
    }
}

class InvalidSettingException extends Exception {
    public InvalidSettingException() {
        super();
    }

    public InvalidSettingException(String msg) {
        super(msg);
    }
}