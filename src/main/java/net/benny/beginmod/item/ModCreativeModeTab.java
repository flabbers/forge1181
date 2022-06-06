package net.benny.beginmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BEGINMOD_ITEMTAB =
            new CreativeModeTab("beginmod_itemtab") {
                @Override
                public ItemStack makeIcon() {
                    return new ItemStack(ModItems.CITRINE.get());
                }
            };

    public static final CreativeModeTab BEGINMOD_BLOCKTAB =
            new CreativeModeTab("beginmod_blocktab") {
                @Override
                public ItemStack makeIcon() {
                    return new ItemStack(ModItems.GSM.get());
                }
            };


}
