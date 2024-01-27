package net.brian.tutorialmod.item;

import net.brian.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .tab(modCreativeModTab.Tutorial_Tab)));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .tab(modCreativeModTab.Tutorial_Tab)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
