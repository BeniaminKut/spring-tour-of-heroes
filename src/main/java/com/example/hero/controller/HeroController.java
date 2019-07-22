package com.example.hero.controller;

import com.example.hero.dao.HeroRepo;
import com.example.hero.model.Hero;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {
    @Autowired
    HeroRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/heroes")
    public Hero addHero(@RequestBody Hero hero){
        return repo.save(hero);
    }
    @PutMapping("/heroes")
    public Hero updateHero(@RequestBody Hero hero){
        return repo.save(hero);
    }
    @DeleteMapping("/heroes/{id}")
    public void deleteHero(@PathVariable("id") int id){
        repo.deleteById(id);
    }
    @RequestMapping("/heroes")
    @ResponseBody
    public Collection<Hero> getHeroes(){

        Collection<Hero> all = repo.findAll();
        return all;
    }
    @RequestMapping("/heroes/{id}")
    @ResponseBody
    public Optional<Hero> getHero(@PathVariable("id") int id){
        Optional<Hero> oneHero =  repo.findById(id);
        return oneHero;
    }
    @PostConstruct
    public void init() {
        //set default heroes
        for(int i=0;i<10;i++) {
            Faker faker = new Faker();
            Hero hero = new Hero();
            hero.setName(faker.superhero().name());
            repo.save(hero);
        }
    }
}
