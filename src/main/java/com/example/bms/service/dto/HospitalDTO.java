package com.example.bms.service.dto;

public class HospitalDTO {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private Integer numberOfRooms;
    private String logo;

    public HospitalDTO() {
    }

    public HospitalDTO(Long id, String name, String address, String contact, Integer numberOfRooms, String logo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.numberOfRooms = numberOfRooms;
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "HospitalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", logo='" + logo + '\'' +
                '}';
    }
}
