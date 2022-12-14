/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviddbhandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Chayodom
 */
public class CovidDBHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       insertCovid(getdataJson());
       
       
       
    }


    public static Covidweek getdataJson() throws Exception{
	URL obj = new URL("https://covid19.ddc.moph.go.th/api/Cases/today-cases-all");
	  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	  con.setRequestMethod("GET");
	  int responseCode = con.getResponseCode();
	  System.out.println("GET Response Code :: " + responseCode);
	  if (responseCode == HttpURLConnection.HTTP_OK) { // success
		  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		  String inputLine;
		  StringBuffer response = new StringBuffer();

		  while ((inputLine = in.readLine()) != null) {
			  response.append(inputLine);
		  }
		  in.close();
		  String json = response.toString();
		  JsonReader jsonReader = Json.createReader(new StringReader(json));
		  JsonArray jsonArray = jsonReader.readArray();
		  jsonReader.close();
		  
		  
		  JsonObject covid = jsonArray.getJsonObject(0);
                  int year                    = covid.getInt("year");
		  int weeknum                 = covid.getInt("weeknum");
		  int newCase                 = covid.getInt("new_case");
		  int totalCase               = covid.getInt("total_case");
		  int newCaseExcludeabroad    = covid.getInt("new_case_excludeabroad");
		  int totalCaseExcludeabroad  = covid.getInt("total_case_excludeabroad");
		  int newRecovered            = covid.getInt("new_recovered");
		  int totalRecovered          = covid.getInt("total_recovered");
		  int newDeath                = covid.getInt("new_death");
		  int totalDeath              = covid.getInt("total_death");
		  int caseForeign             = covid.getInt("case_foreign");
		  int casePrison              = covid.getInt("case_prison");
		  int caseWalkin              = covid.getInt("case_walkin");
		  int caseNewPrev             = covid.getInt("case_new_prev");
		  int caseNewDiff             = covid.getInt("case_new_diff");
		  int deathNewPrev            = covid.getInt("death_new_prev");
		  int deathNewDiff            = covid.getInt("death_new_diff");
		 
		  String updateDate           = covid.getString("update_date");
		  
		  SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  Date date = DateFor.parse(updateDate);
		 
		  
		  Covidweek cov = new Covidweek( year,  weeknum,  newCase,  totalCase,  newCaseExcludeabroad,  totalCaseExcludeabroad,  newRecovered,  totalRecovered,  newDeath,  totalDeath,  caseForeign,  casePrison,  caseWalkin,  caseNewPrev,  caseNewDiff,  deathNewPrev,  deathNewDiff, date);
		  
		  //insertCovid(cov);
                  return cov;
		   
	  
		  
	  } else {
		  System.out.println("GET request did not work.");
                  return null;
	  }
			  
			  
  }
    public static List<Covidweek> findALLDB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidDBHandlerPU");
        EntityManager em = emf.createEntityManager();
        List<Covidweek> coList = (List<Covidweek>)em.createNamedQuery("Covidweek.findAll").getResultList();  //time to change
        return coList;
    }
    public static void insertCovid(Covidweek cov) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidDBHandlerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(cov);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
   
  
    
 
  
   
    public static void removeCovid(int emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidDBHandlerPU");
        EntityManager em = emf.createEntityManager();
        Covidweek fromDb = em.find(Covidweek.class, emp);
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
}
