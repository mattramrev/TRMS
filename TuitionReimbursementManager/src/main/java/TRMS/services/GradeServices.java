package TRMS.services;

import TRMS.models.Grade;

public interface GradeServices {

    public Grade addGrade(Grade g);

    public Grade getGrade(int eventID);

    public Grade updateGrade(int eventID, Grade g);

    public Grade deleteGrade(Grade g);
}
