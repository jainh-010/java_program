package json_demo;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class json_java {
   public static void main(String args[]){
   
      ObjectMapper objectMapper = new ObjectMapper();
      
     //creating a json string
      String jsonString;
      
      Student poloString;
      
      try{
    	  
    	  //setting the values of the pojo class
         Student student = new Student();
         student.setName("Ramesh");
         student.setFname("Suresh");
         student.setAddress("Bikaner");
         student.getMarks().add(90);
         student.getMarks().add(80);
         student.getMarks().add(70);
         
         //Converting to json
         jsonString = objectMapper.writeValueAsString(student);
         
         System.out.println("Json string\n"+ jsonString);
        
        	//Converting to pojo		 
        poloString = objectMapper.readValue(jsonString,Student.class);
         
         System.out.println("Java polo string\n"+ poloString.getName());
         System.out.println("FName: " + poloString.getFname());
         System.out.println("Address: "+poloString.getAddress());
         System.out.println("Marks: "+ poloString.getMarks());
         
         //Conversion using tree model
         JsonNode rootNode = objectMapper.readTree(jsonString);
         
         JsonNode nameNode = rootNode.path("name");
         System.out.println("Name: "+ nameNode.asText());

         JsonNode fnameNode = rootNode.path("fname");
         System.out.println("Fname: " + fnameNode.asText());
         
         JsonNode addressNode = rootNode.path("address");
         System.out.println("Address: "+ addressNode.asText());
         
         
         JsonNode marksNode = rootNode.path("marks");
         Iterator<JsonNode> iterator = marksNode.elements();
         System.out.print("Marks: ");
         while(iterator.hasNext()) {
        	 JsonNode marks = iterator.next();
         System.out.print (marks.asInt()+" , ");
      }
      }
      catch (JsonParseException e) { e.printStackTrace();}
      catch (JsonMappingException e) { e.printStackTrace(); }
      catch (IOException e) { e.printStackTrace(); }
   }
}


