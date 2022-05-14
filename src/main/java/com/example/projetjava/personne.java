package com.example.projetjava;

public class personne {
    Integer id;
    String nom,prenom,addresse,email,genre,num;

    public personne(Integer id, String num, String nom, String prenom, String addresse, String email, String genre)
    {
        this.id=id;
        this.num=num;
        this.nom=nom;
        this.prenom=prenom;
        this.addresse=addresse;
        this.email=email;
        this.genre=genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public  String getAddresse() {
        return addresse;
    }

    public  String getEmail() {
        return email;
    }
    public Integer getId() {
        return id;
    }

    public  String getNum() {
        return num;
    }

    public  String getNom() {
        return nom;
    }

    public  String getPrenom() {
        return prenom;
    }

    public  String getGenre() {
        return genre;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
