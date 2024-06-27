package com.example.demo;

public class Klijent {
    private Bankovni_racun bankovniRacun;
    private String ime;
    private  String prezime;
    private String brojTel;
    private String korisnickoIme;
    private String lozinka;


    public Klijent(Bankovni_racun bankovniRacun, String ime, String prezime, String brojTel, String korisnickoIme, String lozinka) {
        this.bankovniRacun = bankovniRacun;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTel = brojTel;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
    public Klijent(){

    }


    public Bankovni_racun getBankovniRacun() {
        return bankovniRacun;
    }

    public void setBankovniRacun(Bankovni_racun bankovniRacun) {
        this.bankovniRacun = bankovniRacun;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTel() {
        return brojTel;
    }

    public void setBrojTel(String brojTel) {
        this.brojTel = brojTel;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Klijent{" +
                "bankovniRacun=" + bankovniRacun.getBroj_racuna() +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojTel='" + brojTel + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                '}';
    }
}
