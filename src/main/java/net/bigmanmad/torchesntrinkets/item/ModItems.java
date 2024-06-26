package net.bigmanmad.torchesntrinkets.item;

import net.bigmanmad.torchesntrinkets.TorchesnTrinkets;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item TORCHBELT = registerItem("torch_belt", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item LANTERNBELT = registerItem("lantern_belt", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item SOULLANTERNBELT = registerItem("soul_lantern_belt", new Item(new FabricItemSettings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry .register(Registries.ITEM, new Identifier(TorchesnTrinkets.MOD_ID, name), item);
    }

    public static void registerModItems () {
        TorchesnTrinkets.LOGGER.info("Registering Mod Items for " + TorchesnTrinkets.MOD_ID);
    }
}
