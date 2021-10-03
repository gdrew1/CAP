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
  job VARCHAR(30) NOT NULL, 
  req VARCHAR(100) NOT NULL,  
  PRIMARY KEY (id));
 */
@Table(name = "reqs")
@javax.persistence.Entity(name = "reqs")
public class reqs {

   @Column(name = "job")
   private String job;
   
   @Column(name = "req")
   private String req;

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}

public String getReq() {
	return req;
}

public void setReq(String req) {
	this.req = req;
}

}