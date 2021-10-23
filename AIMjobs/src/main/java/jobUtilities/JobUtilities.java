package jobUtilities;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class JobUtilities {

	public static ArrayList<String> getRequirements(String Name, Connection connection){
		
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<String> requirments = new ArrayList<String>();
		try{
			statement=connection.createStatement();
			String sql ="SELECT * FROM reqs WHERE job=\"" + Name + "\"";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				String requirement=resultSet.getString("req");
				requirments.add(requirement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return requirments;
	}
	
}
