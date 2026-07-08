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
import net.minecraft.world.level.block.LeavesBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Gaiasphere.MODID);

    public static final DeferredBlock<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> GREEN_ASPEN_LEAVES = registerBlock("green_aspen_leaves",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> YELLOW_ASPEN_LEAVES = registerBlock("yellow_aspen_leaves",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> PINE_WOOD = registerBlock("pine_wood",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PINE_LOG = registerBlock("pine_log",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ASPEN_PLANKS = registerBlock("aspen_planks",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ASPEN_WOOD = registerBlock("aspen_wood",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> ASPEN_LOG = registerBlock("aspen_log",
            () -> new Block(BlockBehaviour.Properties.of() .strength(1f) .sound(SoundType.WOOD)));


    public static final DeferredBlock<StairBlock> PINE_STAIRS = registerBlock("pine_stairs",
            () -> new StairBlock(ModBlocks.PINE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1f) .sound(SoundType.WOOD)));

    public static final DeferredBlock<PressurePlateBlock> PINE_PRESSURE_PLATE = registerBlock("pine_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.of().strength(1f).sound(SoundType.WOOD)));
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
