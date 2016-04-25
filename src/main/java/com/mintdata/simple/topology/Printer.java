package com.mintdata.simple.topology;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mint.api.annotation.Component;
import mint.api.annotation.Input;

@Component
public class Printer {
    @Input
    public void onData(String data) {
        logger.info("Data received: {}", data);
    }

    private static final Logger logger = LoggerFactory.getLogger(Printer.class);
}
