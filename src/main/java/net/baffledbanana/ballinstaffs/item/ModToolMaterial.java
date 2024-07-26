package net.baffledbanana.ballinstaffs.item;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public enum ModToolMaterial implements ToolMaterial {
    SNOWSTAFF(
            3430,
            0.0f,
            0,
            15
    );


    private final int durability;
    private final float miningSpeedMultiplier, attackDamage;
    private final int enchantability;


    ModToolMaterial(int durability, float miningSpeedMultiplier, float attackDamage, int enchantability) {
        this.durability = durability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
    }


    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;

    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }



}