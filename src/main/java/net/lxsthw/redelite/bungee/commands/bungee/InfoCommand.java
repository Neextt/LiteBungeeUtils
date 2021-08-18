package net.lxsthw.redelite.bungee.commands.bungee;

import net.lxsthw.redelite.bungee.commands.Commands;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfoCommand extends Commands {
    public InfoCommand() {
        super("finder");
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer)sender;
            if (args.length > 0) {
                if (!player.hasPermission("group.master")) {
                    player.sendMessage("§cVocê não possui permissão para executar este comando.");
                    return;
                }
            }

            if (args.length != 1) {
                sender.sendMessage("§cUso: /finder <player>.");
            } else {
                ProxiedPlayer target = (ProxiedPlayer) sender;
                if (target == null) {
                    sender.sendMessage("§cJogador não foi encontrado.");
                } else {
                    if (!player.hasPermission("group.master")) {
                        sender.sendMessage("§cNão é possível visualizar informações desse jogador.");
                    } else {
                        sender.sendMessage("§eFinder:\n\n§fJogador: §7" + target.getName() + "\n§fServidor: §7" + target.getServer().getInfo().getName().toUpperCase());
                    }
                }
            }
        }
    }
}
