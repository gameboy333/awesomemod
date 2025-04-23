package gameboy.awesomemod;

import gameboy.awesomemod.block.awesomeBlocks;
import gameboy.awesomemod.item.awesomeItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Awesomemod implements ModInitializer {
    public static String MOD_ID = "awesomemod";

    public static final RegistryKey<PlacedFeature> deeninOreGen = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("awesomemod","deenin-ore"));

    @Override
    public void onInitialize() {
        awesomeItems.initialize();
        awesomeBlocks.initialize();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, deeninOreGen);
    }
}