package net.magne.nf.block;

import net.magne.nf.NucoreFoundation;
import net.magne.nf.creativetabs.ModCreativeTabs;
import net.magne.nf.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Properties;
import java.util.function.Supplier;

import static net.magne.nf.creativetabs.ModCreativeTabs.addOreToTab;
import static net.magne.nf.creativetabs.ModCreativeTabs.addToTab;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NucoreFoundation.MODID);


public static final RegistryObject<Block> URANIUM_ORE = registerOre("uranium_ore");

public static final RegistryObject<Block> PLUTONIUM_ORE = registerOreEnder("plutonium_ore");

public static final RegistryObject<Block> THORIUM_ORE = registerOre("thorium_ore");

public static final RegistryObject<Block> TITANIUM_ORE = registerOre("titanium_ore");

public static final RegistryObject<Block> SILICON_ORE = registerOre("silicon_ore");

public static final RegistryObject<Block> BAUXITE_ORE = registerOre("bauxite_ore");

public static final RegistryObject<Block> COBALT_ORE = registerOre("cobalt_ore");

public static final RegistryObject<Block> LITHIUM_ORE = registerOre("lithium_ore");

public static final RegistryObject<Block> PLATINUM_ORE = registerOre("platinum_ore");

public static final RegistryObject<Block> PLASMAITE_ORE = registerOre("plasmaite_ore");

public static final RegistryObject<Block> MAGNESIUM_ORE = registerOre("magnesium_ore");


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block>RegistryObject<T> registerOre(String name) {
        addOreToTab(
        registerBlock(name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops())));

        addOreToTab(
        registerBlock("deepslate_" + name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops())));
        return null;
    }

    public static <T extends Block>RegistryObject<T> registerOreEnder(String name) {
        registerBlock(name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops()));

        registerBlock("deepslate_" + name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops()));

        registerBlock("ender_" + name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops()));
        return null;
    }

    public static <T extends Block>RegistryObject<T> registerOreNether(String name) {
        registerBlock(name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops()));

        registerBlock("deepslate_" + name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops()));

        registerBlock("nether_" + name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                        .strength(2f)
                        .explosionResistance(1f)
                        .requiresCorrectToolForDrops()));
        return null;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
