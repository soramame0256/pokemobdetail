package com.github.soramame0256.pokemobdetail;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = PokeMobDetail.MOD_ID,
        name = PokeMobDetail.MOD_NAME,
        version = PokeMobDetail.VERSION
)
public class PokeMobDetail {

    public static final String MOD_ID = "pokemobdetail";
    public static final String MOD_NAME = "PokeMobDetail";
    public static final String VERSION = "1.0.1";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static PokeMobDetail INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventListener());
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
    public static String clearColor(String text){
        return text.replace("§a","")
                .replace("§b","")
                .replace("§c","")
                .replace("§d","")
                .replace("§e","")
                .replace("§f","")
                .replace("§o","")
                .replace("§m","")
                .replace("§n","")
                .replace("§r","")
                .replace("§l","")
                .replace("§k","")
                .replace("§0","")
                .replace("§1","")
                .replace("§2","")
                .replace("§3","")
                .replace("§4","")
                .replace("§5","")
                .replace("§6","")
                .replace("§7","")
                .replace("§8","")
                .replace("§9","");
    }
}
