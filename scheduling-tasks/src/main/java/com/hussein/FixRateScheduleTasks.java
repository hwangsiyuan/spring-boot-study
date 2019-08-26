package com.hussein;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: FixRateScheduleTasks</p>
 * <p>Description: 固定频率的定时任务两次执行的间隔为fixRate与执行时间中最大的一个</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/26 2:06 PM
 */
@Component
public class FixRateScheduleTasks {

    @Scheduled(fixedRate = 5000L)
    public void currentTime() {
        System.out.println("now: " + LocalDate.now() + " " + LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
