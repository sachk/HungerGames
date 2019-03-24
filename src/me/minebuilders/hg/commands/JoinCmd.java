package me.minebuilders.hg.commands;

import me.minebuilders.hg.Game;
import me.minebuilders.hg.HG;
import me.minebuilders.hg.Util;

public class JoinCmd extends BaseCmd {

	public JoinCmd() {
		forcePlayer = true;
		cmdName = "join";
		forceInGame = false;
		argLength = 2;
		usage = "<arena-name>";
	}

	@Override
	public boolean run() {

		if (HG.plugin.players.containsKey(player.getUniqueId())) {
			Util.scm(player, HG.lang.cmd_join_in_game);
		} else {
			Game g = HG.manager.getGame(args[1]);
			if (g != null && !g.getPlayers().contains(player.getUniqueId())) {
				g.join(player);
			} else {
				Util.scm(player, HG.lang.cmd_delete_noexist);
			}
		}
		return true;
	}
}