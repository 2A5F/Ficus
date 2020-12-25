package co.volight.glacier.ficus.mixin;

import co.volight.glacier.ficus.entities.car.HoverCar;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerInject {

    @Shadow private ClientWorld world;

    @Inject(method = "onEntitySpawn(Lnet/minecraft/network/packet/s2c/play/EntitySpawnS2CPacket;)V", at = @At("TAIL"))
    void onEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo ci) {
        EntityType<?> entityType = packet.getEntityTypeId();
        double d = packet.getX();
        double e = packet.getY();
        double f = packet.getZ();
        Entity entity15 = null;
        if (entityType == HoverCar.Red.INSTANCE.getType()) {
            entity15 = HoverCar.Red.INSTANCE.build(this.world, d, e, f);
        }

        if (entity15 != null) {
            int i = packet.getId();
            entity15.updateTrackedPosition(d, e, f);
            entity15.refreshPositionAfterTeleport(d, e, f);
            entity15.pitch = (float)(packet.getPitch() * 360) / 256.0F;
            entity15.yaw = (float)(packet.getYaw() * 360) / 256.0F;
            entity15.setEntityId(i);
            entity15.setUuid(packet.getUuid());
            this.world.addEntity(i, entity15);
        }
    }
}
