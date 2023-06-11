package net.snakefangox.cybergrind;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Things {
    public static final Item SCALPEL = new Item(new FabricItemSettings());
    public static final Block COMPACTOR = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).mapColor(MapColor.WHITE).strength(4.0f));

    public static void register() {
        registerItems();
        registerBlocks();
    }

    private static void registerItems() {
        var items = Crime.getStaticFields(Things.class, Item.class);
        for (var i: items) {
            Registry.register(Registries.ITEM, id(i.getRight()), i.getLeft());
        }
    }

    private static void registerBlocks() {
        var blocks = Crime.getStaticFields(Things.class, Block.class);
        for (var b: blocks) {
            Registry.register(Registries.BLOCK, id(b.getRight()), b.getLeft());
            Registry.register(Registries.ITEM, id(b.getRight()), new BlockItem(b.getLeft(), new FabricItemSettings()));
        }
    }

    private static Identifier id(String name) {
        return new Identifier(Cybergrind.MODID, name);
    }
}
