package com.company;

import java.util.Scanner;


public class Main {

    static int SmallTrailers = 5;
    static int LargeTrailers = 3;
    static String[] SmallTrailersRenters = new String[5];
    static String[] BigTrailersRenters = new String[3];

    public static void main(String[] args)
    {
        main_menu();
    }

    public static void main_menu()
    {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("******************************************");
            System.out.println("* Trailer rental");
            System.out.println("******************************************");
            System.out.println("* 1) Rent small trailer");
            System.out.println("* 2) Rent large trailer");
            System.out.println("* 3) Overview");
            System.out.println("* 9) Exit");
            System.out.println("******************************************");
            System.out.print("Select an option:");

            int choice = in.nextInt();
            if (choice == 1) {
                rentSmallTrailer();
                continue;
            }

            if (choice == 2) {
                rentBigTrailer();
                continue;
            }

            if (choice == 3) {
                OverviewDisplay();
                continue;
            }

            if (choice == 9)
                return;
        }
    }

    public static void rentSmallTrailer()
    {
        Scanner in = new Scanner(System.in);

        if (SmallTrailers == 0) {
            System.out.println("Unfortunately, there are no small trailers available!");
            return;
        }
        System.out.print("What is the last name of the customer?");
        String renter = in.next();
        System.out.print("What is the weight of the load (in kg)?");
        int weight = in.nextInt();
        if (weight > 750) {
            System.out.println("Warning! The maximum load (750 kg) is exceeded by " + (weight - 750) + "kg!");
            while (true) {
                System.out.print("Are you sure you want to rent the trailer (y/n)?");
                char answer = in.next().charAt(0);
                if (answer == 'n') {
                    return;
                }
                if (answer != 'y')
                    continue;
                break;
            }
        }
        SmallTrailersRenters[5 - SmallTrailers] = renter;
        SmallTrailers --;
    }

    public static void rentBigTrailer()
    {
        Scanner in = new Scanner(System.in);

        if (LargeTrailers == 0) {
            System.out.println("Unfortunately, there are no large trailers available!");
            while (true) {
                System.out.print("Would you like to rent a small trailer instead (y/n)?");
                char answer = in.next().charAt(0);
                if (answer == 'n') {
                    return;
                }
                if (answer != 'y')
                    continue;
                rentSmallTrailer();
                return;
            }
        }
        System.out.print("What is the last name of the customer?");
        String renter = in.next();
        System.out.print("Is the driver in possession of an E-type drivers license (y/n)?");


    }

    public static void OverviewDisplay()
    {
        System.out.println("Rented small trailers:");
        for (int i = 0; i < 5 - SmallTrailers; i ++)
            System.out.println("   Small trailer " + (i + 1) + ": " + SmallTrailersRenters[i]);
        System.out.println("There are " + SmallTrailers + " out of 5 small trailers still available.");

        System.out.println("Rented large trailers:");
        for (int i = 0; i < 3 - LargeTrailers; i ++)
            System.out.println("   Large trailer " + (i + 1) + ": " + BigTrailersRenters[i]);
        System.out.println("There are " + LargeTrailers + " out of 3 small trailers still available.");
    }
}
