package net.fabricmc.example;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import calc.RandInt;

public class Green_compass extends Item{

	public Green_compass(Settings settings) {
		super(settings);
	}
	
	RandInt r = new RandInt();
	
	@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		if(playerEntity.isSneaking()) {
			playerEntity.sendMessage(Text.literal(String.valueOf(r.randomInt(0, (int) playerEntity.getHealth()) )), false);
		}
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}