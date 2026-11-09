package net.saitamaking.minecraftprogressrevamp.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.custom.*;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ProgressRevamp.MODID);

    public static final DeferredBlock<Block> PRIMITIVECRAFTINGTABLE = registerBlock("primitive_crafting_table",
            () -> new PrimitiveCraftingTableBlock(BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> RUDIMENTARYCRAFTINGTABLE = registerBlock("rudimentary_crafting_table",
            () -> new RudimentaryCraftingTableBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> INTERMEDIATECRAFTINGTABLE = registerBlock("intermediate_crafting_table",
            () -> new IntermediateCraftingTableBlock(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.WOOD)));

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

    public static final DeferredBlock<MeltedMetalBlock> MELTEDGOLDBLOCK = registerBlock("melted_gold_block",
            () -> new MeltedMetalBlock(GOLD_BLOCK, BlockBehaviour.Properties.of().strength(2.0F, 4.0F).sound(SoundType.FROGLIGHT)));

    public static final DeferredBlock<MeltedMetalBlock> MELTEDIRONBLOCK = registerBlock("melted_iron_block",
            () -> new MeltedMetalBlock(IRON_BLOCK, BlockBehaviour.Properties.of().strength(2.0F, 5.0F).sound(SoundType.FROGLIGHT)));

    public static final DeferredBlock<Block> COPPERBARBLOCK = registerBlock("copper_bar_block",
            () -> new FourDirectionalBlock(BlockBehaviour.Properties.of().strength(2.5F, 5.0F).sound(SoundType.COPPER).noOcclusion()));

    public static final DeferredBlock<Block> GOLDBARBLOCK = registerBlock("gold_bar_block",
            () -> new FourDirectionalBlock(BlockBehaviour.Properties.of().strength(3.5F, 5.0F).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> IRONBARBLOCK = registerBlock("iron_bar_block",
            () -> new FourDirectionalBlock(BlockBehaviour.Properties.of().strength(3.5F, 5.0F).sound(SoundType.METAL).noOcclusion()));

    public static final DeferredBlock<Block> WOODENCRATE = registerBlock("wooden_crate",
            () -> new WoodenCrateBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).noOcclusion().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> COPPERCRATE = registerBlock("copper_crate",
            () -> new CopperCrateBlock(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().sound(SoundType.COPPER)));

    public static final DeferredBlock<Block> SMALLOAKBOX = registerBlock("small_oak_box",
            () -> new SmallBoxBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).noOcclusion().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> CAMPFIREWITHCRUCIBLE = registerBlock("campfire_with_crucible",
            () -> new CampfireWithCrucibleBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).lightLevel(state -> 15).noOcclusion().ignitedByLava()));

    public static final DeferredBlock<Block> COBBLESTONEANVIL = registerBlock("cobblestone_anvil",
            () -> new CobblestoneAnvilBlock(BlockBehaviour.Properties.of().strength(2.0F, 5.0F).sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<Block> BELLOW = registerBlock("bellow",
            () -> new BellowBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).noOcclusion().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> REINFORCEDBARREL = registerBlock("reinforced_barrel",
            () -> new ReinforcedBarrelBlock(BlockBehaviour.Properties.of().strength(3.5F, 12.0F).sound(SoundType.METAL).noOcclusion()));

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

