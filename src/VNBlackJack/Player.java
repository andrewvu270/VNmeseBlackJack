/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNBlackJack;

import java.util.ArrayList;

/**
 *
 * @author Hoang Vu <vuhoan@sheridancollege.ca> <andrewvu270@gmail.com>
 */
public class Player {
    private String name;
    private Hand hand = new Hand();
    private double money = 10000;
    private double wager;
    
    public Hand getHand(){
        return hand;
    }
    
    public Player(String name){
        this.name=name;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getWager() {
        return wager;
    }

    public void setWager(double wager) {
        this.wager = wager;
    }
    
    public void drawCards(Card card){
        this.getHand().add(card);
    }
    
    @Override
    public String toString(){
        return "Player " + this.getName();
    }
}
