package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
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
            () -> new PrimitiveKnifeItem(ModToolTiers.PRIMAL, new Item.Properties().attributes(PrimitiveSawItem.createAttributes(ModToolTiers.PRIMAL, 1.0F, -1.6F))));

    public static final DeferredItem<AxeItem> COPPERAXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 7.0F, -3.2F))));

    public static final DeferredItem<PickaxeItem> COPPERPICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 0.5F, -2.8F))));

    public static final DeferredItem<HoeItem> COPPERHOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -1.0F, -2.0F))));

    public static final DeferredItem<ShovelItem> COPPERSHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.5F, -3.0F))));

    public static final DeferredItem<SwordItem> COPPERSWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3.0F, -2.4F))));

    public static final DeferredItem<PrimitiveKnifeItem> COPPERKNIFE = ITEMS.register("copper_knife",
            () -> new PrimitiveKnifeItem(ModToolTiers.COPPER, new Item.Properties().attributes(PrimitiveKnifeItem.createAttributes(ModToolTiers.COPPER, 1.0F, -1.6F))));

    public static final DeferredItem<PrimitiveHammerItem> COPPERHAMMER = ITEMS.register("copper_hammer",
            () -> new PrimitiveHammerItem(ModToolTiers.COPPER, new Item.Properties().attributes(PrimitiveHammerItem.createAttributes(ModToolTiers.COPPER, 10.0F, -3.6F))));

    public static final DeferredItem<PrimitiveSawItem> COPPERSAW = ITEMS.register("copper_saw",
            () -> new PrimitiveSawItem(ModToolTiers.COPPER, new Item.Properties().attributes(PrimitiveSawItem.createAttributes(ModToolTiers.COPPER, -0.5F, 2.4F))));

    public static final DeferredItem<ChiselItem> COPPERCHISEL = ITEMS.register("copper_chisel",
            () -> new ChiselItem(ModToolTiers.COPPER, new Item.Properties().attributes(PrimitiveSawItem.createAttributes(ModToolTiers.COPPER, -1.0F, -1.8F))));

    public static final DeferredItem<ShearsItem> COPPERSHEARS = ITEMS.register("copper_shears",
            () -> new ShearsItem((new Item.Properties()).durability(191).component(DataComponents.TOOL, ShearsItem.createToolProperties())));

    public static final DeferredItem<Item> LEATHERSTICK = ITEMS.register("leather_stick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WOODENHANDLE = ITEMS.register("wooden_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MELTEDCOPPERPLATE = ITEMS.register("melted_copper_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CLAYBRICK = ITEMS.register("clay_brick",
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

    public static final DeferredItem<MagnifyingGlassItem> MAGNIFYINGGLASS = ITEMS.register("magnifying_glass",
            () -> new MagnifyingGlassItem(new Item.Properties()));

    public static final DeferredItem<Item> FIRECLAYBALL = ITEMS.register("fireclay_ball",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COALPOWDER = ITEMS.register("coal_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNREFINEDCRUCIBLE = ITEMS.register("unrefined_crucible",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> REFINEDCRUCIBLE = ITEMS.register("refined_crucible",
            () -> new RefinedCrucibleItem(new Item.Properties().stacksTo(8)));

    public static final DeferredItem<Item> MELTEDCOPPERBLOB = ITEMS.register("melted_copper_blob",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALLMELTEDCOPPERBLOB = ITEMS.register("small_melted_copper_blob",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MELTEDGOLDBLOB = ITEMS.register("melted_gold_blob",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SMALLMELTEDGOLDBLOB = ITEMS.register("small_melted_gold_blob",
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

    public static final DeferredItem<ArmorItem> COPPERHELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11))));

    public static final DeferredItem<ArmorItem> COPPERCHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(11))));

    public static final DeferredItem<ArmorItem> COPPERLEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(11))));

    public static final DeferredItem<ArmorItem> COPPERBOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(11))));

    public static final DeferredItem<Item> COPPERHELMETHOT = ITEMS.register("copper_helmet_hot",
            () -> new TransformItem("water_cauldron", COPPERHELMET, new Item.Properties()));

    public static final DeferredItem<Item> COPPERCHESTPLATEHOT = ITEMS.register("copper_chestplate_hot",
            () -> new TransformItem("water_cauldron", COPPERCHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> COPPERLEGGINGSHOT = ITEMS.register("copper_leggings_hot",
            () -> new TransformItem("water_cauldron", COPPERLEGGINGS, new Item.Properties()));

    public static final DeferredItem<Item> COPPERBOOTSHOT = ITEMS.register("copper_boots_hot",
            () -> new TransformItem("water_cauldron", COPPERBOOTS, new Item.Properties()));

    public static final DeferredItem<Item> COPPERAXEHEAD = ITEMS.register("copper_axe_head",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERSHOVELHEAD = ITEMS.register("copper_shovel_head",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERPICKAXEHEAD = ITEMS.register("copper_pickaxe_head",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERHOEHEAD = ITEMS.register("copper_hoe_head",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERCROSSGUARD = ITEMS.register("copper_cross_guard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERSWORDHEAD = ITEMS.register("copper_sword_head",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERHAMMERHEAD = ITEMS.register("copper_hammer_head",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERSMALLBLADE = ITEMS.register("copper_small_blade",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERSAWBLADE = ITEMS.register("copper_saw_blade",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERCHISELBLADE = ITEMS.register("copper_chisel_blade",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COPPERSWORDHEADDULL = ITEMS.register("copper_sword_head_dull",
            () -> new TransformItem("grindstone",ModItems.COPPERSWORDHEAD,new Item.Properties()));

    public static final DeferredItem<Item> COPPERAXEHEADDULL = ITEMS.register("copper_axe_head_dull",
            () -> new TransformItem("grindstone",ModItems.COPPERAXEHEAD,new Item.Properties()));

    public static final DeferredItem<Item> COPPERSMALLBLADEDULL = ITEMS.register("copper_small_blade_dull",
            () -> new TransformItem("grindstone",ModItems.COPPERSMALLBLADE,new Item.Properties()));

    public static final DeferredItem<Item> COPPERCHISELBLADEDULL = ITEMS.register("copper_chisel_blade_dull",
            () -> new TransformItem("grindstone",ModItems.COPPERCHISELBLADE,new Item.Properties()));

    public static final DeferredItem<Item> COPPERAXEHEADHOT = ITEMS.register("copper_axe_head_hot",
            () -> new TransformItem("water_cauldron", COPPERAXEHEADDULL, new Item.Properties()));

    public static final DeferredItem<Item> COPPERSHOVELHEADHOT = ITEMS.register("copper_shovel_head_hot",
            () -> new TransformItem("water_cauldron", COPPERSHOVELHEAD, new Item.Properties()));

    public static final DeferredItem<Item> COPPERPICKAXEHEADHOT = ITEMS.register("copper_pickaxe_head_hot",
            () -> new TransformItem("water_cauldron", COPPERPICKAXEHEAD, new Item.Properties()));

    public static final DeferredItem<Item> COPPERHOEHEADHOT = ITEMS.register("copper_hoe_head_hot",
            () -> new TransformItem("water_cauldron", COPPERHOEHEAD, new Item.Properties()));

    public static final DeferredItem<Item> COPPERCROSSGUARDHOT = ITEMS.register("copper_cross_guard_hot",
            () -> new TransformItem("water_cauldron", COPPERCROSSGUARD, new Item.Properties()));

    public static final DeferredItem<Item> COPPERSWORDHEADHOT = ITEMS.register("copper_sword_head_hot",
            () -> new TransformItem("water_cauldron", COPPERSWORDHEADDULL, new Item.Properties()));

    public static final DeferredItem<Item> COPPERHAMMERHEADHOT = ITEMS.register("copper_hammer_head_hot",
            () -> new TransformItem("water_cauldron", COPPERHAMMERHEAD, new Item.Properties()));

    public static final DeferredItem<Item> COPPERSAWBLADEHOT = ITEMS.register("copper_saw_blade_hot",
            () -> new TransformItem("water_cauldron", COPPERSAWBLADE, new Item.Properties()));

    public static final DeferredItem<Item> COPPERSMALLBLADEHOT = ITEMS.register("copper_small_blade_hot",
            () -> new TransformItem("water_cauldron", COPPERSMALLBLADEDULL, new Item.Properties()));

    public static final DeferredItem<Item> COPPERCHISELBLADEHOT = ITEMS.register("copper_chisel_blade_hot",
            () -> new TransformItem("water_cauldron", COPPERCHISELBLADEDULL, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
