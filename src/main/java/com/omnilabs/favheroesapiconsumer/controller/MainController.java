package com.omnilabs.favheroesapiconsumer.controller;

import com.omnilabs.favheroesapiconsumer.factory.MarvelURIFactory;
import com.omnilabs.favheroesapiconsumer.model.Character;
import com.omnilabs.favheroesapiconsumer.pagemap.Pages;
import com.omnilabs.favheroesapiconsumer.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = {"/"})
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MarvelURIFactory marvelURIFactory;

    @Autowired
    private CharacterService characterService;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView showFavoriteHeroes() {

        try {
            LOG.info("Retrieving homepage...");

            //TODO remove this snnipet
            LOG.info(marvelURIFactory.getCharactersURI(1011334).toString());
            LOG.info(marvelURIFactory.getComicsURI(1011334, 6).toString());

            Character character = characterService.getCharacterByID(1011334);


            ModelAndView mv = new ModelAndView(Pages.HOME);
            return mv;

        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return new ModelAndView(Pages.ERROR);
        }
    }

    @RequestMapping(value = "/characters/{id}/comic", method = RequestMethod.GET)
    public ModelAndView showFavoriteHeroesTopComics() {

        try {
            LOG.info("Retrieving top comics per hero.");
            ModelAndView mv = new ModelAndView(Pages.TOP_COMICS);
            return mv;
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return new ModelAndView(Pages.ERROR);
        }
    }
}
