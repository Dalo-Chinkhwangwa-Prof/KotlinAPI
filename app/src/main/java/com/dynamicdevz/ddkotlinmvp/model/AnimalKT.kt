package com.dynamicdevz.ddkotlinmvp.model

data class AnimalKT( val lifeSpan: Int, val species: String){
    constructor(lifeSpan: Int): this(lifeSpan, "Unknown")
}
