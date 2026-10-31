package net.saitamaking.minecraftprogressrevamp.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ProgressRevamp.MODID);

    public static final Supplier<BlockEntityType<WoodenCrateEntity>> WOODENCRATE_BE =
            BLOCK_ENTITIES.register("wooden_crate_be", () -> BlockEntityType.Builder.of(
                    WoodenCrateEntity::new, ModBlocks.WOODENCRATE.get()).build(null));

    public static final Supplier<BlockEntityType<CampfireWithCrucibleEntity>> CAMPFIREWITHCRUCIBLE_BE =
            BLOCK_ENTITIES.register("campfire_with_crucible_be", () -> BlockEntityType.Builder.of(
                    CampfireWithCrucibleEntity::new, ModBlocks.CAMPFIREWITHCRUCIBLE.get()).build(null));

    public static final Supplier<BlockEntityType<PrimitiveCraftingTableEntity>> PRIMITIVECRAFTINGTABLE_BE =
            BLOCK_ENTITIES.register("primitive_crafting_table_be", () -> BlockEntityType.Builder.of(
                    PrimitiveCraftingTableEntity::new, ModBlocks.PRIMITIVECRAFTINGTABLE.get()).build(null));

    public static final Supplier<BlockEntityType<RudimentaryCraftingTableEntity>> RUDIMENTARYCRAFTINGTABLE_BE =
            BLOCK_ENTITIES.register("rudimentary_crafting_table_be", () -> BlockEntityType.Builder.of(
                    RudimentaryCraftingTableEntity::new, ModBlocks.RUDIMENTARYCRAFTINGTABLE.get()).build(null));

    public static final Supplier<BlockEntityType<IntermediateCraftingTableEntity>> INTERMEDIATECRAFTINGTABLE_BE =
            BLOCK_ENTITIES.register("intermediate_crafting_table_be", () -> BlockEntityType.Builder.of(
                    IntermediateCraftingTableEntity::new, ModBlocks.INTERMEDIATECRAFTINGTABLE.get()).build(null));

    public static final Supplier<BlockEntityType<CobblestoneAnvilEntity>> COBBLESTONEANVIL_BE =
            BLOCK_ENTITIES.register("cobblestone_anvil_be", () -> BlockEntityType.Builder.of(
                    CobblestoneAnvilEntity::new, ModBlocks.COBBLESTONEANVIL.get()).build(null));

    public static final Supplier<BlockEntityType<SmallBoxEntity>> SMALLBOX_BE =
            BLOCK_ENTITIES.register("small_box_be", () -> BlockEntityType.Builder.of(
                    SmallBoxEntity::new, ModBlocks.SMALLOAKBOX.get()).build(null));

    public static final Supplier<BlockEntityType<BellowEntity>> BELLOW_BE =
            BLOCK_ENTITIES.register("bellow_be", () -> BlockEntityType.Builder.of(
                    BellowEntity::new, ModBlocks.BELLOW.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
