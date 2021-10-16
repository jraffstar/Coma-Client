package tech.jjjen.coma.client.command.commands;

import tech.jjjen.coma.api.util.MessageUtil;
import tech.jjjen.coma.client.command.Command;
import tech.jjjen.coma.client.command.CommandManifest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.tutorial.TutorialSteps;

@CommandManifest(label = "Tutorial", aliases = {"tut"})
public class TutorialCommand extends Command {

    @Override
    public void execute(String[] args) {
        Minecraft.getMinecraft().gameSettings.tutorialStep = TutorialSteps.NONE;
        Minecraft.getMinecraft().getTutorial().setStep(TutorialSteps.NONE);
        MessageUtil.sendClientMessage("Set tutorial step to none!", -11114);
    }

}
