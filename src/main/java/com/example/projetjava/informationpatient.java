package com.example.projetjava;

import java.util.Date;

public class informationpatient extends personne{

    Date rend;
    String docteur;


    public informationpatient(Integer id, String num, String nom, String prenom, String addresse, String email, String genre, String docteur ,Date rend){


        super(id,num,nom,prenom,addresse,email,genre);

        this.docteur=docteur;
        this.rend=rend;

    }

    public Date getRend() {
        return rend;
    }

    public void setRend(Date rend) {
        this.rend = rend;
    }


    public void setDocteur(String docteur) {
        this.docteur = docteur;
    }






    public  String getDocteur() {
        return docteur;
    }

}

