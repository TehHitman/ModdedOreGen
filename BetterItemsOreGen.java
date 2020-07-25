package com.tehhitman.world.gen;

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

public class BetterItemsOreGen {

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

                genOre(biome, 2, 5, 34, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.BLUE_SAPPHIRE_ORE.get().getDefaultState(), 5);

            }
//Over World
            else {
                genOre(biome, 5, 5, 30, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(), 5);
                genOre(biome, 5, 5, 30, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.AMETHYST_ORE.get().getDefaultState(), 5);
                genOre(biome, 3, 5, 30, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.PINK_SAPPHIRE_ORE.get().getDefaultState(), 5);
                genOre(biome, 12, 5, 21, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.FOOLS_GOLD_ORE.get().getDefaultState(), 5);
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
