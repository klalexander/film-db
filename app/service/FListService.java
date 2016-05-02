package service;

import data.FListData;
import models.FList;
import models.Film;

public class FListService {

    public static void delete(Long id) {
        Film.find.ref(id).delete();
    }

    public static void save(FList fList) {
        fList.save();
    }

    public static void update (FListData filmData) {
        //// TODO:write update
    }
}
