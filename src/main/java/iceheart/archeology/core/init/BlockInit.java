package iceheart.archeology.core.init;

import iceheart.archeology.Archeology;
import iceheart.archeology.common.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Archeology.MOD_ID);

    //ores
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
            () -> new Block(AbstractBlock.Properties.from(Blocks.IRON_ORE)));

    // archeology Blocks
    public static final RegistryObject<OldGravel> OLD_GRAVEL = BLOCKS.register("old_gravel",
            () -> new OldGravel(AbstractBlock.Properties.from(Blocks.GRAVEL)));

    // Copper block insanity
    public static final RegistryObject<CopperBlock> COPPER_BLOCK = BLOCKS.register("copper_block",
            () -> new CopperBlock(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<SlightlyWeatheredCopperBlock> SLIGHTLY_WEATHERED_COPPER_BLOCK = BLOCKS.register("slightly_weathered_copper_block",
            () -> new SlightlyWeatheredCopperBlock(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<WaxedCopperBlock> WAXED_COPPER_BLOCK = BLOCKS.register("waxed_copper_block",
            () -> new WaxedCopperBlock(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<WaxedSlightlyWeatheredCopperBlock> WAXED_SLIGHTLY_WEATHERED_COPPER_BLOCK = BLOCKS.register("waxed_slightly_weathered_copper_block",
            () -> new WaxedSlightlyWeatheredCopperBlock(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)));

    // other
    public static final RegistryObject<LightningRod> LIGHTNING_ROD = BLOCKS.register("lightning_rod",
            () -> new LightningRod(AbstractBlock.Properties.from(COPPER_BLOCK.get())));
}
