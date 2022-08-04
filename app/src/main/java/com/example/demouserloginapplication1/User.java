package com.example.demouserloginapplication1;

public class User {
    String name, surname, phoneNo, age, address, qualification, job_details;
    String id;
    byte[] imageId;

    public User(String name, String surname, String phoneNo, String age, String address, String qualification, String job_details) {
        this.name = name;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.age = age;
        this.address = address;
        this.qualification = qualification;
        this.job_details = job_details;
       // this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getJob_details() {
        return job_details;
    }

    public void setJob_details(String job_details) {
        this.job_details = job_details;
    }

    public byte[] getImageId() {
        return imageId;
    }

    public void setImageId(byte[] imageId) {
        this.imageId = imageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
