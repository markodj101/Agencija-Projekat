package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController extends Database{

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField TfIme;
    @FXML
    private TextField TfPrezime;
    @FXML
    private TextField BrojTel;
    @FXML
    private TextField JBMG;
    @FXML
    private TextField BrojRacuna;
    @FXML
    private TextField KorisnickoIme;
    @FXML
    private PasswordField Lozinka;
    @FXML
    private PasswordField PotvrdaLozinke;
    @FXML
    private Label Greske;
    private int provjera;
    private Bankovni_racun noviRacun;
    private Klijent novi;



    public void switchToScene1(ActionEvent event) {
        provjera = 0;
        uctiajRacuna();
        uctiajKlijente();
        polja();
        if(provjera == 0 ){
            novi = new Klijent(noviRacun,TfIme.getText(),TfPrezime.getText(),BrojTel.getText(),KorisnickoIme.getText(),Lozinka.getText());
            ubaciUBazuKlijenta(novi);
            try {
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();




            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            TfIme.setText("");
            TfPrezime.setText("");
            Lozinka.setText("");
            PotvrdaLozinke.setText("");
            BrojTel.setText("");
            BrojRacuna.setText("");
            KorisnickoIme.setText("");
            JBMG.setText("");
        }
        klijentLista.clear(); /* DA NE BUDU DUPLIKATIIII*/
    }

    private void polja() {
        if (TfIme.getText()=="" || TfPrezime.getText() =="" || Lozinka.getText()=="" || PotvrdaLozinke.getText()=="" || BrojTel.getText()=="" || BrojRacuna.getText()=="" || KorisnickoIme.getText()=="" || JBMG.getText()==""){
            Greske.setText("Nisu sva polja popunjena"); /*Nista nije popunjeno*/
            provjera = 1;
        }
        else {
            for(Bankovni_racun r: racuniLista){ /*Provjeravamo da li postoji bankovni racun*/
                if(r.getBroj_racuna().equals(BrojRacuna.getText())){
                    if(r.getJmbg().equals(JBMG.getText())){
                        noviRacun = new Bankovni_racun(r.getBroj_racuna(),r.getJmbg(),r.getStanje());
                        provjera = 0;
                        break;
                    }
                    else {
                        Greske.setText("Ne poklapa se jmbg ili niste unijeli validan račun");
                        JBMG.setText("");
                        BrojRacuna.setText("");
                        provjera = 1;
                        break;
                    }
                }
            }
            if(provjera==0){
                for (Klijent k: klijentLista){
                    String racun =k.getBankovniRacun().getBroj_racuna();
                    System.out.println(racun);
                    String jb = k.getBankovniRacun().getJmbg();
                    System.out.println(jb);
                    if(k.getKorisnickoIme().equals(KorisnickoIme.getText())){
                        provjera = 1;
                        Greske.setText("Već posotji korisničko ime");
                        KorisnickoIme.setText("");
                        break;
                    } else if (k.getBankovniRacun().getJmbg().equals(JBMG.getText()) || k.getBankovniRacun().getBroj_racuna().equals(BrojRacuna.getText())) {
                        provjera = 1;
                        Greske.setText("Već posotji JBMG ili bankovni račun");
                        BrojRacuna.setText("");
                        JBMG.setText("");
                    }
                }
                if(provjera ==0){
                    if(!Lozinka.getText().equals(PotvrdaLozinke.getText())){
                        provjera=1;
                        Greske.setText("Lozinke nisu iste");
                        Lozinka.setText("");
                        PotvrdaLozinke.setText("");
                    }
                }
            }


        }
    }


}
