package net.f3t1w.cumbucket.Item;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.Item.custom.ModFoods;
import net.f3t1w.cumbucket.block.ModBlocks;
import net.f3t1w.cumbucket.block.custom.SoundBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CumBucket.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CUMBUCKET = CREATIVE_MODE_TABS.register("cumbucket_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KISKA.get()))
                    .title(Component.translatable("creativetab.cumbucket_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KISKA.get());
                        output.accept(ModItems.CUM_COOKIE.get());
                        output.accept(ModItems.METAL_DETECTOR.get());

                        output.accept(ModItems.CUM.get());

                        output.accept(ModBlocks.F_BLOCK.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
