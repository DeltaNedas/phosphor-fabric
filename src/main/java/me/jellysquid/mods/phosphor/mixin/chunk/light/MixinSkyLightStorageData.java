package me.jellysquid.mods.phosphor.mixin.chunk.light;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import me.jellysquid.mods.phosphor.common.chunk.ExtendedSkyLightStorageData;
import net.minecraft.world.chunk.light.SkyLightStorage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SkyLightStorage.Data.class)
public class MixinSkyLightStorageData implements ExtendedSkyLightStorageData {
    @Shadow
    private int defaultTopArraySectionY;

    @Shadow
    @Final
    private Long2IntOpenHashMap topArraySectionY;

    @Override
    public int bridge$defaultHeight() {
        return this.defaultTopArraySectionY;
    }

    @Override
    public Long2IntOpenHashMap bridge$heightMap() {
        return this.topArraySectionY;
    }
}
