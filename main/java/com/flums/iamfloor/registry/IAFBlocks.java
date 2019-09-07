//package com.flums.iamfloor.registry;
//
//import com.flums.iamfloor.Main;
//import com.flums.iamfloor.util.Reference;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.item.Item;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.IForgeRegistry;
//
//@Mod.EventBusSubscriber(modid = Reference.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
//public class IAFBlocks {
//
//	public static Block FABRIC_COMPRESSOR_BLOCK = new Block(Block.Properties.create(Material.ANVIL)).setRegistryName(Reference.MODID, "fabric compressor");
//			
//	@SubscribeEvent
//	public static void registerBlocks(RegistryEvent.Register<Block> event)
//	{
//		final Block[] blocks =
//			{
//					FABRIC_COMPRESSOR_BLOCK
//			};
//		event.getRegistry().registerAll(blocks);
//	}
//	
//	@SubscribeEvent
//	public static void registerItemBlocks(RegistryEvent.Register<Item> event)
//	{
//		final IForgeRegistry<Item> registry = event.getRegistry();
//		
//		registry.register(RegistryUtils.createSimpleItemBlock(FABRIC_COMPRESSOR_BLOCK, Main.IAMFLOOR_GROUP));
//	}
//}
