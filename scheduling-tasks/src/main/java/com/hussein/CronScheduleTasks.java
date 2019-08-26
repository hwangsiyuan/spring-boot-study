package com.hussein;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: CronScheduleTasks</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/26 2:33 PM
 */
@Component
public class CronScheduleTasks {

    @Scheduled(cron = "12 0/1 * * * * ")
    public void currentTime() {
        System.out.println("now: " + LocalDate.now() + " " + LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
