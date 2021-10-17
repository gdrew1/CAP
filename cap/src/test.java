

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class test
 */
@WebServlet("/CAP")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File starting = new File(System.getProperty("user.dir"));
		File fileToBeRead = new File(starting,"my_file.txt");
		// TODO Auto-generated method stub
		String htmlString = Files.lines(Paths.get(System.getProperty("user.dir") + "/webapps/CAP/start_template.html")).collect(Collectors.joining(System.lineSeparator()));
		String body = makeStrings(UtilDBDrew.getJobs());
		htmlString = htmlString.replace("$body", body);
		response.getWriter().append(htmlString).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String makeString(Job job) {
		String returned = 		"<div class=\"mySlides fade\">\n" + 
				  "<div class=\"numbertext\">1 / 3</div>\n" +
				  "<div class=\"card\">\n" +
				    "<div class=\"container\">\n";
		returned += "<h4><b>"+job.name+"</b></h4>\n";
		for(int i = 0; i < job.reqs.size(); i++) {
			returned += "<p>" + job.reqs.get(i)+ "</p>\n";
		}
		returned +=     "</div>\n" +
				  "</div>\n" +
				  "<div class=\"text\">Caption Text</div>\n" +
				"</div>\n";
		return returned;
	}
	
	private String makeStrings(List<Job> jobs) {
		String returned = "";
		for(int i = 0; i < jobs.size(); i++) {
			returned += makeString(jobs.get(i));
		}
		return returned;
	}

}
