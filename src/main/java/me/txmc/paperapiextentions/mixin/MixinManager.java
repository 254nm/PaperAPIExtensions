package me.txmc.paperapiextentions.mixin;

import me.txmc.paperapiextentions.mixin.mixins.MixinEntityTracker;
import me.txmc.paperapiextentions.mixin.mixins.MixinItemStack;
import me.txmc.paperapiextentions.mixin.mixins.MixinTileEntity;
import me.txmc.rtmixin.RtMixin;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftVehicle;

/**
 * @author 254n_m
 * @since 5/27/22/ 12:54 AM
 * This file was created as a part of PaperAPIExtensions
 */
public class MixinManager {
    public void init() {
        RtMixin.attachAgent();
        RtMixin.processMixins(MixinTileEntity.class);
        RtMixin.processMixins(MixinItemStack.class);
        RtMixin.processMixins(MixinEntityTracker.class);
    }
}
