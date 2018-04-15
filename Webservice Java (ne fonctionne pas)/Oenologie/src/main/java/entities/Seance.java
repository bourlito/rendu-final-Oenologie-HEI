package entities;

import java.util.Date;

public class Seance {
     Integer id;
     String libelle;
     Date date;
     String informations;


    public Seance(Integer id, String libelle,Date date,String informations){
        this.id=id;
        this.informations=informations;
        this.date=date;
        this.libelle=libelle;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getInformations() {
        return informations;
    }

    public String getLibelle() {
        return libelle;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
