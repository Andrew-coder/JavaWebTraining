package model.entity;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by andri on 11/14/2016.
 */
public class GameRoom {
    /**
     * allocated sum for toys
     * sum of all toys mustn't exceed allocatedCosts
     */
    private int allocatedCosts;

    /**
     * the list of toys
     */
    private List<Toy> toys;

    /**
     * the list of children
     */
    private List<Child> childrens;

    /**
     * default constructor
     */
    public GameRoom() {
        toys = new ArrayList<>();
        childrens = new ArrayList<>();
    }

    /**
     * method which adds toy to the toys list and checks adequacy of allocated costs
     * @param toy the toy which will be added
     */
    public void addToy(Toy toy) {
        if(allocatedCosts>=toy.getPrice()+calculateTotalToysPrice()){
            toys.add(toy);
        }
        else throw new RuntimeException("Not enough money to add toy!");
    }

    /**
     * sort toys by sort method
     * @param method
     */
    public void sortToys(SortMethod method) {
        if(toys.size()!=0) {
            Collections.sort(toys, method.getComparator());
        }
    }

    /**
     * add child to childs list
     * @param child child which will be added
     */
    public void addChild(Child child) {
        childrens.add(child);
    }

    /**
     * calculate the total cost of toys
     * @return total toys cost
     */
    public int calculateTotalToysPrice() {
        if(toys.size()!=0) {
            return toys.stream().mapToInt(Toy::getPrice).sum();
        }
        return 0;
    }

    public int getAllocatedCosts() {
        return allocatedCosts;
    }

    public void setAllocatedCosts(int allocatedCosts) {
        this.allocatedCosts = allocatedCosts;
    }

    public List<Toy> getToys() {
        return toys;
    }

    /**
     * this method sets toys list and checks the adequacy of allocated costs
     * @param toys the list of toys
     */
    public void setToys(List<Toy> toys) {
        for(Toy toy:toys){
            if(allocatedCosts>=toy.getPrice()+calculateTotalToysPrice()) {
                this.toys.add(toy);
            }
            else throw new RuntimeException("Not enough money!");
        }
    }

    public List<Child> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Child> childrens) {
        this.childrens = childrens;
    }
}
