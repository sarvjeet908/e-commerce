package com.example.payment_service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class Schedule_demo {
    @Scheduled(cron = "*/5 * * * * *")
   public  void  print_time_and_details(){
       System.out.println("hello world !"+ LocalDateTime.now());
   }
}
