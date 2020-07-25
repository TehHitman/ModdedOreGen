package com.tehhitman.world.gen;
//change the package information and the imports
import com.tehhitman.betteritems.BetterItemsMod;
import com.tehhitman.betteritems.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = BetterItemsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModdedOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
//Nether

            if (biome.getCategory() == Biome.Category.NETHER) {

            }
//End
            else if (biome.getCategory() == Biome.Category.THEEND) {

            }
//Icy
            else if (biome.getCategory() == Biome.Category.ICY) {
                
            }
//Over World
// Put your ore in the "YOUR_ORE" area
            else {
                genOre(biome, 5, 5, 30, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.YOUR_ORE.get().getDefaultState(), 5);
            }
        }
    }
    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
