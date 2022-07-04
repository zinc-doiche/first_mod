package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion.DestructionType;

public class BadaGuntlet extends Item{

	public BadaGuntlet(Settings settings) {
		super(settings);
	}
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		if (playerEntity != null) {
			double x = playerEntity.getX() - Math.abs(Math.cos( Math.toRadians(playerEntity.getPitch()) ))*Math.sin( Math.toRadians(playerEntity.getYaw()) );
			double y = playerEntity.getY() - Math.sin( Math.toRadians(playerEntity.getPitch()) );
			double z = playerEntity.getZ() + Math.abs(Math.cos( Math.toRadians(playerEntity.getPitch()) ))*Math.cos( Math.toRadians(playerEntity.getYaw()) );
			world.createExplosion(playerEntity, x, y, z, 4, DestructionType.BREAK);
		}
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
