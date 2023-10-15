package net.magne.nf.creativetabs;

import net.magne.nf.NucoreFoundation;
import net.magne.nf.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = NucoreFoundation.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NucoreFoundation.MODID);

    public static final List<Supplier<? extends ItemLike>> NF_BASICS_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> NF_BASICS = TABS.register("nf_basics",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.nf_basics"))
                    .icon(ModItems.SULFUR_POWDER.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                        NF_BASICS_ITEMS.forEach(itemLike -> output.accept(itemLike.get()));
                    })
                    .build()
    );
    public static <T extends ItemLike> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        NF_BASICS_ITEMS.add(itemLike);
        return itemLike;
    }
}
