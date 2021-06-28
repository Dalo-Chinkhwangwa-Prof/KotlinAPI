package com.dynamicdevz.ddkotlinmvp;

import com.dynamicdevz.ddkotlinmvp.util.Constants;

public class Animal {

    private int lifeSpan;
    private String species;

    public Animal(int lifeSpan, String species) {
        this.lifeSpan = lifeSpan;
        this.species = species;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
