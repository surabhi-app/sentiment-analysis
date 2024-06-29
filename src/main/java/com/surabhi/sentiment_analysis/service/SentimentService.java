package com.surabhi.sentiment_analysis.service;

import edu.stanford.nlp.pipeline.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SentimentService {

    private StanfordCoreNLP pipeline;

    @PostConstruct
    public void init() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public String analyzeSentiment(String text) {
        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);
        return doc.sentences().get(0).sentiment();
    }
}

