package com.dalex.alarm;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import eu.hansolo.medusa.Clock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AlarmGUIController implements Initializable {

    private boolean run = true;
    private Ringer ringer;
    private Thread thread = new Thread(ringer);

    @FXML
    private JFXTimePicker time;

    @FXML
    private JFXDatePicker date;

    @FXML
    private Clock clock;

    @FXML
    private Label weather;

    @FXML
    private ImageView weather_icon;

    @FXML
    private JFXButton btn_help;

    @FXML
    private JFXButton btn_show_alarm;

    @FXML
    private JFXButton btn_add_alarm;

    @FXML
    private JFXButton btn_delete;

    @FXML
    void addAlarm(ActionEvent event) {

        LocalTime time = this.time.getValue();
        LocalDate date = this.date.getValue();

        if (time != null && date != null) {
            Alarm.setHour(time.getHour());
            Alarm.setMinute(time.getMinute());
            Alarm.setSecond(time.getSecond());

            Alarm.setDay(date.getDayOfYear());
        }
        System.out.println(Alarm.getDay());

        try {
            Alarm.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Alarm.setIsRunning(true);
    }

    @FXML
    void deleteAlarm(ActionEvent event) {
        Alarm.setDay(0);
        Alarm.setHour(0);
        Alarm.setMinute(0);
        Alarm.setSecond(0);
        Alarm.setIsRunning(false);
        System.out.println("Your alarm has been deleted.");
    }

    @FXML
    void openHelp(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlarmHelpPage.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Alarm Application Help");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void showALarms(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlarmShowAlarm.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Alarm Application Help");
        stage.setScene(new Scene(root1));


        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OpenWeatherMap owm = new OpenWeatherMap("43cc314d1d3638a6d66d158958b53fab");
        CurrentWeather cWeather = null;
        try {
            cWeather = owm.currentWeatherByCityName("Raleigh");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        weather.setText("Current Temp: " + Float.toString(cWeather.getMainInstance().getTemperature()) + "°F");

        weather_icon.setImage(new Image("file:sun.png"));

        //change order to make sense
        /*if (cWeather.getRainInstance().getRain() > new Float(.5)) {
            weather_icon.setImage(new Image("file:rain.png"));
        }*/
        if (cWeather.getCloudsInstance().getPercentageOfClouds() > new Float(.5)) {
            weather_icon.setImage(new Image("file:cloudy.png"));
        } else {
            weather_icon.setImage(new Image("file:partly.png"));
        }
    }
}

