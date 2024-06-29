package com.surabhi.sentiment_analysis.controller;

import com.surabhi.sentiment_analysis.service.SentimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SentimentController {

    @Autowired
    private SentimentService sentimentService;

    @PostMapping("/sentiment")
    public String getSentiment(@RequestBody String text) {
        return sentimentService.analyzeSentiment(text);
    }
}

