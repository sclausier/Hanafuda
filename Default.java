import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
// import java.util.Random;
// import java.util.Set;

public class Default extends JPanel {

    private JButton[] hand;
    private String[] handImgs;
    private JLabel[] oppoHand;
    private JButton[][] field;
    private String[][] fieldImgs; 
    // private int depth;
    // private int width;
    private boolean pressed;

    public Default() {
        setPreferredSize(new Dimension(1100, 750));
        setBackground(Color.DARK_GRAY);

        Deck deck = new Deck();
        // System.out.println(deck.getCurrDeckSize());

        this.pressed = false;

        this.hand = new JButton[8];
        this.handImgs = new String[8];
        this.oppoHand = new JLabel[9];
        this.field = new JButton[2][6];
        this.fieldImgs = new String[2][6];

        // this.depth = 475;
        // this.width = 5;
        myCards(475, 5);
        
        drawStack(deck);
        ruleButton();
        goButton();

        oppHand();

        theField();

        

    }

    // Adds the drawing stack button (represents the drawing stack)
    private void drawStack(Deck deck) {
        JButton button = new JButton();

        ImageIcon icon = new ImageIcon("./cards/back-of-card.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(156, 234, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        button.setIcon(icon);

        // Dimension size = button.getPreferredSize();
        button.setBounds(10, 250, 156, 234);
        setLayout(null);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);

        button.setBorder(BorderFactory.createEmptyBorder());
        button.setToolTipText("Drawing stack");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(deck.getCurrDeckSize());
                if (pressed == false) {
                    deal(deck);
                } 

                // System.out.println("do later");
            }
        });
        add(button);
    }

    // Adds the rule button
    // click to show the rules
    private void ruleButton() {

        JButton ruleButt = new JButton();

        ImageIcon ruleIcon = new ImageIcon("./cards/rules-button.png");
        Image img = ruleIcon.getImage();
        Image newImg = img.getScaledInstance(86, 46, java.awt.Image.SCALE_SMOOTH);
        ruleIcon = new ImageIcon(newImg);
        ruleButt.setIcon(ruleIcon);

        // Dimension size =  ruleButt.getPreferredSize();
        ruleButt.setBounds(950, 10, 86, 46);
        setLayout(null);
        ruleButt.setContentAreaFilled(false);
        ruleButt.setFocusPainted(false);

        ruleButt.setBorder(BorderFactory.createEmptyBorder());
        ruleButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add rule popup later");
            }
        });

        add(ruleButt);

    }

    // adds the go button
    // when player wants to end turn, they press this button
    // signals next player's turn to start
    private void goButton() {

        JButton goButt = new JButton();

        ImageIcon goIcon = new ImageIcon("./cards/go-button.png");
        Image img = goIcon.getImage();
        Image newImage = img.getScaledInstance(129, 69, java.awt.Image.SCALE_SMOOTH);
        goIcon = new ImageIcon(newImage);
        goButt.setIcon(goIcon);

        // Dimension size = goButt.getPreferredSize();
        goButt.setBounds(900, 325, 129, 69);
        setLayout(null);
        goButt.setBorder(null);
        goButt.setContentAreaFilled(false);
        goButt.setFocusPainted(false);

        goButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add go function later (with turn switching)");
            }
        });

        add(goButt);

    }

    // my hand of cards
    private void myCards(int depth, int width) {


        for (int i = 0; i < hand.length; i++) {
            this.hand[i] = cardInHand("back-of-card", i, width, depth, false);
            this.handImgs[i] = "back-of-card";
            width += 130;
        }



    }

    // represents each of the cards in my hand
    private JButton cardInHand(String cardName, int index, int width, int depth, boolean show) {
        JButton card = new JButton();
        ImageIcon cardCon = new ImageIcon("./cards/" + cardName + ".png");
        Image img = cardCon.getImage();
        Image newImage = img.getScaledInstance(156, 234, java.awt.Image.SCALE_SMOOTH);
        cardCon = new ImageIcon(newImage);
        card.setIcon(cardCon);

        // Dimension size = card.getPreferredSize();
        card.setBounds(width, depth, 156, 234);
        setLayout(null);
        card.setContentAreaFilled(false);
        card.setFocusPainted(false);

        card.setBorder(BorderFactory.createEmptyBorder());


        card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cardName);
                System.out.println("add card function later. card no. " + index);
            }
        });

        if (cardName.equals("back-of-card")) {
            card.setEnabled(false);
        } 

        add(card);
        return (card);
    }


    // Deals the deck and adds cards to your hand
    // also shows that cards were dealt to the opponent
    public void deal(Deck deck) {

        for (int i = 1; i < oppoHand.length; i++) {
            ImageIcon back = new ImageIcon("./cards/back-of-card.png");
            Image img = back.getImage();
            Image newImage = img.getScaledInstance(78, 117, java.awt.Image.SCALE_SMOOTH);
            back = new ImageIcon(newImage);
            oppoHand[i].setIcon(back);
        }

        this.pressed = true; // pretty sure this line is irrelevant
        Random rand = new Random();
        for (int i = 0; i < 16; i ++) { // 16 bc that's the number of cards in my hand plus the number of cards in the opponent's hand
            Set<String> currDeckSet = deck.getCurrDeck().keySet();
            int curr = rand.nextInt(deck.getCurrDeckSize());
            String cardKey = "";
            // System.out.println(curr);

            int j = 0;
            for (String key : currDeckSet) {
                // System.out.println(j + " : " + curr + " ---> " + key);
                if (j == curr) {
                    cardKey = key;
                    // System.out.println(cardKey);
                    break;
                }
                j ++;
            }

            if (i % 2 == 0) {
                deck.putInMine(cardKey);
                // finds the first blank image in ur hand and replaces it with the card key. 
                // breaks after it's found so that only one image is replaced
                // does this for each iteration of the loop 
                for (int k = 0; k < this.handImgs.length; k ++) {
                    String img = this.handImgs[k];
                    if (img.equals("back-of-card")) {
                        // Icon im = new ImageIcon("./cards/" + cardKey + ".png");

                        ImageIcon im = new ImageIcon("./cards/" + cardKey + ".png");
                        Image imga = im.getImage();
                        Image newImage = imga.getScaledInstance(156, 234, java.awt.Image.SCALE_SMOOTH);
                        im = new ImageIcon(newImage);
                        
                        this.hand[k].setIcon(im);
                        this.hand[k].setEnabled(true);
                        this.handImgs[k] = cardKey;
                        break;
                    }
                }
            } else {
                deck.putInOpp(cardKey);
            }
            
        }

        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[0].length; j++) {
                System.out.println("card at " + i + "," + j);
                Set<String> currDeckSet = deck.getCurrDeck().keySet();
                int curr = rand.nextInt(deck.getCurrDeckSize());
                String cardKey = "";

                int k = 0;
                for (String key : currDeckSet) {
                    // System.out.println(j + " : " + curr + " ---> " + key);
                    if (k == curr) {
                        cardKey = key;
                        deck.putInField(cardKey);
                        // System.out.println(cardKey);
                        break;
                    }
                    k ++;
                }

                if (this.fieldImgs[i][j].equals("back-of-card")) {
                    ImageIcon im = new ImageIcon("./cards/" + cardKey + ".png");
                    Image imga = im.getImage();
                    Image newImage = imga.getScaledInstance(130, 195, java.awt.Image.SCALE_SMOOTH);
                    im = new ImageIcon(newImage);

                    this.field[i][j].setIcon(im);
                    this.field[i][j].setEnabled(true);
                    this.fieldImgs[i][j] = cardKey;
                }
            }

        }
    }

    // shows the opponent's cards
    private void oppHand() {

        oppoHand[0] = new JLabel();
        oppoHand[0].setText("<html><body><br><br>Opponent's<br>hand</body></html>");
        Dimension size0 = oppoHand[0].getPreferredSize();
        oppoHand[0].setBounds(5,10, size0.width, size0.height);
        add(oppoHand[0]);

        int wid = 75;
        int dep = 10;
        for (int i = 1; i < oppoHand.length; i++) {
            oppoHand[i] = new JLabel();
            ImageIcon back = new ImageIcon("./cards/empty.png");
            Image img = back.getImage();
            Image newImage = img.getScaledInstance(78, 117, java.awt.Image.SCALE_SMOOTH);
            back = new ImageIcon(newImage);
            oppoHand[i].setIcon(back);

            // Dimension size = oppoHand[i].getPreferredSize();
            oppoHand[i].setBounds(wid, dep, 78, 117);
            setLayout(null);


            oppoHand[i].setBorder(BorderFactory.createEmptyBorder());

            add(oppoHand[i]);
            wid += 70;
        }

    }

    private void theField() {
        // System.out.println(deck.getCurrDeckSize());
        int width = 180;
        int depth = 130;
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[0].length; j++) {
                this.field[i][j] = cardInField("back-of-card", width, depth);
                this.fieldImgs[i][j] = "back-of-card";
                width += 110;
            }
            width = 180;
            depth += 160;
        }
    }

    private JButton cardInField(String cardName, int width, int depth) {
        JButton card = new JButton();
        ImageIcon image = new ImageIcon("./cards/" + cardName + ".png");
        Image img = image.getImage();
        Image newImage = img.getScaledInstance(130, 195, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newImage);
        card.setIcon(image);

        // Dimension size = card.getPreferredSize();
        card.setBounds(width, depth, 130, 195);
        setLayout(null);
        card.setContentAreaFilled(false);
        card.setFocusPainted(false);
        
        card.setBorder(BorderFactory.createEmptyBorder());

        card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cardName);
                System.out.println("add card function later. ");
            }
        });

        card.setEnabled(false);

        add(card);



        return card;
    }
    

}
