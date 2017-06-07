package com.dalex.alarm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 9285314 on 5/18/2017.
 */
public class Alarm {

    private static int hour, minute, second, day;
    private static boolean isRunning;

    public static void save() throws IOException {
        FileWriter fw = new FileWriter("alarms.txt");
        fw.write(hour+minute+second+day);
        fw.close();
    }

    public static int getHour() {
        return hour;
    }

    public static void setHour(int hour) {
        Alarm.hour = hour;
    }

    public static int getMinute() {
        return minute;
    }

    public static void setMinute(int minute) {
        Alarm.minute = minute;
    }

    public static int getSecond() {
        return second;
    }

    public static void setSecond(int second) {
        Alarm.second = second;
    }

    public static int getDay() {
        return day;
    }

    public static void setDay(int day) {
        Alarm.day = day;
    }

    public static boolean isIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean isRunning) {
        Alarm.isRunning = isRunning;
    }
}
