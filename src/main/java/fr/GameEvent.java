package fr;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.impl.MemberImpl;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserGameUpdateEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class GameEvent implements EventListener  {
	boolean debug = true;
	@Override
	public void onEvent(Event event) {
		
		 if (event instanceof UserGameUpdateEvent || event instanceof GuildMemberJoinEvent)
		 {
			User a = (User) ((UserGameUpdateEvent) event).getUser();
		System.out.println(a.getName());
        MemberImpl member = (MemberImpl)((UserGameUpdateEvent) event).getGuild().getMember(a);
      if(member.getGame() != null)
    	  {
    	  //TextChannel cha = ((UserGameUpdateEvent) event).getGuild().getTextChannelById("384382548924432405");
    	if(this.debug) {
    		//cha.sendMessage("Bon; Ce putain de bot marche ! \n DEBUG: \n NAME : "+ member.getEffectiveName() + "\n GAME PLAYING NOW: "+ member.getGame().getName()).queue();
    		}
    	else
    	{
    		System.out.println(this.debug);
    	}
          net.dv8tion.jda.core.entities.Guild b = event.getJDA().getGuildById("140919311412887552");
       	Role r6 = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("🔰 Joueur_R6S 🔰")).findFirst().orElse(null);
      	Role cod = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("🔫 Joueur WWII 🔫")).findFirst().orElse(null);
      	Role fort = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("☢  Joueur_fortnite  ☢")).findFirst().orElse(null);
      	Role arma = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("🔥 Arma III 🔥")).findFirst().orElse(null);
      	Role pubg = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("☢ Joueur PUBG ☢")).findFirst().orElse(null);
      	Role lol = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("✨ League of Legends ✨")).findFirst().orElse(null);
      	Role cs = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("︻╦╤─ Joueur CS:GO ─╤╦︻")).findFirst().orElse(null);
      	Role bf1 = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("💮 Joueur BF1 💮")).findFirst().orElse(null);


    	 /* System.out.println(member.getGame().getName());*/

        
        
        
        
        /* CODE CHIANT */
     	if(member.getGame().getName().contains("Tom Clancy's Rainbow Six Siege"))
     	{
     	//member.getGuild().getController().addSingleRoleToMember(member, (Role)a.getRolesByName("âœ” Membre de la TPC âœ”", true)).queue();;
     	if(member.getRoles().contains(r6))
     	{
     	}
     	else
     	{
     	try { member.getGuild().getController().addSingleRoleToMember(member, r6).queue();; }catch(Exception e) {}

     	}
     	}
     	if(member.getGame().getName().startsWith("Call of Duty: WW") || member.getGame().getName().startsWith("Call of Duty WW"))
     	{
     	if(member.getRoles().contains(cod))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, cod).queue();; }catch(Exception e) {}

     	}
     		

     	//member.getGuild().getController().addSingleRoleToMember(member, (Role)a.getRolesByName("âœ” Membre de la TPC âœ”", true)).queue();;

     	//ðŸ”« Joueur WWII ðŸ”«

     	}
     	if(member.getGame().getName().equals("Fortnite"))
     	{
     	if(member.getRoles().contains(fort))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, fort).queue();; }catch(Exception e) {}
     	}
     	}	
     	if(member.getGame().getName().equals("Arma 3"))
     	{                
     	//member.getGuild().getController().addSingleRoleToMember(member, (Role)a.getRolesByName("âœ” Membre de la TPC âœ”", true)).queue();;
     	if(member.getRoles().contains(arma))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, arma).queue();; }catch(Exception e) {}
     	}
     	}
     	if(member.getGame().getName().equals("PLAYERUNKNOW'S BATTLEGROUND"))
     	{

     	//member.getGuild().getController().addSingleRoleToMember(member, (Role)a.getRolesByName("âœ” Membre de la TPC âœ”", true)).queue();;
     	if(member.getRoles().contains(pubg))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, pubg).queue();; }catch(Exception e) {}
     	}

     	}
     	if(member.getGame().getName().equals("League of Legends"))
     	{

     	//member.getGuild().getController().addSingleRoleToMember(member, (Role)a.getRolesByName("âœ” Membre de la TPC âœ”", true)).queue();;

     	if(member.getRoles().contains(lol))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, lol).queue();; }catch(Exception e) {}
     	}

     	}
     	if(member.getGame().getName().equals("Counter-Strike Global Offensive") || member.getGame().getName().contains("Offensive"))
     	{
     	//member.getGuild().getController().addSingleRoleToMember(member, (Role)a.getRolesByName("âœ” Membre de la TPC âœ”", true)).queue();;
     	if(member.getRoles().contains(cs))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, cs).queue();; }catch(Exception e) {}
     	}
     	}
     	if(member.getGame().getName().equals("Battlefield 1"))
     	{

     	if(member.getRoles().contains(bf1))
     	{
     	}
     	else
     	{
         	try { member.getGuild().getController().addSingleRoleToMember(member, bf1).queue();; }catch(Exception e) {}
     	}
     	}

     	} else if(member.getGame() != null || member.getGame() == null)
     	{


     			OffsetDateTime newlyGeneratedDate = OffsetDateTime.now();

     	          net.dv8tion.jda.core.entities.Guild b = event.getJDA().getGuildById("140919311412887552");
     	         
	         /*	    Role membres = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("✔ Membre de la TPC ✔")).findFirst().orElse(null);
 					member.getGuild().getController().addSingleRoleToMember(member, membres).queue();

	       	    Role threem = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("💿Fidélité 3 mois")).findFirst().orElse(null);
	         	    Role sixm = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("📀Fidélité 6 mois")).findFirst().orElse(null);
	         	    Role douzem = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("💰Fidélité 12 mois")).findFirst().orElse(null);
	         	    Role membre = b.getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("💰Fidélité 12 mois")).findFirst().orElse(null);
     	   Duration d;
     	   
     			if(ChronoUnit.MONTHS.between(member.getJoinDate(), OffsetDateTime.now()) > 3)
     			{
     				if(member.getRoles().contains(threem) || member.getRoles().contains(sixm))
     				{

     				}
     				else
     				{

     					member.getGuild().getController().addSingleRoleToMember(member, threem).queue();

     				}
     			}
     			if(ChronoUnit.MONTHS.between(member.getJoinDate(), OffsetDateTime.now()) > 6)
     			{
     				if(member.getRoles().contains(sixm))
     				{


     				}
     				else if(member.getRoles().contains(threem))
     				{
     			    //	member.getGuild().getController().removeRolesFromMember(member, sixm).queue();
     			    	member.getGuild().getController().addSingleRoleToMember(member, sixm).queue();

     				}
     				else
     				{
     			    	member.getGuild().getController().addSingleRoleToMember(member, sixm).queue();
     			    	
     				}
     			}
     			if(ChronoUnit.MONTHS.between(member.getJoinDate(), OffsetDateTime.now()) > 12)
     			{
     				if(member.getRoles().contains(douzem))
     				{

     				}
     				else if(member.getRoles().contains(sixm) || member.getRoles().contains(threem))
     				{

//     			    	member.getGuild().getController().removeSingleRoleFromMember(member, sixm).queue();

     		//	    	member.getGuild().getController().removeSingleRoleFromMember(member, threem).queue();
     			    	member.getGuild().getController().addSingleRoleToMember(member, douzem).queue();

     				}
     				else
     				{
     			    	member.getGuild().getController().addSingleRoleToMember(member, douzem).queue();

     				}
     			
     		}*/
     			
    	  }
      
			

				
		 }
		 else if(event instanceof MessageReceivedEvent)
		 {

			 if(((MessageReceivedEvent) event).getMessage().getContentRaw().contains("debug"))
			 {
				 String[] zbvc = ((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ");
				 try{ if(zbvc[1] == null)
				 {
					 ((MessageReceivedEvent) event).getChannel().sendMessage("Mauvais argument!").queue();
				 }
				 if(zbvc[1].contains("true") || zbvc[1].contains("false"))
				 {
					 if(zbvc.equals("true"))
					 {
						 ((MessageReceivedEvent) event).getChannel().sendMessage("Properties set !").queue();

						 this.debug = true;
					 }
					 else
					 {
						 ((MessageReceivedEvent) event).getChannel().sendMessage("Properties set !").queue();
						 this.debug = false;
					 }
				 }
				 else
				 {
					 ((MessageReceivedEvent) event).getChannel().sendMessage("Mauvais argument!").queue();

				 } }catch(Exception e)  { e.printStackTrace(); }
			 }
			 
			 
			 if(((MessageReceivedEvent) event).getMessage().getContentRaw().startsWith("!purge"))
			 {
                 TextChannel channel =  ((MessageReceivedEvent) event).getTextChannel();
                 User auth =  ((MessageReceivedEvent) event).getAuthor();
                 Message msg = ((MessageReceivedEvent) event).getMessage();
				 if(((MessageReceivedEvent) event).getMember().hasPermission(Permission.MESSAGE_MANAGE))
				 {
				try {	 if(((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[2] != null && ((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[1] != null)
					 {
						 if(((MessageReceivedEvent) event).getMessage().getMentionedUsers() != null)
						 {
							 String[] msgsplit = ((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ");
			                 ((MessageReceivedEvent) event).getChannel().getHistory().retrievePast(Integer.parseInt(msgsplit[2])).queue(msgsRaw -> {
			                	 
			                	 String[] booring = msgsplit[1].split("@");
			                	try { User b =  msg.getMentionedUsers().get(0); } catch(Exception e ) {}
			                	 User c = msg.getMentionedUsers().get(0);
                                 List<Message> msgs = msgsRaw.stream().filter(message -> !message.getCreationTime().plusWeeks(2).isBefore(OffsetDateTime.now())).collect(Collectors.toList());
                                 List<Message> mentionPurge = msgs.stream().filter(mes -> msg.getMentionedUsers().stream().anyMatch(mes.getAuthor()::equals)).collect(Collectors.toList());

			                     channel.deleteMessages(mentionPurge).queue();;
			                	 System.out.println(c.getName() + booring[1]);

			                     channel.sendMessage("I will delete " + msgsplit[2] + " messages that come from the user " + booring[1]).queue();
			                 });
						 }
						
					 }

				}catch(Exception e ) {return;}
 
					if(((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[1] != 	null && ((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[2] == null)
					 {
						 if(((MessageReceivedEvent) event).getMessage().getMentionedUsers() != null)
						 {
							 String[] msgsplit = ((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ");
			                 ((MessageReceivedEvent) event).getChannel().getHistory().retrievePast(100).queue(msgsRaw -> {
			                	 String[] booring = msgsplit[1].split("@");

			                     List<Message> msgs = msgsRaw.stream().filter(message -> message.getAuthor().getName().equals(booring[1])).collect(Collectors.toList());
			                     channel.deleteMessages(msgsRaw).queue();;
			                     channel.sendMessage("I will delete all the message of " + booring[1]).queue();
			                 });
						 }


					 }
					 
					 else if((((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[2] == null && ((MessageReceivedEvent) event).getMessage().getContentRaw().split(" ")[1] == null)
)
					 {

                 ((MessageReceivedEvent) event).getChannel().getHistory().retrievePast(100).queue(msgsRaw -> {
                	 


                     List<Message> msgs = msgsRaw.stream().filter(message -> !message.getCreationTime().plusWeeks(2).isBefore(OffsetDateTime.now())).collect(Collectors.toList());
                     channel.deleteMessages(msgsRaw).queue();;
                     channel.sendMessage("Gona purge that").queue();
                 });
					 }
				 }
				 
				 else
				 {
					 ((MessageReceivedEvent) event).getChannel().sendMessage("You don't have required permission(s).").queue();
				 }
			 }
		 }
		// TODO Auto-generated method stub
		
	}

}
