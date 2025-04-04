package sa.com.cloudsolutions.antikythera.evaluator;

import java.io.Serializable;

/**
 * Note Serializable to help test the InterfaceSolver
 */
public class Employee implements Serializable {
    int id = 100;
    Person p = new Person("Hornblower");

    public static void main(String[] args) {
        Employee patient = new Employee();
        System.out.println(patient);
    }

    public void simpleAccess() {
        System.out.println(p.getName());
        System.out.println(p.getAddress());
        p.setAddress("Colombo");
        System.out.println(p.getAddress());
    }

    public void publicAccess() {
        System.out.println(p.name);
    }

    public void thisAccess() {
        System.out.println(this.p.getName());
    }

    public void chained() {
        System.out.println(p.name.toUpperCase().contains("horn"));
    }

    @Override
    public String toString() {
        return "Patient id = %d , Name = %s".formatted(id, p.getName());
    }
}
