package com.dsa.ctci.chapter3;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_AnimalShelter {
    Queue<Animal> cat = new LinkedList<>();
    Queue<Animal> dog = new LinkedList<>();

    public void enQueue(Animal animal){
        if(animal.getType() == "CAT"){
            cat.add(animal);
        } else if(animal.getType() == "DOG")
            dog.add(animal);
    }

    public Animal deQueueAny(){
        return cat.peek().rank >= dog.peek().rank ? cat.poll() : dog.poll();
    }

    public Animal deQueueCat(){
        return cat.poll();
    }

    public Animal deQueueDog(){
       return dog.poll();
    }


    public static void main(String[] args) {

    }
}

class Animal {
    int rank;
    String type;

    public Animal(final int rank, final String type) {
        this.rank = rank;
        this.type = type;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Animal getOlderAnimal(final Animal animal) {
        if(this.rank< animal.rank)
            return this;
        else return animal;
    }
}