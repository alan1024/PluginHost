package com.alan.pluginhost.Classifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class TrainingDataManager {
    //private static String defaultPath = "D:\\Lucene\\docs\\ѵ���������ı�\\";
    //private static String defaultPath = "D:\\Lucene\\ClassFile\\";
    //private static String defaultPath = "D:\\Lucene\\����ѵ����������Ͽ�\\DRAP�ṩ�Ĳ���ѵ������\\TanCorpMinTrain\\";
    //private static String defaultPath = "D:\\Lucene\\����ѵ����������Ͽ�\\��������½�ṩ�����Ͽ�\\";
    private static String defaultPath = "D:\\Lucene\\Corpus\\";
    private static TrainingDataManager ini = new TrainingDataManager();
    private String[] traningFileClassifications;//ѵ�����Ϸ��༯��
    private File traningTextDir;//ѵ�����ϴ��Ŀ¼
    //private static String defaultPath = "/opt/Test/Corpus";
    //private static String defaultPath = "D:\\Lucene\\����ѵ����������Ͽ�\\DRAP�ṩ�Ĳ���ѵ������\\Corpus\\";
    private Map<String, Map<String, Double>> classMap = new HashMap<String, Map<String, Double>>();

    @SuppressWarnings("unchecked")
    private TrainingDataManager() {
        traningTextDir = new File(defaultPath);
        if (!traningTextDir.isDirectory()) {
            throw new IllegalArgumentException("ѵ�����Ͽ�����ʧ�ܣ� [" + defaultPath + "]");
        }
        this.traningFileClassifications = traningTextDir.list();
        //��������Map
        String ss[] = traningTextDir.list();
        for (int i = 0; i < ss.length; i++) {
            Map<String, Double> map = new HashMap<String, Double>();
            ObjectInputStream ois = null;
            try {
                FileInputStream is = new FileInputStream(defaultPath + ss[i] + "\\map");
                ois = new ObjectInputStream(is);
                map = (Map<String, Double>) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            classMap.put(ss[i], map);
            map = null;
        }
    }

    public static TrainingDataManager getInstance() {
        return ini;
    }

    /**
     * ���ظ���·�����ı��ļ�����
     *
     * @param filePath �������ı��ļ�·��
     * @return �ı�����
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String getText(String filePath) throws FileNotFoundException, IOException {

        InputStreamReader isReader = new InputStreamReader(new FileInputStream(filePath), "GBK");
        BufferedReader reader = new BufferedReader(isReader);
        String aline;
        StringBuilder sb = new StringBuilder();

        while ((aline = reader.readLine()) != null) {
            sb.append(aline + " ");
        }
        isReader.close();
        reader.close();
        return sb.toString();
    }

    /**
     * ����ѵ���ı�������������Ŀ¼��
     *
     * @return ѵ���ı����
     */
    public String[] getTraningClassifications() {
        return this.traningFileClassifications;
    }

    /**
     * ����ѵ���ı���𷵻��������µ�����ѵ���ı�·����full path��
     *
     * @param classification �����ķ���
     * @return ���������������ļ���·����full path��
     */
    public String[] getFilesPath(String classification) {
        File classDir = new File(traningTextDir.getPath() + File.separator + classification);
        String[] ret = classDir.list();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = traningTextDir.getPath() + File.separator + classification + File.separator + ret[i];
        }
        return ret;
    }

    /**
     * ����ѵ���ı��������е��ı���Ŀ
     *
     * @return ѵ���ı��������е��ı���Ŀ
     */
    public int getTrainingFileCount() {
        int ret = 0;
        for (int i = 0; i < traningFileClassifications.length; i++) {
            ret += getTrainingFileCountOfClassification(traningFileClassifications[i]);
        }
        return ret;
    }

    /**
     * ����ѵ���ı������ڸ��������µ�ѵ���ı���Ŀ
     *
     * @param classification �����ķ���
     * @return ѵ���ı������ڸ��������µ�ѵ���ı���Ŀ
     */
    public int getTrainingFileCountOfClassification(String classification) {
        File classDir = new File(traningTextDir.getPath() + File.separator + classification);
        return classDir.list().length;
    }

    /**
     * ���ظ��������а����ؼ��֣��ʵ�ѵ���ı�����Ŀ
     *
     * @param classification �����ķ���
     * @param key            �����Ĺؼ��֣���
     * @return ���������а����ؼ��֣��ʵ�ѵ���ı�����Ŀ
     */
    public int getCountContainKeyOfClassification(String classification, String key) {
        int ret = 0;
        ret = (int) (classMap.get(classification).containsKey(key) ? classMap.get(classification).get(key) : 0);
        return ret;
    }
}