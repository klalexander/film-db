package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import converter.FilmConverter;
import data.ULinkData;
import models.Film;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import service.FilmService;
import service.ULinkService;
import views.html.searchExamp;
import views.html.searchFilms;
import views.html.viewFilm;

import java.util.List;

public class FilmController extends Controller  {

    public Result save(Long externalId, Long fListId, String filmName) {
        FilmService.save(externalId, fListId, filmName);
        return Results.ok();
    }

    public Result delete(Long id) {
        FilmService.delete(id);
        return Results.ok();
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result save() {
        try {
            JsonNode json = request().body().asJson();
            Film data = FilmConverter.convertToFilm(json);
            FilmService.save(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Results.ok();
    }

    public Result getFilmsByFListId(Long fListId) {
        List<Film> films = FilmService.getFilmsByFList(fListId);
        return ok(Json.toJson(films));
    }

    public Result getUniqueLink(Long filmId, Long fList, Long externalId) {
        return Results.ok(ULinkService.save(fList, externalId, filmId));
    }

    public Result searchFilmsByFList(Long flistId) {
            return ok(searchFilms.render(flistId));
    }

    //old way to test js and search
    public Result search() {
        return ok(searchExamp.render());
    }

    public Result showUnique(String key) {
        ULinkData uLinkData = ULinkService.get(key);
        return ok(viewFilm.render(uLinkData.getName(), "Description", uLinkData.getExternalId()));
    }
}
