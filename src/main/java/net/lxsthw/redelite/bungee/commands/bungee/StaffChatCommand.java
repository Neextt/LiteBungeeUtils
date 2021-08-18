package net.lxsthw.redelite.bungee.commands.bungee;

import net.lxsthw.redelite.bungee.commands.Commands;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import tk.slicecollections.maxteer.player.role.Role;
import tk.slicecollections.maxteer.utils.StringUtils;

import java.util.ArrayList;

public class StaffChatCommand extends Commands {

    public static ArrayList<ProxiedPlayer> staff = new ArrayList<>();

    public StaffChatCommand() {
        super("sc", "staffchat");
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(TextComponent.fromLegacyText("§cApenas jogadores podem utilizar este comando."));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (!player.hasPermission("vanity.cmd.staffchat")) {
            player.sendMessage(TextComponent.fromLegacyText("§cVocê precisa estar no grupo §e[Ajudante] §cou superior para executar este comando."));
            return;
        }
        if (args.length == 0) {
            if (!staff.contains(player)) {
                staff.add(player);
                sender.sendMessage(TextComponent.fromLegacyText("§cUtilize /sc [mensagem] para conversar com a equipe."));
            } else {
                staff.remove(player);
                sender.sendMessage(TextComponent.fromLegacyText("§cUtilize /sc [mensagem] para conversar com a equipe."));
            }
            return;
        }
        String msg = tk.slicecollections.maxteer.utils.StringUtils.join(args, " ");
        BungeeCord.getInstance().getPlayers().stream().filter(playerx -> playerx.hasPermission("redelite.cmd.staffchat")).forEach(playerx -> {
            playerx.sendMessage(TextComponent.fromLegacyText("§d§l[STAFF] §7[" + playerx.getServer().getInfo().getName() + "§7] " + Role.getPrefixed(player.getName()) + "§f: " + StringUtils.formatColors(msg)));
        });
    }
}

