package Services;

import Model.Superhero;
import Repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheroService {
    private SuperheroRepository superheltRepository;

    public SuperheroService(SuperheroRepository superheltRepository) {
        this.superheltRepository = superheltRepository;
    }

    public List<Superhero> List() {
        return superheltRepository.superheroesDB();
    }

    public List searchFor(String heroName) {
        return superheltRepository.searchFor(heroName);
    }

    public Superhero editSuperhero(Superhero superhero) {
        Superhero returnSuperhero = superheltRepository.editSuperhero(superhero);
        return returnSuperhero;
    }

    public Superhero deleteSuperhero(String realName) {
        return (Superhero) superheltRepository.deleteSuperhero(realName);

    }
}
