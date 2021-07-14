package iceheart.archeology.common.blocks;

import iceheart.archeology.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class SlightlyWeatheredCopperBlock extends CopperBlock{

    public SlightlyWeatheredCopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(random.nextInt(200) <= 50){
            worldIn.setBlockState(pos, Blocks.IRON_BLOCK.getDefaultState());
        }
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(player.getHeldItem(Hand.MAIN_HAND).isItemEqual(new ItemStack(Items.HONEYCOMB)) && player.getHeldItem(Hand.MAIN_HAND).getCount() >= 1){

            worldIn.setBlockState(pos, BlockInit.WAXED_SLIGHTLY_WEATHERED_COPPER_BLOCK.get().getDefaultState());

            if (!player.isCreative()) {
                ItemStack item = player.getHeldItem(Hand.MAIN_HAND);
                item.setCount(item.getCount() - 1);
            }
            return ActionResultType.SUCCESS;
        }
        else if(player.getHeldItem(Hand.MAIN_HAND).getToolTypes().contains(ToolType.AXE)){
            worldIn.setBlockState(pos, BlockInit.COPPER_BLOCK.get().getDefaultState());
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.FAIL;
    }
}
