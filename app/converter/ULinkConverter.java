package converter;

import data.ULinkData;
import models.ULink;

public class ULinkConverter {

    public static ULinkData convert(ULink uLink) {
        ULinkData uLinkData = new ULinkData();
        uLinkData.setUlink(uLink.ulink);
        uLinkData.setFilmId(uLink.filmId);
        uLinkData.setfListId(uLink.flistId);
        uLinkData.setExternalId(uLink.externalId);
        return uLinkData;
    }
}
