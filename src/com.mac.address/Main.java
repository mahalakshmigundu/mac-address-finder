package com.mac.address;

import external.api.call.RestServiceHelper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Welcome Instructions to the User.
        System.out.println("**********************************************************************");
        System.out.println("Please Enter the Mac Address to find the details of the Mac Address.");
        System.out.println("To Exit the Program please enter Exit");
        System.out.println("**********************************************************************");

        System.out.println("This is Mac Address Finder Program");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            System.out.print("Enter the Mac Address:");

            // read the Input from the User.
            String macAddress = scanner.next();

            // exit condition
            if(macAddress.equalsIgnoreCase("Exit")) {
                System.exit(1);
            }

            // validate the Input fields first.
            // throw the errors if necessary.


            // make rest call here.
            RestServiceHelper.callExternalMacApi(macAddress);

            System.out.println(macAddress);
        }

    }
}
