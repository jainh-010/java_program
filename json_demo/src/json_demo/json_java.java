package json_demo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class json_java {
   public static void main(String args[]){
   
      ObjectMapper objectmapper = new ObjectMapper();
      String jsonString;
	  Student poloString;
      
      try{
         Student student = new Student("Ramesh","Suresh","Bikaner");
         
         System.out.println(student);
         
         jsonString = objectmapper.writeValueAsString(student);
         
         poloString = objectmapper.readValue(jsonString,Student.class);
         
         System.out.println("Json string\n"+ jsonString);
         
         System.out.println("Java polo  string\n"+ poloString.getName());
         System.out.println(poloString.getFname());
         System.out.println(poloString.getAddress());
      }
      catch (JsonParseException e) { e.printStackTrace();}
      catch (JsonMappingException e) { e.printStackTrace(); }
      catch (IOException e) { e.printStackTrace(); }
   }
}


