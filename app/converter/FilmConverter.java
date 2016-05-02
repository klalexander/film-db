package converter;

import com.fasterxml.jackson.databind.JsonNode;
import data.FilmData;
import models.FList;
import models.Film;

public class FilmConverter {

    public static FilmData convertToFilmData(Film film) {
        FilmData data = new FilmData();
        try {
            data.setId(film.id);
            data.setfListId(film.fList.id);
            data.setName(film.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static FilmData convertToFilmData(JsonNode json) {
        FilmData data = new FilmData();
        try {
            data.setExternalId(json.findPath("externalId").longValue());
            data.setfListId(json.findPath("fListId").longValue());
            data.setName(json.findPath("name").textValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static Film convertToFilm(JsonNode json) {
        Film film = new Film();
        try {
            film.externalId = json.findPath("externalId").longValue();
            film.name = json.findPath("name").textValue();
            film.fList = FList.find.where().eq("id", json.findPath("fListId").longValue()).findUnique();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return film;
    }

    public static Film convertToFilm(FilmData filmData) {
        Film film = new Film();
        try {
            film.externalId = filmData.getExternalId();
            film.name = filmData.getName();
            film.fList = FList.find.where().eq("id",filmData.getfListId()).findUnique();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return film;
    }
}
