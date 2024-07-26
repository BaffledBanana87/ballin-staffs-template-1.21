package net.baffledbanana.ballinstaffs.item;

import net.baffledbanana.ballinstaffs.BallinStaffs;
import net.baffledbanana.ballinstaffs.item.custom.EggItem;
import net.baffledbanana.ballinstaffs.item.custom.FireItem;
import net.baffledbanana.ballinstaffs.item.custom.SnowItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SNOWSTAFF = registerItem("snow_staff", new SnowItem(new Item.Settings().maxCount(1).maxDamage(75)));
    public static final Item EGGSTAFF = registerItem("egg_staff", new EggItem(new Item.Settings().maxCount(1).maxDamage(50)));
    public static final Item FIRESTAFF = registerItem("fire_staff", new FireItem(new Item.Settings().maxCount(1).maxDamage(60)));

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
        entries.add(SNOWSTAFF);
        entries.add(EGGSTAFF);
        entries.add(FIRESTAFF);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BallinStaffs.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BallinStaffs.LOGGER.info("Registering Mod Items for " + BallinStaffs.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
