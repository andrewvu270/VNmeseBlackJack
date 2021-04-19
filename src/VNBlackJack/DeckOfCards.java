/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNBlackJack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Hoang Vu <vuhoan@sheridancollege.ca> <andrewvu270@gmail.com>
 */
public class DeckOfCards {

    private ArrayList<Card> deck = new ArrayList();

    public DeckOfCards() {
        this.loadDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void loadDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card c = new Card(rank, suit);
                this.deck.add(c);
            }
        }
    }
    public void resetDeck(){
        this.deck.removeAll(deck);
        this.loadDeck();
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }


    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < deck.size(); i++) {
            output += deck.get(i).shortString();
            output += "\n";
        }
        return output;
    }

}
