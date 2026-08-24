package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.item.custom.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProgressRevamp.MODID);

    public static final DeferredItem<Item> LOOSEPEBBLE = ITEMS.register("loose_pebble",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHARPPEBBLE = ITEMS.register("sharp_pebble",
            () -> new SharpRockItem(new Item.Properties().durability(16).stacksTo(1)));

    public static final DeferredItem<Item> PRIMITIVEAXE = ITEMS.register("primitive_axe",
            () -> new PrimitiveAxeItem(new Item.Properties().durability(32).stacksTo(1)));

    public static final DeferredItem<Item> PRIMITIVEPICKAXE = ITEMS.register("primitive_pickaxe",
            () -> new Item(new Item.Properties().durability(32).stacksTo(1)));

    public static final DeferredItem<Item> PRIMITIVEHAMMER = ITEMS.register("primitive_hammer",
            () -> new PrimitiveHammerItem(new Item.Properties().durability(32).stacksTo(1)));

    public static final DeferredItem<Item> PRIMITIVESHEARS = ITEMS.register("primitive_shears",
            () -> new ShearsItem((new Item.Properties()).durability(32).component(DataComponents.TOOL, ShearsItem.createToolProperties())));

    public static final DeferredItem<Item> PRIMITIVESAW = ITEMS.register("primitive_saw",
            () -> new PrimitiveSawItem(new Item.Properties().durability(32).stacksTo(1)));

    public static final DeferredItem<Item> WOODENHANDLE = ITEMS.register("wooden_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIRECLAY = ITEMS.register("fireclay",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COALPOWDER = ITEMS.register("coal_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNREFINEDCRUCIBLE = ITEMS.register("unrefined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REFINEDCRUCIBLE = ITEMS.register("refined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STARTERTOOLBOX = ITEMS.register("starter_toolbox",
            () -> new StarterToolboxItem(new Item.Properties().durability(96).stacksTo(1).component(DataComponents.TOOL, StarterToolboxItem.createToolProperties())));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
