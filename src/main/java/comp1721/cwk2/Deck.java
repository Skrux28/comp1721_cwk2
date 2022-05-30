package comp1721.cwk2;

import java.util.Collections;

// Implement Deck class here
public class Deck extends CardCollection{
    public Deck(){
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                cards.add(new Card(rank.getSymbol() +String.valueOf(suit.getSymbol())));
            }
        }
    }
    @Override
    public int size(){
        return cards.size();
    }
    @Override
    public boolean isEmpty(){
        if(cards.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean contains(Card card){
        for (int i=0; i<cards.size();i++){
            if(cards.get(i).hashCode() == card.hashCode()){
                return true;
            }
        }
        return false;
    }
    @Override
    public void discard(){
        cards.clear();
    }
    public Card deal(){
        if(cards.size()==0){
            throw new CardException("the deck is already empty!");
        }
        else{
            Card dealCard = cards.get(0);
            cards.remove(dealCard);
            return dealCard;
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
}