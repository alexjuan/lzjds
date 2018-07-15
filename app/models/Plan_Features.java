package models;

import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="plan_features")
public class Plan_Features extends baseModel {
    @Column
    public String name; //要素名称
    @Column
    public String planID; //方案名称
    @Column
    public String type; //方案名称，point或line
    @Column
    public String positions; //点，线，面(坐标串)


    public Plan_Features(String name, String planID, String type, String positions){

        this.name = name;
        this.planID = planID;
        this.type = type;
        this.positions = positions;
    }
    public Plan_Features(){

    }
}
