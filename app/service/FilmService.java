package service;

import data.FilmData;
import models.FList;
import models.Film;

import java.util.List;

public class FilmService {

    public static void save(Long externalId, Long fListId, String filmName) {
        Film film = new Film();
        film.externalId = externalId;
        film.name = filmName;
        //film.fList = FList.find.ref(fListId);
        film.fList = FList.find.where().eq("id",fListId).findUnique();
        film.save();
    }

    public static void save(Film film) {
        film.save();
    }

    public static void delete(Long filmId) {
        Film.find.ref(filmId).delete();
    }

    public static void update (FilmData filmData) {
        //// TODO:write update
    }

    public static List<Film> getFilmsByFList(Long fListId) {
       return Film.getFilmsByFListId(fListId);
    }
}
