package com.murderexpress;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public List<TriviaItem> triviaData = new ArrayList<>(List.of(
            new TriviaItem( 1, "Interfaces can be placed in packages.", "t"),
            new TriviaItem(2, "Does order matter in treemap", "t"),
            new TriviaItem(3, "The JUnit test runner executes your tests alphabetically.", "f"),
            new TriviaItem(4, "Exceptions are objects, but they are not instantiated with new.", "f"))
    );

}