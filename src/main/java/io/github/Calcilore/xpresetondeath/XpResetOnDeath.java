package io.github.Calcilore.xpresetondeath;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = XpResetOnDeath.MODID, name = XpResetOnDeath.NAME, version = XpResetOnDeath.VERSION)
public class XpResetOnDeath
{
    public static final String MODID = "noxp";
    public static final String NAME = "XP Reset On Death";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Initializing");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void playerDied(PlayerEvent.PlayerRespawnEvent e) {
        if (e.isEndConquered()) return;

        logger.info("Resetting XP!");
        e.player.addExperienceLevel(-100000);
    }
}
