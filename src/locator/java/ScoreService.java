package locator.java;
import javax.ws.rs.*;

@Path("/")
public class ScoreService {
	  public static int wins, losses, ties;
	  
	  @GET
	  @Path("/score")
	  @Produces("application/json")
	  public String getScore() {
	     String pattern = 
	        "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	     return String.format(pattern,  ScoreService.wins, ScoreService.losses, ScoreService.ties );   
	  }
	  
	  @PUT
	  @Path("/score")
	  @Produces("text/plain")
	  public String update(@QueryParam("wins") int wins, 
	                          @QueryParam("losses") int losses, 
	                          @QueryParam("ties")   int ties) {
		  ScoreService.wins   = wins;
		  ScoreService.ties   = ties;
		  ScoreService.losses = losses;
	     String pattern = 
	        "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	     return String.format(pattern,  ScoreService.wins, ScoreService.losses, ScoreService.ties);   
	  }
	  
	  @POST @Path("/score/wins")@Produces("text/plain")
	  public int increaseWins() { return ScoreService.wins++; }
	       
	  @POST @Path("/score/ties")@Produces("text/plain")      
	  public int increaseTies() { return ScoreService.ties++; }
	       
	  @POST @Path("/score/losses")@Produces("text/plain")         
	  public int increaseLosses() {return ScoreService.losses++; }
	  
	  @GET @Path("/score/wins")@Produces("text/plain")
	  public int getWins() { return ScoreService.wins; }
	       
	  @GET @Path("/score/losses")@Produces("text/plain")
	  public int getLosses() { return ScoreService.losses; }
	       
	  @GET @Path("/score/ties")@Produces("text/plain")
	  public int getTies() { return ScoreService.ties; }
}
