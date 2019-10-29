package by.sulitsenko.autop.entity;

import java.util.Map;
import java.util.stream.Collectors;

public class CarInfo {
    private String moneyBel;
    private String moneyUsd;
    private String phone;
    private String ownerName;
    private String ownerCity;
    private Map<String, String> carDetails;

    public String getMoneyBel() {
        return moneyBel;
    }

    public void setMoneyBel(String moneyBel) {
        this.moneyBel = moneyBel;
    }

    public String getMoneyUsd() {
        return moneyUsd;
    }

    public void setMoneyUsd(String moneyUsd) {
        this.moneyUsd = moneyUsd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public Map<String, String> getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(Map<String, String> carDetails) {
        this.carDetails = carDetails;
    }

    @Override
    public String toString() {
        String string = carDetails.entrySet().stream().map(x -> x.getKey() + " = " + x.getValue()).collect(Collectors.joining("\n"));
        return "BYN = " + moneyBel + "\n" +
                "USD = " + moneyUsd + "\n" +
                "owner city = " + ownerCity + "\n" +
                "owner name = " + ownerName + "\n" +
                "owner phone = " + phone + "\n" +
                string;
    }
}
