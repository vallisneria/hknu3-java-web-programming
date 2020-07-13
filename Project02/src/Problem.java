/*
    Author: 이경묵(Gyeong-Muk Lee)
    Email: moogi3469@hknu.ac.kr
    Course: Java Programming
    Assignment: Programming Assignment 2
    Due Date: 08 June 2020

    File: Problem.java
    Purpose: 문제 내용/정답/시도 횟수 등 구현

    Compiler/IDE: Openjdk 1.8.0_242 / Intellij IDEA 2020.1
    Operating System: Windows 10

    References: Java 8 API - Oracle Documentation                   (http://docs.oracle.com/javase/8/docs/api/)
*/

public class Problem {
    private Integer operand1, operand2;
    private Operator operator;
    private Integer tries = 1;

    public Problem() {
        this.InitArguments();
        this.InitOperator();
    }

    /**
     * 이 문제의 결과를 반환하는 함수
     *
     * @return 문제의 정답
     */
    public Integer Answer() {
        return this.operator.result();
    }

    /**
     * GUI에서 문제를 텍스트로 나타내기 위해 String으로 변환하는 함수
     *
     * @return (피연산자1) (연산자) (피연산자2)꼴의 문자열
     */
    public String toString() {
        return this.operand1 + " " + this.operator.toString() + " " + this.operand2;
    }

    /**
     * 해당 문제 푸는 것을 몇 번 시도했는지 반환하는 함수
     *
     * @return 문제 풀이 시도 횟수
     */
    public Integer getTries() {
        return this.tries;
    }

    /**
     * 시도 횟수를 1회 증가시키는 함수
     */
    public void setTriesOneUp() {
        this.tries++;
    }

    /**
     * 피연산자를 초기화하는 함수
     * (생성자에서만 호출)
     */
    private void InitArguments() {
        this.operand1 = (int) (Math.random() * 9) + 1;
        this.operand2 = (int) (Math.random() * 9) + 1;
    }

    /**
     * 연산자를 초기화하는 함수
     * (생성자에서만 호출)
     */
    private void InitOperator() {
        switch ((int) (Math.random() * 3)) {
            case 0:
                this.operator = new Plus();
                break;
            case 1:
                this.operator = new Minus();
                break;
            case 2:
                this.operator = new Multiple();
                break;
        }
    }

    /**
     * 연산자 인터페이스
     */
    interface Operator {
        public Integer result();
    }

    /**
     * 덧셈 클래스
     */
    class Plus implements Operator {
        public Integer result() {
            return operand1 + operand2;
        }

        public String toString() {
            return "plus";
        }
    }

    /**
     * 뺄셈 클래스
     */
    class Minus implements Operator {
        public Integer result() {
            return operand1 - operand2;
        }

        public String toString() {
            return "minus";
        }
    }

    /**
     * 곱셈 클래스
     */
    class Multiple implements Operator {
        public Integer result() {
            return operand1 * operand2;
        }

        public String toString() {
            return "times";
        }
    }
}
