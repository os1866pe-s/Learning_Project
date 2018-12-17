package appIdeas;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Time extends JFrame {
    public static void main(String[] args) {


        Calendar d = Calendar.getInstance(TimeZone.getDefault());


        System.out.println("Day : " + LocalDate.now().getDayOfMonth());
        System.out.println("Week: " + d.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Month : " + LocalDate.now().getMonthValue());
        System.out.println("Year : " + LocalDate.now().getYear());
        System.out.println("Time : " + ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());


        new Time();


    }

    public Time(){
        Calendar d = Calendar.getInstance(TimeZone.getDefault());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(150, 150);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        JPanel p = new JPanel();

        p.add(new JLabel(Integer.toString(d.get(Calendar.WEEK_OF_YEAR))));

        this.add(p);
        this.setVisible(true);
    }


}
