package net.lxsthw.redelite.bungee.commands.bungee;

import net.lxsthw.redelite.bungee.commands.Commands;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import tk.slicecollections.maxteer.player.role.Role;
import tk.slicecollections.maxteer.utils.StringUtils;

public class AvisarCommand extends Commands {

    public AvisarCommand() {
        super("aviso", "alert");
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(TextComponent.fromLegacyText("§cApenas jogadores podem utilizar este comando."));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (!player.hasPermission("group.gerente")) {
            player.sendMessage(TextComponent.fromLegacyText("§cVocê precisa estar no grupo §4Gerente§c ou superior para utilizar este comando."));
            return;
        }
        if (args.length == 0) {
            player.sendMessage(TextComponent.fromLegacyText("§cUtilize /aviso [mensagem] para enviar uma mensagem global."));
            return;
        }
        String msg = StringUtils.join(args, " ");
        BungeeCord.getInstance().getPlayers().forEach(ppr -> {
            ppr.sendMessage(TextComponent.fromLegacyText(""));
            ppr.sendMessage(TextComponent.fromLegacyText("  " + Role.getPrefixed(player.getName()) + "§7: §f" + StringUtils.formatColors(msg)));
            ppr.sendMessage(TextComponent.fromLegacyText(""));

        });
    }
}
