
package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * counts symptoms from a String List
 */
public class AnalyticsCounter {
    private List<String> symptoms;

    /**
     * @param symptoms a list of unordered Strings containing symptoms that may contain many duplications
     */
    public AnalyticsCounter(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    /**
     * @return an ordered TreeMap with key= Symptoms and value= occurrence
     */
    public TreeMap<String, Integer> countSymptoms() {
        TreeMap<String, Integer> treeMapSymptom = new TreeMap<>();

        for (String word : symptoms) {
            if (treeMapSymptom.containsKey(word)) {
                treeMapSymptom.put(word, treeMapSymptom.get(word) + 1);
            } else {
                treeMapSymptom.put(word, 1);
            }
        }
        return treeMapSymptom;
    }
}
