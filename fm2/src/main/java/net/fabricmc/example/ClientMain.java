package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClientMain implements ClientModInitializer {
	@Override
    public void onInitializeClient() {
		ModelPredicateProviderRegistry.register(Main.RED_COMPASS, new Identifier("angle"), (itemStack, clientWorld, livingEntity, k) -> {
					if (livingEntity != null) {
						// livingEntity.sendMessage(Text.literal("k: "+String.valueOf(k)));
						double a = Red_compass.getAngle(livingEntity.getYaw(), livingEntity.getX(), 
								livingEntity.getZ(), Red_brick.destinationX, Red_brick.destinationZ);
						
						//livingEntity.sendMessage(Text.literal("angle: "+String.valueOf(a)));
					
						return (float) Red_compass.
								getAngle(livingEntity.getYaw(), livingEntity.getX(), livingEntity.getZ(), 
										Red_brick.destinationX, Red_brick.destinationZ);
					}
					else return 0.0F;
		});
    }
}