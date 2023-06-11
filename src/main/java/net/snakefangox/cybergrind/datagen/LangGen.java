package net.snakefangox.cybergrind.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.snakefangox.cybergrind.Crime;
import net.snakefangox.cybergrind.Cybergrind;
import net.snakefangox.cybergrind.Things;

import java.nio.file.Path;

public class LangGen extends FabricLanguageProvider {
    protected LangGen(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        Crime.getStaticFields(Things.class, Item.class).forEach(p -> translationBuilder.add(p.getLeft(), capitalizeWords(p.getRight())));
        Crime.getStaticFields(Things.class, Block.class).forEach(p -> translationBuilder.add(p.getLeft(), capitalizeWords(p.getRight())));

        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/" + Cybergrind.MODID + "/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }

    public static String capitalizeWords(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.replace('_', ' ').split("\\s+");
        for (String word : words) {
            if (word.length() > 0) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                result.append(firstChar).append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }
}
