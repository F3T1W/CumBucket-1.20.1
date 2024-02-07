package net.f3t1w.cumbucket.datagen;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.Item.ModItems;
import net.f3t1w.cumbucket.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CumBucket.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.KISKA);
        simpleItem(ModItems.CUM_COOKIE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.CUM);

        simpleBlockItem(ModBlocks.PERIOD_DOOR);

        fenceItem(ModBlocks.PERIOD_FENCE, ModBlocks.PERIOD_BLOCK);
        buttonItem(ModBlocks.PERIOD_BUTTON, ModBlocks.PERIOD_BLOCK);
        wallItem(ModBlocks.PERIOD_WALL, ModBlocks.PERIOD_BLOCK);

        evenSimplerItem(ModBlocks.PERIOD_STAIRS);
        evenSimplerItem(ModBlocks.PERIOD_SLAB);
        evenSimplerItem(ModBlocks.PERIOD_PRESSURE_PLATE);
        evenSimplerItem(ModBlocks.PERIOD_FENCE_GATE);

        trapDoorItem(ModBlocks.PERIOD_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CumBucket.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerItem(RegistryObject<Block> block) {
        this.withExistingParent(CumBucket.MOD_ID + ":" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(),
                modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    public void trapDoorItem(RegistryObject<Block> block) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(),
                modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(CumBucket.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(CumBucket.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(CumBucket.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CumBucket.MOD_ID, "item/" + item.getId().getPath()));
    }
}
