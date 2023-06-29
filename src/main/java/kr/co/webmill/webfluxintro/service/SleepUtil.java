package kr.co.webmill.webfluxintro.service;

public class SleepUtil {
    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception ex){}
    }
}
