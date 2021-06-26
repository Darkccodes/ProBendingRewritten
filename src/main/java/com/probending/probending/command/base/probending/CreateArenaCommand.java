package com.probending.probending.command.base.probending;

import com.probending.probending.ProBending;
import com.probending.probending.command.abstractclasses.BaseSubCommand;
import com.probending.probending.command.abstractclasses.Command;
import com.probending.probending.core.annotations.Language;
import com.probending.probending.core.arena.Arena;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CreateArenaCommand extends BaseSubCommand {

    @Language("Command.ProBending.CreateArena.Description")
    public static String LANG_DESCRIPTION = "Creates a new Arena";


    @Override
    public void execute(CommandSender sender, List<String> args) {
        if (hasPermission(sender)) {
            if (isPlayer(sender)) {
                if (correctLength(sender, args.size(), 1, 1)) {
                    Player player = (Player) sender;
                    String name = args.get(0);
                    if (name.length() < 12 && !name.contains(" ") && !name.contains(".") && name.length() > 3) {
                        Arena arena = new Arena(ProBending.arenaM, name);
                        arena.setCenter(player.getLocation());
                        ProBending.arenaM.registerArena(arena);
                        sender.sendMessage(Command.LANG_SUCCESS);
                    } else {
                        sender.sendMessage(Command.LANG_FAIL);
                    }
                }
            }
        }
    }

    @Override
    public List<String> autoComplete(CommandSender sender, List<String> args) {
        return new ArrayList<>();
    }

    @Override
    protected String name() {
        return "createarena";
    }

    @Override
    protected String usage() {
        return "createarena <name>";
    }

    @Override
    protected String description() {
        return LANG_DESCRIPTION;
    }

    @Override
    protected List<String> aliases() {
        return new ArrayList<>();
    }
}
