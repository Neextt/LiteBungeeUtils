package net.lxsthw.redelite.bungee.commands.bungee;

import net.lxsthw.redelite.bungee.commands.Commands;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import tk.slicecollections.maxteer.player.role.Role;
import tk.slicecollections.maxteer.utils.StringUtils;

import static tk.slicecollections.maxteer.bungee.Bungee.baianice;

public class TellCommand extends Commands {

    public TellCommand() {
        super("tell", "mensagem");
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(TextComponent.fromLegacyText("§cApenas jogadores podem utilizar este comando."));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (args.length < 2) {
            player.sendMessage(TextComponent.fromLegacyText("§cUtilize /tell [jogador] [mensagem] para enviar uma mensagem privada a um jogador."));
            return;
        }
        ProxiedPlayer tKL = BungeeCord.getInstance().getPlayer(args[0]);
        if (player == tKL) {
            player.sendMessage(TextComponent.fromLegacyText("§cVocê não pode mandar mensagens privadas para sí mesmo."));
            return;
        }
        String msg = StringUtils.join(args, 1, " ");
        if (player.hasPermission("lite.tell.color")) {
            msg = StringUtils.formatColors(msg);
        }
        if (tKL == null || !tKL.isConnected()) {
            player.sendMessage(TextComponent.fromLegacyText("§cO usuário foi não encontrado."));
            return;
        }
        baianice.put(tKL, player);
        baianice.put(player, tKL);

        tKL.sendMessage(TextComponent.fromLegacyText("§8Mensagem de "
                + Role.getPrefixed(player.getName()) + "§8: §6" + msg));
        player.sendMessage(TextComponent.fromLegacyText("§8Mensagem para "
                + Role.getPrefixed(tKL.getName()) + "§8: §6" + msg));
    }
}

