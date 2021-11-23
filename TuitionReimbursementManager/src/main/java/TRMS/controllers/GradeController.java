package TRMS.controllers;

import TRMS.logger.MyLogger;
import TRMS.models.Grade;
import TRMS.services.GradeServices;
import com.google.gson.Gson;
import io.javalin.http.Handler;


public class GradeController {
    GradeServices gs;
    Gson gson = new Gson();

    public GradeController(GradeServices gs) {this.gs = gs;}

    public Handler addGrade = (context) -> {
        int eventID = Integer.parseInt(context.pathParam("eventID"));
        int gradeFormat = Integer.parseInt(context.header("gradeFormat"));
        String grade = context.header("grade");
        boolean presentation = Boolean.parseBoolean(context.header("presentation"));

        String presentationFile = context.header("presentationFile");
        Grade g = new Grade(eventID, gradeFormat, presentation, grade, presentationFile);
        MyLogger.logger.info(g);
        context.result((g!=null) ? gson.toJson(g):"{}");

    };

    public Handler getGrade = (context) ->{
        String input = context.pathParam("eventID");
        int id;

        try{
            id = Integer.parseInt(input);
        } catch (NumberFormatException e){
            e.printStackTrace();
            id =-1;
        }
        Grade g = gs.getGrade(id);

        if(g!= null){
            context.result(gson.toJson(g));
            context.status(200);
        } else {
            context.status(400);
        }
    };

    public Handler updateGrade = (context) ->{
        int id = Integer.parseInt(context.pathParam("eventID"));
        Grade g = gson.fromJson(context.body(), Grade.class);

    };


}
