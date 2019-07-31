package evgenyt.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aspects demo.
 * We have MusicPlayer and aspect PlayerLogger that monitor player actions
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
       // musicPlayer is a component defined in MusicPlayer.java
       MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
       musicPlayer.play();
       context.close();
    }
}
