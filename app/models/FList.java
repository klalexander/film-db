package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

@Entity
public class FList  extends Model  {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fList", cascade=CascadeType.ALL)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    @JoinColumn(name = "flist_id")
    public List<Film> films;

    public static Model.Find<Long,FList> find = new Model.Find<Long,FList>(){};

    public static List<FList> findAll(Long flistId) {
        return find.where().findList();
    }

}
