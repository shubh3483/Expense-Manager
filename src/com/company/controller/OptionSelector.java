package com.company.controller;

import java.util.Scanner;

public class OptionSelector {

    /**
     * This function is for giving the user different options and calling the functions according to the selected choice.
     */
    public static void selectOption(){

        TransactionController transactionController = new TransactionController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String message = "You can do the following operations \n Enter 1 : To create new Transaction \n" +
                " Enter 2 : To delete a transaction \n Enter 3 : To edit a transaction\n" +
                " Enter 4 : To see all transactions\n Enter 5 : To see transaction by month\n" +
                " Enter 0 : To exit\n Enter choice here";
        System.out.println(message);
        choice = scanner.nextInt();
        while (choice != 0){
            switch (choice){
                case 1 : transactionController.createTransactionCard();
                    break;
                case 2 : transactionController.deleteTransactionCard();
                    break;
                case 3 : transactionController.editTransactionCard();
                    break;
                case 4 : transactionController.showAllTransactionCards();
                    break;
                case 5 : transactionController.showTransactionCardsByMonth();
                    break;
                default :
                    System.out.println("Will se you again");
            }
            System.out.println(message);
            choice = scanner.nextInt();
        }
    }

}
