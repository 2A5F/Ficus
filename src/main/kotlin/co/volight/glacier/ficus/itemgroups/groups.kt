package co.volight.glacier.ficus.itemgroups

import co.volight.glacier.ficus.Ficus
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

val mainGroup = FabricItemGroupBuilder.build(Identifier(Ficus.id, "main")) { ItemStack(Blocks.GRASS) }