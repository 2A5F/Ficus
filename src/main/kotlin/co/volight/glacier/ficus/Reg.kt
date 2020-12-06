package co.volight.glacier.ficus

import co.volight.glacier.ficus.itemgroups.mainGroup
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.stat.StatFormatter
import net.minecraft.stat.Stats
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


interface Reg<T> {
    val name: String
    val impl: T
    fun reg(): T
}

interface BlockReg<T : Block> : Reg<T> {
    override fun reg(): T {
        return impl.also { Registry.register(Registry.BLOCK, Identifier(Ficus.id, name), it) }
    }
}

interface ItemReg<T : Item> : Reg<T> {
    override fun reg(): T {
        return impl.also { Registry.register(Registry.ITEM, Identifier(Ficus.id, name), it) }
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