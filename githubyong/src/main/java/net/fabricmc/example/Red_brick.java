package net.fabricmc.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class Red_brick extends Block{
	
	public Red_brick(Settings settings) {
        super(settings);
	}
	
	//public static double pull = 0.9;
	//public static double pulling = 0;
	
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) { 
        	if (player.isHolding(Main.IDENTIFIER) /* && pos.isWithinDistance(new Vec3i(1,2,3), 30) */) {
        		player.sendMessage(Text.literal("This is a Red Brick."), false);
				/*
				 * pull = (pull == 0.9) ? 0.6 : 0.9 ;
				 * player.sendMessage(Text.literal("pull: "+String.valueOf(pull)), false);
				 */	
        	}
			/*
			 * if (player.isHolding(Main.WHITE_COMPASS)) { pulling = (pulling == 0) ? 1 : 0
			 * ; player.sendMessage(Text.literal("pulling: "+String.valueOf(pulling)),
			 * false); }
			 */
        }
        return ActionResult.SUCCESS;
        //[1 identifier, 1 air]
        //
    }
    
}
