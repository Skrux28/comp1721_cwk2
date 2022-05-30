package comp1721.cwk2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Implement PokerHand class here
public class PokerHand extends CardCollection{
    public PokerHand(){
        cards.clear();
    }
    public PokerHand(String cardsString){
        cards.clear();
        String[] str = cardsString.split("\\s+");
        int count = 0;
        for (String s: str){
            Card card = new Card(s);
            if (count>=5){
                throw new CardException("Cards in a hand should be less than 5!");
            }
            cards.add(card);
            count++;
        }
    }
    @Override
    public String toString(){
        String cardString2 = "";
        int i=0;
        if (cards.size()!= 0){
            for (i=0;i<cards.size()-1;i++){
                cardString2+=String.valueOf(cards.get(i).getRank().getSymbol())+ cards.get(i).getSuit().getSymbol();
                cardString2+=(" ");
            }
            cardString2+=String.valueOf(cards.get(cards.size()-1).getRank().getSymbol())+ cards.get(i).getSuit().getSymbol();
        }
        return cardString2;
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public void discard() {
        if (cards.size()!=0){
            cards.clear();
        }
        else{
            throw new CardException("This hand is empty!");
        }
    }
    public void discardTo(Deck deck1){
        if (cards.size()!=0){
            deck1.cards.addAll(cards);
            cards.clear();
        }
        else{
            throw new CardException("this hand is empty!");
        }
    }
    @Override
    public void add(Card card){
        if(cards.contains(card)){
            throw new CardException("Adding a duplicate card to the hand");
        }
        else if (cards.size()==5){
            throw new CardException("This hand has been full!");
        }
        else {
            cards.add(card);
        }
    }
    public boolean isPair(){
        if (cards.size()==5){
            List<Character> list = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>(5);
            for(int i=0;i<5;i++){
                list.add(cards.get(i).getRank().getSymbol());
            }
            for(Character c: list){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) +1);
                }
                else{
                    map.put(c, 1);
                }
            }
            for (Character k : map.keySet()) {
                if (map.get(k) == 2) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTwoPairs(){
        if (cards.size()==5){
            List<Character> list = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>(5);
            for(int i=0;i<5;i++){
                list.add(cards.get(i).getRank().getSymbol());
            }
            for(Character c: list){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) +1);
                }
                else{
                    map.put(c, 1);
                }
            }
            int count = 0;
            for (Character k : map.keySet()) {
                if (map.get(k) == 2) {
                    count++;
                }
            }
            return count == 2;
        }
        return false;
    }
    public boolean isThreeOfAKind() {
        if (cards.size()==5){
            List<Character> list = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>(5);
            for(int i=0;i<5;i++){
                list.add(cards.get(i).getRank().getSymbol());
            }
            for(Character c: list){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) +1);
                }
                else{
                    map.put(c, 1);
                }
            }
            for (Character k : map.keySet()) {
                if (map.get(k) == 3) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isFourOfAKind(){
        if (cards.size()==5){
            List<Character> list = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>(5);
            for(int i=0;i<5;i++){
                list.add(cards.get(i).getRank().getSymbol());
            }
            for(Character c: list){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) +1);
                }
                else{
                    map.put(c, 1);
                }
            }
            for (Character k : map.keySet()) {
                if (map.get(k) == 4) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isFullHouse(){
        if (cards.size()==5){
            List<Character> list = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>(5);
            for(int i=0;i<5;i++){
                list.add(cards.get(i).getRank().getSymbol());
            }
            for(Character c: list){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) +1);
                }
                else{
                    map.put(c, 1);
                }
            }
            boolean three = false;
            boolean two = false;
            for (Character k : map.keySet()) {
                if (map.get(k) == 3) {
                    three = true;
                }
                if (map.get(k) == 2){
                    two = true;
                }
            }
            return three && two;
        }
        return false;
    }
    public boolean isFlush(){
        return false;
    }
    public boolean isStraight(){
        return false;
    }
}