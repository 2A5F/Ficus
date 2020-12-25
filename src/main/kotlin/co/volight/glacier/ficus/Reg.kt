package co.volight.glacier.ficus

import co.volight.glacier.ficus.itemgroups.mainGroup
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.block.Block
import net.minecraft.client.particle.Particle
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.world.ClientWorld
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleType
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.stat.StatFormatter
import net.minecraft.stat.Stats
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

interface RegName {
    val name: String
}

interface Reg: RegName {
    fun reg()
}

interface SelfReg<T>: Reg {
    val impl: T
}

interface BlockReg<T : Block> : SelfReg<T> {
    override fun reg() {
        Registry.register(Registry.BLOCK, Identifier(Ficus.id, name), impl)
    }
}

interface ItemReg<T : Item> : SelfReg<T> {
    override fun reg() {
        Registry.register(Registry.ITEM, Identifier(Ficus.id, name), impl)
    }
}

interface JoinItemGroup {
    fun joinItemGroup(settings: Item.Settings) {
        settings.group(mainGroup)
    }
}

interface BlockRegWithItem<T> : BlockReg<T> where T : Block, T: JoinItemGroup {
    fun makeBlockItem(block: T): BlockItem {
        return BlockItem(block, Item.Settings().also(block::joinItemGroup))
    }

    fun regBlockItem() {
        Registry.register(Registry.ITEM, Identifier(Ficus.id, name), makeBlockItem(impl))
    }
}

fun regStat(name: String, statFormatter: StatFormatter = StatFormatter.DEFAULT): Identifier {
    return Identifier(Ficus.id, name).also {
        Registry.register(Registry.CUSTOM_STAT, it, it)
        Stats.CUSTOM.getOrCreateStat(it, statFormatter)
    }
}

fun <T : ScreenHandler> regScreenHandler(name: String, factory: ScreenHandlerRegistry.SimpleClientHandlerFactory<T>): ScreenHandlerType<T> {
    return ScreenHandlerRegistry.registerSimple(Identifier(Ficus.id, name), factory)
}

interface ParticleReg<T : ParticleEffect>: RegName {
    val type: ParticleType<T>

    @Environment(EnvType.CLIENT)
    fun createParticle(
        parameters: T, world: ClientWorld, x: Double, y: Double, z: Double, vx: Double, vy: Double, vz: Double
    ): Particle

    fun regType() {
        Registry.register(Registry.PARTICLE_TYPE, Identifier(Ficus.id, name), type)
    }
    @Environment(EnvType.CLIENT)
    fun regFactory() {
        ParticleFactoryRegistry.getInstance().register(type, this::createParticle)
    }
}

interface RegEntity<T : Entity> : RegName {
    val type: EntityType<T>

    fun regType() {
        Registry.register(Registry.ENTITY_TYPE, Identifier(Ficus.id, name), type)
    }

    @Environment(EnvType.CLIENT)
    fun render(dispatcher: EntityRenderDispatcher, context: EntityRendererRegistry.Context): EntityRenderer<T>

    @Environment(EnvType.CLIENT)
    fun regRender() {
        EntityRendererRegistry.INSTANCE.register(type, ::render)
    }
}
