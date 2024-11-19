package com.xadmin.sys.arcsoft;


public class ArcsoftVo {

    //人脸相似度
    private double similarity;

    //人脸特征码
    private String featureData;

    //其它数据集
    private Object data;

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public String getFeatureData() {
        return featureData;
    }

    public void setFeatureData(String featureData) {
        this.featureData = featureData;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}