package model;

import model.state.ATMState;
import model.state.IdleState;

public class ATM {
    private ATMState atmState;
    private int balance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    private static ATM atmObject;

    public static ATM getATMObject() {
        if(atmObject == null) {
            atmObject = new ATM();
            atmObject.setAtmState(new IdleState());
        }
        return atmObject;
    }

    private ATM() {
    }

    public void addNotesToMachine(int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.noOfTwoThousandNotes += noOfTwoThousandNotes;
        this.noOfFiveHundredNotes += noOfFiveHundredNotes;
        this.noOfOneHundredNotes += noOfOneHundredNotes;
        this.balance += 2000 * noOfTwoThousandNotes + 500 * noOfFiveHundredNotes + 100 * noOfOneHundredNotes;
    }

    public void deductTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes -= noOfTwoThousandNotes;
        this.balance -= 2000 * noOfTwoThousandNotes;
    }

    public void deductFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes -= noOfFiveHundredNotes;
        this.balance -= 500 * noOfFiveHundredNotes;
    }

    public void deductOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes -= noOfOneHundredNotes;
        this.balance -= 100 * noOfOneHundredNotes;
    }

    public int getBalance() {
        return balance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void printATM() {
        System.out.println("ATM Balance: " + balance);
        System.out.println("2K Notes: " + noOfTwoThousandNotes);
        System.out.println("500 Notes: " + noOfFiveHundredNotes);
        System.out.println("100 Notes: " + noOfOneHundredNotes);
    }
}
