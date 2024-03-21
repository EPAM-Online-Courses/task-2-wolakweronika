package efs.task.syntax;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
public class GuessNumberGame {

    public int M;

    public String progressBar;

    public int randomNumber;

    public int L;

    public int p = 0;

    public int x;

    //Do not modify main method
    public static void main(String[] args) {
        try {
            GuessNumberGame game = new GuessNumberGame(args.length > 0 ? args[0] : "");
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GuessNumberGame(String argument) {
        try {

            this.M = Integer.parseInt(argument);

            if (M > 400 || M < 1) {
                System.out.println(UsefulConstants.WRONG_ARGUMENT);
                throw new java.lang.IllegalArgumentException("- podany argument jest spoza zakresu.");

            }
        } catch (NumberFormatException e) {

            System.out.println(UsefulConstants.WRONG_ARGUMENT);
            throw new java.lang.IllegalArgumentException("- podany argument nie jest liczba.");

        }

        System.out.println("zgadujesz liczbe z przedzialu <1," + this.M + ">");

        Random random = new Random();
        this.randomNumber = random.nextInt(M) + 1;

        this.L = (int) (Math.log(M) / Math.log(2) + 1);


        this.progressBar = "[";

        for (int i = 0; i < L; i++) {
            this.progressBar += ".";
        }
        this.progressBar += "]";

    }

    public void newProgressBar()
    {
        if (this.p >= 0 && this.p < this.progressBar.length()) {
            this.p++;
            this.progressBar = this.progressBar.substring(0, this.p) + "*" + this.progressBar.substring(this.p + 1);
        } else {
            System.out.println("Index out of bounds");
        }
    }
    public void play() {

        Scanner scanner = new Scanner(System.in);

        while(p < L) {
            newProgressBar();
            System.out.println(progressBar);
            System.out.println(UsefulConstants.GIVE_ME);
            try{
                x = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {

                System.out.println(UsefulConstants.NOT_A_NUMBER);
                continue;
            }
            if(x>randomNumber)
            {
                System.out.println(UsefulConstants.TO_MUCH);
            }
            else if(x<randomNumber)
            {
                System.out.println(UsefulConstants.TO_LESS);
            }
            else {
                System.out.println(UsefulConstants.YES);
                break;
            }
        }
        if(x == randomNumber)
        {
            System.out.println(UsefulConstants.CONGRATULATIONS);
        }
        else
        {
            System.out.println(UsefulConstants.UNFORTUNATELY);
        }
    }
}

