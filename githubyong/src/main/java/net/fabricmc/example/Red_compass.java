package net.fabricmc.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CompassItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.*;

public class Red_compass extends CompassItem{

	public Red_compass(Settings settings) {
		super(settings);
	}
	
	public static double playerX, playerZ, destinationX, destinationZ;
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		
			playerX = playerEntity.getX(); playerZ = playerEntity.getZ();
			destinationX = playerEntity.getBlockX(); destinationZ = playerEntity.getBlockZ(); 
		
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

	void createDungeonPos(JigsawStructure structure){
		structure.getStructurePosition(null);

	}

	
}