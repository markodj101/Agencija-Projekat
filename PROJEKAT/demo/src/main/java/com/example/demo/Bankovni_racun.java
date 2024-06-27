package com.example.demo;

public class Bankovni_racun {
    private String broj_racuna;
    private  String jmbg;
    private  float stanje;


    public Bankovni_racun( String broj_racuna, String jmbg, float stanje) {
        this.broj_racuna = broj_racuna;
        this.jmbg = jmbg;
        this.stanje = stanje;
    }






    public String getBroj_racuna() {
        return broj_racuna;
    }

    public void setBroj_racuna(String broj_racuna) {
        this.broj_racuna = broj_racuna;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public float getStanje() {
        return stanje;
    }

    public void setStanje(float stanje) {
        this.stanje = stanje;
    }

    @Override
    public String toString() {
        return "Bankovni_racun{" +
                ", broj_racuna=" + broj_racuna +
                ", jmbg=" + jmbg +
                ", stanje=" + stanje +
                '}';
    }
}
