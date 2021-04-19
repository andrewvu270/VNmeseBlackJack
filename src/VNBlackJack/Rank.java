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
public enum Rank {
    TWO(2,"Two","2"),
    THREE(3,"Three","3"),
    FOUR(4,"Four","4"),
    FIVE(5,"Five","5"),
    SIX(6,"Six","6"),
    SEVEN(7,"Seven","7"),
    EIGHT(8,"Eight","8"),
    NINE(9,"Nine","9"),
    TEN(10,"Ten","10"),
    JACK(11,"Jack","J"),
    QUEEN(12,"Queen","Q"),
    KING(13,"King","K"),
    ACE(1,"Ace","A");
    
    private int value;
    private String name;
    private String shortName;
    
    public int getValue(){
        return this.value;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getShortName(){
        return this.shortName;
    }
    
    private Rank(int value, String name, String shortName){
        this.value = value;
        this.name = name;
        this.shortName = shortName;
    }
    
}
