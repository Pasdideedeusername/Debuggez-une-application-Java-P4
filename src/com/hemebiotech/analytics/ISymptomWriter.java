package com.hemebiotech.analytics;

import java.util.TreeMap;


/**
 * Anything that will write data on a valid data output format
 */
public interface ISymptomWriter {

    public void writeSymptoms(TreeMap<String, Integer> symptoms);
}
