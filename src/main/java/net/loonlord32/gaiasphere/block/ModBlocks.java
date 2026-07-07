package net.loonlord32.gaiasphere.block;

import net.loonlord32.gaiasphere.Gaiasphere;
import net.loonlord32.gaiasphere.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Gaiasphere.MODID);

    public static final DeferredBlock<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> PINE_WOOD = registerBlock("pine_wood",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));

    public static final DeferredBlock<StairBlock> PINE_STAIRS = registerBlock("pine_stairs",
            () -> new StairBlock(ModBlocks.PINE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> PINE_SLAB = registerBlock("pine_slab",
            () -> new SlabBlock(ModBlocks.PINE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD)));

    public static final DeferredBlock<PressurePlateBlock> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD)));

    public static final DeferredBlock<PressurePlateBlock> PINE_BUTTON = registerBlock("pine_button",
            () -> new ButtonBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).noCollission()));

    public static final DeferredBlock<FenceBlock> PINE_FENCE = registerBlock("pine_fence",
            () -> new FenceBlock(ModBlocks.PINE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD)));

    public static final DeferredBlock<FenceGateBlock> PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            () -> new FenceGateBlock(WoodType.SPRUCE, BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD)));

    public static final DeferredBlock<DoorBlock> PINE_DOOR = registerBlock("pine_door",
            () -> new DoorBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> PINE_TRAPDOOR = registerBlock("pine_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.of().strength(1f) .sound(SoundType.WOOD).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> Block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, Block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
