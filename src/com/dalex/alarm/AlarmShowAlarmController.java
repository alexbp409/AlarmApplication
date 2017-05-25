package com.dalex.alarm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AlarmShowAlarmController implements Initializable {

    @FXML
    private JFXButton btn_close_show_alarm;

    @FXML
    private Label display_time;

    @FXML
    private Label display_date;

    @FXML
    void close(ActionEvent event) {
        btn_close_show_alarm.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Alarm.localDate != null && Alarm.localTime != null) {
            display_time.setText(Alarm.localTime.toString());
            display_date.setText(Alarm.localDate.toString());
        }
    }
}
