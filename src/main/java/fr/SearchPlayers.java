package fr;
import java.awt.Color;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.StringUtils;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.SteamPlayer;
import com.github.koraktor.steamcondenser.steam.servers.SourceServer;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageChannel;

public class SearchPlayers 
{
    public static final Charset UTF_8 = Charset.forName("UTF-8");

	@SuppressWarnings("unused")
	public static void main(String ip, String port, MessageChannel msg)
	{	
	    try {
	    	int porta = Integer.parseInt(port);
	    	SourceServer server = new SourceServer(ip, porta);
	    	server.initialize();
	    	System.out.println(server.getServerInfo());
	    	
	    	
	    	/* Formatting message */
	    	HashMap<String, SteamPlayer> a = server.getPlayers();
	    	HashMap<String, Object> ar = server.getServerInfo();
	    	HashMap<String, Object> ara = server.getServerInfo();
	    	HashMap<String, Object> arae = server.getServerInfo();
	    	String s = a.toString();
	    	String so = ar.toString();
	    	String sob = ara.toString();
	    	String soc = arae.toString();
	    	StringBuilder sta = new StringBuilder();
	    	StringBuilder str = new StringBuilder();

			String[] tds = StringUtils.substringsBetween(s, "\"", "\"");
		try {	for (String td : tds) {
				sta.append(td); // good
				sta.append(",\n");
			}}catch(Exception e) { msg.sendMessage("Nobody is connected on " + ip + ":" + port);}
			so = so.substring(so.indexOf("ame=") + 1);
			so = so.substring(0, so.indexOf(","));
			so = so.replaceAll("me=", "");
			sob = sob.substring(sob.indexOf("numberOfPlayers=") + 1);
			sob = sob.substring(0, sob.indexOf(","));
			sob = sob.replaceAll("umberOfPlayers=", "");
			soc = soc.substring(soc.indexOf("maxPlayers") + 1);
			soc = soc.substring(0, soc.indexOf(","));
			soc = soc.replaceAll("axPlayers=", "");
			//msg.sendMessage("PLAYER :" +sob + " MAX PLAYER: " + soc +" IP:PORT" + ip + ":" +port).queue();;

			String value = new String(sta.toString().getBytes("UTF-8"));
	    	/* Done Sending */
			EmbedBuilder eb = new EmbedBuilder();


			String be = so.replace("�", "");
        	eb.setTitle(be + " | " + ip + ":" + port +"\n", null);
        	eb.setColor(Color.red);
        	eb.setColor(new Color(0xF40C0C));
        	eb.setColor(new Color(255, 0, 54));

        	//eb.setThumbnail("https://cdn.discordapp.com/attachments/353965754233913354/419552111953575938/499f0f7a69f1b823fcf8d98759f69dd6c7d7c880_full.jpg");
        	eb.setDescription("steam://connect/"+ ip + ":" + port + "\n");
        	//eb.setImage("https://cdn.discordapp.com/attachments/353965754233913354/419552126935629824/header.png");
            eb.addField("Player(s) connected \n ", value, true);

        	

        	eb.addBlankField(true);


     
        	msg.sendMessage(eb.build()).queue();
	    	
	       } catch (TimeoutException e){
	    	   System.out.println("server off / internet off");
	       } catch (SteamCondenserException e) {
			// TODO Auto-generated catch block
	    	   System.out.println("exception");
	    	   msg.sendMessage("Server is not active").queue();
		}catch(Exception e)
	    {
			msg.sendMessage("You did something wrong!").queue();
			e.printStackTrace();
	    }
	}
	
	
	public static void maina(String ip, String port, MessageChannel msg)
	{
	    try {
	    	int porta = Integer.parseInt(port);
	    	SourceServer server = new SourceServer(ip, porta);
	    	server.initialize();
	    	System.out.println(server.getServerInfo());
	    	
	    	
	    	/* Formatting message */
	    	HashMap<String, SteamPlayer> a = server.getPlayers();
	    	HashMap<String, Object> ar = server.getServerInfo();
	    	HashMap<String, Object> ara = server.getServerInfo();
	    	HashMap<String, Object> arae = server.getServerInfo();
	    	String s = a.toString();
	    	String so = ar.toString();
	    	String sob = ara.toString();
	    	String soc = arae.toString();
	    	StringBuilder sta = new StringBuilder();
	    	StringBuilder str = new StringBuilder();

			String[] tds = StringUtils.substringsBetween(s, "\"", "\"");
		try {	for (String td : tds) {
				sta.append(td); // good
				sta.append(",\n");
			}}catch(Exception e) { msg.sendMessage("Nobody is connected on " + ip + ":" + port);}
			so = so.substring(so.indexOf("ame=") + 1);
			so = so.substring(0, so.indexOf(","));
			so = so.replaceAll("me=", "");
			sob = sob.substring(sob.indexOf("numberOfPlayers=") + 1);
			sob = sob.substring(0, sob.indexOf(","));
			sob = sob.replaceAll("umberOfPlayers=", "");
			soc = soc.substring(soc.indexOf("maxPlayers") + 1);
			soc = soc.substring(0, soc.indexOf(","));
			soc = soc.replaceAll("axPlayers=", "");


			String value = new String(sta.toString().getBytes("UTF-8"));
	    	/* Done Sending */
			EmbedBuilder eb = new EmbedBuilder();


        	eb.setTitle(so + " | " + ip + ":" + port +"\n", null);
        	eb.setColor(Color.red);
        	eb.setColor(new Color(0xF40C0C));
        	eb.setColor(new Color(255, 0, 54));

        	eb.setThumbnail("https://cdn.discordapp.com/attachments/353965754233913354/419552111953575938/499f0f7a69f1b823fcf8d98759f69dd6c7d7c880_full.jpg");
        	eb.setDescription("steam://connect/"+ ip + ":" + port + "\n");
        	eb.setImage("https://cdn.discordapp.com/attachments/353965754233913354/419552126935629824/header.png");
        	eb.addField("No player on", "NO", false);


        	eb.addBlankField(false);


     
        	msg.sendMessage(eb.build()).queue();
	    	
	       } catch (TimeoutException e){
	    	   System.out.println("server off / internet off");
	       } catch (SteamCondenserException e) {
			// TODO Auto-generated catch block
	    	   System.out.println("exception");
	    	   msg.sendMessage("Server is not active").queue();
		} catch(Exception e)
	    {
			msg.sendMessage("You did something wrong!").queue();
			e.printStackTrace();
	    }
	}

}
