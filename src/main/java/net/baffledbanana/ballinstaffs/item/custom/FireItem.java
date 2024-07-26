package net.baffledbanana.ballinstaffs.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FireItem extends Item{


    private static final int MAX_DAMAGE = 60;

    public FireItem(Item.Settings settings) {
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
                SoundEvents.ITEM_FIRECHARGE_USE,
                SoundCategory.NEUTRAL,
                0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {
            SmallFireballEntity snowballEntity = new SmallFireballEntity(world, user.getX(), user.getY()+ 1.35, user.getZ(), user.getVelocity());
            snowballEntity.setItem(new ItemStack(Items.FIRE_CHARGE));
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
