package co.volight.glacier.ficus.entities

import co.volight.glacier.ficus.Ficus
import co.volight.glacier.ficus.RegEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.util.Identifier
import net.minecraft.world.World


class Cube(entityType: EntityType<out Cube>, world: World): PathAwareEntity(entityType, world) {
    companion object: RegEntity<Cube> {
        override val name: String = "cube"
        override val type: EntityType<Cube> by lazy {
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ::Cube)
                .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
                .build()
        }

        override fun render(dispatcher: EntityRenderDispatcher, context: EntityRendererRegistry.Context): EntityRenderer<Cube> {
            return CubeRenderer(dispatcher)
        }

    }
}

class CubeRenderer(dispatcher: EntityRenderDispatcher) : MobEntityRenderer<Cube, CubeModel>(dispatcher, CubeModel(), 0.5f) {
    override fun getTexture(entity: Cube?): Identifier {
        return Identifier(Ficus.id, "textures/entity/cube/cube.png")
    }

}

class CubeModel : EntityModel<Cube>() {
    private val base: ModelPart = ModelPart(this, 0, 0)
    init {
        base.addCuboid(-6f, -6f, -6f, 12f, 12f, 12f)
        textureHeight = 64
        textureWidth = 64
    }

    override fun render(matrices: MatrixStack, vertices: VertexConsumer, light: Int, overlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        matrices.translate(0.0, 1.125, 0.0);
        base.render(matrices, vertices, light, overlay);
    }

    override fun setAngles(entity: Cube?, limbAngle: Float, limbDistance: Float, animationProgress: Float, headYaw: Float, headPitch: Float) {

    }

}