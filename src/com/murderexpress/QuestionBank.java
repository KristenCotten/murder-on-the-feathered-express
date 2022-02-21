package com.murderexpress;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public List<TriviaItem> triviaData = new ArrayList<>(List.of(
            new TriviaItem( 1, "There can only be one main method.", "T"),
            new TriviaItem(2, "Java is not portable.", "F"),
            new TriviaItem(3, "The default value for primitive types that are not explicitly initialized is 'null'", "F"),
            new TriviaItem(4, "A method can be marked as private.", "T"),
            new TriviaItem(5, "It is safe to compare Strings with ==.", "F"),
            new TriviaItem(6, "Throwable is the superclass of all exceptions.", "T"),
            new TriviaItem(7, "The JUnit test runner executes our tests in the order they appear in the class.", "F"),
            new TriviaItem(8, "Java bytecode uses the .byte extension", "F"),
            new TriviaItem(9, "Duplicates are allowed in sets.", "F"),
            new TriviaItem(10, "The comparable interface defines the natural order of a class.", "T")
    )
    );

}