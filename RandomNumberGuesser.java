import java.util.Scanner;
public class RandomNumberGuesser {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        //initialize data members
        int randNum = 0;
        int nextGuess = 0;
        int lowGuess = 0;
        int highGuess = 0;
        int first = 0;
        int correct = 0;
        // header
        System.out.println("GUESS THE NUMBER ");
        do {
            correct = 0;
            // first guess, generates random number
            if (first == 0) {
                randNum = RNG.rand();
                highGuess = 100;
                lowGuess = 0;
                System.out.println("Enter your first guess");
                nextGuess = Integer.parseInt(r.nextLine());
                //checks if first guess is between the high and low
                if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
                    System.out.println("Number of guessses is " + RNG.getCount());
                    if (nextGuess > randNum) {
                        System.out.println("You guess is too high");
                        highGuess = nextGuess;
                    } else if (nextGuess < randNum) {
                        System.out.println("Your guess is too low");
                        lowGuess = nextGuess;
                    } else if (nextGuess == randNum) {
                        correct = 1;
                    }
                }
                first = 1;
            } else {
                do {
                    System.out.println("Enter your guess between " + lowGuess + " and " + highGuess);
                    nextGuess = Integer.parseInt(r.nextLine());
                    if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
                        System.out.println("Number of guessses is " + RNG.getCount());             
                        if (nextGuess > randNum) {
                            System.out.println("Your guess is too high");
                            highGuess = nextGuess;
                        } else if (nextGuess < randNum) {
                            System.out.println("Your guess is too low");
                            lowGuess = nextGuess;
                        } else if (nextGuess == randNum) {
                            correct = 1;
                            break;
                        }
                    }
                } while (true);
            }
        
            if (correct == 1) {
                System.out.println("Congratulations, you guessed correctly.");
                int exit = 0;
                // let the user choose to try playing again   
                do {
                    System.out.println("Try again? (yes or no)");
                    String choice = r.nextLine();
                    if(choice.equalsIgnoreCase("yes")){
                        RNG.resetCount();
                        first = 0;
                        break;
                    }else if(choice.equalsIgnoreCase("no")){
                        exit = 1;
                        break;
                    }
                } while (true);
                if(exit==1){
                    break;
                }
            }
        } while (true);
        System.out.println("Hello my name is Giovanni Argueta\n Thank you for playing...");
    }
}


