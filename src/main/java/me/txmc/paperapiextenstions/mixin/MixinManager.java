package me.txmc.paperapiextenstions.mixin;

import me.txmc.paperapiextenstions.mixin.mixins.MixinItemStack;
import me.txmc.rtmixin.RtMixin;
import net.minecraft.server.v1_12_R1.ChunkProviderServer;

/**
 * @author 254n_m
 * @since 5/27/22/ 12:54 AM
 * This file was created as a part of PaperAPIExtensions
 */
public class MixinManager {
    public void init() {
        RtMixin.attachAgent();
        RtMixin.processMixins(MixinItemStack.class);
    }
}
