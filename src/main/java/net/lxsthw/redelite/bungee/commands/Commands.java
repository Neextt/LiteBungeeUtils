package net.lxsthw.redelite.bungee.commands;

import net.lxsthw.redelite.bungee.Main;
import net.lxsthw.redelite.bungee.commands.bungee.*;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public abstract class Commands extends Command {

    public Commands(String name, String... aliases) {
        super(name, null, aliases);
        ProxyServer.getInstance().getPluginManager().registerCommand(Main.getInstance(), this);
    }

    public abstract void perform(CommandSender sender, String[] args);

    @Override
    public void execute(CommandSender sender, String[] args) {
        this.perform(sender, args);
    }

    public static void setupCommands() {
        new StaffChatCommand();
        new AvisarCommand();
        new InfoCommand();
        new TellCommand();
        new ReplyCommand();
    }
}