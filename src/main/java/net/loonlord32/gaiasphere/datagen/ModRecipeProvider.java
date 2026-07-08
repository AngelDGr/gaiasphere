package net.loonlord32.gaiasphere.datagen;

import com.ibm.icu.impl.duration.impl.DataRecord;
import net.loonlord32.gaiasphere.block.ModBlocks;
import net.loonlord32.gaiasphere.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

import static net.loonlord32.gaiasphere.block.ModBlocks.PINE_LOG;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

// hey loon, this is just a template/example for when we do smth with a shaped recipe :)
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_LOG.get())
//                .pattern("BBB")
//                .pattern("BBB")
//                .pattern("BBB")
//                .define('B', ModItems.PINE_SAPLING.get())
//                .unlockedBy("has_pine_sapling",has(ModItems.PINE_SAPLING)).save(recipeOutput);
// this one's legit tho
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PINE_PLANKS.get(), 4)
                .requires(PINE_LOG)
                .unlockedBy(getHasName(PINE_LOG),has(PINE_LOG)).save(recipeOutput);

// hey loon, this is just a template/example for when we do smth with a shaped recipe :) PART 2!
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PINE_PLANKS.get(), 64)
//                .requires(ModBlocks.YELLOW_ASPEN_LEAVES)
//                .unlockedBy("has_yellow_aspen_leaves",has(ModBlocks.YELLOW_ASPEN_LEAVES)).save(recipeOutput, "gaiasphere:holy_crap");
    }
}
