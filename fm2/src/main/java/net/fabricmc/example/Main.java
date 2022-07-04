package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("first_mod");
	
	public static final BadaGuntlet BADA_GUNTLET = new BadaGuntlet(
			new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC));
	public static final Red_compass RED_COMPASS = new Red_compass(
			new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final Blue_compass BLUE_COMPASS = new Blue_compass(
			new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final Green_compass GREEN_COMPASS = new Green_compass(
			new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final White_compass WHITE_COMPASS = new White_compass(
			new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final Ident IDENTIFIER = new Ident(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
	public static final Warper WARPER = new Warper(new FabricItemSettings().maxCount(20).rarity(Rarity.EPIC));
	public static final Red_brick RED_BRICK = new Red_brick(
			FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());

	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(new Identifier("tutorial", "other"))
			.icon(() -> new ItemStack(Main.IDENTIFIER)).appendItems(stacks -> {
				stacks.add(new ItemStack(Main.BADA_GUNTLET));
				stacks.add(new ItemStack(Main.BLUE_COMPASS));
				stacks.add(new ItemStack(Main.GREEN_COMPASS));
				stacks.add(new ItemStack(Main.RED_COMPASS));
				stacks.add(new ItemStack(Main.WHITE_COMPASS));
				stacks.add(new ItemStack(Main.IDENTIFIER));
				stacks.add(new ItemStack(Main.RED_BRICK));
				stacks.add(new ItemStack(Main.WARPER));
				stacks.add(new ItemStack(Items.COMPASS));
			}).build();
			
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Minecraft! This is the FIRST MOD!!");
		Registry.register(Registry.ITEM, new Identifier("first_mod", "bada_guntlet"), BADA_GUNTLET);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "red_compass"), RED_COMPASS);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "blue_compass"), BLUE_COMPASS);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "green_compass"), GREEN_COMPASS);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "white_compass"), WHITE_COMPASS);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "identifier"), IDENTIFIER);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "warper"), WARPER);
		Registry.register(Registry.ITEM, new Identifier("first_mod", "red_brick"),
				new BlockItem(RED_BRICK, new FabricItemSettings()));

		Registry.register(Registry.BLOCK, new Identifier("first_mod", "red_brick"), RED_BRICK);

		/*
		 * AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
		 * BlockState state = world.getBlockState(pos); Manual spectator check is
		 * necessary because AttackBlockCallbacks fire before the spectator check if
		 * (state.isToolRequired() && !player.isSpectator() &&
		 * player.getMainHandStack().isEmpty()) { player.damage(DamageSource.GENERIC,
		 * 1.0F); } return ActionResult.PASS; });
		 */

	}
}