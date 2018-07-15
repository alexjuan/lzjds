package models;

import org.hibernate.annotations.GenericGenerator;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

import javax.persistence.*;
@MappedSuperclass
public class baseModel extends GenericModel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String id;
    public String getId() {
        return id;
    }
    @Override
    public String _key() {
        return getId();
    }
    public baseModel(){
    }
}
