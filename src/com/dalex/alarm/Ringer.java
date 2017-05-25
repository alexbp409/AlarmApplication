package com.dalex.alarm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alex on 5/18/2017.
 */
public class Ringer implements Runnable {

    public Ringer() {

    }

    public void ring() {

        String soundEffect = new String("ring.mp3");
        Media sound = new Media(new File(soundEffect).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlarmPopUp.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("RING!!!");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void run() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                /*if (Alarm.localDate.getMonth() == Month.APRIL) {
                    ring();
                }*/
                System.out.println(LocalTime.now());
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}

