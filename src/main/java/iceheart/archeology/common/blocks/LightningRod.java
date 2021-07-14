package iceheart.archeology.common.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.stream.Stream;

public class LightningRod extends Block {
    public LightningRod(Properties properties) {
        super(properties);
    }
    public BlockPos pos_main;

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 12, 9),
            Block.makeCuboidShape(6, 12, 6, 10, 16, 10))
            .reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
        return SHAPE;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        pos_main = pos;
    }

    /*
    //catcher
    @SubscribeEvent
    public static void catch_lightning(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof LightningBoltEntity){
            BlockPos pos = event.getEntity().getPosition();
            BlockPos rod_main = event.getWorld().
            if(pos.withinDistance(pos_main, 4) ){
                event.getEntity().forceSetPosition(pos_main.getX(), pos_main.getY(), pos_main.getZ());
                System.out.println("BOOM");
            }
        }
        System.out.println("Event");
    }*/
}
