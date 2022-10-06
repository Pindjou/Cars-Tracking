module com.example.vpsallaumlines {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.vpindjou.Vpsallaumlines to javafx.fxml;
    exports com.vpindjou.Vpsallaumlines;
}