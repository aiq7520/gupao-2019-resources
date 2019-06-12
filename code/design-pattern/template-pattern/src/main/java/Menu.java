import java.util.Date;

/**
 * @Description:
 * @Author: gege
 * @CreateDate: 2019/3/26 10:21
 */
public class Menu {
    private String name;
    private Integer id;
    private  String url;
    private Date createdTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
