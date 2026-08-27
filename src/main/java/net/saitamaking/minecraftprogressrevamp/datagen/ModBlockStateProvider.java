package net.saitamaking.minecraftprogressrevamp.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProgressRevamp.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModBlocks.);
        blockWithItem(ModBlocks.CHARCOALBLOCK);
        primitiveCraftingTableBlock(ModBlocks.PRIMITIVECRAFTINGTABLE, "primitive_crafting_table");
        blockWithItem(ModBlocks.FIRECLAY);
        rudimentaryCraftingTableBlock(ModBlocks.RUDIMENTARYCRAFTINGTABLE, "rudimentary_crafting_table");
        steelCutterBlock(ModBlocks.STEELCUTTER, "steel_cutter");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void primitiveCraftingTableBlock(DeferredBlock<?> deferredBlock, String name) {
        Block block = deferredBlock.get();

        ModelFile model = models().cube(name,
                mcLoc("minecraft:block/oak_log_top"), // down
                modLoc("block/" + name + "_top"),    // up
                modLoc("block/" + name + "_front"),  // north
                modLoc("block/" + name + "_front"),   // south
                modLoc("block/" + name + "_side"),   // east
                modLoc("block/" + name + "_side")    // west
        ).texture("particle", modLoc("block/" + name + "_side"));

        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void rudimentaryCraftingTableBlock(DeferredBlock<?> deferredBlock, String name) {
        Block block = deferredBlock.get();

        ModelFile model = models().cube(name,
                mcLoc("minecraft:block/stripped_oak_log_top"), // down
                modLoc("block/" + name + "_top"),    // up
                modLoc("block/" + name + "_front"),  // north
                modLoc("block/" + name + "_side"),   // south
                modLoc("block/" + name + "_back"),   // east
                modLoc("block/" + name + "_side")    // west
        ).texture("particle", modLoc("block/" + name + "_side"));

        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void steelCutterBlock(DeferredBlock<?> deferredBlock, String name) {
        Block block = deferredBlock.get();

        BlockModelBuilder model = models().getBuilder(name)
                .parent(models().getExistingFile(mcLoc("block/block")))
                .texture("particle", modLoc("block/" + name + "_bottom"))
                .texture("bottom", modLoc("block/" + name + "_bottom"))
                .texture("top", modLoc("block/" + name + "_top"))
                .texture("side", modLoc("block/" + name + "_side"))
                .texture("saw", modLoc("block/" + name + "_saw"));

        // base cuboid (0,0,0) -> (16,9,16)
        model.element()
                .from(0, 0, 0)
                .to(16, 9, 16)
                .face(Direction.DOWN).uvs(0, 0, 16, 16).texture("#bottom").cullface(Direction.DOWN).end()
                .face(Direction.UP).uvs(0, 0, 16, 16).texture("#top").end()
                .face(Direction.NORTH).uvs(0, 7, 16, 16).texture("#side").cullface(Direction.NORTH).end()
                .face(Direction.SOUTH).uvs(0, 7, 16, 16).texture("#side").cullface(Direction.SOUTH).end()
                .face(Direction.WEST).uvs(0, 7, 16, 16).texture("#side").cullface(Direction.WEST).end()
                .face(Direction.EAST).uvs(0, 7, 16, 16).texture("#side").cullface(Direction.EAST).end()
                .end();

        // saw blade (1,9,8) -> (15,16,8)
        model.element()
                .from(1, 9, 8)
                .to(15, 16, 8)
                .face(Direction.NORTH).uvs(1, 9, 15, 16).texture("#saw").tintindex(0).end()
                .face(Direction.SOUTH).uvs(15, 9, 1, 16).texture("#saw").tintindex(0).end()
                .end();

        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }
}
