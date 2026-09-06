package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProgressRevamp.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //basicItem(ModItems.get());
        basicItem(ModItems.COALPOWDER.get());
        basicItem(ModItems.LOOSEPEBBLE.get());
        basicItem(ModItems.FIRECLAYBALL.get());
        handheldItem(ModItems.PRIMITIVEAXE.get());
        handheldItem(ModItems.PRIMITIVEHAMMER.get());
        handheldItem(ModItems.PRIMITIVEPICKAXE.get());
        handheldItem(ModItems.PRIMITIVESAW.get());
        handheldItem(ModItems.PRIMITIVESHEARS.get());
        handheldItem(ModItems.REFINEDCRUCIBLE.get());
        basicItem(ModItems.SALT.get());
        basicItem(ModItems.SALTEDBEEF.get());
        basicItem(ModItems.SALTEDCOOKEDBEEF.get());
        basicItem(ModItems.SHARPPEBBLE.get());
        handheldItem(ModItems.STARTERTOOLBOX.get());
        basicItem(ModItems.UNREFINEDCRUCIBLE.get());
        basicItem(ModItems.WOODENHANDLE.get());
    }
}
