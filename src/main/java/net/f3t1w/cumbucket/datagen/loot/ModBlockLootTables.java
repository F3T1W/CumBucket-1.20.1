package net.f3t1w.cumbucket.datagen.loot;

import net.f3t1w.cumbucket.Item.ModItems;
import net.f3t1w.cumbucket.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.PERIOD_BLOCK.get());

        this.add(ModBlocks.F_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.F_BLOCK.get(), ModItems.CUM.get()));

        this.dropSelf(ModBlocks.PERIOD_STAIRS.get());
        this.dropSelf(ModBlocks.PERIOD_BUTTON.get());
        this.dropSelf(ModBlocks.PERIOD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PERIOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PERIOD_FENCE.get());
        this.dropSelf(ModBlocks.PERIOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PERIOD_WALL.get());

        this.add(ModBlocks.PERIOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PERIOD_SLAB.get()));
        this.add(ModBlocks.PERIOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.PERIOD_DOOR.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator
                                        .between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount
                                        .addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
