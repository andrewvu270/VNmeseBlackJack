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
        boolean play = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = sc.nextLine();
        Player player = new Player(name);
        Dealer dealer = new Dealer("Dealer");
        System.out.println("Enter your fund:");
        player.setMoney(sc.nextDouble());
        dealer.setMoney(10*player.getMoney());
        
        String confirm = "c";
        while(confirm.equalsIgnoreCase("c")){
            System.out.println("Starting new game:");
            VNBlackJack newGame = new VNBlackJack(player, dealer);
            System.out.println("Enter your wager:");
            player.setWager(sc.nextDouble());
            newGame.deal(System.in);
            newGame.calculate();
            System.out.println("Press c to continue playing or other keys to quit");
            sc = new Scanner(System.in);
            confirm = sc.nextLine();
            newGame.reset();
            System.out.println();
        }

    }

}
