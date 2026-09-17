package net.saitamaking.minecraftprogressrevamp;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.saitamaking.minecraftprogressrevamp.block.ModBlocks;
import net.saitamaking.minecraftprogressrevamp.block.entity.ModBlockEntities;
import net.saitamaking.minecraftprogressrevamp.component.ModDataComponents;
import net.saitamaking.minecraftprogressrevamp.item.ModCreativeModeTabs;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;
import net.saitamaking.minecraftprogressrevamp.item.crafting.ModRecipeSerializers;
import net.saitamaking.minecraftprogressrevamp.loot.ModLootModifiers;
import net.saitamaking.minecraftprogressrevamp.screen.ModMenuTypes;
import net.saitamaking.minecraftprogressrevamp.screen.custom.WoodenCrateScreen;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ProgressRevamp.MODID)
public class ProgressRevamp {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "minecraftprogressrevamp";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ProgressRevamp(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.

        ModCreativeModeTabs.register(modEventBus);

        ModDataComponents.register(modEventBus);

        ModRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //if(event.getTabKey() == CreativeModeTabs.)
        //bruh
    }

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

        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.WOODEN_CRATE_MENU.get(), WoodenCrateScreen::new);
        }
    }
}
