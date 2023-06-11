package net.snakefangox.cybergrind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.snakefangox.cybergrind.Crime;
import net.snakefangox.cybergrind.Things;

public class LootTableGen extends FabricBlockLootTableProvider {
    protected LootTableGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        var items = Crime.getStaticFields(Things.class, Block.class);
        for (var i : items) {
            addDrop(i.getLeft());
        }
    }
}
