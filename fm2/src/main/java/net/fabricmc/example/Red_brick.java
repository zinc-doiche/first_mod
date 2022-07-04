package net.fabricmc.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Red_brick extends Block{
	
	
	public Red_brick(Settings settings) {
        super(settings);
	}
	
	public static double destinationX, destinationZ;
	
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) { 
        	if (player.isHolding(Main.IDENTIFIER) /* && pos.isWithinDistance(new Vec3i(1,2,3), 30) */) {
        		player.sendMessage(Text.literal("This is a Red Brick."), false);
        	}
        	if (player.isHolding(Main.RED_COMPASS)) {
        		destinationX = pos.getX(); destinationZ = pos.getZ();
        		player.sendMessage(Text.literal("pos: " + pos.getX() + ", " + pos.getZ()));
        		
        	}
        }
        return ActionResult.SUCCESS;
    }
}