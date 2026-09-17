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

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
