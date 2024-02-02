package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 4 花色 * 13
 */
public class CardGame {
    public static final String[] card = {"♥", "♠", "♦", "♣"};

    /**
     * 生成一副扑克牌
     * 52张 4*13
     * @return
     */

    public List<Card> buyCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards.add(new Card(card[i], j));
            }
        }
        return cards;
    }
    //洗牌
    public void shuffle(List<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size()-1; i > 0 ; i--) {
            int index = random.nextInt(i);
            swap(cardList, i, index);
        }
    }
    public void swap(List<Card> cardList, int i, int j) {
        Card tmp = cardList.get(i);
        cardList.set(i, cardList.get(j));
        cardList.set(j, tmp);
    }
    public List<List<Card>> getCard(List<Card> cardList) {

        List<List<Card>> hand = new ArrayList<>();
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                hand.get(j).add(card);
            }
        }
        return hand;
    }



}
