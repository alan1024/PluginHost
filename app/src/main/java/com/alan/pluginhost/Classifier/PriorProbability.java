package com.alan.pluginhost.Classifier;

public class PriorProbability {
    private static TrainingDataManager tdm = TrainingDataManager.getInstance();

    /**
     * �������
     *
     * @param c �����ķ���
     * @return ���������µ��������
     */
    public static float calculatePc(String c) {
        float ret = 0F;
        float Nc = tdm.getTrainingFileCountOfClassification(c);
        float N = tdm.getTrainingFileCount();
        ret = Nc / N;
        return ret;
    }
}