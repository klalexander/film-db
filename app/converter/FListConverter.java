package converter;

import data.FListData;
import models.FList;

public class FListConverter {

    public static FListData convert(FList fList) {
        FListData data = new FListData();
        try {
            data.setId(fList.id);
            data.setName(fList.name);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}