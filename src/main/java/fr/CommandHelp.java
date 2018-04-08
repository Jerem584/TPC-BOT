package fr;

import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class CommandHelp implements EventListener{
	


	public void onEvent(Event event) 
	{

		if(event instanceof MessageReceivedEvent)
		{
			if(((MessageReceivedEvent) event).getChannel().getId().equals("384382546877612045") && ((MessageReceivedEvent) event).getMessage().getContentRaw().equals("!help"))
			{
				((MessageReceivedEvent) event).getChannel().sendMessage("ADMIN : Help TPC Bot \n !help Show this help message \n !r6s rank <Username> Get you're rank automaticly /!\\ Work only on channel #r6s_rank").queue();

			}
			else if(((MessageReceivedEvent) event).getMessage().getContentRaw().equals("!help"))
			{
				((MessageReceivedEvent) event).getChannel().sendMessage("Help TPC Bot \n !help Show this help message \n !r6s rank <Username> Get you're rank automaticly /!\\ Work only on channel #role_r6s").queue();
			}
		}
		
	}

}
