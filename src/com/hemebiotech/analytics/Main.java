package com.hemebiotech.analytics;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.List;
import java.util.TreeMap;

/**
 * main class that defines the external files to read from and write to
 * execute in this order:
 * 1) instantiate a new class of ISymptomReader and execute getSymptoms(), the method that reads and stores in a String List the symptoms from the defined external file
 * 2) instantiate a new class of AnalyticsCounter and execute countSymptoms(), the method that counts the number of occurrence of each symptoms from the String List and return a sorted TreeMap with the symptoms as key and their occurrence as value
 * 3) instantiate a new class of ISymptomWriter and execute writeSymptoms(), the method that writes the TreeMap content into the defined external file.
 */


public class Main {

    /**
     * @param args indicate the files to read from and to write to.
     */
    public static void main(String[] args) {

        String fileToRead = "symptoms.txt";
        String fileToWrite = "result.out";

        ISymptomReader symptomReader = new ReadSymptomDataFromFile(fileToRead);
        List<String> readSymptoms = symptomReader.getSymptoms();

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptoms);
        TreeMap<String, Integer> countSymptoms = analyticsCounter.countSymptoms();

        ISymptomWriter writer = new WriteSymptomDataToFile(fileToWrite);
        writer.writeSymptoms(countSymptoms);


    }
}