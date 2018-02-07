package com.jawas.controller;

import com.jawas.model.Planet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/planet")
public class PlanetController
{
    private Logger logger = LogManager.getLogger(PlanetController.class);

    @RequestMapping(value = "/{id}")
    public Planet planet(@PathVariable Long id)
    {
        Planet planet = new Planet(id, "earth", "rock", 1200000);
        logger.info(planet.toString());
        return planet;
    }
}
