package com.gmail.ivan200sx.metaData.sheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.gmail.ivan200sx.metaData.WebWetherTts;

@Component
public class ScheduledLoader {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledLoader.class);

    
    private WebWetherTts webWetherTts;

    private  Double lastTemp = 0d ;

    @Autowired
    public ScheduledLoader(WebWetherTts webWetherTts){
      this.webWetherTts = webWetherTts;
    }


    @Scheduled(fixedRate = 1000)
    public void runLoader() {
      lastTemp = Double.valueOf(webWetherTts.getTtsToWeb());
      System.out.println("Loader started with delay");      
    }

    public Double getLastTemp() {
      return lastTemp;
    }
}
