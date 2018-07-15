package models;

import javax.persistence.*;
import java.util.List;


import play.db.jpa.Model;


@Entity
@Table(name="device")
public class Device extends baseModel {

    @Column
    public String name; //设备名称
    @Column
    public String cameraType; //设备类型  video 为监控epolice为电警
    @Column
    public String indexCode; //设备编号

    //设备姿态相关
    @Column
    public double xRoll;  //x轴旋转
    @Column
    public double yRoll;  //y轴旋转
    @Column
    public double zRoll;  //z轴旋转
    @Column
    public double scale;  //放大比例

    //设备位置相关
    @Column
    public double lat;  //设备纬度
    @Column
    public double lon;    //设备经度
    @Column
    public double height;     //设备高程

    //场景位置相关

    @Column
    public double heading;  //场景视高
    @Column
    public double pitch;    //场景俯仰
    @Column
    public double roll;     //场景旋转

    @Column
    public double lat_view;  //场景视高
    @Column
    public double lon_view;    //场景俯仰
    @Column
    public double height_view;     //场景旋转

    public Device(String name,String cameraType,String indexCode,double xRoll,double yRoll,double zRoll,double scale,double lat,double lon,double height,double heading,double pitch,double roll,double lat_view,double lon_view,double height_view, String remark){

        this.name = name;
        this.cameraType = cameraType;
        this.indexCode = indexCode;

        this.xRoll = xRoll;
        this.yRoll = yRoll;
        this.zRoll = zRoll;
        this.scale = scale;

        this.lat = lat;
        this.lon = lon;
        this.height = height;
        this.heading = heading;
        this.pitch = pitch;
        this.roll = roll;

        this.lat_view = lat_view;
        this.lon_view = lon_view;
        this.height_view = height_view;

    }
    public Device(){

    }
}
