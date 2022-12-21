package main.atm;

import java.util.ArrayList;

public class Data {
    private String name = "";
    private Integer cardNumber;
    private Integer CVV;

    public String getName() {
        return name;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public Integer getCVV() {
        return CVV;
    }

    public Data(String name, Integer cardNumber, Integer CVV){

        this.name = name;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
    }
    public void printData(){

        System.out.println("Name\tcardNumber\tCVV");
        System.out.println(name + "\t" + cardNumber + "\t" + CVV);
    }
}