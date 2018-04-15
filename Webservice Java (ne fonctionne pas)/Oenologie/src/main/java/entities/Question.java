package entities;

public class Question {
    private Integer id;
    private String libelle;

    public Question (Integer id, String libelle){
        this.id=id;
        this.libelle=libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
