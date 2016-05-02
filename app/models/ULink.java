package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="ulink")
public class ULink extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    public String ulink;

    @Column(name = "flist_id")
    public Long flistId;

    @Column(name = "film_id")
    public Long filmId;

    @Column(name = "external_id")
    public Long externalId;

    public static Model.Find<Long, models.ULink> find = new Model.Find<Long, models.ULink>(){};

    public static List<ULink> getFilmsByFListId(String ulink) {
        return ULink.find.where().eq("ulink", ulink).findList();
    }
}
