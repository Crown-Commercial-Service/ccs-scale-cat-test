package com.scale.pojo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FTSEPojo {
    private String sampleTime;
    private String timeFrame;
    private String requestedDataSetType;
    private String chartPriceType;
    private String key;
    public String getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getRequestedDataSetType() {
        return requestedDataSetType;
    }

    public void setRequestedDataSetType(String requestedDataSetType) {
        this.requestedDataSetType = requestedDataSetType;
    }

    public String getChartPriceType() {
        return chartPriceType;
    }

    public void setChartPriceType(String chartPriceType) {
        this.chartPriceType = chartPriceType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
