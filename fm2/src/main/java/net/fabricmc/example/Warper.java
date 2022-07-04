package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Warper extends Item{

	public Warper(Settings settings) {
		super(settings);
	}
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		addVelocity(playerEntity);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
	
	void addVelocity(PlayerEntity playerEntity) {
		if (playerEntity != null) {
			float pitch = playerEntity.getPitch();
			float yaw = playerEntity.getYaw();
		
			double x = -Math.abs(Math.cos(Math.toRadians(pitch)))*Math.sin(Math.toRadians(yaw));
			double y = -Math.sin(Math.toRadians(pitch));
			double z = Math.abs(Math.cos(Math.toRadians(pitch)))*Math.cos(Math.toRadians(yaw));
			playerEntity.addVelocity(x,y,z);
			System.out.println("coordinates: "+x+", "+y+", "+z); 
			System.out.println("rotates: "+yaw+", "+pitch); 
			//set a identity sphere.
		}
	}
}
