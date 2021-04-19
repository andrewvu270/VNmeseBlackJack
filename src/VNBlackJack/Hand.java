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
public class Hand {

    private ArrayList<Card> myHand = new ArrayList();
    private boolean bust = false;
    
    public void add(Card card){
        myHand.add(card);
    }
    
    public ArrayList<Card> getMyHand(){
        return myHand;
    }
    
    public int calculatePts() {
        int pts = 0;
        int numAce = 0;
        for (Card card : myHand) {
            switch (card.rank) {
                case TWO:
                    pts += 2;
                    break;
                case THREE:
                    pts += 3;
                    break;
                case FOUR:
                    pts += 4;
                    break;
                case FIVE:
                    pts += 5;
                    break;
                case SIX:
                    pts += 6;
                    break;
                case SEVEN:
                    pts += 7;
                    break;
                case EIGHT:
                    pts += 8;
                    break;
                case NINE:
                    pts += 9;
                    break;
                case TEN:
                    pts += 10;
                    break;
                case JACK:
                    pts += 10;
                    break;
                case QUEEN:
                    pts += 10;
                    break;
                case KING:
                    pts += 10;
                    break;
                case ACE:
                    numAce ++;
                    break;
            }
        }
            for(int i = 1; i <= numAce; i++){
                if(pts <= 10){
                    pts += 11;
                } else if (pts == 11){
                    pts += 10;
                } else if (pts > 11){
                    pts += 1;
                }
            }
        
        return pts;
    }
    
    public int getSize(){
        return myHand.size();
    }
    public void resetHand(){
        myHand.removeAll(myHand);
    }
    
    @Override
    public String toString(){
        String output = "";
        for(Card card : myHand){
            output += card.shortString();
            output += "\n";
        }
        return output;
    }
}
