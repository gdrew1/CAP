import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE jobs (
  id INT NOT NULL AUTO_INCREMENT,    
  TITLE VARCHAR(30) NOT NULL, 
  PRIMARY KEY (id));
 */
@Table(name = "jobs")
@javax.persistence.Entity(name = "jobs")
public class Jobs {

    
	@Id
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "TITLE")
    private String job;
   

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}

}
