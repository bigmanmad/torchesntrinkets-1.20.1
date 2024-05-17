package net.bigmanmad.torchesntrinkets;

import net.bigmanmad.torchesntrinkets.item.ModItemGroups;
import net.bigmanmad.torchesntrinkets.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.RotationAxis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TorchesnTrinkets implements ModInitializer {
	public static final String MOD_ID = "torchesntrinkets";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		LOGGER.info("!?");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

	}
	public static void beltTorchTrinket(MatrixStack matrices, EntityModel<? extends LivingEntity> model,
										LivingEntity entity, float bodyYaw, float bodyPitch) {

		if (entity.isInSwimmingPose() || entity.isFallFlying()) {
			PlayerEntityModel<AbstractClientPlayerEntity> ctx = (PlayerEntityModel<AbstractClientPlayerEntity>) model;
			if(model instanceof PlayerEntityModel)
			{

				matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ctx.body.pivotZ));
			}
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(ctx.body.pivotY));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(ctx.body.pivotX));
		} else {

			if (entity.isInSneakingPose() && !model.riding) {
				matrices.translate(0.0F, 0.25F, 0.0F);
			}
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(bodyYaw));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(bodyPitch));
		}
		matrices.translate(0.0F, -0.25F, -0.3F);
	}
}

