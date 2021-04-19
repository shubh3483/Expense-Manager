package com.company.controller;

import com.company.models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TransactionController {

    /**
     * This is to store all the transactions.
     */
    List<Transaction> transactions = new ArrayList<>();

    /**
     * This is to store transactions along with the date.
     */
    HashMap<String,List<Transaction>> listOfTransactionByDate = new HashMap<>();
    String mm;
    String date, finalDate;
    String[] dateArray;
    float amount;
    String type;
    String note = "";
    Scanner scanner = new Scanner(System.in);
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
            "Oct", "Nov", "Dec"};

    /**
     * This function will create new transaction and will store it in a hash map.
     */

    void createTransactionCard(){
        /*
            This is to store the newly created transaction so that the transaction can be easily stored with particular
            date in hashmap.
         */
        List<Transaction> listByDates = new ArrayList<>();

        transactionCardInput();
        Transaction transaction = new Transaction(finalDate,amount,type,note);
        transactions.add(transaction);
        listByDates.add(transaction);
        if(listOfTransactionByDate.containsKey(mm)){
            listOfTransactionByDate.get(mm).add(transaction);
            System.out.println("Transaction card added successfully");
            System.out.println("Your transaction card id is " + transaction.id);
        }else{
            listOfTransactionByDate.put(mm,listByDates);
        }
        System.out.println();
    }

    /**
     * This function is to delete a transaction based on the month and the transaction id.
     */

    void deleteTransactionCard(){
        int id;
        System.out.println("Enter transaction id");
        id = scanner.nextInt();
        System.out.println("Enter month(transaction month) in \'mm\'");
        mm = scanner.next();
        int flag = 0;
        if(listOfTransactionByDate.containsKey(mm)){
            for (Transaction transaction: listOfTransactionByDate.get(mm)) {
                if(transaction.id == id){
                    transactions.remove(transaction);
                    listOfTransactionByDate.get(mm).remove(transaction);
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0){
            System.out.println("Transaction not available");
        }
        System.out.println();
    }

    /**
     * This function is for functionality of edit transactions.
     */

    void editTransactionCard(){
        int id;
        System.out.println("Enter transaction id");
        id = scanner.nextInt();
        System.out.println("Enter month(transaction month) in \'mm\'");
        mm = scanner.next();
        int flag = 0;
        if(listOfTransactionByDate.containsKey(mm)){
            for (Transaction transaction: listOfTransactionByDate.get(mm)) {
                if(transaction.id == id){
                    transactionCardInput();
                    transaction.date = finalDate;
                    transaction.amount = amount;
                    transaction.type = type;
                    transaction.note = note;
                    System.out.println("Transaction card edited successfully\n");
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0){
            System.out.println("Transaction not available");
        }
        System.out.println();
    }

    /**
     * This function is to take input for creating and editing a transaction.
     */

    private void transactionCardInput() {
        System.out.println("Enter date(dd,mm,yyyy),amount,type(Expense or Income) and note");
        date = scanner.next();
        dateArray = date.split(",");
        finalDate = dateArray[0] + " " + months[Integer.parseInt(dateArray[1])-1] + " " + dateArray[2];
        mm = dateArray[1];
        amount = scanner.nextFloat();
        type = scanner.next();
        note = scanner.next();
    }


    /**
     * This function will display all the transactions
     */
    void showAllTransactionCards(){
        int counter = 1;
        for (Transaction transaction : transactions) {
            System.out.print(counter + " : ");
            System.out.println(transaction);
            counter++;
        }
        System.out.println();
    }

    /**
     * This function will display all the transactions of a particular month.
     */

    void showTransactionCardsByMonth(){
        System.out.println("Enter month number in \'mm\'");
        mm = scanner.next();
        int counter = 1;
        if(listOfTransactionByDate.containsKey(mm)){
            for (Transaction transaction: listOfTransactionByDate.get(mm)) {
                System.out.println(counter + " : ");
                System.out.println(transaction);
                counter++;
            }
        }else{
            System.out.println("No transaction on this month");
        }
        System.out.println();
    }
}
