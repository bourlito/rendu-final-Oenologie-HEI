package entities;

public class Reponse {
    private Integer id;
    private String libelle;
    private boolean correct;

    public Reponse (Integer id, String libelle, boolean correct){
        this.correct=correct;
        this.id=id;
        this.libelle=libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }

}

