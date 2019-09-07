package com.flums.iamfloor.registry;

import com.flums.iamfloor.objects.items.ItemFabricParticle;
import com.flums.iamfloor.util.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class IAFItems
{
	public static Item FABRIC_PARTICLE	= new ItemFabricParticle().setRegistryName(Reference.MODID,"fabric_particle");
//	public static Item FABRIC_COMPRESSOR = new ItemFabricCompressor().setRegistryName(Reference.MODID,"fabric_compressor");
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		final Item[] items =
		{
				FABRIC_PARTICLE
		};
		event.getRegistry().registerAll(items);
	}
}
