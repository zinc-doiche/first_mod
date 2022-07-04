package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CompassItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.*;

public class Red_compass extends CompassItem{

	public Red_compass(Settings settings) {
		super(settings);
	}
	
	public static double getAngle(double yaw, double playerPosX, double playerPosZ, double destinationPosX, double destinationPosZ) {
		yaw += 180; 
		while (yaw < 0 || yaw > 360) {
			if (yaw < 0) yaw += 360; if (yaw > 360) yaw -= 360;
		}
		double theta = -Math.toDegrees(Math.atan2(destinationPosX - playerPosX, destinationPosZ - playerPosZ)) + 180;
		
		//System.out.println("yaw: "+yaw+" theta: "+ theta );
		
		return 1-((yaw - theta < 0 ? yaw - theta + 360 : yaw - theta) / 360);
	}
	
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		if (playerEntity != null) {
			//playerEntity.sendMessage(Text.literal(""));
		}
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
	
	void createDungeonPos(JigsawStructure structure){
		structure.getStructurePosition(null);
	}	
}