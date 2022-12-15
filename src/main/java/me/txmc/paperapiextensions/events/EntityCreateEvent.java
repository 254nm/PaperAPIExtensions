package me.txmc.paperapiextensions.events;

import lombok.RequiredArgsConstructor;
import net.minecraft.server.v1_12_R1.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author 254n_m
 * @since 2022/12/10 3:53 PM
 * This file was created as a part of PaperAPIExtensions
 *
 * This event is called when the NMS Entity constructor is called because bukkit's EntitySpawnEvent is dogshit
 */
@RequiredArgsConstructor
public class EntityCreateEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Entity entity;
    private boolean cancel;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
