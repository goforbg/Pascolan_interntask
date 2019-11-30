package com.androar.pascolan;

import java.io.Serializable;

public class Topic implements Serializable {

    public String topicNumber;
    public String topicNameEng;
    public String topicNameHindi;
    public String topicImage;

    public Topic() {
    }

    public Topic(String topicNumber, String topicNameEng, String topicNameHindi, String topicImage) {
        this.topicNumber = topicNumber;
        this.topicNameEng = topicNameEng;
        this.topicNameHindi = topicNameHindi;
        this.topicImage = topicImage;
    }

    public String getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(String topicNumber) {
        this.topicNumber = topicNumber;
    }

    public String getTopicNameEng() {
        return topicNameEng;
    }

    public void setTopicNameEng(String topicNameEng) {
        this.topicNameEng = topicNameEng;
    }

    public String getTopicNameHindi() {
        return topicNameHindi;
    }

    public void setTopicNameHindi(String topicNameHindi) {
        this.topicNameHindi = topicNameHindi;
    }

    public String getTopicImage() {
        return topicImage;
    }

    public void setTopicImage(String topicImage) {
        this.topicImage = topicImage;
    }
}
