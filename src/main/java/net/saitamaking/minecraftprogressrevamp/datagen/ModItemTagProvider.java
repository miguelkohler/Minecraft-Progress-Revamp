package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ProgressRevamp.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.LOOSE_PEBBLES)
                .add(ModItems.LOOSEPEBBLE.get());
        tag(ModTags.Items.PRIMITIVE_TOOLS)
                .add(ModItems.SHARPPEBBLE.get())
                .add(ModItems.PRIMITIVEAXE.get())
                .add(ModItems.PRIMITIVEHAMMER.get())
                .add(ModItems.PRIMITIVESAW.get())
                .add(ModItems.PRIMITIVEPICKAXE.get())
                .add(ModItems.STARTERTOOLBOX.get())
                .add(ModItems.PRIMITIVEKNIFE.get())
                .add(ModItems.CERAMICBUCKET.get())
                .add(ModItems.WATER_CERAMICBUCKET.get())
                .add(ModItems.PRIMITIVESHEARS.get());
        tag(ItemTags.AXES)
                .add(
                        ModItems.PRIMITIVEAXE.get(),
                        ModItems.COPPERAXE.get(),
                        ModItems.PRIMITIVESAW.get(),
                        ModItems.STARTERTOOLBOX.get(),
                        ModItems.INTERMEDIATETOOLBOX.get(),
                        ModItems.COPPERSAW.get()
                );
        tag(ItemTags.PICKAXES)
                .add(
                        ModItems.COPPERPICKAXE.get(),
                        ModItems.PRIMITIVEPICKAXE.get()
                );
        tag(ModTags.Items.SAWS)
                .add(
                        ModItems.PRIMITIVESAW.get(),
                        ModItems.STARTERTOOLBOX.get(),
                        ModItems.INTERMEDIATETOOLBOX.get(),
                        ModItems.COPPERSAW.get()
                );
        tag(ModTags.Items.HAMMERS)
                .add(
                        ModItems.PRIMITIVEHAMMER.get(),
                        ModItems.STARTERTOOLBOX.get(),
                        ModItems.INTERMEDIATETOOLBOX.get(),
                        ModItems.COPPERHAMMER.get()
                );
        tag(ModTags.Items.KNIVES)
                .add(
                        ModItems.PRIMITIVEKNIFE.get(),
                        ModItems.COPPERKNIFE.get()
                );

        tag(ModTags.Items.SHEARS)
                .add(
                        ModItems.PRIMITIVESHEARS.get(),
                        ModItems.STARTERTOOLBOX.get(),
                        ModItems.INTERMEDIATETOOLBOX.get(),
                        Items.SHEARS,
                        ModItems.COPPERSHEARS.get()
                );
        tag(ModTags.Items.CHISELS)
                .add(
                        ModItems.INTERMEDIATETOOLBOX.get(),
                        ModItems.COPPERCHISEL.get()
                );
        tag(ModTags.Items.WATERCONTAINERS)
                .add(Items.WATER_BUCKET)
                .add(ModItems.WATER_CERAMICBUCKET.get());
        tag(ModTags.Items.FIRESTARTERS)
                .add(Items.FLINT_AND_STEEL)
                .add(ModItems.FIRESTARTER.get());
        tag(ModTags.Items.SANDMOLDS)
                .add(ModItems.EMPTYSANDMOLD.get())
                .add(ModItems.NAILSANDMOLD.get())
                .add(ModItems.NUGGETSANDMOLD.get())
                .add(ModItems.INGOTSANDMOLD.get());
        tag(ModTags.Items.GOLDMOLDS)
                .add(ModItems.EMPTYGOLDMOLD.get())
                .add(ModItems.NAILGOLDMOLD.get())
                .add(ModItems.NUGGETGOLDMOLD.get())
                .add(ModItems.INGOTGOLDMOLD.get());
        tag(ModTags.Items.INGOTSHAPED)
                .add(Items.BRICK)
                .add(Items.NETHER_BRICK)
                .add(Items.COPPER_INGOT)
                .add(Items.IRON_INGOT)
                .add(Items.GOLD_INGOT)
                .add(
                        ModItems.ROSEGOLDINGOT.get()
                )
                .add(Items.NETHERITE_INGOT);
        tag(ModTags.Items.NUGGETSHAPED)
                .add(
                        ModItems.COPPERNUGGET.get(),
                        ModItems.ROSEGOLDNUGGET.get()
                )
                .add(Items.IRON_NUGGET)
                .add(Items.GOLD_NUGGET);
        tag(ModTags.Items.NAILSHAPED)
                .add(ModItems.COPPERNAIL.get())
                .add(ModItems.IRONNAIL.get());
        tag(ModTags.Items.COALBLOCKS)
                .add(Items.COAL_BLOCK)
                .add(ModBlocks.CHARCOALBLOCK.asItem());
        tag(ModTags.Items.IRONBLOCKMELTABLES)
                .add(Items.IRON_BLOCK)
                .add(Items.RAW_IRON_BLOCK)
                .add(ModBlocks.IRONBARBLOCK.asItem());
        tag(ModTags.Items.COPPERBLOCKMELTABLES)
                .add(Items.COPPER_BLOCK)
                .add(Items.RAW_COPPER_BLOCK)
                .add(ModBlocks.COPPERBARBLOCK.asItem());
        tag(ModTags.Items.GOLDBLOCKMELTABLES)
                .add(Items.GOLD_BLOCK)
                .add(Items.RAW_GOLD_BLOCK)
                .add(ModBlocks.GOLDBARBLOCK.asItem());
        tag(ModTags.Items.SMALLCOPPERBLOBMELTABLES)
                .add(ModItems.COPPERNUGGET.get());
        tag(ModTags.Items.SMALLGOLDBLOBMELTABLES)
                .add(Items.GOLD_NUGGET);
        tag(ModTags.Items.SMALLROSEGOLDBLOBMELTABLES)
                .add(ModItems.ROSEGOLDNUGGET.get());
        tag(ModTags.Items.SMALLIRONBLOBMELTABLES)
                .add(Items.IRON_NUGGET);
        tag(ModTags.Items.STONESLABCRAFTINGMATERIAL)
                .add(
                        Items.COBBLESTONE_SLAB,
                        Items.BLACKSTONE_SLAB,
                        Items.COBBLED_DEEPSLATE_SLAB
                );
        tag(ModTags.Items.COPPERBLOBMELTABLES)
                .add(Items.RAW_COPPER)
                .add(Items.COPPER_INGOT)
                .add(Items.DEEPSLATE_COPPER_ORE)
                .add(Items.COPPER_ORE);
        tag(ModTags.Items.GOLDBLOBMELTABLES)
                .add(Items.RAW_GOLD)
                .add(Items.GOLD_INGOT)
                .add(Items.DEEPSLATE_GOLD_ORE)
                .add(Items.NETHER_GOLD_ORE)
                .add(Items.GOLD_ORE);
        tag(ModTags.Items.IRONBLOBMELTABLES)
                .add(Items.RAW_IRON)
                .add(Items.IRON_INGOT)
                .add(Items.DEEPSLATE_IRON_ORE)
                .add(Items.IRON_ORE);
        tag(ModTags.Items.ROSEGOLDBLOBMELTABLES)
                .add(ModItems.ROSEGOLDINGOT.get());
        tag(ModTags.Items.COPPERPLATES)
                .add(ModItems.COPPERPLATE.get());
        tag(ModTags.Items.GOLDPLATES)
                .add(ModItems.GOLDPLATE.get());
        tag(ModTags.Items.IRONPLATES)
                .add(ModItems.IRONPLATE.get());
        tag(ModTags.Items.ALLTHEWOODITEM)
                .addTag(ItemTags.ACACIA_LOGS)
                .addTag(ItemTags.BIRCH_LOGS)
                .addTag(ItemTags.SPRUCE_LOGS)
                .addTag(ItemTags.DARK_OAK_LOGS)
                .addTag(ItemTags.MANGROVE_LOGS)
                .addTag(ItemTags.CHERRY_LOGS)
                .addTag(ItemTags.JUNGLE_LOGS)
                .addTag(ItemTags.WARPED_STEMS)
                .addTag(ItemTags.CRIMSON_STEMS)
                .addTag(ItemTags.OAK_LOGS);

        tag(ModTags.Items.COPPERARMOR)
                .add(
                        ModItems.COPPERHELMET.get(),
                        ModItems.COPPERCHESTPLATE.get(),
                        ModItems.COPPERLEGGINGS.get(),
                        ModItems.COPPERBOOTS.get()
                );

        tag(ModTags.Items.COPPERTOOLS)
                .add(
                        ModItems.COPPERHOE.get(),
                        ModItems.COPPERSHOVEL.get(),
                        ModItems.COPPERSWORD.get(),
                        ModItems.COPPERPICKAXE.get(),
                        ModItems.COPPERHAMMER.get(),
                        ModItems.COPPERKNIFE.get(),
                        ModItems.COPPERSAW.get(),
                        ModItems.COPPERCHISEL.get(),
                        ModItems.COPPERSHEARS.get(),
                        ModItems.COPPERAXE.get()
                );

        tag(ModTags.Items.COPPERTOOLPARTS)
                .add(
                        ModItems.COPPERHOEHEAD.get(),
                        ModItems.COPPERSHOVELHEAD.get(),
                        ModItems.COPPERSWORDHEAD.get(),
                        ModItems.COPPERPICKAXEHEAD.get(),
                        ModItems.COPPERCROSSGUARD.get(),
                        ModItems.COPPERHAMMERHEAD.get(),
                        ModItems.COPPERCHISELBLADE.get(),
                        ModItems.COPPERSMALLBLADE.get(),
                        ModItems.COPPERSAWBLADE.get(),
                        ModItems.COPPERAXEHEAD.get()
                );

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPERHELMET.get())
                .add(ModItems.COPPERCHESTPLATE.get())
                .add(ModItems.COPPERLEGGINGS.get())
                .add(ModItems.COPPERBOOTS.get())
                .add(ModItems.HIDEVEST.get())
                .add(ModItems.HIDEBOOTS.get())
                .add(ModItems.HIDESHORTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ROSEGOLDINGOT.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.CRANIUMSMITHINGTEMPLATE.get());
    }
}
