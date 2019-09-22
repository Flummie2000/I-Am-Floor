package com.flums.iamfloor.registry;

import java.util.List;

import com.flums.iamfloor.objects.entities.EntityFabricParticle;
import com.flums.iamfloor.objects.entities.EntityThrowableBlock;
import com.flums.iamfloor.util.Reference;
import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("rawtypes")
public class IAFEntities
{
	private static List<EntityType> entities = Lists.newArrayList();
	private static List<Item> spawnEggs = Lists.newArrayList();
	
	public static final EntityType<EntityFabricParticle> FABRIC_PARTICLE = createEntity(EntityFabricParticle.class, EntityFabricParticle::new, EntityClassification.MISC, "fabric_particle", 0.5F, 0.5F, 14596231, 16744272);
//	public static final EntityType<EntityFabricNet> FABRIC_NET = createEntity(EntityFabricNet.class, EntityFabricNet::new, EntityClassification.MISC, "fabric_net", 0.5F, 0.5F, 14596231, 16744272);
	public static final EntityType<EntityThrowableBlock> THROWABLE_BLOCK = createEntity(EntityThrowableBlock.class, EntityThrowableBlock::new, EntityClassification.MISC, "throwable_block", 0.5F, 0.5F, 14596231, 16744272);

	private static <T extends Entity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
    
		EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
				.size(width, height).setTrackingRange(64)
				.setShouldReceiveVelocityUpdates(true)
				.setUpdateInterval(3)
				.build(location.toString());
    
		entity.setRegistryName(location);
    
		entities.add(entity);
		spawnEggs.add(RegistryUtils.createSpawnEggForEntity(entity, eggPrimary, eggSecondary, ItemGroup.MISC));

		return entity;
	}
	
	 @SubscribeEvent
	    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
	    	for (EntityType entity : entities) {
	    		event.getRegistry().register(entity);
	    	}
//	    	EntitySpawnPlacementRegistry.register(FABRIC_PARTICLE);
	    }

//	 @SubscribeEvent
//	    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
//	        for (Item spawnEgg : spawnEggs) {
//	            event.getRegistry().register(spawnEgg);
//	        }
//	    }
}