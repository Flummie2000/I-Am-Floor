package com.flums.iamfloor.registry;

import com.flums.iamfloor.objects.items.ItemFabricParticle;
import com.flums.iamfloor.objects.items.ItemStickyParticle;
import com.flums.iamfloor.util.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class IAFItems
{
	public static Item FABRIC_PARTICLE	= new ItemFabricParticle().setRegistryName(Reference.MODID,"fabric_particle");
//	public static Item FABRIC_NET = new ItemFabricNet().setRegistryName(Reference.MODID,"fabric_net");
	public static Item STICKY_PARTICLE = new ItemStickyParticle().setRegistryName(Reference.MODID,"sticky_particle");
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		final Item[] items =
		{
				FABRIC_PARTICLE
//				,FABRIC_NET
				,STICKY_PARTICLE
		};
		event.getRegistry().registerAll(items);
	}
}
