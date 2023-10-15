package net.magne.nf.item;

import net.magne.nf.NucoreFoundation;
import net.magne.nf.creativetabs.ModCreativeTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.BadLocationException;

import static net.magne.nf.creativetabs.ModCreativeTabs.addToTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NucoreFoundation.MODID);

    public static final RegistryObject<Item> SULFUR_POWDER = addToTab(ITEMS.register("sulfur_powder",
            () -> new Item(new Item.Properties())));

    public static final RegistryObject<Item> BLUEPRINT = registerBlueprint("blueprint");

    public static final RegistryObject<Item> BLUEPRINT_BOOK = registerBlueprint("blueprint_book");

    public static final RegistryObject<Item> MACHINE_BLUEPRINT = registerBlueprint("machine_blueprint");

    public static final RegistryObject<Item> FLUID_BLUEPRINT = registerBlueprint("fluid_blueprint");

    public static final RegistryObject<Item> MATERIAL_BLUEPRINT = registerBlueprint("material_blueprint");

    public static final RegistryObject<Item> BAUXITE_INGOT = registerIngot("bauxite_ingot");
    public static final RegistryObject<Item> COBALT_INGOT = registerIngot("cobalt_ingot");
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot",
            () -> );
    public static final RegistryObject<Item> MAGNESIUM_INGOT = registerIngot("magnesium_ingot");
    public static final RegistryObject<Item> PLASMAITE_INGOT = registerIngot("plasmaite_ingot");
    public static final RegistryObject<Item> PLATINUM_INGOT = registerIngot("platinum_ingot");
    public static final RegistryObject<Item> PLUTONIUM_INGOT = registerIngot("plutonium_ingot");
    public static final RegistryObject<Item> SILICON_INGOT = registerIngot("silicon_ingot");
    public static final RegistryObject<Item> THORIUM_INGOT = registerIngot("thorium_ingot");
    public static final RegistryObject<Item> TITANIUM_INGOT = registerIngot("titanium_ingot");
    public static final RegistryObject<Item> URANIUM_INGOT = registerIngot("uranium_ingot");


    public static <T extends Item> RegistryObject<T> registerIngot(String name) {
        addToTab(ITEMS.register(name,
                () -> new Item(new Item.Properties())));

        return null;
    }

    public static <T extends Item> RegistryObject<T> registerBlueprint(String name) {
        addToTab(ITEMS.register(name,
                () -> new Item(new Item.Properties()
                        .stacksTo(16))));

        return null;
    }




    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}
