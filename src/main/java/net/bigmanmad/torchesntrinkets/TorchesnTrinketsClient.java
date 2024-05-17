package net.bigmanmad.torchesntrinkets;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;

public class TorchesnTrinketsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TrinketRendererRegistry.registerRenderer(Items.TORCH,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(0.5F, 0.5F, 0.5F);
                        matrices.translate(-0.45F, -0.09F, 0.65F);
                        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(new ItemStack(Items.TORCH), ModelTransformationMode.NONE, light,0, matrices, vertexConsumers, entity.getWorld(), 0);
                    }
                }
        );
    }
    }
