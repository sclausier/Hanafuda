// import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.io.*;


// Deck class
    /* Creates the original deck with original 48 cards (standard for each play)
     * Creates the changeDeck which removes cards as the game progresses 
     *      (ie: when a card is dealt)
     * Creates the player's hand
     * Creates the opponent's hand 
     */
//

public class Deck {
    
    private Card[] ogDeck;
    private Map<String, Card> changeDeck;
    private Map<String, Card> myHand;
    private Map<String, Card> oppHand;
    private Map<String, Card> field;
    
    public Deck() {
        fillDecks();
        
    }

    // Fills the different decks
    // ogDeck and changeDeck get the original 48 cards
    // myHand and oppHand start empty
    private void fillDecks(){
        this.ogDeck = new Card[32]; // change to 48 later
        this.myHand = new TreeMap<>();
        this.oppHand = new TreeMap<>();
        this.changeDeck = new TreeMap<>();
        this.field = new TreeMap<>();

        ogDeck[0] = new Card("mutsuki-1", "Jan", 1, 
            20, false, picture("./cards/mutsuki-1.png"));

        ogDeck[1] = new Card("mutsuki-2", "Jan", 2, 
            10, false, picture("./cards/mutsuki-2.png"));
        
        ogDeck[2] = new Card("mutsuki-3", "Jan", 3, 
            0, false, picture("./cards/mutsuki-3.png"));

        ogDeck[3] = new Card("mutsuki-4", "Jan", 4, 
            0, false, picture("./cards/mutsuki-4.png"));

        ogDeck[4] = new Card("kisaragi-1", "Feb", 1, 
            10, false, picture("./cards/kisaragi-1.png"));
        
        ogDeck[5] = new Card("kisaragi-2", "Feb", 2, 
            5, false, picture("./cards/kisaragi-2.png"));

        ogDeck[6] = new Card("kisaragi-3", "Feb", 3, 
            0, false, picture("./cards/kisaragi-3.png"));

        ogDeck[7] = new Card("kisaragi-4", "Feb", 4, 
            0, false, picture("./cards/kisaragi-4.png"));

        ogDeck[8] = new Card("yayoi-1", "March", 1, 
            20, false, picture("./cards/yayoi-1.png"));
        
        ogDeck[9] = new Card("yayoi-2", "March", 2, 
            10, false, picture("./cards/yayoi-2.png"));
        
        ogDeck[10] = new Card("yayoi-3", "March", 3, 
            0, false, picture("./cards/yayoi-3.png"));

        ogDeck[11] = new Card("yayoi-4", "March", 4, 
            0, false, picture("./cards/yayoi-4.png"));

        ogDeck[12] = new Card("uzuki-1", "April", 1, 
            10, false, picture("./cards/uzuki-1.png"));

        ogDeck[13] = new Card("uzuki-2", "April", 2, 
            5, false, picture("./cards/uzuki-2.png"));

        ogDeck[14] = new Card("uzuki-3", "April", 3, 
            0, false, picture("./cards/uzuki-3.png"));

        ogDeck[15] = new Card("uzuki-4", "April", 4, 
            0, false, picture("./cards/uzuki-4.png"));
        
        ogDeck[16] = new Card("satsuki-1", "May", 1, 
            10, false, picture("./cards/satsuki-1.png"));

        ogDeck[17] = new Card("satsuki-2", "May", 2, 
            5, false, picture("./cards/satsuki-2.png"));
        
        ogDeck[18] = new Card("satsuki-3", "May", 3, 
            0, false, picture("./cards/satsuki-3.png"));
        
        ogDeck[19] = new Card("satsuki-4", "May", 4,  
            0, false, picture("./cards/satsuki-4.png"));

        ogDeck[20] = new Card("minazuki-1", "June", 1, 
            10, false, picture("./cards/minazuki-1.png"));
        
        ogDeck[21] = new Card("minazuki-2", "June", 2, 
            5, false, picture("./cards/minazuki-2.png"));

        ogDeck[22] = new Card("minazuki-3", "June", 3, 
            0, false, picture("./cards/minazuki-3.png"));

        ogDeck[23] = new Card("minazuki-4", "June", 4, 
            0, false, picture("./cards/minazuki-4.png"));

        ogDeck[24] = new Card("fumizuki-1", "July", 1, 
            10, false, picture("./cards/fumizuki-1.png"));

        ogDeck[25] = new Card("fumizuki-2", "July", 2, 
            5, false, picture("./cards/fumizuki-2.png"));

        ogDeck[26] = new Card("fumizuki-3", "July", 3, 
            0, false, picture("./cards/fumizuki-3.png"));

        ogDeck[27] = new Card("fumizuki-4", "July", 4, 
            0, false, picture("./cards/fumizuki-4.png"));

        ogDeck[28] = new Card("hazuki-1", "August", 1, 
            20, false, picture("./cards/hazuki-1.png"));
        
        ogDeck[29] = new Card("hazuki-2", "August", 2, 
            5, false, picture("./cards/hazuki-2.png"));

        ogDeck[30] = new Card("hazuki-3", "August", 3, 
            0, false, picture("./cards/hazuki-3.png"));

        ogDeck[31] = new Card("hazuki-4", "August", 4, 
        0, false, picture("./cards/hazuki-4.png"));


        // ***** Implement when there is a full deck of cards (48) **************
        for (Card card : ogDeck) { 
            this.changeDeck.put(card.getName(), card);
        }

    }

