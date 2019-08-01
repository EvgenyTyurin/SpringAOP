package evgenyt.springdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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

    // Executes before and after play()
    @Around("execution(* evgenyt.springdemo.MusicPlayer.play(..))")
    public void aroundPlay(ProceedingJoinPoint joinPoint) {
        try {
            // Before section
            long startTime = System.currentTimeMillis();
            System.out.println("Timer started");
            // Starting play()
            joinPoint.proceed();
            // After section
            long endTime = System.currentTimeMillis();
            System.out.println("Music played in " + (endTime - startTime) + " milliseconds.");
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    // Pointcut to provide music argument of play() to collectMusic below
    @Pointcut("execution(* evgenyt.springdemo.MusicPlayer.play(String)) && args(music)")
    public void pointCutPlay(String music) {}

    // Intercept music parameter of play() using pointcut above
    @Before("pointCutPlay(music)")
    public void collectMusic(String music) {
        System.out.println("Collected: " + music);
    }
}
