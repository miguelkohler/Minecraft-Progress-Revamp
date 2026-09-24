package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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
                        output.accept(ModBlocks.PEBBLE);
                        output.accept(ModItems.LOOSEPEBBLE);
                        output.accept(ModItems.SHARPPEBBLE);
                        output.accept(ModItems.PRIMITIVEAXE);
                        output.accept(ModBlocks.PRIMITIVECRAFTINGTABLE);
                        output.accept(ModBlocks.RUDIMENTARYCRAFTINGTABLE);
                        output.accept(ModBlocks.COBBLESTONEANVIL);
                        output.accept(ModItems.PRIMITIVEPICKAXE);
                        output.accept(ModItems.PRIMITIVEHAMMER);
                        output.accept(ModItems.PRIMITIVESHEARS);
                        output.accept(ModItems.PRIMITIVESAW);
                        output.accept(ModItems.PRIMITIVEKNIFE);
                        output.accept(ModItems.STRAW);
                        output.accept(ModItems.STRAWSTRING);
                        output.accept(ModItems.STARTERTOOLBOX);
                        output.accept(ModItems.WOODENHANDLE);
                        output.accept(ModItems.TREEBARK);
                        output.accept(ModItems.ANIMALHIDE);
                        output.accept(ModItems.HIDEVEST);
                        output.accept(ModItems.HIDESHORTS);
                        output.accept(ModItems.HIDEBOOTS);
                        output.accept(ModItems.SCRAPEDANIMALHIDE);
                        output.accept(ModItems.UNFIREDCLAYBUCKET);
                        output.accept(ModItems.CERAMICBUCKET);
                        output.accept(ModItems.WATER_CERAMICBUCKET);
                        output.accept(ModItems.COALPOWDER);
                        output.accept(ModItems.FIRECLAYBALL);
                        output.accept(ModBlocks.FIRECLAY);
                        output.accept(ModItems.UNREFINEDCRUCIBLE);
                        output.accept(ModItems.REFINEDCRUCIBLE);
                        output.accept(ModBlocks.CAMPFIREWITHCRUCIBLE);
                        output.accept(ModItems.EMPTYSANDMOLD);
                        output.accept(ModItems.INGOTSANDMOLD);
                        output.accept(ModItems.NAILSANDMOLD);
                        output.accept(ModItems.SALT);
                        output.accept(ModItems.SALTEDBEEF);
                        output.accept(ModItems.SALTEDCOOKEDBEEF);
                        output.accept(ModBlocks.CHARCOALBLOCK);
                        output.accept(ModBlocks.WOODENCRATE);


                    }).build());

    public static final Supplier<CreativeModeTab> COPPER_AGE_ITEMS_TAB = CREATIVE_MODE_TAB.register("copper_age_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.COPPER_INGOT))
                    .title(Component.translatable("creativetab.minecraftprogressrevamp.copper_age_items"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ProgressRevamp.MODID, "primitive_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MELTEDCOPPERBLOB);
                        output.accept(ModItems.SMALLMELTEDCOPPERBLOB);
                        output.accept(ModBlocks.MELTEDCOPPERBLOCK);
                        output.accept(ModItems.COPPERNAIL);
                        output.accept(Items.COPPER_INGOT);
                        output.accept(ModBlocks.COPPERBARBLOCK);
                        output.accept(ModItems.MELTEDGOLDBLOB);
                        output.accept(ModItems.SMALLMELTEDGOLDBLOB);
                        output.accept(ModBlocks.MELTEDGOLDBLOCK);
                        output.accept(ModBlocks.GOLDBARBLOCK);
                        output.accept(Blocks.COPPER_BLOCK);

                        output.accept(ModBlocks.STEELCUTTER);


                    }).build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }
}
