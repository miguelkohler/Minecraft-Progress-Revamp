package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
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

    public static final DeferredItem<PrimitiveKnifeItem> PRIMITIVEKNIFE = ITEMS.register("primitive_knife",
            () -> new PrimitiveKnifeItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(PrimitiveSawItem.createAttributes(ModToolTiers.PRIMAL, 1.0F, -1.0F))));

    public static final DeferredItem<Item> WOODENHANDLE = ITEMS.register("wooden_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STRAW = ITEMS.register("straw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STRAWSTRING = ITEMS.register("straw_string",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EMPTYSANDMOLD = ITEMS.register("empty_sand_mold",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> INGOTSANDMOLD = ITEMS.register("ingot_sand_mold",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> NAILSANDMOLD = ITEMS.register("nail_sand_mold",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> TREEBARK = ITEMS.register("tree_bark",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANIMALHIDE = ITEMS.register("animal_hide",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCRAPEDANIMALHIDE = ITEMS.register("scraped_animal_hide",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNFIREDCLAYBUCKET = ITEMS.register("unfired_clay_bucket",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<CeramicBucketItem> CERAMICBUCKET = ITEMS.register("ceramic_bucket",
            () -> new CeramicBucketItem(Fluids.EMPTY, (new Item.Properties()).stacksTo(16)));

    public static final DeferredItem<CeramicBucketItem> WATER_CERAMICBUCKET = ITEMS.register("water_ceramic_bucket",
            () -> new CeramicBucketItem(Fluids.WATER, (new Item.Properties()).craftRemainder(CERAMICBUCKET.get()).stacksTo(1)));

    public static final DeferredItem<Item> FIRECLAYBALL = ITEMS.register("fireclay_ball",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COALPOWDER = ITEMS.register("coal_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNREFINEDCRUCIBLE = ITEMS.register("unrefined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REFINEDCRUCIBLE = ITEMS.register("refined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MELTEDCOPPERBLOB = ITEMS.register("melted_copper_blob",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALLMELTEDCOPPERBLOB = ITEMS.register("small_melted_copper_blob",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERNAIL = ITEMS.register("copper_nail",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<StarterToolboxItem> STARTERTOOLBOX = ITEMS.register("starter_toolbox",
            () -> new StarterToolboxItem(new Item.Properties().durability(96).stacksTo(1).component(DataComponents.TOOL, StarterToolboxItem.createToolProperties())));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALT)));

    public static final DeferredItem<Item> SALTEDBEEF = ITEMS.register("salted_beef",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALTEDBEEF)));

    public static final DeferredItem<Item> SALTEDCOOKEDBEEF = ITEMS.register("salted_cooked_beef",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALTEDCOOKEDBEEF)));

    public static final DeferredItem<ArmorItem> HIDEVEST = ITEMS.register("hide_chestplate",
            () -> new ArmorItem(ModArmorMaterials.PRIMITIVE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(3))));

    public static final DeferredItem<ArmorItem> HIDESHORTS = ITEMS.register("hide_leggings",
            () -> new ArmorItem(ModArmorMaterials.PRIMITIVE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(3))));

    public static final DeferredItem<ArmorItem> HIDEBOOTS = ITEMS.register("hide_boots",
            () -> new ArmorItem(ModArmorMaterials.PRIMITIVE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(3))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
