package demo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("买牌");
        CardGame cardGame = new CardGame();
        List<Card> cardList = cardGame.buyCard();
        System.out.println(cardList);
        System.out.println("洗牌");
    }
}
