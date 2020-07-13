package ch04_02;

import java.io.*;

public class QuizCard implements Serializable {
    private String uniqueID;
    private String category;
    private String question;
    private String answer;
    private String hint;

    public QuizCard(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    public void setUniqueID(String id) {
        this.uniqueID = id;
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return this.hint;
    }
}
