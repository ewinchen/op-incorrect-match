package com.example;

import com.example.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private AppService appService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        appService.solve();
    }
}
