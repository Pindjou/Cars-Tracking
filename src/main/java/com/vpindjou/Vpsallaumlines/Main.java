package com.vpindjou.Vpsallaumlines;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GuiManager.getInstance().openGuiShowTrack(stage);
        GuiManager.getInstance().openGuiTrack();   }

    public static void main(String[] args) {
        launch();
    }
}