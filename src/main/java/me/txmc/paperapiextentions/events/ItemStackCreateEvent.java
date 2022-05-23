package me.txmc.paperapiextentions.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.server.v1_12_R1.ItemStack;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author 254n_m
 * @since 5/14/22/ 7:14 PM
 * This file was created as a part of PaperAPIExtensions
 */

@RequiredArgsConstructor
public class ItemStackCreateEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Getter private final ItemStack itemStack;
    @Getter private final Reason reason;

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

    public enum Reason { DEFAULT, NBT }
}
