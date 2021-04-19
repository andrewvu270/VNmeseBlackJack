/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNBlackJack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hoang Vu <vuhoan@sheridancollege.ca> <andrewvu270@gmail.com>
 */
public class PlayGame {

    public static void main(String[] args) {
        System.out.println("You are playing Vietnamese Blackjack");
        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println("INSTRUCTIONS:");
        System.out.println("There will be 2 players: You against the house dealer. Each player will first be dealt 2 cards.\n"
                + "Then the player will have the right to draw or stand. Each player hand cannot contain more than 5 cards\n"
                + "and less then 2 cards. All cards values are same as their rank except for faces card and Aces. Face cards\n" 
                + "are all count as 10, while Aces can be 10, 1 or 11 up to the player choices. The minimum point for each\n" 
                + "player to hit is 16 and dealer is 15. The maximum point to hit is 21. If you get above 21 you bust. If\n"
                + "you are below 16 you bust. The player with the closet point to 21 wins. If player point is the same as\n"
                + "dealer point or both got bust, it's a draw!\n");
        System.out.println("If you want to place bets make sure to put in a big fund otherwise you will lose fast ;)");
        System.out.println("Have fun! :)\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = sc.nextLine();
        Player player = new Player(name);
        Dealer dealer = new Dealer("Dealer");
        System.out.println("Enter your fund:");
        player.setMoney(sc.nextDouble());
        dealer.setMoney(10 * player.getMoney());

        String confirm = "c";
        
        while (confirm.equalsIgnoreCase("c")) {
            System.out.println("Starting new game:");
            VNBlackJack newGame = new VNBlackJack(player, dealer);
            boolean invalid = true;
            while(invalid) {
                System.out.println("Enter your wager:");
                double amount = sc.nextDouble();
                if(amount > newGame.getPlayer().getMoney()){
                    System.out.println("Invalid amount! Please enter an amount within your fund:");
                }
                if(amount <= newGame.getPlayer().getMoney()){
                        invalid = false;
                        newGame.getPlayer().setWager(amount);
                }
                
            }
            
            
            newGame.deal(System.in);
            newGame.calculate();
            if (newGame.getPlayer().getMoney() <= 0) {
                System.out.println("You ran out of money. Goodbye!");
                break;
            }
            System.out.println("Press c to continue playing or other keys to quit");
            sc = new Scanner(System.in);
            confirm = sc.nextLine();
            System.out.println();
        }

    }

}
