package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProgressRevamp.MODID);

    public static final Supplier<CreativeModeTab> PRIMAL_ITEMS_TAB = CREATIVE_MODE_TAB.register("primitive_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PRIMITIVEAXE.get()))
                    .title(Component.translatable("creativetab.minecraftprogressrevamp.primitive_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LOOSEPEBBLE);
                        output.accept(ModItems.SHARPPEBBLE);
                        output.accept(ModItems.PRIMITIVEAXE);
                        output.accept(ModBlocks.PRIMITIVECRAFTINGTABLE);
                    }).build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }
}
