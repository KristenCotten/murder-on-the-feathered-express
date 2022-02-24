package com.murderexpress;

class TriviaItem {
    private int id;
    private String question;
    private String answer;

    public TriviaItem(String question, String answer) {
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