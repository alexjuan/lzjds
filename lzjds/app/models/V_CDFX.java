package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="v_cdfx")
public class V_CDFX extends baseModel {
    @Column
    public String KKDM; //卡口代码
    @Column
    public String CDBH; //车道编号
    @Column
    public String wd; //纬度
    @Column
    public String Jd; //经度
    @Column
    public String FXDM; //方向代码
    @Column
    public String FXMC; //方向名称

    public V_CDFX(String KKDM, String CDBH, String wd, String Jd, String FXDM,String FXMC){

        this.KKDM = KKDM;
        this.CDBH = CDBH;
        this.wd = wd;
        this.Jd = Jd;
        this.FXDM = FXDM;
        this.FXMC = FXMC;
    }
    public V_CDFX(){

    }
}
