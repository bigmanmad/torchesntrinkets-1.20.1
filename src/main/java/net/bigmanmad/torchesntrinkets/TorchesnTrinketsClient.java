package net.bigmanmad.torchesntrinkets;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.bigmanmad.torchesntrinkets.item.ModItems;
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




        TrinketRendererRegistry.registerRenderer(ModItems.LANTERNBELT,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(0.63F, 0.67F, 0.67F);
                        matrices.translate(0.0F, 0.8F, 0.227F);
                        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(new ItemStack(ModItems.LANTERNBELT), ModelTransformationMode.NONE, light,0, matrices, vertexConsumers, entity.getWorld(), 0);
                    }
                }
        );
        TrinketRendererRegistry.registerRenderer(ModItems.TORCHBELT,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(0.63F, 0.67F, 0.67F);
                        matrices.translate(0.0F, 0.8F, 0.227F);
                        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(new ItemStack(ModItems.TORCHBELT), ModelTransformationMode.NONE, light,0, matrices, vertexConsumers, entity.getWorld(), 0);
                    }
                }
        );
        TrinketRendererRegistry.registerRenderer(ModItems.SOULLANTERNBELT,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(0.63F, 0.67F, 0.67F);
                        matrices.translate(0.0F, 0.8F, 0.227F);
                        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(new ItemStack(ModItems.SOULLANTERNBELT), ModelTransformationMode.NONE, light,0, matrices, vertexConsumers, entity.getWorld(), 0);
                    }
                }
        );
    }
    }
