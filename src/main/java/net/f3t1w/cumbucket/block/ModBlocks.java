package net.f3t1w.cumbucket.block;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.Item.ModItems;
import net.f3t1w.cumbucket.block.custom.SoundBlock;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CumBucket.MOD_ID);

    public static final RegistryObject<Block> F_BLOCK = registerBlock("f_block",
            () -> new DropExperienceBlock((BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops()), UniformInt
                    .of(3, 6)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock((BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> PERIOD_BLOCK = registerBlock("period_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops())));

    public static final RegistryObject<Block> PERIOD_STAIRS = registerBlock("period_stairs",
            () -> new StairBlock(() -> ModBlocks.PERIOD_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PERIOD_SLAB = registerBlock("period_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PERIOD_BUTTON = registerBlock("period_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST),
                    BlockSetType.IRON, 10, true));

    public static final RegistryObject<Block> PERIOD_PRESSURE_PLATE = registerBlock("period_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> PERIOD_FENCE = registerBlock("period_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PERIOD_FENCE_GATE = registerBlock("period_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> PERIOD_WALL = registerBlock("period_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PERIOD_DOOR = registerBlock("period_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> PERIOD_TRAPDOOR = registerBlock("period_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON));

    private static <T extends Block> RegistryObject<T> registerBlock(String name,
                                                                     Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
                                                                            RegistryObject<T> block) {
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
