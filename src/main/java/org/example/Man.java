package org.example;

public class Man extends Person {
    private String previousLastName;
    boolean isRetired = true;
    //private String partner;

    public Man(String firstName, String lastName, int age, boolean isMarried) {
        super(firstName, lastName, age, isMarried);
    }

    @Override
    public boolean isRetired(int age) {
        if(age>=65) {
            System.out.printf("%s is retired\n", getFirstName());
            return true;
        }
        else {
            System.out.printf("%s did not reach 65 yet\n", getFirstName());
            return false;
        }
    }

    @Override
    public void registerPartnership(Person partner) {
        setPartner(partner);
        getPartner().setPartner(this);
        this.setLastName(partner.getLastName());
        this.setMarriageStatus(true);
        System.out.println("After marriage partner is: " + this.partner + ", Last name: " + this.lastName + ", Is married: " + this.isMarried);
    }

    @Override
    public boolean deregisterPartnership(boolean returnToPreviousLastName) {
        if (!(partner == null)) {
            this.partner = null;
            this.setMarriageStatus(false);
            System.out.println("After divorce partner is: " + this.partner + ", Is married: " + this.isMarried);

            return true;
        }

        return false;
    }
}
