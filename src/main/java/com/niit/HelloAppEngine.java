package com.niit;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;


//DataStore API
//https://cloud.google.com/datastore/docs/datastore-api-tutorial

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet 
{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException 
  {
//	  Entity employee = new Entity("Employee", "asalieri");
//	  employee.setProperty("firstName", "Antonio");
//	  employee.setProperty("lastName", "Salieri");
//	  employee.setProperty("hireDate", new Date());
//	  employee.setProperty("attendedHrTraining", true);
//
	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//	  datastore.put(employee);
	  
	 Filter propertyFilter =
			    new FilterPredicate("firstName", FilterOperator.EQUAL, "Antonio");
			Query q = new Query("Employee").setFilter(propertyFilter);
			Key key=q.getAncestor();
			
			try 
			{
				Entity employee = datastore.get(key);
				response.getWriter().print(employee.getProperty("lastName"));
				
			}
			catch (EntityNotFoundException e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}
	  response.getWriter().print("Hello App Engine!\r\n");

  }
}