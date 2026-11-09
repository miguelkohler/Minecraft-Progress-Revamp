package net.saitamaking.minecraftprogressrevamp.screen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.block.entity.RudimentaryCraftingTableEntity;
import net.saitamaking.minecraftprogressrevamp.screen.custom.*;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, ProgressRevamp.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<WoodenCrateMenu>> WOODEN_CRATE_MENU =
            registerMenuType("wooden_crate_menu", WoodenCrateMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<CopperCrateMenu>> COPPER_CRATE_MENU =
            registerMenuType("copper_crate_menu", CopperCrateMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ReinforcedBarrelMenu>> REINFORCED_BARREL_MENU =
            registerMenuType("reinforced_barrel_menu", ReinforcedBarrelMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<CampfireWithCrucibleMenu>> CAMPFIRE_WITH_CRUCIBLE_MENU =
            registerMenuType("campfire_with_crucible_menu", CampfireWithCrucibleMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<PrimitiveCraftingTableMenu>> PRIMITIVE_CRAFTING_TABLE_MENU =
            registerMenuType("primitive_crafting_table_menu", PrimitiveCraftingTableMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<RudimentaryCraftingTableMenu>> RUDIMENTARY_CRAFTING_TABLE_MENU =
            registerMenuType("rudimentary_crafting_table_menu", RudimentaryCraftingTableMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<IntermediateCraftingTableMenu>> INTERMEDIATE_CRAFTING_TABLE_MENU =
            registerMenuType("intermediate_crafting_table_menu", IntermediateCraftingTableMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<CobblestoneAnvilMenu>> COBBLESTONE_ANVIL_MENU =
            registerMenuType("cobblestone_anvil_menu", CobblestoneAnvilMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<SmallBoxMenu>> SMALL_BOX_MENU =
            registerMenuType("small_box_menu", SmallBoxMenu::new);

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                              IContainerFactory<T> factory){
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
