package iceheart.archeology.common.blocks;

import iceheart.archeology.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ArcheologyBlock extends Block {

    public static final IntegerProperty STAGE = IntegerProperty.create("level", 0, 9);

    public ArcheologyBlock(Properties properties, IntegerProperty STAGE) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(STAGE, Integer.valueOf(0)));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack hold = player.getHeldItem(handIn);
        if(hold.isItemEqual(new ItemStack(ItemInit.BRUSH.get()))){
            Integer curr_state = state.get(STAGE);
            worldIn.setBlockState(pos, state.with(STAGE, curr_state + 1));
            hold.damageItem(1, player, (entity) -> {
                entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        // TODO Generate Loot
    }
}
