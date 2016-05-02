package service;

import converter.ULinkConverter;
import data.ULinkData;
import models.ULink;
import util.ULinkUtil;

public class ULinkService {

    public static String save(Long fListId, Long externalId, Long filmId) {
        try {
            ULink ulink = new ULink();
            ulink.ulink = ULinkUtil.UNIQUE_KEY + fListId + filmId + externalId;
            ulink.flistId = fListId;
            ulink.filmId = filmId;
            ulink.externalId = externalId;
            ulink.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ULinkUtil.UNIQUE_KEY + fListId + filmId + externalId;
    }

    public static ULinkData get(String link) {
        return ULinkConverter.convert(ULink.getFilmsByFListId(link).get(0));
    }

    public static void delete(String link, Long fListId, Long externalId, Long filmId) {
        //// TODO:write delete
    }
}
