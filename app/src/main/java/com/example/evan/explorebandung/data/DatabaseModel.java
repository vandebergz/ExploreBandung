package com.example.evan.explorebandung.data;

/**
 * Created by evan on 5/14/17.
 */

public class DatabaseModel {

    private String id;
    private String place;
    private String address;
    //private String contact;
    private String idWisata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }*/

    public String getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(String idWisata) {
        this.idWisata = idWisata;
    }
}
