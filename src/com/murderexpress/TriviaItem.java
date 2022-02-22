package com.murderexpress;

public class TriviaItem {
    private int id;
    private String question;
    private String answer;

    public TriviaItem(int id, String question, String answer) {
        this.id = id;
        setQuestion(question);
        setAnswer(answer);
    }

    //Accessor Methods
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    private void setQuestion(String question) {
        this.question = question;
    }

    private void setAnswer(String answer) {
        this.answer = answer;
    }
}