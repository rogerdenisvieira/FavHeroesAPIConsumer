package com.omnilabs.favheroesapiconsumer.controller;

import com.omnilabs.favheroesapiconsumer.model.Character;
import com.omnilabs.favheroesapiconsumer.factory.MarvelURIFactory;
import com.omnilabs.favheroesapiconsumer.model.Comic;
import com.omnilabs.favheroesapiconsumer.pagemap.Pages;
import com.omnilabs.favheroesapiconsumer.service.CharacterService;
import com.omnilabs.favheroesapiconsumer.service.ComicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = {"/"})
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MarvelURIFactory marvelURIFactory;

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ComicService comicService;

    private final Integer COMICS_LIMIT = 5;
    private final List<Integer> CHARACTERS_IDS = Arrays.asList(1009368,1009610,1009592);


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView showFavoriteHeroes() {

        List<Character> characters = new ArrayList<>();

        try {
            LOG.info("Retrieving homepage...");


            for(Integer id : CHARACTERS_IDS){
                Character character = characterService.getCharacterByID(id);
                characters.add(character);
            }

            ModelAndView mv = new ModelAndView(Pages.HOME);
            mv.addObject("charactersList",characters);
            return mv;

        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return new ModelAndView(Pages.ERROR);
        }
    }

    @RequestMapping(value = "/characters/{id}/comics", method = RequestMethod.GET)
    public ModelAndView showFavoriteHeroesTopComics(@PathVariable Integer id) {


        try {
            List<Comic> comics = comicService.findTopComicsByCharacterId(id,COMICS_LIMIT);
            LOG.info("Retrieving top comics per hero.");

            ModelAndView mv = new ModelAndView(Pages.TOP_COMICS);
            mv.addObject("comicList", comics);

            return mv;
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return new ModelAndView(Pages.ERROR);
        }
    }
}
