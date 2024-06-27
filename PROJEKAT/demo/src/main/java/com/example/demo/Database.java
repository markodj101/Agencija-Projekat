package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Set;


public class Database {
    private static String DB_user = "root";
    private static String DB_password = "";
    private static String connectionUrl;
    private static int port = 3306;
    private static String DB_name = "agencija";
    private static Connection connection;

    public static ArrayList<Admin> adminLista = new ArrayList<>();
    public  static ArrayList<Bankovni_racun> racuniLista = new ArrayList<>();
    public static ArrayList<Klijent> klijentLista = new ArrayList<>();
    private static Bankovni_racun bankRacun;




    public static void DBConnect() throws SQLException /*, ClassNotFoundException*/ {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        connectionUrl = "jdbc:mysql://localhost" + ":" + port + "/" + DB_name;
        connection = DriverManager.getConnection(connectionUrl, DB_user, DB_password);
    }

    public static void uctiajAdmin() { /*Ucitva Admine iz baze*/
        try {
            DBConnect();
            System.out.println("Uspjesno ste se konektovali na bazu za ADMINE:" + connectionUrl);
            ResultSet resultSet = null;
            Statement statement = connection.createStatement();
            String SQLQuery = "SELECT * FROM admin";
            resultSet = statement.executeQuery(SQLQuery);
            System.out.println("--------------------------------------------");
            while (resultSet.next()) {
                String adminId = resultSet.getString("id");
                String firstName = resultSet.getString("ime");
                String lastName = resultSet.getString("prezime");
                String username = resultSet.getString("korisnicko_ime");
                String password = resultSet.getString("lozinka");
                Admin dodaj =new Admin(Integer.parseInt(adminId),firstName,lastName,username,password);
                adminLista.add(dodaj);

            }
            for (Admin n : adminLista){    /*, samo sluzi za ispis*/
                String result = n.getId() + ", " + n.getKorisnickoIme() + ", " + n.getLozinka() + ", " + n.getIme() + ", " + n.getPrezime();
                System.out.println(result);
            }
            System.out.println("--------------------------------------------");

            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void uctiajRacuna() { /*Ucitava racune iz baze*/
        try {
            DBConnect();
            System.out.println("Uspjesno ste se konektovali na bazu za BANKOVNE RACUNE:" + connectionUrl);
            ResultSet resultSet = null;
            Statement statement = connection.createStatement();
            String SQLQuery = "SELECT * FROM bankovni_racun";
            resultSet = statement.executeQuery(SQLQuery);
            System.out.println("--------------------------------------------");
            while (resultSet.next()) {
                String Id = resultSet.getString("id");
                String Broj_racuna = resultSet.getString("broj_racuna");
                String jmbg = resultSet.getString("jmbg");
                String stanje = resultSet.getString("stanje");
                Bankovni_racun temp = new Bankovni_racun(Broj_racuna,jmbg,Float.parseFloat(stanje));
                racuniLista.add(temp);

            }

            System.out.println("--------------------------------------------");

            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }





    }
    public static void uctiajKlijente() { /*Ucitava listu klijenta koja je vec u bazi*/
        try {
            DBConnect();
            System.out.println("Uspješno ste se konektovali na bazu za KLIJENTE:" + connectionUrl);
            ResultSet resultSet = null;
            Statement statement = connection.createStatement();
            String SQLQuery = "SELECT * FROM klijent";
            resultSet = statement.executeQuery(SQLQuery);
            System.out.println("--------------------------------------------");

            if(resultSet.next()){
                do {
                    String ime = resultSet.getString("ime");
                    String prezime = resultSet.getString("prezime");
                    String brojTel = resultSet.getString("broj_telefona");
                    String jmbg = resultSet.getString("jmbg");
                    String brojRacuna = resultSet.getString("broj_racuna");
                    String korisnickoIme = resultSet.getString("korisnicko_ime");
                    String lozinka = resultSet.getString("lozinka");

                    for (Bankovni_racun n : racuniLista) {
                        if (brojRacuna.equals(n.getBroj_racuna())) {
                            bankRacun = new Bankovni_racun(n.getBroj_racuna(), n.getJmbg(), n.getStanje());
                        }
                    }

                    Klijent kl = new Klijent(bankRacun, ime, prezime, brojTel, korisnickoIme, lozinka);
                    klijentLista.add(kl);
                } while (resultSet.next());
            } else {
                System.out.println("Tabela Klijent je trenutno prazna");
            }

            System.out.println("--------------------------------------------");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }






    }

    public static void ubaciUBazuKlijenta(Klijent k) { /*Ubacuje datog Klijenta u bazu*/
        try {
            DBConnect();
            System.out.println("\nUspješno ste se konektovali na bazu za UNOS NOVOG KLIJENTA:\n" + connectionUrl);

            String SQLQuery = "INSERT INTO klijent (id, ime, prezime, broj_telefona, jmbg, broj_racuna, korisnicko_ime, lozinka) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(SQLQuery);
            statement.setInt(1,brojic(0));
            statement.setString(2, k.getIme());
            statement.setString(3, k.getPrezime());
            statement.setString(4, k.getBrojTel());
            statement.setString(5, k.getBankovniRacun().getJmbg());
            statement.setString(6, k.getBankovniRacun().getBroj_racuna());
            statement.setString(7, k.getKorisnickoIme());
            statement.setString(8, k.getLozinka());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("\n\nKlijent uspješno dodan u bazu.\n\n");
            } else {
                System.out.println("\n\nNije uspjelo dodavanje klijenta u bazu.\n\n");
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int brojic( int brojac) {

            for (Klijent k : klijentLista){
                brojac++;
                System.out.println(brojac + " =========== " + k.toString());

            }
            brojac +=1;
            return brojac;

    }

}
