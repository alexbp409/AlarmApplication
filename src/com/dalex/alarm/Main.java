package com.dalex.alarm;

import eu.hansolo.medusa.Clock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main extends Application {

    private Thread thread = new Thread(new Ringer());

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AlarmGUI.fxml"));
        primaryStage.setTitle("Alarm Application");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        thread.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
