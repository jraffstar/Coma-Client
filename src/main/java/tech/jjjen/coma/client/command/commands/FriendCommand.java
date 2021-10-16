package tech.jjjen.Main.client.command.commands;

import tech.jjjen.coma.Main;
import tech.jjjen.coma.client.command.Command;
import tech.jjjen.coma.client.command.CommandManifest;

@CommandManifest(label = "Friend", aliases = {"friends", "friend, f"})
public class FriendCommand extends Command {

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            return;
        }

        try {
            String name = args[2];
            switch (args[1].toUpperCase()) {
                case ("ADD"):
                    Main.INSTANCE.getFriendManager().addFriend(name);
                    break;
                case ("DEL"):
                    Main.INSTANCE.getFriendManager().removeFriend(name);
                    break;
                case ("DELETE"):
                    Main.INSTANCE.getFriendManager().removeFriend(name);
                    break;
                case ("CLEAR"):
                    Main.INSTANCE.getFriendManager().clearFriends();
                    break;
                case ("INSIDE"):
                    Main.INSTANCE.getFriendManager().clearFriends();
                    break;
            }
        } catch (Exception e) {
        }
    }

}
