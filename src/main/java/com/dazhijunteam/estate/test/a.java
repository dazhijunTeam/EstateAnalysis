package com.dazhijunteam.estate.test;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;


public class a {
    private AtomicInteger number = new AtomicInteger();



    @Scheduled(fixedRate = 100)
    public void job() {
        LocalTime start = LocalTime.now();
        System.out.println(Thread.currentThread() + " start " + number.incrementAndGet() + " @ "  + start);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2) * 1000);
        } catch (InterruptedException e) {
        }
        LocalTime end = LocalTime.now();
        System.out.println(Thread.currentThread() + " end " + number.get() + " @ " + end
                + ", seconds cost " + (ChronoUnit.SECONDS.between(start, end)));
    }
    public static void main(String[] args){
        String a="https://pic1.ajkimg.com/display/xinfang/7b5c7c6e47d01961033d9d3fff392bda/200x140n.jpg";
        String v="\\u70ed\\u70b9";
        System.out.println(v);

    }
}

