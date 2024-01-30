package net.brian.tutorialmod.block;

import net.brian.tutorialmod.TutorialMod;
import net.brian.tutorialmod.item.ModItems;
import net.brian.tutorialmod.item.modCreativeModTab;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.AMETHYST)
                    .strength(6f)
                    .requiresCorrectToolForDrops()), modCreativeModTab.Tutorial_Tab);

    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)), modCreativeModTab.Tutorial_Tab);

    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)), modCreativeModTab.Tutorial_Tab);

    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of (Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)), modCreativeModTab.Tutorial_Tab);

    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
                    .of (Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)), modCreativeModTab.Tutorial_Tab);

    //The two methods below are helper methods that first registers the block to the blocks registry and to the item registry
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn , tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItems(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventbus) { BLOCKS.register(eventbus); }
}