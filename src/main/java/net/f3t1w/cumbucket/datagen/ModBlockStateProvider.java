package net.f3t1w.cumbucket.datagen;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CumBucket.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.F_BLOCK);
        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.PERIOD_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.PERIOD_STAIRS.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PERIOD_SLAB.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.PERIOD_BUTTON.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PERIOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.PERIOD_FENCE.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PERIOD_FENCE_GATE.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.PERIOD_WALL.get()), blockTexture(ModBlocks.PERIOD_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.PERIOD_DOOR.get()), modLoc("block/period_door_bottom"), modLoc("block/period_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PERIOD_TRAPDOOR.get()), modLoc("block/period_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
