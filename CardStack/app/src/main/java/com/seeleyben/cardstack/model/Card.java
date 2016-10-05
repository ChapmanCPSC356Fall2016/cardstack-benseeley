package com.seeleyben.cardstack.model;

public class Card
{
    private Suit m_suit;
    private int m_number;

    public Card(Suit suit, int number)
    {
        m_suit = suit;
        m_number = number;
    }

    public Suit getSuit()
    {
        return m_suit;
    }

    public int getNumber()
    {
        return m_number;
    }

}
