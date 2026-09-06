package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;
import net.saitamaking.minecraftprogressrevamp.item.custom.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProgressRevamp.MODID);

    //base attributes to remember when adding tools: base attack damage= 0.5, base attack speed = 4

    public static final DeferredItem<Item> LOOSEPEBBLE = ITEMS.register("loose_pebble",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SharpRockItem> SHARPPEBBLE = ITEMS.register("sharp_pebble",
            () -> new SharpRockItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(SharpRockItem.createAttributes(ModToolTiers.PRIMAL, 2, -2.0F))));

    public static final DeferredItem<PrimitiveAxeItem> PRIMITIVEAXE = ITEMS.register("primitive_axe",
            () -> new PrimitiveAxeItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(PrimitiveAxeItem.createAttributes(ModToolTiers.PRIMAL, 3.0F, -2.0F))));

    public static final DeferredItem<PickaxeItem> PRIMITIVEPICKAXE = ITEMS.register("primitive_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.PRIMAL, 1.0F, -2.8F))));

    public static final DeferredItem<PrimitiveHammerItem> PRIMITIVEHAMMER = ITEMS.register("primitive_hammer",
            () -> new PrimitiveHammerItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(PrimitiveHammerItem.createAttributes(ModToolTiers.PRIMAL, 9.5F, -3.6F))));

    public static final DeferredItem<ShearsItem> PRIMITIVESHEARS = ITEMS.register("primitive_shears",
            () -> new ShearsItem((new Item.Properties()).durability(32).component(DataComponents.TOOL, ShearsItem.createToolProperties())));

    public static final DeferredItem<PrimitiveSawItem> PRIMITIVESAW = ITEMS.register("primitive_saw",
            () -> new PrimitiveSawItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(PrimitiveSawItem.createAttributes(ModToolTiers.PRIMAL, 0.5F, 2.4F))));

    public static final DeferredItem<Item> WOODENHANDLE = ITEMS.register("wooden_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIRECLAYBALL = ITEMS.register("fireclay_ball",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COALPOWDER = ITEMS.register("coal_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNREFINEDCRUCIBLE = ITEMS.register("unrefined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REFINEDCRUCIBLE = ITEMS.register("refined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<StarterToolboxItem> STARTERTOOLBOX = ITEMS.register("starter_toolbox",
            () -> new StarterToolboxItem(new Item.Properties().durability(96).stacksTo(1).component(DataComponents.TOOL, StarterToolboxItem.createToolProperties())));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALT)));

    public static final DeferredItem<Item> SALTEDBEEF = ITEMS.register("salted_beef",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALTEDBEEF)));

    public static final DeferredItem<Item> SALTEDCOOKEDBEEF = ITEMS.register("salted_cooked_beef",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALTEDCOOKEDBEEF)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
