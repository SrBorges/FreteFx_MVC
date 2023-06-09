package com.company.fretefx;

import com.company.fretefx.model.Conex;
import com.company.fretefx.model.ControllerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.text.ParseException;

public class ViewController implements ControllerDAO {

    public String dtviagem;
    public String empresa;
    public String vlrfrete;
    public String pedagio;
    public String combustivel;
    public String quilomatragem;
    public String codviagem;
    public String cidade;
    public String estado;
    public String vlrpago;
    public int atualizar, excluir;


    @FXML
    protected TextField tf01;

    @FXML
    protected TextField tf02;

    @FXML
    protected TextField tf03;

    @FXML
    protected TextField tf04;

    @FXML
    protected TextField tf05;

    @FXML
    protected TextField tf06;

    @FXML
    protected TextField tf07;

    @FXML
    protected TextField tf08;

    @FXML
    protected TextField tf09;

    @FXML
    protected TextField tf10;

    @FXML
    protected TextField tf11;

    @FXML
    protected TextField tf12;

    @FXML
    protected TextField tf13;

    @FXML
    protected Label lb01;

    @FXML
    protected Label lb02;

    @FXML
    protected Label lb03;

    @FXML
    protected Label lb04;

    @FXML
    protected Label lb05;

    @FXML
    protected Label lb06;

    @FXML
    protected Label lb07;

    @FXML
    protected Label lb08;

    @FXML
    protected Label lb09;

    @FXML
    protected Label lb10;

    @FXML
    protected Label lb11;


    @FXML
    protected Button bt01;

    @FXML
    protected Button bt02;

    @FXML
    protected Button bt03;

    @FXML
    protected Button bt04;

    Conex conex = new Conex();

    @Override
    public void create() {

        Connection conn = null;
        PreparedStatement st = null;

        dtviagem = tf01.getText();
        empresa = tf02.getText();
        vlrfrete = tf03.getText();
        pedagio = tf04.getText();
        combustivel = tf05.getText();
        quilomatragem = tf06.getText();
        codviagem = tf07.getText();
        cidade = tf08.getText();
        estado = tf09.getText();
        vlrpago = tf10.getText();


        try {
            conn = conex.conex();
            st = conn.prepareStatement("INSERT INTO study.fretefx" +
                    "(dtviagem, empresa, vlrfrete, pedagio, combustivel, quilometragem, codviagem, " +
                    "cidade, estado, vlrpago)" +
                    "VALUES" +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, dtviagem);
            st.setString(2, empresa);
            st.setString(3, vlrfrete);
            st.setString(4, pedagio);
            st.setString(5, combustivel);
            st.setString(6, quilomatragem);
            st.setString(7, codviagem);
            st.setString(8, cidade);
            st.setString(9, estado);
            st.setString(10, vlrpago);


            int rowsAffected = st.executeUpdate();

            System.out.println("Row Affected " + rowsAffected);

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                conn.close();
            } catch (SQLException e) {


                throw new RuntimeException(e);
            }
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void read() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            conn = conex.conex();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM study.fretefx");

            while (rs.next()) {

                lb11.setText(String.valueOf(rs.getInt("id")));
                lb01.setText(rs.getString("dtviagem"));
                lb02.setText(rs.getString("empresa"));
                lb03.setText(rs.getString("vlrfrete"));
                lb04.setText(rs.getString("pedagio"));
                lb05.setText(rs.getString("combustivel"));
                lb06.setText(rs.getString("quilometragem"));
                lb07.setText(rs.getString("codviagem"));
                lb08.setText(rs.getString("cidade"));
                lb09.setText(rs.getString("estado"));
                lb10.setText(rs.getString("vlrpago"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                rs.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void update() {

        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = conex.conex();
            st = conn.prepareStatement("UPDATE study.fretefx " +
                    "SET vlrfrete = vlrfrete + ? " +
                    "WHERE " +
                    "(id = ?) ");


            vlrfrete = tf11.getText();
            atualizar = Integer.parseInt(tf12.getText());


            st.setString(1, vlrfrete);
            st.setInt(2, atualizar);    // O segundo número é o ID do usuário cadastrado




            int rowsAffected = st.executeUpdate();

            System.out.println("Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            try {

                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete() {

        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = conex.conex();
            st = conn.prepareStatement("DELETE FROM study.fretefx "
                    + "WHERE " +
                    "id = ? ");

            excluir = Integer.parseInt(tf13.getText());

            st.setInt(1, excluir);


            int rowsAffected = st.executeUpdate();

            System.out.println("Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}


