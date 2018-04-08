package fr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class installfirsthttp{
	public static int ranka= 0;
	public static int rankamax= 0;
	public static int rankb = 0;
	public static int rankbmax = 0;
	public static int rankc=0;
	public static int rankcmax=0;
	public static int mmr=0;

	public static int maxmmr=0;
public static  void main(String[] args)
	{
		new installfirsthttp().notimetotest("Theo-Dev_TPC");
	}
   public static void getrank(String id)
   {
        new installfirsthttp().testIt(id);
   }
   public static void getid(String id)
   {
        new installfirsthttp().notimetotest(id);
   }
   private void testIt(String id){

      String https_url = "https://r6db.com/api/v2/players/" + id;
      URL url;
      try {

	     url = new URL(https_url);
	     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
	     con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
	     con.setRequestProperty("X-App-Id", "TPC-Bot multi gaming community 1000+ members");
	        con.setRequestProperty("Content-Type", "application/json");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
	       StringBuffer res = new StringBuffer(); 
	       String line;
	       while ((line = reader.readLine()) != null) {
	           res.append(line);
	       }
	       //System.out.println(res);
	       reader.close();
	       
	       JSONObject jsonObj = new JSONObject(res.toString());

           System.err.println("LOG" + res.toString());

	      //JSONObject jsonarr=  jsonObj;
	       JSONArray obj = new JSONArray();
         //  Iterator<Object> iterator = ((Iterable<Object>) jsonarr).iterator();
	      // JSONObject jsonObj2 = (JSONObject) iterator.next();
         //  while (iterator.hasNext()) {

               System.err.println("LOG" + res.toString());
         //  }
      //     System.err.println(jsonObj2.toString());
         try {  JSONObject b = (JSONObject) jsonObj.get("rank");
         System.err.println(b.toString());
           JSONObject c = (JSONObject) b.get("ncsa");
           JSONObject d = (JSONObject) b.get("emea");
           JSONObject e = (JSONObject) b.get("apac"); 
           int a = c.getInt("rank");
           int f = c.getInt("max_rank");
           int u= d.getInt("rank");
           int o= d.getInt("max_rank");
           int w= d.getInt("max_mmr");
           int z= d.getInt("mmr");

           int i = e.getInt("rank");
           int m = e.getInt("max_rank");
//           System.err.println("LOG" + res.toString());

           this.ranka = a;
           this.rankamax= f;
           this.rankb = u;
           this.rankbmax = o;
           this.mmr = z;
           this.maxmmr = w;
           this.rankc = i;
           this.rankc = m;
           System.out.println("ncsa rank");

           System.out.println("ncsa rank " + a +f+" emea rank : "+ u+o +"  apac rank : "+ i+m);
           System.err.println("ncsa rank " + a +" emea rank : "+ u +"  apac rank : "+ i);

           if(a == 0)
           {
        	  a =0;
           }
           } catch(Exception e) {e.printStackTrace();}
//           String a = b.getString(key)
	       

	       /*int count = jsonObj.getInt("ra		nk");
	       System.out.println("Rank :" + count);*/
/*	JSONObject jso = (JSONObject) con;
	JSONObject company = (JSONObject) jso.get("company");
	JSONObject location = (JSONObject) company.get("location");
	String city = (String) location.get("city");
	String country = (String) location.get("country");	*/




      } catch (MalformedURLException e) {
	     e.printStackTrace();
      } catch (IOException e) {
	     e.printStackTrace();
      } catch (JSONException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

   }
   private String notimetotest(String toid){

	      String https_url = "https://api.r6stats.com/api/v1/players/"+ toid +"?platform=uplay";
	      URL url;
	      try {

		     url = new URL(https_url);
		     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
		     con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		        con.setRequestProperty("Content-Type", "application/json");
		        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
			       StringBuffer res = new StringBuffer(); 
			       String line;
			       while ((line = reader.readLine()) != null) {
			           res.append(line);
			       }

		       reader.close();
		       
		       //System.out.println(res.toString());
		       JSONObject jsonObj = new JSONObject(res.toString());
		       System.out.println(jsonObj.toString());
		       JSONObject player = (JSONObject) jsonObj.get("player");
		       String b = player.getString("ubisoft_id");
		       System.out.println(b);
		       con.disconnect();
		       installfirsthttp.getrank(b);
	/*	JSONObject jso = (JSONObject) con;
		JSONObject company = (JSONObject) jso.get("company");
		JSONObject location = (JSONObject) company.get("location");
		String city = (String) location.get("city");
		String country = (String) location.get("country");	*/




	      } catch (MalformedURLException e) {
		     e.printStackTrace();
	      } catch (IOException e) {
		     e.printStackTrace();
	      } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return https_url;

	   }

   
   

}	