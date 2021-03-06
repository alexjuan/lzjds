package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="device_hk1")
public class Device_HK1 extends baseModel {
    @Column
    public String name; //设备名称
    @Column
    public String type; //设备类型  video 为监控epolice为电警
    @Column
    public String port; //设备端口号
    @Column
    public String ip;   //设备IP地址
    @Column
    public String serialnumber;   //编号



    public Device_HK1(String name, String type, String port, String ip, String serialnumber){

        this.name = name;
        this.type = type;
        this.port = port;
        this.ip = ip;
        this.serialnumber = serialnumber;
    }
    public Device_HK1(){

    }
}
