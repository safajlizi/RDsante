package com.example.projetjava;

import java.time.LocalDate;
import java.util.Date;

public class facture {
    private int id;
    private String nom;
    private String prenom;
    private String num;
    private String adresse;
    private Date date;
    private String doctor;
    private Float montant;
    private Float montantpaye;
public facture(int id,String nom,String prenom,String num,String adresse,Date date,String doctor,Float montant,Float montantpaye)
{   this.id=id;
   this.adresse=adresse;
   this.date=date;
   this.doctor=doctor;
   this.montant=montant;
   this.montantpaye=montantpaye;
   this.nom=nom;
   this.prenom=prenom;
   this.num=num;
}


    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getMontantpaye() {
        return montantpaye;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getNum() {
        return num;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public void setMontantpaye(Float montantpaye) {
        this.montantpaye=montantpaye;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}