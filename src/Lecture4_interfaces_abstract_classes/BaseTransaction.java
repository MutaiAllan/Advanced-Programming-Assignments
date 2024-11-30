package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private double amount;
    private Calendar date;
    private String transactionID;

    /**
     * Lecture1_adt.TransactionInterface Constructor
     * @param amount in an integer
     * @param date: Not null, and must be a Calendar object
     * @return void
     * Instialises the field, attributes of a transaction
     * Creates a object of this
     */
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    /**
     * getAmount()
     * Method to get the transaction amount
     * @return double
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * getDate()
     * @return Calendar Object
     */
    public Calendar getDate() {
//        return date;    // Because we are dealing with Reference types we need to judiciously copy what our getters return
        return (Calendar) date.clone(); // Defensive copying or Judicious Copying
    }

    // Method to get a unique identifier for the transaction
    public String getTransactionID(){
        return  transactionID;
    }
    // Method to print a transaction receipt or details
    public abstract void printTransactionDetails();
    public abstract void apply(BankAccount ba);
}
