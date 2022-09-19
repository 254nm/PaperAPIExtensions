package me.txmc.paperapiextensions.mixin.mixins;

import me.txmc.paperapiextensions.events.TileEntityCreateEvent;
import me.txmc.rtmixin.CallbackInfo;
import net.minecraft.server.v1_12_R1.*;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;

/**
 * @author 254n_m
 * @since 5/22/22/ 3:14 PM
 * This file was created as a part of PaperAPIExtensions
 */
public class MixinTileEntity {
    private static RegistryMaterials<MinecraftKey, Class<? extends TileEntity>> registryMaterials;
    private static Logger logger;

    static {
        try {
            Field fF = TileEntity.class.getDeclaredField("f");
            fF.setAccessible(true);
            registryMaterials = (RegistryMaterials<MinecraftKey, Class<? extends TileEntity>>) fF.get(null);
            Field loggerF = TileEntity.class.getDeclaredField("a");
            loggerF.setAccessible(true);
            logger = (Logger) loggerF.get(null);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

//    @Replace(info = @MethodInfo(_class = TileEntity.class, name = "create", sig = {World.class, NBTTagCompound.class}, rtype = TileEntity.class))
    public static TileEntity onTileEntityCreate(CallbackInfo ci) {
        World world = (World) ci.getParameters()[0];
        NBTTagCompound compound = (NBTTagCompound) ci.getParameters()[1];
        String id = compound.getString("id");
        try {
            Class<? extends TileEntity> teClass = registryMaterials.get(new MinecraftKey(id));
            if (teClass == null) throw new NullPointerException();
            TileEntityCreateEvent event = new TileEntityCreateEvent(world, compound, teClass);
            Bukkit.getPluginManager().callEvent(event);
            checkXYZ(compound, event.getCompound());
            TileEntity tileEntity = teClass.newInstance();
            tileEntity.a(world);
            tileEntity.load(event.getCompound());
            return tileEntity;
        } catch (Throwable t) {
            if (t instanceof NullPointerException) {
                logger.warn("Skipping BlockEntity with id {}", id);
            }
        }
        return null;
    }
    private static void checkXYZ(NBTTagCompound original, NBTTagCompound evtCompound) {
        if (evtCompound != original) {
            if (evtCompound.getInt("x") != original.getInt("x"))
                evtCompound.setInt("x", original.getInt("x"));
            if (evtCompound.getInt("y") != original.getInt("y"))
                evtCompound.setInt("y", original.getInt("y"));
            if (evtCompound.getInt("z") != original.getInt("z"))
                evtCompound.setInt("z", original.getInt("z"));
        }
    }
}
