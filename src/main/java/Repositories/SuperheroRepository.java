package Repositories;


import Model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheroRepository {

    Superhero superhero1 = new Superhero("Bruce Wayne", "Batman", 1998, "Rig", true, 2.1);
    Superhero superhero2 = new Superhero("Clark Kent", "Superman", 1975, "Flyve", true, 3.8);
    Superhero superhero3 = new Superhero("Low Fat", "Lone Svinkløv", 1944, "Spise uden at tage på", true,  0);
    Superhero superhero4 = new Superhero("Prinsesse Diana", "Wonder Woman", 1941, "Flyve", false, 3.1);
    Superhero superhero5 = new Superhero("Peter Parker", "Spiderman", 1938, "Spinne", true, 2.1);
    private ArrayList<Superhero> superheroesDB = new ArrayList<>(Arrays.asList(superhero1,superhero2,superhero3,superhero4,superhero5));

    // Getter for arraylist of superheroes
    public List<Superhero> superheroesDB() {
        return superheroesDB;
    }

    /*
    public Superhero createSuperhero(String heroName, String realName, int creationYear, String superpower, boolean human, double strength) {
        Superhero hero = new Superhero(heroName, realName, creationYear, superpower, human, strength);
        superheroesDB.add(hero);
        return hero;
    }
     */

    public List<Superhero> searchFor(String searchTerm) {
        List<Superhero> searchResults = new ArrayList<>(); // creating arraylist of superheroes

        // Loop through arraylist of superheroes, return if matching searchTerm
        for (Superhero superhelt : superheroesDB) {
            String name = superhelt.getHeroName().toLowerCase(); // making all characters in superhero name lower case
            if (name.contains(searchTerm.toLowerCase().trim())) { // if superhero contains searchTerm, add superhero to arraylist
                searchResults.add(superhelt);
            }
        }
        // return searchResult
        return searchResults;
    }


    public List<Superhero> deleteSuperhero(String searchTerm) {
        List<Superhero> searchResults = new ArrayList<>();

        searchResults = searchFor(searchTerm);

        for (Superhero superhelt : searchResults){
            superheroesDB().remove(superhelt); // takes  the ArrayList of superheroes and removing the appropriate superhero
        }

        return searchResults;
    }

    public Superhero editSuperhero(Superhero superhero){
        for (Superhero superUpdated : superheroesDB){
            if (superUpdated.getHeroName().equalsIgnoreCase(superhero.getHeroName().toLowerCase())){

                String newHeroName = superhero.getHeroName();
                superUpdated.setHeroName(newHeroName);

                String newRealName = superhero.getRealName();
                superUpdated.setRealName(newRealName);

                int newCreationYear = superhero.getCreationYear();
                superUpdated.setCreationYear(newCreationYear);

                String newSuperPower = superhero.getSuperpower();
                superUpdated.setSuperpower(newSuperPower);

                boolean newHuman = superhero.isHuman();
                superUpdated.setHuman(newHuman);

                double newPower = superhero.getStrength();
                superUpdated.setStrength(newPower);
            }
            return superUpdated;
        }

        return superhero;
    }


}
