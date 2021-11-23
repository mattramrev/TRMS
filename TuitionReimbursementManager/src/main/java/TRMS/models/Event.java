package TRMS.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="events")
public class Event {
    @Id
    @Column(name = "eventid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;

    @Column(name = "eventtypeid")
    private int eventType;

    @Column(name = "eventcost", columnDefinition = "numeric(12,2)")
    private double price;

    private String location;
    private String description;
    private String reason;
    @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name= "eventid")
    private Grade grade;

    private long finishT;
    @Column(columnDefinition = "boolean")
    boolean superApproval;
    @Column(columnDefinition = "boolean")
    boolean depHeadApproval;
    @Column(columnDefinition = "boolean")
    boolean benCoApproval;




    public Event() {
    }

    public Event(int eventID, int eventType, double price, String location, String description, String reason, Grade grade, long finishTime, boolean superApproval, boolean depHeadApproval, boolean benCoApproval) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.price = price;
        this.location = location;
        this.description = description;
        this.reason = reason;
        this.grade = grade;
        this.finishT = finishTime;
        this.superApproval = superApproval;
        this.depHeadApproval = depHeadApproval;
        this.benCoApproval = benCoApproval;
    }

    public Event(int eventType, double price, String location, String description, String reason, Grade grade, long finishTime, boolean superApproval, boolean depHeadApproval, boolean benCoApproval) {
        this.eventType = eventType;
        this.price = price;
        this.location = location;
        this.description = description;
        this.reason = reason;
        this.grade = grade;
        this.finishT = finishTime;
        this.superApproval = superApproval;
        this.depHeadApproval = depHeadApproval;
        this.benCoApproval = benCoApproval;
    }

    public Event(int eventType, double price, String location, String description, String reason, Grade grade, long finishT) {
        this.eventType = eventType;
        this.price = price;
        this.location = location;
        this.description = description;
        this.reason = reason;
        this.grade = grade;
        this.finishT = finishT;
    }

    public int getEventID() {
        return eventID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEventType() {
        return eventType;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getReason() {
        return reason;
    }

    public Grade getGrade() {
        return grade;
    }

    public long getFinishTime() {
        return finishT;
    }

    public boolean isSuperApproval() {
        return superApproval;
    }

    public boolean isDepHeadApproval() {
        return depHeadApproval;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setFinishTime(long finishTime) {
        this.finishT = finishTime;
    }

    public void setSuperApproval(boolean superApproval) {
        this.superApproval = superApproval;
    }

    public void setDepHeadApproval(boolean depHeadApproval) {
        this.depHeadApproval = depHeadApproval;
    }

    public boolean isBenCoApproval() {
        return benCoApproval;
    }

    public void setBenCoApproval(boolean benCoApproval) {
        this.benCoApproval = benCoApproval;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", eventType=" + eventType +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", reason='" + reason + '\'' +
                ", grade=" + grade +
                ", finishT=" + finishT +
                ", superApproval=" + superApproval +
                ", depHeadApproval=" + depHeadApproval +
                ", benCoApproval=" + benCoApproval +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventID == event.eventID && eventType == event.eventType && Double.compare(event.price, price) == 0 && finishT == event.finishT && superApproval == event.superApproval && depHeadApproval == event.depHeadApproval && benCoApproval == event.benCoApproval && Objects.equals(location, event.location) && Objects.equals(description, event.description) && Objects.equals(reason, event.reason) && Objects.equals(grade, event.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, eventType, price, location, description, reason, grade, finishT, superApproval, depHeadApproval, benCoApproval);
    }
}
