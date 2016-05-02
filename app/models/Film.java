package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

@Entity
public class Film  extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    @Column(name="external_id")
    public Long externalId;

    @Constraints.Required
    public String name;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="flist_id", referencedColumnName="id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    public FList fList;

    public static Model.Find<Long,Film> find = new Model.Find<Long,Film>(){};

    public static List<Film> getFilmsByFListId(Long fListId) {
        return Film.find.fetch("fList").where().eq("flist_id", fListId).findList();
    }
}
