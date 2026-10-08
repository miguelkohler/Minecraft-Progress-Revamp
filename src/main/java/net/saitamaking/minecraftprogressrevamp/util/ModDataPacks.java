package net.saitamaking.minecraftprogressrevamp.util;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;

import java.nio.file.Path;
import java.util.Optional;

@EventBusSubscriber(modid = ProgressRevamp.MODID)
public class ModDataPacks {

    @SubscribeEvent
    public static void addPacks(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.SERVER_DATA) return;

        Path path = ModList.get().getModFileById("minecraftprogressrevamp")
                .getFile().findResource("resourcepacks/overrides");

        Pack pack = Pack.readMetaAndCreate(
                new PackLocationInfo("minecraftprogressrevamp:overrides",
                        Component.literal("Progress Revamp Overrides"),
                        PackSource.BUILT_IN, Optional.empty()),
                new PathPackResources.PathResourcesSupplier(path),
                PackType.SERVER_DATA,
                new PackSelectionConfig(true, Pack.Position.TOP, false));

        event.addRepositorySource(consumer -> consumer.accept(pack));
    }
}
