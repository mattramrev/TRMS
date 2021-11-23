package TRMS.Repository;

import TRMS.models.Grade;

public interface GradeRepo {

    public Grade addGrade(Grade g);
    public Grade getGrade(int eventID);
    public Grade updateGrade(int eventID, Grade g);
    public Grade deleteGrade(Grade g);
}
