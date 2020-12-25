package co.volight.glacier.ficus.entities.car

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.Packet
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
import net.minecraft.world.World

abstract class AHoverCar(
    entityType: EntityType<out AHoverCar>, world: World,
    val moveSpeed: Float, val moveAcc: Float,
    val brakeSpeed: Float, val brakeAcc: Float,
    val climbSpeed: Float, val climbAcc: Float,
    val fallSpeed: Float, val fallAcc: Float,
) : Entity(entityType, world)
{

    init {
        stepHeight = 2.0f
        inanimate = true
    }

    override fun isCollidable(): Boolean {
        return true
    }

    override fun initDataTracker() {

    }

    override fun readCustomDataFromTag(tag: CompoundTag) {

    }

    override fun writeCustomDataToTag(tag: CompoundTag?) {

    }

    override fun createSpawnPacket(): Packet<*> {
        return EntitySpawnS2CPacket(this)
    }

}