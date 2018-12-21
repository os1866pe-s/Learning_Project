package Test;
import sun.util.resources.CalendarData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class Time extends JFrame {
    public static void main(String[] args) {


        Calendar d = Calendar.getInstance(TimeZone.getDefault());

        System.out.println("Day : " + LocalDate.now().getDayOfMonth() + " " + LocalDate.now().getDayOfWeek());
        System.out.println("Month : " + LocalDate.now().getMonthValue());
        System.out.println("Year : " + LocalDate.now().getYear());
        System.out.println("Time : " + ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTimeZone());

        //new Time();


    }

    public Time(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        p.add(new JLabel(String.valueOf(ZonedDateTime.now().getSecond())));

        this.add(p);
        this.setVisible(true);
    }


}
