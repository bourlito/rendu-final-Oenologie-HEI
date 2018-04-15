package impl;

import entities.Seance;

public interface SeanceDao {
    public Seance getSeance1 ( Integer Id);
    public Seance getSeance2 ( Integer Id);
    public Seance getSeance3 ( Integer Id);
    public Seance updateSeance (Integer id, String libelle, String date, String informations);
}
