package net.loonlord32.gaiasphere.datagen;

import net.loonlord32.gaiasphere.Gaiasphere;
import net.loonlord32.gaiasphere.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Gaiasphere.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PINE_LOG);
        blockWithItem(ModBlocks.PINE_WOOD);
        blockWithItem(ModBlocks.ASPEN_LOG);
        blockWithItem(ModBlocks.ASPEN_WOOD);
        blockWithItem(ModBlocks.PINE_PLANKS);
        blockWithItem(ModBlocks.ASPEN_PLANKS);
        blockWithItem(ModBlocks.PINE_LEAVES);
        blockWithItem(ModBlocks.GREEN_ASPEN_LEAVES);
        blockWithItem(ModBlocks.YELLOW_ASPEN_LEAVES);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
