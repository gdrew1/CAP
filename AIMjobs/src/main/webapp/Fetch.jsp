<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.JSONArray"%>
<%@page import="jobUtilities.JobUtilities" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="application/json; charset=UTF-8"%>
<%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://ec2-3-141-98-240.us-east-2.compute.amazonaws.com:3306/";
	String database = "CAP";
	String userid = "connector";
	String password = "12345";
	String jobName = request.getParameter("JobName");
	String requirements = request.getParameter("Requirements");
	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	JSONArray json_array= new JSONArray();
	try{
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement=connection.createStatement();
			String sql ="SELECT * FROM jobs";
			resultSet = statement.executeQuery(sql);
			int i=0;
			while(resultSet.next()){
				String job_name=resultSet.getString("TITLE");
				
				ArrayList<String> requirments = new ArrayList<String>();
				requirments = JobUtilities.getRequirements(job_name, connection);
				requirments.add(0, job_name);
				
				JSONArray json_inner= new JSONArray();
				for(String j: requirments){
					json_inner.put(j);
				}
				
				json_array.put(json_inner);
			}
			
			String json_string = json_array.toString();
			
			response.getWriter().write(json_string); 
			response.getWriter().flush(); 
			response.getWriter().close();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
	}
%>