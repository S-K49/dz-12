package org.example;

public class Main {
    public static void main(String[] args) {

        Man man = new Man("Valera", "Strong", 65, false);
        Woman woman = new Woman("Galya", "Wild", 60, false);

       // Version 1
        System.out.println("Version 1:" + "\n================================================");

       //woman.isRetired(woman.age);
      // man.isRetired(man.age);

       woman.registerPartnership(man);
       man.registerPartnership(woman);

       woman.deregisterPartnership(true);
       man.deregisterPartnership(false);

        /*/Version 2 - What chatbot suggested:
        System.out.println("\nVersion 2:" + "\n================================================");

        woman.isRetired(); //My method
        man.isRetired(); // My method

        woman2.registerPartnership(man2);
        man2.registerPartnership(man2);

        woman2.deregisterPartnership(true, woman2);
        man2.deregisterPartnership(false, man2);*/
    }
}
