package net.lxsthw.redelite.bungee;

import net.lxsthw.redelite.bungee.commands.Commands;
import net.lxsthw.redelite.bungee.commands.bungee.InfoCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
    private static Main instance;
    private static ProxyServer proxy;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    public static ProxyServer getProxyServer() {
        return proxy;
    }

    @Override
    public void onEnable() {
        Commands.setupCommands();

        this.getLogger().info("O plugin foi ativado.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("O plugin foi desativado.");
    }
}
