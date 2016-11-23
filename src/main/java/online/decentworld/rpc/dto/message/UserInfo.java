package online.decentworld.rpc.dto.message;

/**
 * Created by Sammax on 2016/11/16.
 */
public class UserInfo {

    private String dwID;
    private Integer sex;
    private String name;
    private String icon;
    private String area;
    private String sign;
    private Integer worth;
    private String type;

    public String getDwID() {
        return dwID;
    }

    public void setDwID(String dwID) {
        this.dwID = dwID;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getWorth() {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserInfo(String dwID, Integer sex, String name, String icon, String area, String sign, Integer worth, String type) {

        this.dwID = dwID;
        this.sex = sex;
        this.name = name;
        this.icon = icon;
        this.area = area;
        this.sign = sign;
        this.worth = worth;
        this.type = type;
    }
}
