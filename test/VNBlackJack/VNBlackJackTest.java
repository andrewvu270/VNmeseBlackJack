/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNBlackJack;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hoang Vu <vuhoan@sheridancollege.ca> <andrewvu270@gmail.com>
 */
public class VNBlackJackTest {
    
    public VNBlackJackTest() {
    }
  
//    /**
//     * Test of deal method, of class VNBlackJack.
//     */
    
    @Test
    public void testDeal() throws IOException {
        InputStream in = new ByteArrayInputStream("s".getBytes("UTF-8"));
        System.out.println("Check deal");
        Player player = new Player("Tester");
        Dealer dealer = new Dealer("Tester");
        VNBlackJack instance = new VNBlackJack(player, dealer);
        
        instance.deal(in);
        boolean expResult = false;
        boolean result = instance.getPlayer().getHand().getMyHand().isEmpty();
        assertEquals(expResult, result);
    }
       
    /**
     * Test of draw method, of class VNBlackJack.
     */
    
    @Test
    public void testDraw() {
        System.out.println("Check draw");
        Player player = new Player("Tester");
        Dealer dealer = new Dealer("Tester");
        VNBlackJack instance = new VNBlackJack(player, dealer);
        instance.draw(player);
        instance.draw(player);
        instance.draw(player);
        instance.draw(player);
        instance.draw(player);
        int expResult = 5;
        int result = instance.getPlayer().getHand().getSize();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of blackjack method, of class VNBlackJack.
     */
    @Test
    public void testBlackjackgood() {
        System.out.println("Check blackjack good");
        Player player = new Player("Tester");
        Dealer dealer = new Dealer("Tester");
        Card card1 = new Card(Rank.ACE, Suit.CLUBS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
        player.getHand().add(card1);
        player.getHand().add(card2);
        VNBlackJack instance = new VNBlackJack(player, dealer);
        boolean expResult = true;
        boolean result = instance.blackjack(player);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testBlackjackbad() {
        System.out.println("Check blackjack bad");
        Player player = new Player("Tester");
        Dealer dealer = new Dealer("Tester");
        Card card1 = new Card(Rank.TWO, Suit.CLUBS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
        player.getHand().add(card1);
        player.getHand().add(card2);
        VNBlackJack instance = new VNBlackJack(player, dealer);
        boolean expResult = false;
        boolean result = instance.blackjack(player);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculate method, of class VNBlackJack.
     */
    @Test
    public void testCalculate() {
        System.out.println("Check calculate good");
        Player player = new Player("Tester");
        Dealer dealer = new Dealer("Tester");
        Card card1 = new Card(Rank.TEN, Suit.CLUBS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
        player.getHand().add(card1);
        player.getHand().add(card2);
        Card card3 = new Card(Rank.JACK, Suit.CLUBS);
        Card card4 = new Card(Rank.NINE, Suit.HEARTS);
        dealer.getHand().add(card3);
        dealer.getHand().add(card4);
        VNBlackJack instance = new VNBlackJack(player, dealer);
        instance.calculate();
        boolean expResult = true;
        boolean result = instance.getPlayer().getHand().calculatePts() > instance.getDealer().getHand().calculatePts();
        assertEquals(expResult, result);
    }

    /**
     * Test of reset method, of class VNBlackJack.
     */
    @Test
    public void testReset() {
        System.out.println("Check reset");
        Player player = new Player("Tester");
        Dealer dealer = new Dealer("Tester");
        Card card1 = new Card(Rank.TEN, Suit.CLUBS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
        player.getHand().add(card1);
        player.getHand().add(card2);
        Card card3 = new Card(Rank.JACK, Suit.CLUBS);
        Card card4 = new Card(Rank.NINE, Suit.HEARTS);
        dealer.getHand().add(card3);
        dealer.getHand().add(card4);
        VNBlackJack instance = new VNBlackJack(player, dealer);
        instance.reset();
        boolean expResult = true;
        boolean result = instance.getPlayer().getHand().getMyHand().isEmpty() && instance.getDealer().getHand().getMyHand().isEmpty();
        assertEquals(expResult, result);
    }
    
}
