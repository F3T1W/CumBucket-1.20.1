package net.f3t1w.cumbucket.Item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModFoods extends Item {
    private static final int DRINK_DURATION = 40;

    public ModFoods(Item.Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        super.finishUsingItem(pStack, pLevel, pEntityLiving);

        if (!pLevel.isClientSide) {
            if (pEntityLiving instanceof Player player && !((Player)pEntityLiving).getAbilities().instabuild) {
                ItemStack itemStack = player.getInventory().getSelected();
                pEntityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1000));
                player.getInventory().removeItem(itemStack);
            }
        }

        return pStack;
    }

    public int getUseDuration(ItemStack pStack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.cumbucket.cum.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}