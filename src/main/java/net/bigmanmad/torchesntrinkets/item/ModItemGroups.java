package net.bigmanmad.torchesntrinkets.item;

import net.bigmanmad.torchesntrinkets.TorchesnTrinkets;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TORCHESNTRINKETS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TorchesnTrinkets.MOD_ID, "torch_belt"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.torchesntrinkets"))
                    .icon(() -> new ItemStack(ModItems.TORCHBELT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TORCHBELT);
                        entries.add(ModItems.LANTERNBELT);
                        entries.add(ModItems.SOULLANTERNBELT);

                    }).build());
    public static void registerItemGroups() {
        TorchesnTrinkets.LOGGER.info("Registering Item Groups for" + TorchesnTrinkets.MOD_ID);
    }
}
