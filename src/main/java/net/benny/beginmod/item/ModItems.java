package net.benny.beginmod.item;

import net.benny.beginmod.BeginMod;
//import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //we hebben een deferredregister nodig waarbij we onze items registreren
    //dit is een list van items welke we creeeren, van de soort Forgeresistryitems, en ze horen allemaal bij deze mod_id
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeginMod.MOD_ID);

    //een methode register om onze items bij de deferredregister te registereren
    //deze methode moet worden aangeroepen vanuit BeginMod constructor, de main klasse van deze mod
    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

    //een item toevoegen :
    public static final RegistryObject<Item> GSM = ITEMS.register("gsm",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEGINMOD_ITEMTAB)));
    //that's it, nu is het item in de game, maar nog zonder texture en functionaliteit ...

    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEGINMOD_ITEMTAB)));
            //() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEGINMOD_ITEMTAB)));

}
