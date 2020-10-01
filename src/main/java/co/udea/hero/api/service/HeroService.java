package co.udea.hero.api.service;

import co.udea.hero.api.exception.BusinessException;
import co.udea.hero.api.model.Hero;
import co.udea.hero.api.repository.HeroRepository;
import co.udea.hero.api.util.Messages;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeroService {

    private HeroRepository heroRepository;
    private Messages messages;

    public HeroService(HeroRepository heroRepository, Messages messages){
        this.messages = messages;
        this.heroRepository = heroRepository;
    }

    public Hero getHero(Integer id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        if(!optionalHero.isPresent()){
            throw new BusinessException(messages.get("exception.data_not_found.hero"));
        }
        return optionalHero.get();
    }

    public Hero addHero(Hero hero){
        Optional<Hero> optionalHero = heroRepository.findByName(hero.getName());
        if(optionalHero.isPresent()){
            throw new BusinessException(messages.get("exception.data_duplicate_name.hero"));
        }
        return heroRepository.save(hero);
    }
}
