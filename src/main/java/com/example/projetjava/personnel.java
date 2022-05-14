package com.example.projetjava;
import java.util.Date;

public class personnel extends personne{
    String docteur;
        String temps_travail;

   public  personnel(Integer id, String num, String nom, String prenom, String addresse, String email, String genre, String Specialite ,String temps_travail)
   {
       super(id,num,nom,prenom,addresse,email,genre);
       this.docteur=Specialite;
       this.temps_travail=temps_travail;
   }


    public void setSpecialite(String Specialite) {
        this.docteur = Specialite;
    }


    public  String getDocteur() {
        return docteur;
    }

    public void setTemps_travail(String temps_travail) {
        this.temps_travail = temps_travail;
    }

    public String getTemps_travail() {
        return temps_travail;
    }

}
