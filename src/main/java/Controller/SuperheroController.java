package Controller;

import Model.Superhero;
import Services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class SuperheroController {

    @RestController("/")
    public class superheltcontroller {
        @Autowired

        SuperheroService superheroService;

        public superheltcontroller(SuperheroService superheltService) {
            this.superheroService = superheltService;
        }

        @GetMapping("/hero/{navn}")
        public ResponseEntity<Superhero> getsearchForHero(@PathVariable String heroName) {
            Superhero searchForHero = (Superhero) superheroService.searchFor(heroName);
            return new ResponseEntity<>(searchForHero, HttpStatus.OK);
        }

        @GetMapping("/edit")
        public ResponseEntity<Superhero> getEditHero(@RequestBody Superhero superhero) {
            Superhero editHero = superheroService.editSuperhero(superhero);
            return new ResponseEntity<>(editHero, HttpStatus.OK);
        }

        @GetMapping("/delete{name}")
        public ResponseEntity<Superhero> getDeleteHero(@PathVariable String realName) {
            Superhero deleteHero = superheroService.deleteSuperhero(realName);
            return new ResponseEntity<>(deleteHero, HttpStatus.OK);
        }

    }
}
