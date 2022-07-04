package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class White_compass extends Item{

	public White_compass(Settings settings) {
		super(settings);
	}
	
	public static boolean click = false, snclick = false;
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		if (playerEntity.isSneaking()) snclick = snclick ? false : true;
		else click = click ? false : true;
        
		return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}