package net.fabricmc.example;

import calc.DestinationAngle;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClientMain implements ClientModInitializer {
	@Override
    public void onInitializeClient() {
		ModelPredicateProviderRegistry.register(Main.RED_COMPASS, new Identifier("angle"), 
				(itemStack, clientWorld, livingEntity, k) -> {
			if (White_compass.click) livingEntity.sendMessage(Text.literal("k: "+String.valueOf(k)));
			double a = DestinationAngle.getAngle(livingEntity.getYaw(), livingEntity.getX(), livingEntity.getZ(), Red_compass.destinationX, Red_compass.destinationZ);
			if (White_compass.snclick) livingEntity.sendMessage(Text.literal("angle: "+String.valueOf(a)));
			
			return (float) DestinationAngle.
					getAngle(livingEntity.getYaw(), livingEntity.getX(), livingEntity.getZ(), 
							Red_compass.destinationX, Red_compass.destinationZ);
		});
    }
}