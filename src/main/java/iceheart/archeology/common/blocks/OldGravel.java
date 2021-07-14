package iceheart.archeology.common.blocks;


import iceheart.archeology.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.stream.Stream;

public class OldGravel extends Block {
    public static final IntegerProperty STAGE = IntegerProperty.create("level", 0, 9);

    public OldGravel(Properties properties) {
        super(properties);
        this.setDefaultState(this.getStateContainer().getBaseState().with(STAGE, Integer.valueOf(0)));
    }

    private static VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 16, 16))
            .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
        return SHAPE;
    }

    public boolean isTransparent(BlockState state) {
        return false;
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack hold = player.getHeldItem(handIn);
        if(hold.isItemEqual(new ItemStack(ItemInit.BRUSH.get()))){
            Integer curr_state = state.get(STAGE);
            if(state.get(STAGE) < 9) {
                worldIn.setBlockState(pos, state.with(STAGE, curr_state + 1));
                /*
                SHAPE = Stream.of(Block.makeCuboidShape(0, 0, 0, 16, 16-curr_state, 16))
                        .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();*/
                hold.damageItem(1, player, (entity) -> {
                    entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                });
                return ActionResultType.SUCCESS;
            }
            else{
                worldIn.destroyBlock(pos, false);
                return ActionResultType.CONSUME;
            }
        }
        return ActionResultType.FAIL;
    }

    /*
    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        // TODO Generate Loot
    }
     */



    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(STAGE);
    }
}
