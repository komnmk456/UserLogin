package com.elcholostudios.userlogin.commands.subs;

import com.elcholostudios.userlogin.UserLogin;
import com.elcholostudios.userlogin.util.lists.Path;
import com.elcholostudios.userlogin.util.command.SubCommand;
import com.elcholostudios.userlogin.util.Utils;
import org.bukkit.command.CommandSender;

public class Reload extends SubCommand {

    private final Utils utils = new Utils();

    public Reload() {
        super("reload", false);
    }

    @Override
    public boolean run(CommandSender sender, String[] args) {
        if(args.length > 0) return false;

        if(utils.sqlMode())
            UserLogin.sql.saveData();

        UserLogin.pluginSetup();

        utils.sendMessage(Path.RELOAD, sender);
        return true;
    }
}
