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

    public static LocalTime localTime;
    public static LocalDate localDate;


    public static void save() throws IOException {
        FileWriter fw = new FileWriter("alarms.txt");
        //fw.write
        fw.close();
    }
}
