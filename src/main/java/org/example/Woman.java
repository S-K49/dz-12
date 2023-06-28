package org.example;

public class Woman extends Person {

    private String previousLastName;
    private boolean returnPreviousLastName;

    private boolean isRetired = true;
    private boolean isMarried;

    /*public ClassesLogic.Woman(String firstName, String lastName, int age, boolean isMarried, ClassesLogic.Man partner) {
        super(firstName, lastName, age, isMarried);
        this.previousLastName = lastName;
        this.setPartner(partner);
        this.getPartner().setPartner(this.partner);
    }*/

    public Woman(String firstName, String lastName, int age, boolean isMarried) {
        super(firstName, lastName, age, isMarried);
        this.previousLastName = lastName;
    }

    public String getPreviousLastName() {
        return lastName;
    }

    public void setPreviousLastName(String lastName) {
        this.previousLastName = lastName;
    }

    // Version 1

    public boolean isRetired(int age) {
        if(age>=60) {
            System.out.printf("%s is retired\n", getFirstName());
            return true;
        }
        else {
            System.out.printf("%s did not reach 60 yet\n", getFirstName());
            return false;
        }
    }

    @Override
    public void registerPartnership(Person partner) {
        if (!(partner == null)) {
            setPartner(partner);
            getPartner().setPartner(this);
            this.setLastName(partner.getLastName());
            this.setMarriageStatus(true);
            System.out.println("After marriage partner is: " + this.partner + ", Last name: " + this.lastName + ", Is married: " + this.getMarriageStatus());
        }
    }

    @Override
    public boolean deregisterPartnership(boolean returnToPreviousLastName) {
        this.partner = null;
        this.setMarriageStatus(false);
        if (returnToPreviousLastName) {
            this.setPreviousLastName(lastName);
            System.out.println("After divorce partner is: " + this.partner + ", Previous last name: " + this.previousLastName + ", Is married: " + this.isMarried);
        return true;
        }
        return false;
    }
}
