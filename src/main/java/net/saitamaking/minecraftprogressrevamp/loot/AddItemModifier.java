package net.saitamaking.minecraftprogressrevamp.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.saitamaking.minecraftprogressrevamp.item.ModItems;

public class AddItemModifier extends LootModifier {
    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            LootModifier.codecStart(inst)
                    .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(m -> m.item))
                    .and(Codec.INT.fieldOf("minLoot").forGetter(m -> m.minLoot))
                    .and(Codec.INT.fieldOf("maxLoot").forGetter(m -> m.maxLoot))
                    .apply(inst, AddItemModifier::new));
    private final Item item;
    private final int minLoot;
    private final int maxLoot;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item, int minLoot, int maxLoot) {
        super(conditionsIn);
        this.item = item;
        this.minLoot = minLoot;
        this.maxLoot = maxLoot;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        for (LootItemCondition condition : this.conditions) {
            if(!condition.test(lootContext)) {
                return generatedLoot;
            }
        }
        int count = lootContext.getRandom().nextIntBetweenInclusive(this.minLoot, this.maxLoot);
        generatedLoot.add(new ItemStack(this.item, count));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
