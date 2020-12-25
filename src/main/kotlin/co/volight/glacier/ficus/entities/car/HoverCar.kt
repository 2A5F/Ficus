package co.volight.glacier.ficus.entities.car

import co.volight.glacier.ficus.Ficus
import co.volight.glacier.ficus.RegEntity
import com.google.common.collect.ImmutableList
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.model.CompositeEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.client.util.math.Vector3f
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.util.Identifier
import net.minecraft.world.World

enum class HoverCarColor {
    Red
}

class HoverCar : AHoverCar {
    val color: HoverCarColor

    constructor(entityType: EntityType<out HoverCar>, world: World, color: HoverCarColor) : super(entityType, world,
        10f, 1f,
        10f, 1f,
        10f, 1f,
        10f, 1f) {
        this.color = color
    }

    constructor(entityType: EntityType<out HoverCar>, world: World, x: Double, y: Double, z: Double, color: HoverCarColor) : super(entityType, world, x, y, z,
        10f, 1f,
        10f, 1f,
        10f, 1f,
        10f, 1f) {
        this.color = color
    }

    object Red : RegHoverCar {
        override val name = "red_hover_car"
        override val type: EntityType<HoverCar> by lazy { buildType() }
        override val color = HoverCarColor.Red
    }

}

interface RegHoverCar : RegEntity<HoverCar> {
    val color: HoverCarColor

    fun buildType(): EntityType<HoverCar> {
        return FabricEntityTypeBuilder.create<HoverCar>(SpawnGroup.MISC) { t, w ->
            HoverCar(t, w, color)
        } .dimensions(EntityDimensions.fixed(3f, 2f)).build()
    }

    @Environment(EnvType.CLIENT)
    override fun render(dispatcher: EntityRenderDispatcher, context: EntityRendererRegistry.Context): EntityRenderer<HoverCar> {
        return HoverCarRenderer(dispatcher)
    }

    fun build(world: World, x: Double, y: Double, z: Double): HoverCar {
        return HoverCar(HoverCar.Red.type, world, x, y, z, color)
    }
}

@Environment(EnvType.CLIENT)
class HoverCarRenderer(dispatcher: EntityRenderDispatcher): EntityRenderer<HoverCar>(dispatcher) {
    private val textures = mapOf(
        HoverCarColor.Red to Identifier(Ficus.id, "textures/entity/hover_car/red.png"),
    )

    init {
        shadowRadius = 2.5f
    }

    val model = HoverCarModel()

    override fun getTexture(car: HoverCar): Identifier {
        return textures[car.color]!!
    }

    override fun render(
        entity: HoverCar,
        yaw: Float,
        tickDelta: Float,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int
    ) {
        matrices.push()

        matrices.translate(0.0, 0.375, 0.0)
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F - yaw))

        matrices.scale(-1.0F, -1.0F, 1.0F)
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90.0F))
        model.setAngles(entity, tickDelta, 0.0F, -0.1F, 0.0F, 0.0F)
        val vertex: VertexConsumer =
            vertexConsumers.getBuffer(model.getLayer(this.getTexture(entity)))
        model.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F)

        matrices.pop()
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light)
    }
}

@Environment(EnvType.CLIENT)
class HoverCarModel : CompositeEntityModel<HoverCar>() {
    init {
        textureWidth = 256
        textureHeight = 128

    }

    private val parts: ImmutableList<ModelPart>

    init {
        val partMain = ModelPart(this)
        partMain.setPivot(0f, 24f, 0f)
        partMain.setTextureOffset(0, 0)
            .addCuboid(-21f, -16f, -40f, 42f, 16f, 80f, 0f, false)

        val builder = ImmutableList.builder<ModelPart>()
        builder.add(partMain)
        parts = builder.build()
    }

    override fun setAngles(
        entity: HoverCar?,
        limbAngle: Float,
        limbDistance: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {

    }

    override fun getParts(): MutableIterable<ModelPart> {
        return parts
    }

}