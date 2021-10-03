import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE reqs (
  id INT NOT NULL AUTO_INCREMENT,    
  TITLE VARCHAR(30) NOT NULL, 
  PRIMARY KEY (id));
 */
@Table(name = "reqs")
@javax.persistence.Entity(name = "reqs")
public class Jobs {

   @Column(name = "TITLE")
   private String job;
   

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}

}
