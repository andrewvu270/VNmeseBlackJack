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
public class Card {
    Rank rank;
    Suit suit;
    
    public Card(){}
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    @Override
    public String toString(){
        return this.getRank().getName() + " of " + this.getSuit().getSuit();
    }
    
    public String shortString(){
        String space = "";
        for(int i = 0; i < (2 - this.getRank().getShortName().length()); i++){
            space += " ";
        }
        return space + this.getRank().getShortName() + this.getSuit().getUnicode();
    }
    
    
}
