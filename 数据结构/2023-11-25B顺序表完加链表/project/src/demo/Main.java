package demo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("买牌");
        CardGame cardGame = new CardGame();
        List<Card> cardList = cardGame.buyCard();
        System.out.println(cardList);
        System.out.println("洗牌");
        cardGame.shuffle(cardList);
        System.out.println(cardList);
        System.out.println("发牌");
        List<List<Card>> ret = cardGame.getCard(cardList);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println("第"+i+"个人: "+ret.get(i));
        }
        System.out.println("剩下的牌");
        System.out.println(cardList);
    }
}
