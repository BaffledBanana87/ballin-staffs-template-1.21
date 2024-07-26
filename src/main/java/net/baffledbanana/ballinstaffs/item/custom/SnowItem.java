package net.baffledbanana.ballinstaffs.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class SnowItem extends Item{

    private static final int MAX_DAMAGE = 75;

    public SnowItem(Settings settings) {
        super(settings.maxDamage(MAX_DAMAGE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.NEUTRAL,
                0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {
            SnowballEntity snowballEntity = new SnowballEntity(world, user);
            snowballEntity.setItem(new ItemStack(Items.SNOWBALL));
            snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(snowballEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.damage(1, user, PlayerEntity.getSlotForHand(hand));

        if (itemStack.isEmpty()) {
            user.getInventory().removeOne(itemStack);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

}
