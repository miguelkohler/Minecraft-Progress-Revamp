package net.saitamaking.minecraftprogressrevamp.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.saitamaking.minecraftprogressrevamp.ProgressRevamp;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProgressRevamp.MODID);

    public static final DeferredItem<Item> LOOSEPEBBLE = ITEMS.register("loose_pebble",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SHARPPEBBLE = ITEMS.register("sharp_pebble",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PRIMITIVEAXE = ITEMS.register("primitive_axe",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
