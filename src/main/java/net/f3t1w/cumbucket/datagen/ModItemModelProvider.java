package net.f3t1w.cumbucket.datagen;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.Item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CumBucket.MOD_ID, "item/" + item.getId().getPath()));
    }
}
