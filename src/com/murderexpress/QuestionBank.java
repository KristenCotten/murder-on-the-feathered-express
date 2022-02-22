package com.murderexpress;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public List<TriviaItem> triviaData = new ArrayList<>(List.of(
            new TriviaItem( "There is typically one main method.", "T"),
            new TriviaItem( "Java is not portable.", "F"),
            new TriviaItem( "The default value for primitive types that are not explicitly initialized is 'null'", "F"),
            new TriviaItem( "A method can be marked as private.", "T"),
            new TriviaItem( "It is safe to compare Strings with ==.", "F"),
            new TriviaItem( "Throwable is the superclass of all exceptions.", "T"),
            new TriviaItem( "The JUnit test runner executes our tests in the order they appear in the class.", "F"),
            new TriviaItem( "Java bytecode uses the .byte extension", "F"),
            new TriviaItem( "Duplicates are allowed in sets.", "F"),
            new TriviaItem( "The comparable interface defines the natural order of a class.", "T"),
            new TriviaItem( "Anywhere a functional interface type is expected, a compatible lamba can be used.", "T"),
            new TriviaItem( "You schedule a thread for execution by invoking its run() method.", "F"),
            new TriviaItem( "A solution to race conditions is synchronization via locking mechanisms using mutexes.", "T"),
            new TriviaItem( "An inner class and a static nested class are the same.", "F"),
            new TriviaItem( "Annotations are not defined as an @interface.", "F"),
            new TriviaItem( "A lambda expression is the same as an anonymous method.", "T"),
            new TriviaItem( "Generics add type safety to collections.", "T"),
            new TriviaItem( "You may have duplicate keys in a Map.", "F"),
            new TriviaItem( "Every class has at least one constructor.", "T"),
            new TriviaItem( "Every field in the equals() check is used in hashcode().", "T"),
            new TriviaItem( "StringBuffer is not thread safe.", "F"),
            new TriviaItem( "Strings are immutable.", "T"),
            new TriviaItem( "Static fields are common, or shared among instances.", "T"),
            new TriviaItem( "A package is a collection of related classes.", "T"),
            new TriviaItem( "Using import statements are mandatory.", "F"),
            new TriviaItem( "You can change the length of an array after it has been created.", "F"),
            new TriviaItem( "A method must declare a checked exception via 'throws'.", "T"),
            new TriviaItem( "Interfaces are used to define but not implement behavior (methods).", "T"),
            new TriviaItem( "When writing test cases, it is best practice to have one test verify multiple pieces of functionality.", "F"),
            new TriviaItem( "Local variables can not be accessed outside the method in which they were declared.", "T")

    )
    );
}



