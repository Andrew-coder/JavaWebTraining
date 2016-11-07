package model;

/**
 * this method describes the address as a part of record
 */
public class Address {
    private int index;
    private String city;
    private int homeNumber;
    private int apartmentNumber;
    private String fullAddress;
    public Address() {

    }

    public Address(int index, String city, int homeNumber, int apartmentNumber) {
        this.index = index;
        this.city = city;
        this.homeNumber = homeNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
