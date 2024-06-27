package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LogInController extends Database  {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;
    private  static  Parent root1;
    private static  Parent root2;

    @FXML
    public Label AdminIme;

    @FXML
    public Label AdminPrezime;

    @FXML

    public Label AdminKorisnicko;

    @FXML
    private TextField TFkorisnickoIme;

    @FXML
    private PasswordField TFlozinka;

    @FXML
    private Label Greske;

    @FXML
    private Label ImeKlijenta;




    public void switchToScene1(ActionEvent event) { /* treba otvoriti nesto novo ako je login validan*/
        if(TFlozinka.getText()=="" || TFkorisnickoIme.getText()==""){
            Greske.setText("Nisu vam sva polja popunjena");
        }
        else {
            procesiranje(event,TFkorisnickoIme,TFlozinka);
        }

    }

    private void procesiranje(ActionEvent event,TextField tFkorisnickoIme, PasswordField tFlozinka) {
        uctiajKlijente();
        uctiajAdmin();
        int provjera = 1;
        for (Admin a:adminLista){
            if(a.getKorisnickoIme().equals(tFkorisnickoIme.getText()) && a.getLozinka().equals(tFlozinka.getText())){
                provjera=0;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin.fxml")));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for (Klijent k:klijentLista){
            if(k.getKorisnickoIme().equals(tFkorisnickoIme.getText()) && k.getLozinka().equals(tFlozinka.getText())){
                provjera=0;
                try {
                    root = FXMLLoader.load(getClass().getResource("Klijent.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(provjera==1){
            Greske.setText("Unos nije validan");

        }
    }




    public void switchToScene2(ActionEvent event) { /* Prebaci na sign up*/
        try {
            root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

public void NoviAdmin(){}

}
