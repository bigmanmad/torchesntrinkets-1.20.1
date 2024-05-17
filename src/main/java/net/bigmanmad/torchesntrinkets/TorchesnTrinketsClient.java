package net.bigmanmad.torchesntrinkets;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class TorchesnTrinketsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {



        TrinketRendererRegistry.registerRenderer(TorchBelt.TORCH_HIP,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToFace(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player, headYaw, headPitch);
                        matrices.scale(0.5F, 0.5F, 0.5F);
                        matrices.translate(1.0F, -0.85F, 0.0F);
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
    }
})
    ;}
}
