package controllers;

import models.FList;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import service.FListService;
import views.html.listFLists;
import views.html.listFilms;

import javax.inject.Inject;
import java.util.List;

public class FListController extends Controller{
    
    private FormFactory formFactory;

    @Inject
    public FListController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result delete(Long id) {
        FListService.delete(id);
        flash("success", "FilmsList has been deleted");
        return ok("ok");
    }

    public Result create() {
        Form<FList> fListForm = formFactory.form(FList.class);
        return ok(
            views.html.createFormFList.render(fListForm)
        );
    }

    public Result save() {
        Form<FList> fListForm = formFactory.form(FList.class).bindFromRequest();
        if(fListForm.hasErrors()) {
            return badRequest(views.html.createFormFList.render(fListForm));
        }
        FListService.save(fListForm.get());
        flash("success", "FListData " + fListForm.get().name + " has been created");
        return ok("ok");
    }


    public Result listAll() {
        return ok(Json.toJson(FListService.getAllRecords()));
    }
    public Result fListGetAll() {
        return ok(listFLists.render("Your new application is ready."));
    }

    public Result getAllFilmsForFList(Long flistId) {
        return ok(listFilms.render(flistId));
    }
}
