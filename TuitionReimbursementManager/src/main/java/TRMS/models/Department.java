package TRMS.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int departmentID;

    @Column(nullable = false)
    String depname;

    public Department() {
    }

    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.depname = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return depname;
    }

    public void setDepartmentName(String departmentName) {
        this.depname = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentID == that.departmentID && Objects.equals(depname, that.depname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentID, depname);
    }

    @Override
    public String toString() {
        return "Departments{" +
                "departmentID=" + departmentID +
                ", departmentName='" + depname + '\'' +
                '}';
    }

}
