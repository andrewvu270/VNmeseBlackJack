/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNBlackJack;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hoang Vu <vuhoan@sheridancollege.ca> <andrewvu270@gmail.com>
 */
public class VNBlackJack {

    private Player player;
    private Dealer dealer;
    private ArrayList<Card> playDeck;
    

    public VNBlackJack(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.playDeck = dealer.getPlayingDeck().getDeck();
    }

    public Player getPlayer(){
        return player;
    }
    
    public Dealer getDealer(){
        return dealer;
    }
    
    public void deal(InputStream in) {
        Scanner sc = new Scanner(in);
        this.reset();
        this.draw(player);
        this.draw(dealer);
        this.draw(player);
        this.draw(dealer);
        System.out.println("\nDealer hand is \n" + dealer.getHand().getMyHand().get(0).shortString() + "\nHidden\n");

        boolean confirm = true;
        while (confirm) {
            System.out.println("Your hand is \n" + player.getHand().toString() + "Your score is "
                    + player.getHand().calculatePts());;
            System.out.println();
            System.out.println("Enter d to draw and s to stand!");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("d") || player.getHand().getSize()== 5) {
                break;
            }
            this.draw(player);
        }
        while (dealer.getHand().calculatePts() < 15) {
            this.draw(dealer);
        }

        if (player.getHand().getSize() == 2) {
            if (dealer.getHand().calculatePts() <= 17) {
                this.draw(dealer);
            }
        }

        System.out.println("Dealer hand is \n" + dealer.getHand().toString()
                + "Dealer score is " + dealer.getHand().calculatePts());

    }

    public void draw(Player player1) {
        player1.drawCards(playDeck.get(0));
        playDeck.remove(0);
    }

    public boolean blackjack(Player player1) {
        String blackjackd = "";
        if (player1.getHand().getSize() == 2) {
            for (Card card : player1.getHand().getMyHand()) {
                blackjackd += card.rank.getShortName();
            }
        }
        if (blackjackd.equals("AA")) {
            System.out.println(player1.getName() + " WINS BY BLACKJACK!");
            return true;
        } else {
            return false;
        }
    }

    public void calculate() {
        if (this.blackjack(dealer)) {
            player.setMoney(player.getMoney() - 2 * player.getWager());
            dealer.setMoney(dealer.getMoney() + 2 * player.getWager());
        } else if (this.blackjack(player)) {
            player.setMoney(player.getMoney() + 2 * player.getWager());
            dealer.setMoney(dealer.getMoney() - 2 * player.getWager());
        } else if (player.getHand().calculatePts() <= 21 && player.getHand().calculatePts() > dealer.getHand().calculatePts()
                || player.getHand().calculatePts() <= 21 && player.getHand().calculatePts() >= 16
                && dealer.getHand().calculatePts() > 21) {
            System.out.println("WON");
            player.setMoney(player.getMoney() + player.getWager());
            dealer.setMoney(dealer.getMoney() - player.getWager());
        } else if (dealer.getHand().calculatePts() <= 21 && dealer.getHand().calculatePts() > player.getHand().calculatePts()
                || dealer.getHand().calculatePts() <= 21 && player.getHand().calculatePts() < 16
                || dealer.getHand().calculatePts() <= 21 && player.getHand().calculatePts() > 21) {
            System.out.println("LOST");
            player.setMoney(player.getMoney() - player.getWager());
            dealer.setMoney(dealer.getMoney() + player.getWager());
        } else {
            System.out.println("DRAW");
        }

        System.out.println("Your fund is " + player.getMoney());
        System.out.println("Dealer fund is " + dealer.getMoney());
        System.out.println(playDeck.size());
        
    }
    
    public void reset(){
        dealer.useDeck();
        player.getHand().resetHand();
        dealer.getHand().resetHand();
    }
}
