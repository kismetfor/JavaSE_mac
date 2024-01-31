package demo;

import java.util.List;

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
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = card[i];
                Card card = new Card(suit, j);
            }
        }
        return null;
    }

}
