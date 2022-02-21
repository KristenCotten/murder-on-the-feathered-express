package com.murderexpress.client;

import com.murderexpress.StoryLine;

class MurderClient {
    public static void main(String[] args) {
        String scene1 = "one";
        String scene2 = "two";
        String scene3 = "three";
        StoryLine storyLine1 = new StoryLine(scene1, scene2, scene3);
        // test questions and answers


        //first question
        storyLine1.getScene1();
        storyLine1.getTrivia();
        storyLine1.getQuestion();
        storyLine1.checkAnswer("f");
        System.out.println();

        // second question
        storyLine1.getScene2();
        storyLine1.getTrivia();
        storyLine1.getQuestion();
        storyLine1.checkAnswer("t");
        System.out.println();

        // third question
        storyLine1.getScene3();
        storyLine1.getTrivia();
        storyLine1.getQuestion();
        storyLine1.checkAnswer("t");
        System.out.println();

        // final question
        storyLine1.getTrivia();
        storyLine1.getQuestion();
        storyLine1.checkAnswer("t");
        System.out.println();


    }
}