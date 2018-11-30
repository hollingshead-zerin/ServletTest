package mypkg;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
public class EchoServlet extends HttpServlet {
 
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html; charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Student Form Response</title></head>");
         out.println("<body><h2>Student Sign-up Form</h2>");
         out.println("<h3>You have Entered</h3>");
         out.println("<h4>Personal Information</h4>");
         
         // Retrieve the value of the query parameter "firstname" (from text field)
         String Firstname = request.getParameter("firstname");
         // Get null if the parameter is missing from query string.
         // Get empty string or string of white spaces if user did not fill in
         if (Firstname == null
               || (Firstname = htmlFilter(Firstname.trim())).length() == 0) {
            out.println("<p>FirstName: MISSING</p>");
         } else {
            out.println("<p>FirstName: " + Firstname + "</p>");
         }
 
         // Retrieve the value of the query parameter "password" (from password field)
         String lastname = request.getParameter("lastname");
         if (lastname == null
               || (lastname = htmlFilter(lastname.trim())).length() == 0) {
            out.println("<p>LastName: MISSING</p>");
         } else {
            out.println("<p>LastName: " + lastname + "</p>");
         }
 
         // Retrieve the value of the query parameter "gender" (from radio button)
         String gender = request.getParameter("gender");
         // Get null if the parameter is missing from query string.
         if (gender == null) {
            out.println("<p>Gender: MISSING</p>");
         } else if (gender.equals("m")) {
            out.println("<p>Gender: Male</p>");
         } else {
            out.println("<p>Gender: Female</p>");
         }
 
         // Retrieve the value of the query parameter "age" (from pull-down menu)
         String age = request.getParameter("age");
         if (age == null) {
            out.println("<p>Age: MISSING</p>");
         } else if (age.equals("10")) {
            out.println("<p>Age: &lt; 10 years old</p>");
         } else if (age.equals("20")) {
            out.println("<p>Age: 11 to 20 years old</p>");
         } else if (age.equals("30")) {
            out.println("<p>Age: 21 to 30 years old</p>");
         } else if (age.equals("40")) {
            out.println("<p>Age: 31 to 40 years old</p>");
         } else if (age.equals("50")) {
            out.println("<p>Age: 41 to 50 years old</p>");
         } else if (age.equals("60")) {
             out.println("<p>Age: 51 to 60 years old</p>");
         } else {
            out.println("<p>Age: &gt; 70 years old</p>");
         }
 
//**********************************************************************************************************/
             
         out.println("<h4>Contact Information</h4>");
         
         String street2 = "";
         // Retrieve the value of the query parameter "street" (from text field)
         String street = request.getParameter("street");
         // Get null if the parameter is missing from query string.
         // Get empty string or string of white spaces if user did not fill in
         if (street == null
               || (street = htmlFilter(street.trim())).length() == 0) {
        	 street2 = "!!MISSING!!";
         } else {
            street2 = street;
         }
 
         String city2 = "";
         // Retrieve the value of the query parameter "city"
         String city = request.getParameter("city");
         if (city == null
               || (city = htmlFilter(city.trim())).length() == 0) {
        	 city2 = "!!MISSING!!";
         } else {
        	 city2 = city;
         }
 
        
 
         String state2 = "";
         // Retrieve the value of the query parameter "age" (from pull-down menu)
         String state = request.getParameter("state");
         if (state == null) {
        	 state2 = "!!MISSING!!";
         } else if (state.equals("AZ")) {
        	 state2 = "Arizona";
         }  else if (state.equals("CA")) {
        	 state2 = "California";
         }  else if (state.equals("NV")) {
        	 state2 = "Nevada";
         }  else if (state.equals("UT")) {
        	 state2 = "Utah";
         }  else if (state.equals("ID")) {
        	 state2 = "Idaho";
         }  else if (state.equals("OR")) {
        	 state2 = "Oregon";
         }  else if (state.equals("WA")) {
        	 state2 = "Washington";
   	     }  else if (state.equals("MT")) {
   	    	state2 = "Montana";
         } else {
        	 state2 = "Wyoming";
         }
 
         
         String zip2 = "";
      // Retrieve the value of the query parameter "instruction" (from text area)
         String zip = request.getParameter("zip");
         // Get null if the parameter is missing from query string.
         if (zip == null
              || (zip = htmlFilter(zip.trim())).length() == 0) {
        	 zip2 = "!!MISSING!!";
         } else {
            zip2 = zip;
         }
         
         
         out.println("<p>" + street2 + "</p>");
         out.println("<p>" +city2 + ", " + state2 + "  " + zip2 +"<p>");
         
        
      // Retrieve the value of the query parameter "instruction" (from text area)
         String number = request.getParameter("number");
         // Get null if the parameter is missing from query string.
         if (number == null
              || (number = htmlFilter(number.trim())).length() == 0) {
            out.println("<p>PhoneNumber: NONE</p>");
         } else {
            out.println("<p>PhoneNumber: " + number + "</p>");
         }
         
//**********************************************************************************************************/
         out.println("<h4>Other Information</h4>");
         
         // Retrieve the value of the query parameter "instruction" (from text area)
         String comments = request.getParameter("comments");
         // Get null if the parameter is missing from query string.
         if (comments == null
              || (comments = htmlFilter(comments.trim())).length() == 0
              || comments.equals("Enter your Comments here...")) {
            out.println("<p>Comments: NONE</p>");
         } else {
            out.println("<p>Comments: " + comments + "</p>");
         }
         
//**********************************************************************************************************/
                  
         
         
         // Get all the names of request parameters
         Enumeration names = request.getParameterNames();
         out.println("<p>Request Parameter Names are: ");
         if (names.hasMoreElements()) {
            out.print(htmlFilter(names.nextElement().toString()));
         }
         do {
            out.print(", " + htmlFilter(names.nextElement().toString()));
         } while (names.hasMoreElements());
         out.println(".</p>");
 
         // Hyperlink "BACK" to input page
         out.println("<a href='form_input.html'>BACK</a>");
 
         out.println("</body></html>");
      } finally {
         out.close();  // Always close the output writer
      }
   }
 
   // Redirect POST request to GET request.
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      doGet(request, response);
   }
 
   // Filter the string for special HTML characters to prevent
   // command injection attack
   private static String htmlFilter(String message) {
      if (message == null) return null;
      int len = message.length();
      StringBuffer result = new StringBuffer(len + 20);
      char aChar;
 
      for (int i = 0; i < len; ++i) {
         aChar = message.charAt(i);
         switch (aChar) {
             case '<': result.append("&lt;"); break;
             case '>': result.append("&gt;"); break;
             case '&': result.append("&amp;"); break;
             case '"': result.append("&quot;"); break;
             default: result.append(aChar);
         }
      }
      return (result.toString());
   }
}

//http://www.ntu.edu.sg/home/ehchua/programming/java/javaservlets.html