package net.benny.beginmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Arrays;

//bij rechtsklikken : kijkt naar alle blokken eronder en geeft locactie van waardevolle terug
public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        //usually not the case, meestel zijn we op de server
        if (pContext.getLevel().isClientSide()) {
            BlockPos pos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundValuable = false;

            for (int i = 0; i < pos.getY() + 64; i++) {
                Block onder = pContext.getLevel().getBlockState(pos.below(i)).getBlock();
                if (isValuableBlock(onder)) {
                    outputValuableCoordinates(pos, player, onder);
                    foundValuable = true;
                    break;
                }
            }

            if (! foundValuable) {
                player.sendMessage(new TextComponent("item.beginmod.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }
        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                (player -> player.broadcastBreakEvent(player.getUsedItemHand())));

        return super.useOn(pContext);
    }




    //zelf gedefinieerde functionaliteiten :
    private boolean isValuableBlock(Block block) {
        //return block == Blocks.COAL_ORE
         //       || block == Blocks.COPPER_ORE
         //       || block == Blocks.DIAMOND_ORE
         //       || block == Blocks.IRON_ORE;
        Block[] blocks = {Blocks.COAL_ORE,Blocks.COPPER_ORE,Blocks.DIAMOND_ORE,Blocks.IRON_ORE};
        return Arrays.stream(blocks).anyMatch(b -> b.equals(block));

    }


    private void outputValuableCoordinates(BlockPos pos, Player player, Block blockBelow) {
        player.sendMessage(
                //new TextComponent("Found" + blockBelow.asItem().getRegistryName().toString() + "at" +
                //        "(" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + ")"), player.getUUID()
                new TextComponent(
                        String.format(
                                "Found %s at position (%d,%d,%d)"
                                ,blockBelow.asItem().getRegistryName().toString(),pos.getX(),pos.getY(),pos.getZ()
                        )
                )
                , player.getUUID()
        );
    }





}
