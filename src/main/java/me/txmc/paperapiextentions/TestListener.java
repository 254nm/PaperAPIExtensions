package me.txmc.paperapiextentions;

import me.txmc.paperapiextentions.events.TileEntityCreateEvent;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author 254n_m
 * @since 5/25/22/ 12:34 AM
 * This file was created as a part of PaperAPIExtensions
 */
public class TestListener implements Listener {

    @EventHandler
    public void onTileEntityCreate(TileEntityCreateEvent event) {
//        NBTTagCompound compound = event.getCompound();
//        System.out.println("A tile entity was created ----------------------");
//        System.out.println(compound);
//        System.out.println(event.getType());
//        System.out.println(event.getWorld());
//        System.out.println("----------------------");
//        event.setCompound(new NBTTagCompound());
    }

}
