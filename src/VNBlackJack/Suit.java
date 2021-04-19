/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNBlackJack;

/**
 *
 * @author Hoang Vu <vuhoan@sheridancollege.ca> <andrewvu270@gmail.com>
 */
public enum Suit {
    CLUBS(1,"Clubs",'\u2663'),
    DIAMONDS(2,"Diamonds",'\u2662'),
    HEARTS(3,"Hearts",'\u2661'),
    SPADES(4,"Spades",'\u2660');
    
    private int number;
    private String name;
    private char unicode;
    
    public String getSuit(){
        return this.name;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public char getUnicode(){
        return this.unicode;
    }
    
    private Suit(int number, String name, char unicode){
        this.number = number;
        this.name = name;
        this.unicode = unicode;
    }
    
}
