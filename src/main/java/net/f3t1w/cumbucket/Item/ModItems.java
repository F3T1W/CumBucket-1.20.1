package net.f3t1w.cumbucket.Item;

import net.f3t1w.cumbucket.CumBucket;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CumBucket.MOD_ID);

    public static final RegistryObject<Item> KISKA = ITEMS.register("kiska",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CUM_COOKIE = ITEMS.register("cum_cookie",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
