package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="v_gcxx")
public class V_GCXX extends baseModel {
    @Column
    public String kkbh; //卡口编号
    @Column
    public String kkmc; //卡口名称
    @Column
    public String wd; //纬度
    @Column
    public String Jd; //经度
    @Column
    public String jgsk; //经过时间
    @Column
    public String cdbh; //车道编号
    @Column
    public String hphm; //号牌号码
    @Column
    public String hpys; //号牌颜色[0	白色1	黄色2	蓝色3	黑色 4	其它颜色]
    @Column
    public String xsfxdm; //行驶方向代码
    @Column
    public String xsfx; //行驶方向
    @Column
    public String cllx; //车辆类型[ga24.4]
    @Column
    public String csys; //车身颜色[ga24.8]

    public V_GCXX(String kkbh, String kkmc, String wd, String Jd, String jgsk, String cdbh, String hphm, String hpys, String xsfxdm, String xsfx, String cllx, String csys){

        this.kkbh = kkbh;
        this.kkmc = kkmc;
        this.wd = wd;
        this.Jd = Jd;
        this.jgsk = jgsk;
        this.cdbh = cdbh;
        this.hphm = hphm;
        this.hpys = hpys;
        this.xsfxdm = xsfxdm;
        this.xsfx = xsfx;
        this.cllx = cllx;
        this.csys = csys;
    }
    public V_GCXX(){

    }
}
