package dao;

import metier.entities.Sport;
 
public class TestDao {
    public static void main(String[] args) {
        SportDaoImpl sportDao = new SportDaoImpl();

        Long idSportAModifier = 1L; // ID du sport à modifier
        Sport sportAModifier = sportDao.getSport(idSportAModifier);

        if (sportAModifier != null) {
            System.out.println("Informations du sport avant mise à jour:");
            System.out.println("ID: " + sportAModifier.getIdSport() + ", Nom: " + sportAModifier.getNomSport());

            sportAModifier.setNomSport("Nouveau nom du sport");

            sportDao.updateSport(sportAModifier);

            System.out.println("Informations du sport après mise à jour:");
            System.out.println("ID: " + sportAModifier.getIdSport() + ", Nom: " + sportAModifier.getNomSport());
        } else {
            System.out.println("Sport non trouvé pour l'ID: " + idSportAModifier);
        }
    }
}
