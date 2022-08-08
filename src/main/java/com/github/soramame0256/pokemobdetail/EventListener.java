package com.github.soramame0256.pokemobdetail;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

import static com.github.soramame0256.pokemobdetail.PokeMobDetail.clearColor;

public class EventListener {
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent e){
        ItemStack is = e.getItemStack();
        List<String> newLore = new ArrayList<>();
        if(Minecraft.getMinecraft().player == null) return;
        ScoreObjective so = Minecraft.getMinecraft().player.getWorldScoreboard().getObjectiveInDisplaySlot(1);
        if(so == null) return;
        if(!clearColor(so.getDisplayName()).contains("ポケットモブ")) return;
        if(is.getTagCompound() != null){
            for (String s : e.getToolTip()) {
                if (is.getTagCompound().hasKey("mobtype") && clearColor(s).contains(is.getTagCompound().getString("mobtype"))){

                    if(is.getTagCompound().hasKey("level")) {
                        if(e.getFlags() == ITooltipFlag.TooltipFlags.ADVANCED){
                            newLore.add(s.replace(" (#0383)", " [Lv." + is.getTagCompound().getInteger("level") + (is.getTagCompound().hasKey("exp") ? ":exp." + is.getTagCompound().getInteger("exp") : "") + "] (#0383)"));
                        }else {
                            newLore.add(s.concat(" [Lv." + is.getTagCompound().getInteger("level")) + (is.getTagCompound().hasKey("exp") ? ":exp." + is.getTagCompound().getInteger("exp") : "") + "]");
                        }
                    }else newLore.add(s);
                } else if(s.contains("ATK:")) {
                    if(is.getTagCompound().hasKey("atk")) newLore.add(s.concat(" (" + is.getTagCompound().getInteger("atk")) + ")");
                    else newLore.add(s);
                } else if(s.contains("DEF:")){
                    if(is.getTagCompound().hasKey("def")) newLore.add(s.concat(" (" + is.getTagCompound().getInteger("def")) + ")");
                    else newLore.add(s);
                } else if(s.contains("VIT:")){
                    if(is.getTagCompound().hasKey("vit")) newLore.add(s.concat(" (" + is.getTagCompound().getInteger("vit")) + ")");
                    else newLore.add(s);
                } else {
                    newLore.add(s);
                }
            }
            e.getToolTip().clear();
            e.getToolTip().addAll(newLore);
        }

    }
}
