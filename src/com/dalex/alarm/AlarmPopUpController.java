package com.dalex.alarm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlarmPopUpController {

    @FXML
    private JFXButton btn_close_window;

    @FXML
    private Label display_time;

    @FXML
    private Label display_date;

    @FXML
    private JFXButton btn_snooze;

    @FXML
    void snooze(ActionEvent event) {

    }

}
