package net.loonlord32.gaiasphere.items;

import net.loonlord32.gaiasphere.Gaiasphere;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Gaiasphere.MODID);

    public static final DeferredItem<Item> SARDINE = ITEMS.register("sardine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINE_SAPLING = ITEMS.register("pine_sapling",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
