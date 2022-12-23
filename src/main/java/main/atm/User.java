package main.atm;

public class User {
    public String cardNumber, CVV;
    public Integer balance;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public User(String cardNumber, String CVV, Integer balance) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.balance = balance;
    }
    public User() {}
}
