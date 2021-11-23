package TRMS.services;

import TRMS.Repository.GradeRepo;
import TRMS.models.Grade;

public class GradeServiceImp implements GradeServices{

    GradeRepo gr;

    public GradeServiceImp(GradeRepo gr) {
        this.gr = gr;
    }

    @Override
    public Grade addGrade(Grade g) {
        return gr.addGrade(g);
    }

    @Override
    public Grade getGrade(int eventID) {
        return gr.getGrade(eventID);
    }

    @Override
    public Grade updateGrade(int eventID, Grade g) {
        return gr.updateGrade(eventID,g);
    }

    @Override
    public Grade deleteGrade(Grade g) {
        return gr.deleteGrade(g);
    }
}
