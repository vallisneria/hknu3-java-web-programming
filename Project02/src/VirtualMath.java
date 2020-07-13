/*
    Author: 이경묵(Gyeong-Muk Lee)
    Email: moogi3469@hknu.ac.kr
    Course: Java Programming
    Assignment: Programming Assignment 2
    Due Date: 08 June 2020

    File: VirtualMath.java
    Purpose: 어플리케이션 GUI 구현

    Compiler/IDE: Openjdk 1.8.0_242 / Intellij IDEA 2020.1
    Operating System: Windows 10

    References: Java 8 API - Oracle Documentation                   (http://docs.oracle.com/javase/8/docs/api/)
                Stackoverflow - Detect enter press in JTextField    (https://stackoverflow.com/questions/4419667/detect-enter-press-in-jtextfield)

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualMath {
    static JFrame MainFrame;

    static JLabel Question;

    static JPanel AnswerFieldPanel;
    static JLabel Result;
    static JTextField AnswerField;

    static JButton NewProblemButton;

    static Problem problem;

    public static void main(String[] args) {
        MainFrame = new JFrame("Virtual Math Tutor - 2018250038 이경묵");
        Question = new JLabel();
        AnswerFieldPanel = new JPanel();
        Result = new JLabel();
        AnswerField = new JTextField(10);
        NewProblemButton = new JButton("새로운 문제");

        AnswerField.addActionListener(new AnswerFieldEnterPressEvent());
        NewProblemButton.addActionListener(new NewProblemButtonEvent());

        QuestionLabelChange();
        ResultLabelInit();
        AnswerFieldPanel.add(BorderLayout.WEST, Result);
        AnswerFieldPanel.add(BorderLayout.EAST, AnswerField);

        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainFrame.getContentPane().add(BorderLayout.NORTH, Question);
        MainFrame.getContentPane().add(BorderLayout.CENTER, AnswerFieldPanel);
        MainFrame.getContentPane().add(BorderLayout.SOUTH, NewProblemButton);

        MainFrame.setSize(600, 350);
        MainFrame.setVisible(true);
    }

    /**
     * 문제를 변경하고 GUI에 적용하는 함수
     */
    private static void QuestionLabelChange() {
        problem = new Problem();
        Question.setText(problem.toString() + "의 값은 무엇일까요?");
    }

    /**
     * 텍스트 상자 옆에 '정답을 입력해 주세요' 가 화면에 표시되도록 하는 함수
     */
    private static void ResultLabelInit() {
        Result.setText("정답을 입력해 주세요");
    }

    /**
     * 문제가 맞았을 경우 실행되는 함수
     */
    private static void ResultLabelRightAnswer() {
        Result.setText("정답입니다! (" + problem.getTries() + "회 시도)");
    }

    /**
     * 문제가 틀렸을 경우 실행되는 함수
     */
    private static void ResultLabelWrongAnswer() {
        Result.setText("틀렸습니다! 다시 시도해 보세요!");
        problem.setTriesOneUp();
        AnswerField.setText("");
    }

    /**
     * 새로운 문제 클릭 이벤트
     */
    private static class NewProblemButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            QuestionLabelChange();
            ResultLabelInit();
            AnswerField.setText("");
        }
    }

    /**
     * 답을 입력하고 Enter를 눌렀을 때 발생하는 이벤트
     */
    private static class AnswerFieldEnterPressEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (Integer.parseInt(AnswerField.getText()) == problem.Answer()) {
                // 정답일 때
                ResultLabelRightAnswer();
            } else {
                // 오답일 때
                ResultLabelWrongAnswer();
            }
        }
    }
}
