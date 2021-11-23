package TRMS.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    private int eventID;

    int gradeFormat;
    boolean presentation;
    String grade;
    String presentationFile;

    public Grade() {
    }

    public Grade(int eventID, int gradeFormat, boolean presentation, String grade, String presentationFile) {
        this.eventID = eventID;
        this.gradeFormat = gradeFormat;
        this.presentation = presentation;
        this.grade = grade;
        this.presentationFile = presentationFile;
    }

    public Grade(int gradeFormat, boolean presentation, String grade, String presentationFile) {
        this.gradeFormat = gradeFormat;
        this.presentation = presentation;
        this.grade = grade;
        this.presentationFile = presentationFile;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getGradeFormat() {
        return gradeFormat;
    }

    public void setGradeFormat(int gradeFormat) {
        this.gradeFormat = gradeFormat;
    }

    public boolean isPresentation() {
        return presentation;
    }

    public void setPresentation(boolean presentation) {
        this.presentation = presentation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPresentationFile() {
        return presentationFile;
    }

    public void setPresentationFile(String presentationFile) {
        this.presentationFile = presentationFile;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "eventID=" + eventID +
                ", gradeFormat='" + gradeFormat + '\'' +
                ", presentation=" + presentation +
                ", grade='" + grade + '\'' +
                ", presentationFile='" + presentationFile + '\'' +
                '}';
    }
}
