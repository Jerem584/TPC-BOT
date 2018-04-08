package fr;

import javax.security.auth.login.LoginException;

import org.json.JSONException;
import org.json.JSONObject;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.WebSocketCode;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.RichPresence;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Main 
{	

	public static JDA jda;
		public static void main(String[] args)
	            throws LoginException, RateLimitedException, InterruptedException
	    {

	    	// Note: It is important toregister your ReadyListener before building
	        jda = new JDABuilder(AccountType.BOT)
	            .setToken("YourTokenHere")
	            .addEventListener(new r6Listener())
	            .addEventListener(new gamelistener())
	            .addEventListener(new GameEvent())
	            .addEventListener(new CommandHelp())
	            .setStatus(OnlineStatus.IDLE)
	            
	            .buildBlocking();
	        
	        JDAImpl abd = (JDAImpl) jda;
	        Main.Maina(abd);


	    }
	    
	    public static void Maina(JDAImpl jda) { //JDA object can be casted to a JDAImpl
	        JSONObject obj = new JSONObject();
	        JSONObject gameObj = new JSONObject();

	        try {
	           
	        gameObj.put("name", "En ligne - No action");
	        gameObj.put("type", 0); //1 if streaming
				gameObj.put("details", "Details Here");
	    	
	        gameObj.put("state", "Spotify - PLAYING");
	        gameObj.put("timestamps", new JSONObject().put("start", 1508373056)); //somehow used for the time elapsed thing I assume, you can probably also set the end to make it show "xx:xx left"

	        JSONObject assetsObj = new JSONObject();
	        assetsObj.put("large_image", "376410582829498368"); //ID of large icon
	        assetsObj.put("large_text", "Large Text");

	        assetsObj.put("small_image", "376410693861244928"); //ID of small icon

	        gameObj.put("assets", assetsObj);
	        gameObj.put("application_id", "354736186516045835"); //Application ID

	        obj.put("game", gameObj);
	        obj.put("afk", jda.getPresence().isIdle());
	        obj.put("status", jda.getPresence().getStatus().getKey());
	        obj.put("since", System.currentTimeMillis());

	        System.out.println(obj);

	        jda.getClient().send(new JSONObject()
	                .put("d", obj)
	                .put("op", WebSocketCode.PRESENCE).toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
	    }
	    }
	     

	    public void onEvent(Event event)
	    {
	        if (event instanceof ReadyEvent)
	            System.out.println("API is ready!");
	    }

}