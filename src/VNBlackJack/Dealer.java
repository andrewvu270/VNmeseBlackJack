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
public class Dealer extends Player{
    private DeckOfCards playingDeck = new DeckOfCards();
    
    public void useDeck(){
        playingDeck.resetDeck();
        playingDeck.shuffle();
    }
    
    public Dealer(String name){
        super(name);
    }
    
    public DeckOfCards getPlayingDeck(){
        return this.playingDeck;
    }
}
