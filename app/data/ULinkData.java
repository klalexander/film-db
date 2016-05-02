package data;


public class ULinkData {

    private Long id;

    private String name;

    private String ulink;

    private Long fListId;

    private Long filmId;

    private Long externalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUlink() {
        return ulink;
    }

    public void setUlink(String ulink) {
        this.ulink = ulink;
    }

    public Long getfListId() {
        return fListId;
    }

    public void setfListId(Long fListId) {
        this.fListId = fListId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }
}
