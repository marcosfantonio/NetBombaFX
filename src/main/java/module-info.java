module alture.netbombafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens alture.netbombafx to javafx.fxml;
    exports alture.netbombafx;
}