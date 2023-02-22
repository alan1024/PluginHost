package com.alan.pluginhost.contentBased;

import com.alan.pluginhost.UserOperationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


public class ContentBasedRecommenderServiceImpl implements ContentBasedRecommenderService {
    private String tableName;

    private String userColumn;

    private String itemColumn;

    private String prefColumn;

    private int recommendNum;

    DataSource dataSource;

    UserOperationRepository userOperationRepository;

    public ContentBasedRecommenderServiceImpl() {

    }

    public void init() {
        try {
            // 注意需要先在 TrainVsmModel 中训练
            this.initParagraphVectors();
        } catch (Exception e) {
        }
    }

    private void initParagraphVectors() throws Exception {

    }

    @Override
    public List<Long> recommend(long userId) {
        List<Long> ret = new ArrayList<>();


        return ret;
    }

    @Override
    public Map<String, Double> evaluate() {


        return null;
    }

}
