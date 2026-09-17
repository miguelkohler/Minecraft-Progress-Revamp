package net.saitamaking.minecraftprogressrevamp.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.custom.*;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.COPPER_BLOCK;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ProgressRevamp.MODID);

    public static final DeferredBlock<Block> PRIMITIVECRAFTINGTABLE = registerBlock("primitive_crafting_table",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> RUDIMENTARYCRAFTINGTABLE = registerBlock("rudimentary_crafting_table",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> STEELCUTTER = registerBlock("steel_cutter",
            () -> new SteelCutterBlock(BlockBehaviour.Properties.of().strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> CHARCOALBLOCK = registerBlock("charcoal_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> FIRECLAY = registerBlock("fireclay",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.6F).sound(SoundType.GRAVEL)));

    public static final DeferredBlock<Block> PEBBLE = registerBlock("pebble",
            () -> new PebbleBlock(BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.STONE)));

    public static final DeferredBlock<MeltedMetalBlock> MELTEDCOPPERBLOCK = registerBlock("melted_copper_block",
            () -> new MeltedMetalBlock(COPPER_BLOCK, BlockBehaviour.Properties.of().strength(2.0F, 4.0F).sound(SoundType.FROGLIGHT)));

    public static final DeferredBlock<Block> COPPERBARBLOCK = registerBlock("copper_bar_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.5F, 5.0F).sound(SoundType.COPPER).noOcclusion()));

    public static final DeferredBlock<Block> WOODENCRATE = registerBlock("wooden_crate",
            () -> new WoodenCrateBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

