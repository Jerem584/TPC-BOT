package fr;


import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed.AuthorInfo;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;

public class gamelistener extends ListenerAdapter
{
	boolean accepted = false;
	boolean ifaccepted = false;

	@Override
	public void onMessageReceived(MessageReceivedEvent event) 
	{
		if(event.getMessage().getContentRaw().toLowerCase().equals("confirm"))
		{
			if(accepted)
			{
				String fdpname = event.getAuthor().getName();
				event.getChannel().sendMessage("You confirmed.").queue();;
				accepted = true;
				ifaccepted = true;
			}
			else
			{
				System.err.println("He's dumb line 32 : gamelistener");
			}

		}
		if(event.getMessage().getContentRaw().startsWith("!bulkmessage"))
		{
			if(event.getMember().hasPermission(Permission.MANAGE_SERVER))
			{
				for(Member mem : event.getGuild().getMembers())
				{		

					User a = mem.getUser();
					if(!a.isBot())
					{
						
					}
					else
					{
						RestAction<PrivateChannel> cha =  a.openPrivateChannel();
						PrivateChannel br = cha.complete();
						String eval = event.getMessage().getContentRaw().split(" ", 2)[1];

						br.sendMessage(eval).queue();
						event.getChannel().sendMessage("MEMBER: " + mem.getEffectiveName()).queue();;
						System.out.println("MEMBER: " + mem.getEffectiveName());
						accepted = false;
						ifaccepted = false;
					}

				}
			}
			else
			{
				
			}


		}
	}


	
}
