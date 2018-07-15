package models;
import javax.persistence.*;
import javax.persistence.Id;
import play.db.jpa.Model;

@Entity
@Table(name="person")
public class Person extends baseModel {
    @Column
    public String name;
    @Column
    public String personID;
    @Column
    public String standAddress;
    @Column
    public String doubleInfoID;

    @Column
    public double lat;
    @Column
    public double lon;
    @Column
    public double height;

    @Column
    public double lat_view;
    @Column
    public double lon_view;
    @Column
    public double height_view;
    @Column
    public String remark;

    public Person(String name,String personID,String standAddress,String doubleInfoID,double lat,double lon,double height,double lat_view,double lon_view,double height_view,String remark){
        this.name = name;
        this.personID = personID;
        this.standAddress = standAddress;
        this.doubleInfoID = doubleInfoID;
        this.lat = lat;
        this.lon = lon;
        this.height = height;
        this.lat_view = lat_view;
        this.lon_view = lon_view;
        this.height_view = height_view;
        this.remark = remark;
    }
    public Person(){ }
}
