package org.example;

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected int age;
    protected boolean isMarried;
    protected Person partner;

    public Person(String firstName, String lastName, int age, boolean isMarried) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
        this.partner=null;
    }

    public abstract boolean isRetired(int age);

    public abstract void registerPartnership(Person partner);

    public abstract boolean deregisterPartnership(boolean returnToPreviousLastName);

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public boolean getMarriageStatus() {
        return isMarried;
    }

    public void setMarriageStatus(boolean isMarried) {
        this.isMarried = isMarried;
    }
}
