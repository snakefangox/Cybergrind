package net.snakefangox.cybergrind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.snakefangox.cybergrind.Crime;
import net.snakefangox.cybergrind.Things;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModelGen extends FabricModelProvider {
    public ModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        var blocks = Crime.getStaticFields(Things.class, Block.class);
        for (var b: blocks) {
            blockStateModelGenerator.registerSimpleCubeAll(b.getLeft());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        var items = Crime.getStaticFields(Things.class, Item.class);
        for (var i : items) {
            itemModelGenerator.register(i.getLeft(), Models.GENERATED);
        }
    }
}
