package com.murderexpress;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class QuestionBank {
    private Path dataFilePath;

    public QuestionBank(String dataFilePath) {
        this.dataFilePath = Path.of(dataFilePath);
    }

    public List<TriviaItem> load() throws IOException {
        List<TriviaItem> triviaData = new ArrayList<>();

        Files.lines(dataFilePath).forEach(line -> {
            String[] tokens = line.split(",");

            String question= tokens[0];
            String answer = tokens[1];

            triviaData.add(new TriviaItem(question,answer));
        });
        return triviaData;
    }

}



