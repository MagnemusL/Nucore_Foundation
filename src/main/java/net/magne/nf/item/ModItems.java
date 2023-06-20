package net.magne.nf.item;

import net.magne.nf.NucoreFoundation;
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

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NucoreFoundation.MODID);


    public static final RegistryObject<Item> B = ITEMS.register("b",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUPER_APPLE = ITEMS.register("super_apple",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEat().nutrition(7)
                            .saturationMod(5)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 2), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 500, 2), 0.15f)
                            .build())
                    .rarity(Rarity.RARE)
                    .stacksTo(16)
            ));

    public static final RegistryObject<Item> SULFUR_POWDER = ITEMS.register("sulfur_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TEST_INGOT = registerIngot("test_ingot");


    public static <T extends Item>RegistryObject<T> registerIngot(String name) {
        ITEMS.register(name,
                () -> new Item(new Item.Properties()));

        return null;
    }




    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

}
