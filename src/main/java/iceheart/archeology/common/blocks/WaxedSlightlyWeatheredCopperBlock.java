package iceheart.archeology.common.blocks;

import iceheart.archeology.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class WaxedSlightlyWeatheredCopperBlock extends WaxedCopperBlock{

    public WaxedSlightlyWeatheredCopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(player.getHeldItem(Hand.MAIN_HAND).isItemEqual(new ItemStack(Items.HONEYCOMB)) && player.getHeldItem(Hand.MAIN_HAND).getCount() >= 1) {
            return ActionResultType.FAIL;
        }
        if(player.getHeldItem(Hand.MAIN_HAND).getToolTypes().contains(ToolType.AXE)){
            worldIn.setBlockState(pos, BlockInit.SLIGHTLY_WEATHERED_COPPER_BLOCK.get().getDefaultState());
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }
}
