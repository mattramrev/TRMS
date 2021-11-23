package TRMS.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeID;

    @ManyToOne
        @JoinColumn(name = "depID")
    Department depID;

    @ManyToOne
        @JoinColumn(name = "superID")
    Employee superID;

    @Column(nullable = false)
    String acctName;
    @Column(nullable = false)
    String acctPass;
    @Column(name = "position", nullable = false)
    String title;

    @OneToMany(fetch = FetchType.EAGER)
            @JoinColumn(name="eventID")
    List<Event> eID;

    int reimbursementAcctAmt;

    String email;


    public Employee() {
    }

    public Employee(int employeeID, Department depID, Employee superID, String acctName, String acctPass, String title, List<Event> eID, int reimbursementAcctAmt, String email) {
        this.employeeID = employeeID;
        this.depID = depID;
        this.superID = superID;
        this.acctName = acctName;
        this.acctPass = acctPass;
        this.title = title;
        this.eID = eID;
        this.reimbursementAcctAmt = reimbursementAcctAmt;
        this.email = email;
    }

    public int getId() {
        return employeeID;
    }

    public Employee getSuperID() {
        return superID;
    }

    public String getAcctName() {
        return acctName;
    }

    public String getAcctPass() {
        return acctPass;
    }

    public String getTitle() {
        return title;
    }

    public List<Event> getEventID() {
        return eID;
    }

    public int getReimbursementAcctAmt() {
        return reimbursementAcctAmt;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.employeeID = id;
    }

    public void setSuperID(Employee superID) {
        this.superID = superID;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public void setAcctPass(String acctPass) {
        this.acctPass = acctPass;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEventID(List<Event> eventID) {
        this.eID = eventID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReimbursementAcctAmt(int reimbursementAcctAmt) {
        this.reimbursementAcctAmt = reimbursementAcctAmt;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID && depID == employee.depID && reimbursementAcctAmt == employee.reimbursementAcctAmt && Objects.equals(superID, employee.superID) && Objects.equals(acctName, employee.acctName) && Objects.equals(acctPass, employee.acctPass) && Objects.equals(title, employee.title) && Objects.equals(eID, employee.eID) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, depID, superID, acctName, acctPass, title, eID, reimbursementAcctAmt, email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", depID=" + depID +
                ", superID=" + superID +
                ", acctName='" + acctName + '\'' +
                ", acctPass='" + acctPass + '\'' +
                ", title='" + title + '\'' +
                ", eID=" + eID +
                ", reimbursementAcctAmt=" + reimbursementAcctAmt +
                ", email='" + email + '\'' +
                '}';
    }
}
