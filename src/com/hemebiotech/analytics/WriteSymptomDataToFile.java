package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeMap;

/**
 * implements ISymptomWriter interface
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePathOut;

    /**
     *@param filePathOut a path to file where symptoms and occurrence will be written.
     */

    public WriteSymptomDataToFile(String filePathOut) {
        this.filePathOut = filePathOut;
    }

    /**
     * uses FileWriter and bufferedWriter to read through a TreeMap containing Each symptom with number of occurrence and write the data to a file.
     */
    public void writeSymptoms(TreeMap<String, Integer> symptoms) {
        try {

            File file = new File(filePathOut);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Set<String> symptomSet = symptoms.keySet();
            for (String key : symptomSet) {
                bufferedWriter.write(key + " " + symptoms.get(key) + "\n");
            }


            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
