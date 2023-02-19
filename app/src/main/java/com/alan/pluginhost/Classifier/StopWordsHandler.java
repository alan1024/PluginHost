package com.alan.pluginhost.Classifier;

import java.util.HashSet;
import java.util.Set;

public class StopWordsHandler {
    public static boolean IsStopWord(String word) {
        Set<String> set = new HashSet<String>();
//		try {
////			for (String e : FileUtils.readLines(new File("D://Test//ChineseStopwords.txt"))) {
////				set.add(e);
////			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        if (set.contains(word)) return true;
        return false;
    }
}
