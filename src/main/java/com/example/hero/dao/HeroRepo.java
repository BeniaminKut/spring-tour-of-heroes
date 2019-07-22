package com.example.hero.dao;

import com.example.hero.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends JpaRepository<Hero, Integer> {
}
