package net.loonlord32.gaiasphere.items;

import net.loonlord32.gaiasphere.Gaiasphere;
import net.loonlord32.gaiasphere.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gaiasphere.MODID);
    public static final Supplier<CreativeModeTab> GAIASPHERE = CREATIVE_MODE_TAB.register("gaiasphere",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PINE_SAPLING.get()))
                    .title(Component.translatable("creativetab.gaiasphere.gaiasphere"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PINE_SAPLING);
                        output.accept(ModBlocks.PINE_LEAVES);
                        output.accept(ModBlocks.PINE_WOOD );
                        output.accept(ModBlocks.PINE_LOG );
                        output.accept(ModBlocks.PINE_PLANKS );
                        output.accept(ModBlocks.PINE_STAIRS );
                        output.accept(ModBlocks.PINE_PRESSURE_PLATE );
                        output.accept(ModBlocks.PINE_DOOR );
                        output.accept(ModBlocks.PINE_TRAPDOOR);
                        output.accept(ModBlocks.PINE_FENCE_GATE );
                        output.accept(ModBlocks.ASPEN_PLANKS );
                        output.accept(ModBlocks.ASPEN_WOOD );
                        output.accept(ModBlocks.ASPEN_LOG );
                        output.accept(ModBlocks.GREEN_ASPEN_LEAVES );
                        output.accept(ModBlocks.YELLOW_ASPEN_LEAVES );
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
