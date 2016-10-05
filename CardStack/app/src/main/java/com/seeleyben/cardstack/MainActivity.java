package com.seeleyben.cardstack;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seeleyben.cardstack.model.Card;
import com.seeleyben.cardstack.model.Suit;

import java.util.Collections;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    TextView topNumber;
    TextView bottomNumber;
    ImageView topSuit;
    ImageView centerSuit;
    ImageView bottomSuit;
    RelativeLayout topCardLayout;
    Stack<Card> cardStack = new Stack<>();
    Card topCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topNumber = (TextView) findViewById(R.id.tv_topNumber);
        bottomNumber = (TextView) findViewById(R.id.tv_bottomNumber);
        topSuit = (ImageView) findViewById(R.id.iv_topSuit);
        centerSuit = (ImageView) findViewById(R.id.iv_centerSuit);
        bottomSuit = (ImageView) findViewById(R.id.iv_bottomSuit);
        topCardLayout = (RelativeLayout) findViewById(R.id.rl_topCard);

        createDeck();
        shuffleDeck();
        nextCard();
        loadCard(topCard);




    }

    private void nextCard()
    {
        topCard = cardStack.pop();
    }

    private void loadCard(Card card)
    {
        String cardNumber;
        int textColor;
        int  suitImage;
        switch (card.getNumber())
        {
            case 1:
                cardNumber = "A";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                cardNumber = Integer.toString(card.getNumber());
                break;
            case 11:
                cardNumber = "J";
                break;
            case 12:
                cardNumber = "Q";
                break;
            case 13:
                cardNumber = "K";
                break;
            default:
                cardNumber = "E";
                break;
        }
        switch (card.getSuit())
        {
            case HEART:
                suitImage = R.drawable.heart;
                textColor = Color.RED;
                break;
            case CLUB:
                suitImage = R.drawable.club;
                textColor = Color.BLACK;

                break;
            case SPADE:
                suitImage = R.drawable.spade;
                textColor = Color.BLACK;

                break;
            case DIAMOND:
                suitImage = R.drawable.diamond;
                textColor = Color.RED;

                break;
            default:
                suitImage = R.drawable.heart;
                textColor = Color.BLACK;

                break;
        }
        topNumber.setText(cardNumber);
        topNumber.setTextColor(textColor);

        bottomNumber.setText(cardNumber);
        bottomNumber.setTextColor(textColor);

        topSuit.setImageResource(suitImage);
        centerSuit.setImageResource(suitImage);
        bottomSuit.setImageResource(suitImage);




    }

    private void createDeck()
    {
        for(Suit suit : Suit.values())
        {
            for(int i = 0; i < 13; ++i)
            {
                cardStack.push(new Card(suit, i+1));
            }
        }
    }

    private void shuffleDeck()
    {
        Collections.shuffle(cardStack);
    }

    public void cardTapped(View view)
    {
        if(!cardStack.isEmpty())
        {
            nextCard();
            loadCard(topCard);
        }
        else
        {
            topCardLayout.setVisibility(View.GONE);
        }

    }
}
