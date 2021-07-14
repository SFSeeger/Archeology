package iceheart.archeology.core.world;

import iceheart.archeology.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.FrostedIceBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

    public static void generateOres(final BiomeLoadingEvent event){
        if(!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))){
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.COPPER_ORE.get().getDefaultState(), 9, 0, 64, 30);
        }
    }
    public static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int size, int min_height, int max_height, int amount){
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(fillerType, state, size))
                        .withPlacement(
                                Placement.RANGE.configure(
                                        new TopSolidRangeConfig(min_height, 0, max_height))).square().count(amount));
    }

}
