module com.company.fretefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.company.fretefx to javafx.fxml;
    exports com.company.fretefx;
}