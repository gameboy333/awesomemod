package gameboy.awesomemod.block;

import gameboy.awesomemod.Awesomemod;
import gameboy.awesomemod.item.awesomeItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class awesomeBlocks {
    public static final RegistryKey<ItemGroup> itemGroupKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Awesomemod.MOD_ID, "item_group_blocks"));
    public static final ItemGroup customItemGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(awesomeBlocks.testingBlock.asItem()))
            .displayName(Text.translatable("itemGroup.awesomeModBlocks"))
            .build();

    public static final Block testingBlock = register(
            "testing-block",
            Block::new,
            AbstractBlock.Settings.create().hardness(1).sounds(BlockSoundGroup.GRASS),
            true
    );

    public static final Block berryBlock = register(
            "berry-block",
            Block::new,
            AbstractBlock.Settings.create().hardness(2).sounds(BlockSoundGroup.HONEY),
            true
    );

    public static final Block deeninOre = register(
            "deenin-ore",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().hardness(3).sounds(BlockSoundGroup.STONE),
            true
    );

    public static final Block rawDeenin = register(
            "raw-deenin-block",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().hardness(3).sounds(BlockSoundGroup.STONE),
            true
    );

    public static final Block deenin = register(
            "deenin-block",
            Block::new,
            AbstractBlock.Settings.create().requiresTool().hardness(3).sounds(BlockSoundGroup.IRON),
            true
    );



    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Awesomemod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Awesomemod.MOD_ID, name));
    }

    private static void addItems(FabricItemGroupEntries entries) {
        entries.add(testingBlock.asItem());
        entries.add(berryBlock.asItem());
        entries.add(deeninOre.asItem());
        entries.add(rawDeenin.asItem());
        entries.add(deenin.asItem());
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, itemGroupKey, customItemGroup);
        ItemGroupEvents.modifyEntriesEvent(itemGroupKey).register(awesomeBlocks::addItems);
    }
}
