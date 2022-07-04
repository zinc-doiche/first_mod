package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Blue_compass extends Item{

	public Blue_compass(Settings settings) {
		super(settings);
	}
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		playerEntity.addVelocity(1,0,0); 
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}