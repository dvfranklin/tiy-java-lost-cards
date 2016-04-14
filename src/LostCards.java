/**
 * You once had a nice deck of cards.
 *
 * The cards in the decal had the following values:
 *  Ace = 1
 *  2 = 2
 *  3 = 3
 *  ... etc ...
 *  10 = 10
 *  Jack = 11
 *  Queen = 12
 *  King = 13
 *
 * The symbols for the suits are:
 *
 *  Clubs = ♣
 *  Diamonds = ♢
 *  Hearts = ♡
 *  Spades = ♠
 *
 * Unfortunately you've lost the following cards:
 *  - King of Spades
 *  - All of the 3s except 3 of Diamonds
 *
 * All of the cards that are divisible by 3 and have a suit that is red have been torn.
 *
 * All of the face cards (ace, jack, queen, king) in the hearts and clubs suits have been water damaged.
 *
 * Any card whose value is the same as the number of letters in the card's suit (in plural form) is face down. All other
 * cards are face up. For example, the 6 of Hearts would be face down because "Hearts" is 6 letters long and the value
 * of the card is 6.
 *
 * Your task is to describe your deck of cards:
 *
 * Output the cards in ascending order by value, grouped by suit, in alphabetical order.
 *  - Ace of Clubs, 2 of clubs, 3 of clubs ... etc ... queen of spades, king of spades.
 *
 * For face cards output the first letter of the card. IE: A, J, Q, or K.
 *
 * For 10s output "t".
 *
 * For all other cards output the value of the card. IE: 2, 3, 4...., or 9.
 *
 * Cards in good shape are output like this: [A♢], [9♠], [t♣], etc.
 *
 * Cards that are torn are output like this: -A♢-, -9♠-, -t♣-, etc.
 *
 * Cards that are water damaged are output like this: ~A♢~, ~9♠~, ~t♣~ etc
 *
 * Cards that are torn AND water damaged are output like this: -~A♢~-, -~9♠~-, -~t♣~- etc
 *
 * Cards that are face down are output with asterisks instead of the card's value and suit. For example, [**], -**-, or ~**~.
 *
 * Output one card per line.
 *
 * Lastly, output the number of cards you have in your deck on its own line.
 *
 */
public class LostCards {
    public static void main(String[] args){

        // counter for total number of cards
        int countCards = 0;

        // loop through suits
        for(int suit=1; suit <= 4; suit++){

            // write out suits to check for length
            String suitText = "";
            switch(suit){
                case 1:
                    suitText = "Clubs";
                    break;
                case 2:
                    suitText = "Diamonds";
                    break;
                case 3:
                    suitText = "Hearts";
                    break;
                case 4:
                    suitText = "Spades";
                    break;
            }

            // loop through numbers
            for(int num=1; num <= 13; num++){

                String card = "";
                String suitSymbol = "";
                boolean isMissing = false;
                boolean isTorn = false;
                boolean isDamaged = false;
                boolean isDown = false;

                if ((num == 13 && suit == 4) || (num == 3 && suit != 2)){
                    isMissing = true;
                }

                if ((num % 3 == 0)  && (suit == 2 || suit == 3)){
                    isTorn = true;
                }

                if ((num == 1 || num == 11 || num == 12 || num == 13) && (suit == 1 || suit == 3)){
                    isDamaged = true;
                }

                if (num == suitText.length()){
                    isDown = true;
                }

                // change suitText to use suit symbols
                switch(suit){
                    case 1:
                        suitSymbol = "♣";
                        break;
                    case 2:
                        suitSymbol = "♢";
                        break;
                    case 3:
                        suitSymbol = "♡";
                        break;
                    case 4:
                        suitSymbol = "♠";
                        break;
                }

                switch(num){
                    case 1:
                        card = "A";
                        break;
                    case 10:
                        card = "t";
                        break;
                    case 11:
                        card = "J";
                        break;
                    case 12:
                        card = "Q";
                        break;
                    case 13:
                        card = "K";
                        break;
                    default:
                        Integer cardInt = new Integer(num);
                        card = cardInt.toString();
                }

                // if card is in the deck, print it out
                if(!isMissing){

                    if(isTorn && isDamaged && isDown){
                        System.out.println("-~**~-");
                        countCards++;
                    } else if(isTorn && isDown){
                        System.out.println("-**-");
                        countCards++;
                    } else if(isDamaged && isDown){
                        System.out.println("~**~");
                        countCards++;
                    } else if(isDamaged && isTorn){
                        System.out.println("-~" + card + suitSymbol + "~-");
                        countCards++;
                    } else if(isDamaged){
                        System.out.println("~" + card + suitSymbol + "~");
                        countCards++;
                    } else if(isTorn){
                        System.out.println("-" + card +suitSymbol + "-");
                        countCards++;
                    } else if(isDown){
                        System.out.println("[**]");
                        countCards++;
                    } else{
                        System.out.println("[" + card + suitSymbol + "]");
                        countCards++;
                    }
                }

            }

        }

        System.out.println(countCards);
    }
}
