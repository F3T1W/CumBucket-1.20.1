package net.f3t1w.cumbucket.datagen;

import net.f3t1w.cumbucket.CumBucket;
import net.f3t1w.cumbucket.Item.ModItems;
import net.f3t1w.cumbucket.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    private static final List<ItemLike> SMELTABLES = List.of(ModBlocks.F_BLOCK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, SMELTABLES, RecipeCategory.MISC, ModItems.KISKA.get(),
                0.25f, 200, "kiska");
        oreSmelting(pWriter, SMELTABLES, RecipeCategory.MISC, ModItems.KISKA.get(),
                0.25f, 200, "kiska");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.F_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.CUM_COOKIE.get())
                .unlockedBy(getHasName(ModItems.CUM_COOKIE.get()),
                        has(ModItems.CUM_COOKIE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUM_COOKIE.get(), 9)
                .requires(ModBlocks.F_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.F_BLOCK.get()), has(ModBlocks.F_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                      List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory,
                                      @NotNull ItemLike pResult, float pExperience, int pCookingTIme,
                                      @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients,
                pCategory, pResult, pExperience, pCookingTIme,
                pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                      List<ItemLike> pIngredients,
                                      @NotNull RecipeCategory pCategory,
                                      @NotNull ItemLike pResult,
                                      float pExperience,
                                      int pCookingTime,
                                      @NotNull String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE,
                pIngredients, pCategory, pResult, pExperience,
                pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients,
                                     @NotNull RecipeCategory pCategory,
                                     @NotNull ItemLike pResult,
                                     float pExperience,
                                     int pCookingTime,
                                     @NotNull String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike),
                            pCategory, pResult, pExperience,
                            pCookingTime, pCookingSerializer).
                    group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).
                    save(pFinishedRecipeConsumer,
                            CumBucket.MOD_ID + ":" + getItemName(pResult)
                                    + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
