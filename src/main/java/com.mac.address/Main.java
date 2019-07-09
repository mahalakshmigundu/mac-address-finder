package com.mac.address;

import com.mac.external.call.api.RestServiceHelper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Welcome Instructions to the User.
        System.out.println("**********************************************************************");
        System.out.println("This is Mac Address Finder Program");
        System.out.println("Please Enter the Mac Address to find the details of the Mac Address.");
        System.out.println("Please enter 'Exit' to exit the program.");
        System.out.println("**********************************************************************");
        System.out.print("Enter the Mac Address:");

        Scanner scanner = new Scanner(System.in);
        do {
            // read the Input from the User.
            String macAddress = scanner.next();

            // validate the Input fields first.
            if (macAddress == null && macAddress.isEmpty()) {
                System.out.println("Wrong Input Please try again.");
                continue;
            }

            // exit condition
            if (macAddress.equalsIgnoreCase("Exit")) {
                System.exit(1);
            }

            // make rest call here.
            RestServiceHelper.callExternalMacApi(macAddress);

            System.out.println("**********************************************************************");
            System.out.print("Please enter the Another Mac Address or Enter 'Exit' to exit the program.:");
        } while (scanner.hasNext());

    }
}
