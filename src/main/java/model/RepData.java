package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepData implements Serializable {
    private String name;
    private String office;
    private String phone;
    private String link;
    private String district;
    private String party;
    public RepData() {

    }
    public String getName() {
        return name;
    }
    public String getOffice() {
        return office;
    }
    public String getPhone() {
        return phone;
    }
    public String getLink() {
        return link;
    }
    public String getParty() {
        return party;
    }
    public String getDistrict() {
        return district;
    }
}
