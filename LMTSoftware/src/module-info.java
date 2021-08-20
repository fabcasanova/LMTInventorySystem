module LMTSoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;
    requires java.sql.rowset;
    requires org.testng;

    opens phatsmalone.com.Main;
}