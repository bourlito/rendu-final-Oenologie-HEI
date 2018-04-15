package managers;

import entities.Seance;
import impl.SeanceDao;
import impl.SeanceDaoImpl;

import java.util.Date;

public class SeanceLibrary {

    private static class SeanceLibraryHolder{
        final static SeanceLibrary instance = new SeanceLibrary();
    }

    public static SeanceLibrary getInstance(){
        return SeanceLibraryHolder.instance;
    }

    private SeanceDao seanceDao = new SeanceDaoImpl();

    private SeanceLibrary(){};

    public Seance getSeance1 (Integer id){
        return seanceDao.getSeance1(id);
    }
    public Seance getSeance2 (Integer id){
        return seanceDao.getSeance2(id);
    }
    public Seance getSeance3 (Integer id){
        return seanceDao.getSeance3(id);
    }


    public Seance updateSeance (Integer id, String libelle, String date, String informations){
        return seanceDao.updateSeance(id,libelle,date,informations);
    }
}
