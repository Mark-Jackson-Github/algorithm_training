package com.mark.zuoshen.stack_queue;

import com.mark.zuoshen.stack_queue.vo.Pet;

public class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, Long count){
        this.pet = pet;
        this.count = count;

    }

    public Pet getPet(){
        return this.pet;

    }

    public Long getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }

}
