package com.pluralsight;

public class RollTheDice {
    public static void main(String[] args) {
        int roll1;
        int roll2;
        int sum;
        int count2 = 0;
        int count4 = 0;
        int count6 = 0;
        int count7 = 0;

        Dice dice = new Dice();

        for (int i = 0; i < 100; i++) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            sum = roll1 + roll2;
            System.out.println("Roll " + (i+1) + ": " + roll1 + " - " + roll2 + " Sum: " + (sum));

            switch (sum) {
                case 2:
                    count2++;
                    break;
                case 4:
                    count4++;
                    break;
                case 6:
                    count6++;
                    break;
                case 7:
                    count7++;
                    break;
            }
        }

        System.out.println("Number of 2's: " + count2);
        System.out.println("Number of 4's: " + count4);
        System.out.println("Number of 6's: " + count6);
        System.out.println("Number of 7's: " + count7);

    }
}
