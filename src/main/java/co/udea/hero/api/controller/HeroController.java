package co.udea.hero.api.controller;

import co.udea.hero.api.model.Hero;
import co.udea.hero.api.service.HeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
public class HeroController {

   // @Autowired
   // HeroRepository heroRepository;


    private final Logger log = LoggerFactory.getLogger(HeroController.class);

    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }



    // get a hero por id
    @GetMapping("{id}")
    @ApiOperation(value = "Busca un hero por su id",  response = Hero.class)
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Hero encontrado existosamente"), @ApiResponse(code = 400, message = "La petición es invalida"),
    @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})

    public Hero getHero(@PathVariable Integer id) {
        log.info("Rest request buscar heroe por id");
        return this.heroService.getHero(id);

    }

    /**
     * Recuperar all heroes
     *
     * @return iterable with all heroes
     */
    @GetMapping()
    @ApiOperation(value = "Get all heroes.", notes = "Get a list of all heroes.")
    public ResponseEntity<Hero> getHeroes(@PathVariable Integer id){
        log.info("Rest request buscar heroe por id");
        return ResponseEntity.ok(heroService.getHero(id));

}

    /**
     * Crear a hero. Returned hero will have the auto-generated id of the new hero.
     *
     * @param hero
     * @return the created hero
     */
    @PostMapping()
    @RequestMapping()
    @ApiOperation(value = "Crear un heroe",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero) {
        log.info("Rest request crear heroe");
        return ResponseEntity.ok(heroService.addHero(hero));
    }


    /**
     * eliminar hero
     *
     * @param id
     *
     */
    @RequestMapping()
    @DeleteMapping(value = "{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHero(@PathVariable Integer id) {
        log.info("Rest request eliminar heroe");

    }


     /**
     * actualizar a hero. Hero must exist for id.
     *
     * @param id
     *            The id of the hero to update
     * @param hero
     *
     */
     @RequestMapping
    public void updateHero(@PathVariable Integer id, @RequestBody Hero hero) {

        this.heroRepository.save(currentHero);

    }



}
