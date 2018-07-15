package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="double_info")
public class DoubleInfo extends baseModel {
    @Column
    public String name_info;    //名称
    @Column
    public String IDNumber_info;    //身份证号
    @Column
    public String standAddress;    //标准地址
    @Column
    public String remark_info;  //备注

    public DoubleInfo(String name_info, String IDNumber_info,String standAddress, String remark_info){
        this.name_info = name_info;
        this.IDNumber_info = IDNumber_info;
        this.standAddress = standAddress;
        this.remark_info = remark_info;
    }

    public DoubleInfo(){ }
}
