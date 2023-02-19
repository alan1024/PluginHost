package com.alan.pluginhost.Classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapMaker {
    public void make(String ditrectory) {
        File f = new File(ditrectory);
        for (File ff : f.listFiles()) {
            Map<String, Double> map = null;
            String[] extensions = {"txt", "TXT"};
            map = new HashMap<String, Double>();
            Iterator<File> iterateFiles = new Iterator<File>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public File next() {
                    return null;
                }
            };
            while (iterateFiles.hasNext()) {
                File current = iterateFiles.next();
                for (String key : extractSingle(current)) {
                    double freq = (double) (map.get(key) == null ? 0
                            : (double) map.get(key));
                    map.put(key, freq == 0 ? 1 : freq + 1);
                }
            }
            try {
                if (new File(ff + "//map").exists())
                    new File(ff + "//map").delete();
                FileOutputStream os = new FileOutputStream(ff + "//map");
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeObject(map);
                oos.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 抽取单个文件的词,返回一个Set
     *
     * @param current
     * @return
     * @author GS
     */
    public Set<String> extractSingle(File current) {
        FileReader d = null;
        Set<String> list = new HashSet<String>();// sped aritical
        try {
            d = new FileReader(current);
            while (true) {
                try {
                    String a = "";
                    if (!list.contains(a) && a.length() > 1
                            && a.matches(".*[\u4e00-\u9faf].*")) {
                        list.add(a);
                    }
                } catch (NullPointerException e) {
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
