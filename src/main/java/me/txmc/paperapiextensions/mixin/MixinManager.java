package me.txmc.paperapiextensions.mixin;

import me.txmc.paperapiextensions.mixin.mixins.MixinEntity;
import me.txmc.paperapiextensions.mixin.mixins.MixinItemStack;
import me.txmc.rtmixin.RtMixin;

/**
 * @author 254n_m
 * @since 5/27/22/ 12:54 AM
 * This file was created as a part of PaperAPIExtensions
 */
public class MixinManager {
    public void init() {
        RtMixin.attachAgent();
        RtMixin.processMixins(MixinItemStack.class);
        RtMixin.processMixins(MixinEntity.class);
    }
}
