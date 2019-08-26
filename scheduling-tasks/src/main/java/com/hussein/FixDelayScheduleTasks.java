package com.hussein;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: FixDelayScheduleTasks</p>
 * <p>Description: 延迟定时任务两次任务的间隔是fixedDelay+执行时间</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/26 2:22 PM
 */
@Component
public class FixDelayScheduleTasks {

    @Scheduled(fixedDelay = 5000L)
    public void currentTime() {
        System.out.println("now: " + LocalDate.now() + " " + LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
