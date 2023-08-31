/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartu;

/**
 *
 * @author Dimas
 */



public class Kartu {

    private final int rank;
    private final int suit;

    /**
     *
     */
    public final static int Tempe = 1;
    public final static int Keriting    = 2;
    public final static int Hati   = 3;
    public final static int Padung   = 4;

    
    public final static int AS   = 1;
    public final static int Dua = 2;
    public final static int Tiga = 3;
    public final static int Empat  = 4;
    public final static int Lima  = 5;
    public final static int Enam   = 6;
    public final static int Tujuh = 7;
    public final static int Delapan = 8;
    public final static int Sembilan  = 9;
    public final static int Sepuluh   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;

    public Kartu(int rank, int suit) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        this.rank = rank;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public static boolean isValidRank(int rank) {
        return AS <= rank && rank <= KING;
    }

    public static boolean isValidSuit(int suit) {
        return Tempe <= suit && suit <= Padung;
    }

    public static String rankToString (int rank) {
        switch (rank) {
        case AS:
            return "AS";
        case Dua:
            return "Dua";
        case Tiga:
            return "Tiga";
        case Empat:
            return "Empat";
        case Lima:
            return "Lima";
        case Enam:
            return "Enam";
        case Tujuh:
            return "Tujuh";
        case Delapan:
            return "Delapan";
        case Sembilan:
            return "Sembilan";
        case Sepuluh:
            return "Sepuluh";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";
        default:
            return null;
        }    
    }
    
    public static String suitToString(int suit) {
        switch (suit) {
        case Tempe:
            return "Tempe";
        case Keriting:
            return "Keriting";
        case Hati:
            return "Hati";
        case Padung:
            return "Padung";
        default:
            return null;
        }    
    }

    public static void main(String[] args) {
    	

        assert rankToString(AS) == "AS";
        assert rankToString(Dua) == "Dua";
        assert rankToString(Tiga) == "Tiga";
        assert rankToString(Empat) == "Empat";
        assert rankToString(Lima) == "Lima";
        assert rankToString(Enam) == "Enam";
        assert rankToString(Tujuh) == "Tujuh";
        assert rankToString(Delapan) == "Delapan";
        assert rankToString(Sembilan) == "Sembilan";
        assert rankToString(Sepuluh) == "Sepuluh";
        assert rankToString(JACK) == "Jack";
        assert rankToString(QUEEN) == "Queen";
        assert rankToString(KING) == "King";

        assert suitToString(Tempe) == "Tempe";
        assert suitToString(Keriting) == "Keriting";
        assert suitToString(Hati) == "Hati";
        assert suitToString(Padung) == "Padung";

    }
}


class Deck {

    public static int numSuits = 3;
    public static int numRanks = 10;
    public static int numCards = numSuits * numRanks;

    private Kartu[][] cards;

    public Deck() {
        cards = new Kartu[numSuits][numRanks];
        for (int suit = Kartu.Tempe; suit <= Kartu.Padung; suit++) {
            for (int rank = Kartu.AS; rank <= Kartu.KING; rank++) {
                cards[suit-1][rank-1] = new Kartu(rank, suit);
            }
        }
    }

    public Kartu getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
}
class Tampilan {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (int suit = Kartu.AS; suit <=Kartu.Padung; suit++) {
            for (int rank = Kartu.AS; rank <= Kartu.KING; rank++) {
                Kartu Kartu = deck.getCard(suit, rank);
                System.out.printf("%s of %s%\n",
                    Kartu.rankToString(Kartu.getRank()),
                    Kartu.suitToString(Kartu.getSuit())
                );
            }
        }
    }
}