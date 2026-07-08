package net.loonlord32.gaiasphere.datagen;

import net.loonlord32.gaiasphere.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }


    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PINE_PLANKS.get());
        this.dropSelf(ModBlocks.PINE_LOG.get());
        this.dropSelf(ModBlocks.PINE_WOOD.get());
        this.dropSelf(ModBlocks.PINE_STAIRS.get());
        this.dropSelf(ModBlocks.PINE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PINE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PINE_DOOR.get());
        this.dropSelf(ModBlocks.PINE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ASPEN_PLANKS.get());
        this.dropSelf(ModBlocks.ASPEN_LOG.get());
        this.dropSelf(ModBlocks.ASPEN_WOOD.get());

        add(ModBlocks.PINE_LEAVES.get(),
                block -> this.createLeavesDrops(ModBlocks.PINE_LEAVES.get(), ModBlocks.ASPEN_LOG, NORMAL_LEAVES_SAPLING_CHANCES));

       add(ModBlocks.GREEN_ASPEN_LEAVES.get(),
                block -> this.createLeavesDrops(ModBlocks.GREEN_ASPEN_LEAVES.get(), ModBlocks.ASPEN_LOG, NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.YELLOW_ASPEN_LEAVES.get(),
                block -> this.createLeavesDrops(ModBlocks.YELLOW_ASPEN_LEAVES.get(), ModBlocks.ASPEN_LOG, NORMAL_LEAVES_SAPLING_CHANCES));
    }

    private LootTable.Builder createLeavesDrops(Block block, DeferredBlock<Block> aspenLog, float[] normalLeavesSaplingChances){return null;}

    {
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
