package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filePathIn;

    /**
     * @param filePathIn a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filePathIn) {
        this.filePathIn = filePathIn;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (this.filePathIn != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(this.filePathIn));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}