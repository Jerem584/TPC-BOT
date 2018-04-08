package fr;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed.Field;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class r6Listener extends ListenerAdapter 
{
	String actualrank = "Error";
	String actualrankurl = "Error";
	Color actualrankcolor;
	String actualbest;
	BufferedReader br = null; /* Bugging // Must rework the reader & writer */ 
	FileReader fr = null;

	 @Override
	    public void onMessageReceived(MessageReceivedEvent event)
	    {
         if(event.getMessage().getContentDisplay().equals("!server"))
         {

         	System.out.println("ok");
         	event.getChannel().sendMessage("It should look like this: !server IP:PORT").queue();
         }
     	if(event.getMessage().getContentDisplay().startsWith("!server "))
     		{
     		String[] a = event.getMessage().getContentDisplay().split(" ", 2);
     			if(a[1] != null)
     			{
     				if(a[1].contains(":"))
     				{
     					String[] b = a[1].split(":");
     					MessageChannel cha = event.getChannel();
     					SearchPlayers.main(b[0], b[1], cha);
     				}
     				else
     				{
     					event.getChannel().sendMessage("Wrong input, Example: 10.0.0.1:25565\r\n" + 
     							"").queue();
     				}
     			}
     		}
	        if (event.isFromType(ChannelType.PRIVATE))
	        {
	            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
	                                    event.getMessage().getContentRaw());
	        }
	        else
	        {
/*	        	if(!event.getAuthor().isBot() && event.getMessage().getContentRaw().toLowerCase().equals("bonjour") || event.getMessage().getContentRaw().toLowerCase().equals("salut") || event.getMessage().getContentRaw().toLowerCase().equals("yo"))
	        	{ 
	        		event.getChannel().sendMessage("Bonjour.").queue();
	        	}*/
	        	if(event.getChannel().getId().equals("412728199173373953"))
	        	{
	        		
	            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
	                        event.getTextChannel().getName(), event.getMember().getEffectiveName(),
	                        event.getMessage().getContentRaw());
	            if(event.getMessage().getContentRaw().startsWith("r6s claim")) /* Must rework the writer for making it p*/ 
	            {
	            	System.out.print("trigger");
	            	File a = new File("Database.txt");
	            	if(!a.exists())
	            	{
	            		try {
							a.createNewFile();
							
					      
					        
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            		System.out.println("File created " + a.getAbsolutePath());
	            	}
	            	else
	            	{



					            try {
				            		  String in = "";
								        BufferedWriter writer = null;
						            	String message = event.getMessage().getContentRaw();
						            	String[] msg = message.split(" ");
						            	MessageChannel chan = event.getChannel();
						            	StringBuilder test = new StringBuilder();
						    			fr = new FileReader(a);
						    			br = new BufferedReader(fr);

						    			String sCurrentLine;

						    			while ((sCurrentLine = br.readLine()) != null) {
						    				test.append(sCurrentLine);
						    			}
						    			if(test.toString().contains(event.getAuthor().getId() + ":"))
						    			{
						    				chan.sendMessage("You can only claim 1 accounts!").queue();
						    			}
						    			else if(test.toString().contains(":" + msg[2]))
						    			{
						    				chan.sendMessage("This account is already claimed!").queue();
						    			}
						    			else
						    			{

						    			  //  FileWriter fileWriter = new FileWriter(a);
						    			//    PrintWriter printWriter = new PrintWriter(fileWriter);
							    			System.out.println(test.toString()	);
									        String line = event.getAuthor().getId() + ":" + msg[2];
									//        FileWriter writera = new FileWriter(a);

						    			PrintWriter pw = new PrintWriter(new FileWriter(a));
										pw.append(line);
										
							            //System.out.println(line);
							            chan.sendMessage("CREATED : " + line).queue();;
							            pw.close();
						    			}

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					            finally
					            {
										try {
							            	if(br != null) br.close();
							            	if(fr != null) fr.close();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					            }

	            	}
	            }
	            if(event.getMessage().getContentRaw().startsWith("r6s rank"))
	            {
	            	File abc = new File("Database.txt");
	            	String message = event.getMessage().getContentRaw();
	            	String[] msg = message.split(" ");
	            	String player = msg[2];
	            	StringBuilder test = new StringBuilder();
	    			try {
						fr = new FileReader(abc);
		    			br = new BufferedReader(fr);

		    			String sCurrentLine;

		    			while ((sCurrentLine = br.readLine()) != null) {
		    				test.append(sCurrentLine);
		    			}
		    			if(test.toString().toString().toLowerCase().contains(event.getAuthor().getId() + ":" + msg[2].toLowerCase()) || !test.toString().toLowerCase().contains(":" + msg[2].toLowerCase()))
		    			{
		    				System.out.println(test.toString().toLowerCase());
			            	Main.jda.getPresence().setGame(Game.playing("Searching rank ;)"));

			            	installfirsthttp.getid(player);
			            	if(installfirsthttp.rankbmax < installfirsthttp.rankb)
			            	{
			            		switch(installfirsthttp.rankb)
			            		{
			            		case 0:
			            			this.actualrankurl="https://rbgboost.net/wp-content/uploads/2017/10/unranked2.png";
			            			this.actualrank = "UNRANKED";
			            			break;
			            		case 1:
			            			this.actualrank = "COPPER IV";
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424618687861882880/rank.png";
			            			break;
			            		case 2:
			            			this.actualrank = "COOPER III";
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424619305594781696/rank.png";
			            			break;	            		
			            		case 3:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424626066431148032/rank.png";
				            		this.actualrank = "COOPER II";
				            		break;
			            		case 4:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424620097827635211/rank.png";

			            			this.actualrank = "COPPER 1";
			            			break;
			            		case 5: 
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424620813430292481/rank.png";
			            			this.actualrank = "BRONZE IV";
			            			break;
			            		case 6: 
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424621196404064277/rank.png";
			            			this.actualrank = "BRONZE III";
			            			break;
			            		case 7:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424621423961833482/rank.png";;
			            			this.actualrank = "BRONZE II";
			            			break;
			            		case 8:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424621669936791562/rank.png";
			            			this.actualrank = "BRONZE I";
			            			break;
			            		case 9:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424622574400438292/rank.png";
			            			this.actualrank = "SILVER IV";
			            			break;
			            		case 10:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424622881725612033/rank.png";
			            			this.actualrank = "SILVER III";
			            			break;
			            		case 11:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424623435034132480/rank.png";
			            			this.actualrank = "SILVER II";
			            			break;
			            		case 12:
			            			this.actualrankurl ="https://cdn.discordapp.com/attachments/424617415171899399/424623644853927947/rank.png";
			            			this.actualrank = "SILVER I";
			            			break;
			            		case 13:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424630501249384458/rank.png";
			            			this.actualrank = "GOLD IV";
			            			break;
			            		case 14:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424630819127296020/rank.png";
			            			this.actualrank = "GOLD III";
			            			break;
			            		case 15:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424630915541499915/rank.png";
			            			this.actualrank = "GOLD II";
			            			break;
			            		case 16:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424631091752730624/rank.png";
			            			this.actualrank = "GOLD I";
			            			break;
			            		case 17:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632132493901844/rank.png";
			            			this.actualrank = "PLATINIUM III";
			            			break;
			            		case 18:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632198038290434/rank.png";
			            			this.actualrank = "PLATINIUM II";
			            			break;
			            		case 19:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632273737089024/rank.png";
			            			this.actualrank = "PLATINIUM I";
			            			break;
			            		case 20:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632369450844164/rank.png";
			            			this.actualrank = "Diamond";
			            			break;
			            		
			            		
			            		
			            	}

			            	}else {switch(installfirsthttp.rankbmax)
			            		{
			            		case 0:
			            			this.actualrankurl="https://rbgboost.net/wp-content/uploads/2017/10/unranked2.png";
			            			this.actualrank = "UNRANKED";
			            			break;
			            		case 1:
			            			this.actualrank = "COPPER IV";
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424618687861882880/rank.png";
			            			break;
			            		case 2:
			            			this.actualrank = "COOPER III";
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424619305594781696/rank.png";
			            			break;	            		
			            		case 3:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424626066431148032/rank.png";
				            		this.actualrank = "COOPER II";
				            		break;
			            		case 4:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424620097827635211/rank.png";

			            			this.actualrank = "COPPER 1";
			            			break;
			            		case 5: 
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424620813430292481/rank.png";
			            			this.actualrank = "BRONZE IV";
			            			break;
			            		case 6: 
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424621196404064277/rank.png";
			            			this.actualrank = "BRONZE III";
			            			break;
			            		case 7:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424621423961833482/rank.png";;
			            			this.actualrank = "BRONZE II";
			            			break;
			            		case 8:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424621669936791562/rank.png";
			            			this.actualrank = "BRONZE I";
			            			break;
			            		case 9:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424622574400438292/rank.png";
			            			this.actualrank = "SILVER IV";
			            			break;
			            		case 10:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424622881725612033/rank.png";
			            			this.actualrank = "SILVER III";
			            			break;
			            		case 11:
			            			this.actualrankurl = "https://cdn.discordapp.com/attachments/424617415171899399/424623435034132480/rank.png";
			            			this.actualrank = "SILVER II";
			            			break;
			            		case 12:
			            			this.actualrankurl ="https://cdn.discordapp.com/attachments/424617415171899399/424623644853927947/rank.png";
			            			this.actualrank = "SILVER I";
			            			break;
			            		case 13:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424630501249384458/rank.png";
			            			this.actualrank = "GOLD IV";
			            			break;
			            		case 14:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424630819127296020/rank.png";
			            			this.actualrank = "GOLD III";
			            			break;
			            		case 15:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424630915541499915/rank.png";
			            			this.actualrank = "GOLD II";
			            			break;
			            		case 16:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424631091752730624/rank.png";
			            			this.actualrank = "GOLD I";
			            			break;
			            		case 17:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632132493901844/rank.png";
			            			this.actualrank = "PLATINIUM III";
			            			break;
			            		case 18:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632198038290434/rank.png";
			            			this.actualrank = "PLATINIUM II";
			            			break;
			            		case 19:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632273737089024/rank.png";
			            			this.actualrank = "PLATINIUM I";
			            			break;
			            		case 20:
			            			this.actualrankurl="https://cdn.discordapp.com/attachments/424617415171899399/424632369450844164/rank.png";
			            			this.actualrank = "Diamond";
			            			break;
			            		
			            		
			            		
			            			}

			                Role muteRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Silver")).findFirst().orElse(null);
			                Role mutRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Gold")).findFirst().orElse(null);
			                Role muRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Platinium")).findFirst().orElse(null);
			                Role mRole = event.getGuild().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("Diamond")).findFirst().orElse(null);
			                String actualroletomake = "Error";

			                if(this.actualrank.contains("UNRANKED"))
			                {
			                	this.actualrankcolor = Color.BLACK;
			                }
			                if(this.actualrank.contains("COOPER"))
			                {
			                	this.actualrankcolor = Color.RED;
			                }
			                if(this.actualrank.contains("BRONZE"))
			                {
			                	this.actualrankcolor = Color.ORANGE;
			                }
			            	if(this.actualrank.contains("SILVER"))
			            	{
			            		actualrankcolor = Color.GRAY;
			            		event.getAuthor().getName();
			            		actualroletomake = "silver";

			            		event.getGuild().getController().addRolesToMember(event.getMember(), muteRole).queue();;
			            	}
			            	if(this.actualrank.contains("GOLD"))
			            	{
			            		actualrankcolor = Color.YELLOW;
			            		event.getGuild().getController().addRolesToMember(event.getMember(), mutRole).queue();;
			            		actualroletomake = "gold";

			            		event.getAuthor().getName();
			            	}
			            	if(this.actualrank.contains("PLATINIUM"))
			            	{
			            		actualrankcolor = Color.LIGHT_GRAY;
			            		event.getGuild().getController().addRolesToMember(event.getMember(), muRole).queue();;
			            		actualroletomake = "platinium";

			            		event.getAuthor().getName();
			            	}
			            	if(this.actualrank.contains("Diamond"))
			            	{
			            		actualrankcolor = Color.BLUE;
			            		event.getGuild().getController().addRolesToMember(event.getMember(), mRole).queue();;
			            		actualroletomake = "diamond";
			            	}
			            	
			            	/*EmbedBuilder eb = new EmbedBuilder();
			            	eb.setTitle(player.toString());
			            	eb.setThumbnail("https://cdn.discordapp.com/attachments/377867974414958593/424607502378860552/tpc.png");
			            	eb.setAuthor("");
			            	eb.setDescription("Rank de " + player +""+ actualrank);
			            	event.getChannel().sendMessage(eb.build()).queue();-*/
			    			EmbedBuilder eb = new EmbedBuilder();


			            	eb.setTitle(player + " | " + "TPC" + "\n", "http://teamplayercommunity.fr/");
			            	eb.setColor(Color.red);
			            	
			            	eb.setColor(this.actualrankcolor);

			            	eb.setThumbnail(this.actualrankurl);
			            	eb.setImage("https://cdn.discordapp.com/attachments/424617415171899399/424644141792886784/logo.jpg");
			            	eb.setDescription("Ranked information for the EU region on UPLAY");
			            	eb.addBlankField(true);
			            	eb.addField("*Rank*", this.actualrank, false);
			            	eb.addField("*MMR*\n\n*MAX*", installfirsthttp.mmr + "\n\n" + installfirsthttp.maxmmr, true);
			            	
			            	Field a = new Field(actualroletomake, actualroletomake, false);
			            	eb.addBlankField(true);
			            	eb.addBlankField(true);

			            	//eb.setImage("https://cdn.discordapp.com/attachments/353965754233913354/419552126935629824/header.png");
			                eb.addField("Merci d'utiliser notre bot.", "", false);

			            	

			            	eb.addBlankField(true);
			            	event.getChannel().sendMessage(eb.build()).queue();
			            	Main.jda.getPresence().setGame(Game.playing("Développing myself."));


			         
			            	if(this.actualrank.contains("COPPER") || this.actualrank.contains("BRONZE") || this.actualrank.contains("UNRANK"))
			            	{
			            		event.getChannel().sendMessage("No rank to add;").queue();
			            	}
			            	else
			            	{
			            		event.getChannel().sendMessage("Rank added, Have a nice day :) !").queue();

			            	}
		            	//	event.getChannel().sendMessage("Debug: emea rank " + installfirsthttp.rankb + "   Max:  " + installfirsthttp.rankbmax).queue();

			            //	event.getChannel().sendMessage("Trying to put rank " + actualroletomake + "  " + actualrank + " Pour l'utilisateur " + event.getAuthor().getAsMention()).queue();
			            }
		    			}
		    			else
		    			{
		    				event.getChannel().sendMessage("This account is not yours").queue();
		    			}


					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			finally
	    			{
						try {
			            	if(br != null) br.close();
			            	if(fr != null) fr.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    			}

	        	}
	        }
	    }

	    }
}
