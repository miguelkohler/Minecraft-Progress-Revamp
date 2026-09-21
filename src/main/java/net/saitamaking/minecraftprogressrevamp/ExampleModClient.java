package net.saitamaking.minecraftprogressrevamp;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.saitamaking.minecraftprogressrevamp.screen.ModMenuTypes;
import net.saitamaking.minecraftprogressrevamp.screen.custom.CampfireWithCrucibleScreen;
import net.saitamaking.minecraftprogressrevamp.screen.custom.WoodenCrateScreen;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = ProgressRevamp.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = ProgressRevamp.MODID, value = Dist.CLIENT)
public class ExampleModClient {
    public ExampleModClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        ProgressRevamp.LOGGER.info("HELLO FROM CLIENT SETUP");
        ProgressRevamp.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.WOODEN_CRATE_MENU.get(), WoodenCrateScreen::new);
        event.register(ModMenuTypes.CAMPFIRE_WITH_CRUCIBLE_MENU.get(), CampfireWithCrucibleScreen::new);
    }
}
