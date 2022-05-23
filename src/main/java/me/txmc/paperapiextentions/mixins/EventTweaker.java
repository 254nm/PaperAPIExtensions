package me.txmc.paperapiextentions.mixins;

import me.txmc.paperapiextentions.events.ItemStackCreateEvent;
import me.txmc.rtmixin.CallbackInfo;
import me.txmc.rtmixin.mixin.At;
import me.txmc.rtmixin.mixin.Inject;
import me.txmc.rtmixin.mixin.MethodInfo;
import net.minecraft.server.v1_12_R1.Item;
import net.minecraft.server.v1_12_R1.ItemStack;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Bukkit;

/**
 * @author 254n_m
 * @since 5/22/22/ 3:14 PM
 * This file was created as a part of PaperAPIExtensions
 */
public class EventTweaker {
    @Inject(
            info = @MethodInfo(_class = ItemStack.class, name = "<init>", sig = NBTTagCompound.class, rtype = void.class),
            at = @At(pos = At.Position.TAIL)
    )
    public static void mixinItemStackNBTConstructor(CallbackInfo ci) {
        ItemStack itemStack = (ItemStack) ci.getSelf();
        ItemStackCreateEvent event = new ItemStackCreateEvent(itemStack, ItemStackCreateEvent.Reason.NBT);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            itemStack.setCount(-1);
        }
    }

    @Inject(
            info = @MethodInfo(_class = ItemStack.class, name = "<init>", sig = {Item.class, int.class, int.class, boolean.class}, rtype = ItemStack.class),
            at = @At(pos = At.Position.TAIL)
    )
    public static void mixinItemStackDefaultConstructor(CallbackInfo ci) {
        ItemStack itemStack = (ItemStack) ci.getSelf();
        if (itemStack.getItem() == Item.getById(0)) return;
        ItemStackCreateEvent event = new ItemStackCreateEvent(itemStack, ItemStackCreateEvent.Reason.DEFAULT);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) {
            itemStack.setCount(-1);
        }
    }
}
