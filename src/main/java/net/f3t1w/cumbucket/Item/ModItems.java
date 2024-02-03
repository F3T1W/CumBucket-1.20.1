package net.f3t1w.cumbucket.Item;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.Item.custom.MetalDetectorItem;
import net.f3t1w.cumbucket.Item.custom.ModFoods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Items.BUCKET;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CumBucket.MOD_ID);

    public static final RegistryObject<Item> KISKA = ITEMS.register("kiska",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CUM_COOKIE = ITEMS.register("cum_cookie",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("booba_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> CUM = ITEMS.register("cum", () -> new ModFoods((new Item.Properties()).craftRemainder(BUCKET).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
