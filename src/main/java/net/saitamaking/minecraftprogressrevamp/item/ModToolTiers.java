package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.saitamaking.minecraftprogressrevamp.util.ModTags;

public class ModToolTiers {
    public static final Tier PRIMAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_PRIMAL_TOOL,
            32, 1.5F, -0.5F, 10, () -> Ingredient.of(ModItems.SHARPPEBBLE));

    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            191, 5.0F, 1.0F, 13, () -> Ingredient.of(Items.COPPER_INGOT));
}
