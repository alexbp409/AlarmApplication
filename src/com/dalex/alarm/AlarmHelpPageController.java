package com.dalex.alarm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AlarmHelpPageController {

    @FXML
    private JFXButton btn_close_help;

    @FXML
    void close(ActionEvent event) {
        btn_close_help.getScene().getWindow().hide();
    }

}
