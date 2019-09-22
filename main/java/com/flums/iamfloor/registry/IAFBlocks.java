//package com.flums.iamfloor.registry;
//
//import com.flums.iamfloor.util.Reference;
//
//import net.minecraft.block.Block;
//import net.minecraft.item.Item;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.IForgeRegistry;
//
//@Mod.EventBusSubscriber(modid = Reference.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
//public class IAFBlocks {
//
//	public static Block FABRIC_STABILIZER_BLOCK = new BlockFabricStabilizer().setRegistryName(Reference.MODID, "fabric_stabilizer");
//			
//	@SubscribeEvent
//	public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
//	{
//		final Block blocks[] =
//			{
//					FABRIC_STABILIZER_BLOCK
//			};
//		event.getRegistry().registerAll(blocks);
//	}
//	
//	@SubscribeEvent
//	public static void onRegisterItemBlocks(RegistryEvent.Register<Item> event)
//	{
//		final IForgeRegistry<Item> registry = event.getRegistry();
//		
//		registry.register(RegistryUtils.createSimpleItemBlock(FABRIC_STABILIZER_BLOCK, Main.IAMFLOOR_GROUP));
//	}
//}