    // A method to process pictures associated with each card. 
    private BufferedImage picture(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("File name is null");
        }
        BufferedImage image = null;

        try {
            File file = new File(fileName);
            if (file.isFile()) {
                image = ImageIO.read(file);
            }
            if (image == null) {
                throw new IllegalArgumentException("could not read image" + fileName);
            }
        }

        catch (IOException ioe) {
            throw new IllegalArgumentException("could not load image" + fileName + ioe);
        }

        return image;
    }

    // Gets the original deck (ogDeck)
    public Card[] getOGDeck() {
        return this.ogDeck;
    }

    // Get og Deck size
    public int getOGDeckSize() {
        return this.ogDeck.length;
    }

    // Gets the changeDeck
    public Map<String, Card> getCurrDeck() {
        return this.changeDeck;
    }

    // Gets the size of the changeDeck
    public int getCurrDeckSize() {
        return this.changeDeck.size();
    }

    // removes the given card from the curr deck via it's key
    public void remove(String key) {
        this.getCurrDeck().remove(key);
    }

    // Gets myHand
    public Map<String, Card> getMy() {
        return this.myHand;
    }

    // Gets the size of my hand
    public int getMySize() {
        return this.myHand.size();
    }

    // Gets oppHand
    public Map<String, Card> getOpp() {
        return this.oppHand;
    }

    // Gets the size of oppHand
    public int getOppSize() {
        return this.oppHand.size();
    }

    // Puts a card from the changeDeck into myHand
    // Removes the card from changeDeck after putting into myHand
    // Throws an exception if the card doesn't exist in changeDeck
    public void putInMine(String name) {
        if (this.changeDeck.get(name) == null) {
            throw new IllegalArgumentException("Card does not exist in the current deck");
        }

        Card curr = this.changeDeck.get(name);
        this.myHand.put(name, curr);
        this.changeDeck.remove(name);
    }

    // Puts a card from the changeDeck into oppHand
    // Removes the card from changeDeck after putting into oppHand
    // Throws an exception if the card doesn't exist in changeDeck
    public void putInOpp(String name) {
        if (this.changeDeck.get(name) == null) {
            throw new IllegalArgumentException("Card does not exist in the current deck");
        }

        Card curr = this.changeDeck.get(name);
        this.oppHand.put(name, curr);
        this.changeDeck.remove(name);
    }

    public void putInField(String name) {
        if (this.changeDeck.get(name) == null) {
            throw new IllegalArgumentException("Card does not exist in the current deck");
        }

        Card curr = this.changeDeck.get(name);
        this.field.put(name, curr);
        this.changeDeck.remove(name);
    }
}
