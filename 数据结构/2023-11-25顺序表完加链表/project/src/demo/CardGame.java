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
        List<Card> hand = new ArrayList<>();
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                int index = random.nextInt(i);

            }
        }
    }
    public void swap(List<Card> cardList, int i, int j)

}
