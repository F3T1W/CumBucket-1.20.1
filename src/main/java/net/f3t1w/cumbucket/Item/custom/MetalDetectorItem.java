package net.f3t1w.cumbucket.Item.custom;

import net.f3t1w.cumbucket.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel()
                        .getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    assert player != null;
                    outputVariableCoordinates(positionClicked.below(i),
                            player,
                            state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                assert player != null;
                player.sendSystemMessage(Component.literal("No valuables found!"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, Objects
                        .requireNonNull(pContext.getPlayer()),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void outputVariableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found "
                + I18n.get(block.getDescriptionId())
                + " at "
                + "("
                + blockPos.getX()
                + ", "
                + blockPos.getY()
                + ", "
                + blockPos.getZ()
                + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType){
        return 400;
    }
}