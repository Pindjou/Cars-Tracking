package com.vpindjou.Vpsallaumlines;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GuiTrack {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onBtnTrackClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}