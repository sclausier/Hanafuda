import java.awt.image.BufferedImage;


//Card class
    /*
     * contains information about each card
     * name = card's name (also functions as the card's id)
     * month = the month that the card is from, aka the card's hiki
     * num = the card's place in the hiki (1-4)
     * points = the card's point value
     * gaji = if the card is a gaji (there should be only one gaji in the deck)
     * image = the image of the card
     */
public class Card {

    private String name;
    private String month;
    private int num;
    private int points;
    private boolean gaji;
    private BufferedImage image;

    // Creates a default card
    public Card() {
        this.gaji = false;
    }

    // Creates a card with the specified values
    public Card(String name, String month, int num, int points, boolean gaji, BufferedImage image) {
        this.name = name;
        this.month = month;
        this.num = num;
        this.points = points;
        this.gaji = gaji;
        this.image = image;
    }


    // returns the card's name
    public String getName() {
        return this.name;
    }

    // returns the card's month/hiki
    public String getMonth() {
        return this.month;
    }

    // returns the card's number in the hiki
    public int getNum() {
        return this.num;
    }

    // returns the card's point value
    public int getPoint() {
        return this.points;
    }

    // returns if the card is a gaji (t/f)
    public boolean isGaji() {
        return this.gaji;
    }

    // returns the card's image
    public BufferedImage getImage() {
        return this.image;
    }
}
