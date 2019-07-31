package evgenyt.springdemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Logger for MusicPlayer
 */

@Aspect
public class PlayerLogger {
    @Before("execution(* evgenyt.springdemo.MusicPlayer.play(..))")
    public void beforePlay() {
        System.out.println("Logger: Starting play music.");
    }

    @After("execution(* evgenyt.springdemo.MusicPlayer.play(..))")
    public void afterPlay() {
        System.out.println("Logger: Music played");
    }
}
