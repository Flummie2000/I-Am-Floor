package com.flums.iamfloor.objects.items;

import com.flums.iamfloor.Main;
import com.flums.iamfloor.objects.entities.EntityFabricParticle;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ItemFabricParticle extends Item
{
	public ItemFabricParticle()
	{
		super(getProperties());
	}
	
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(Main.IAMFLOOR_GROUP);
		properties.maxStackSize(16);
		
		return properties;
	}	   
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!playerIn.abilities.isCreativeMode) {
		itemstack.shrink(1);
		}

		boolean failedteleport = random.nextBoolean();
		boolean definatelyfailedteleport = random.nextBoolean();
		if (failedteleport==true && definatelyfailedteleport==true)
		{
			if(!worldIn.isRemote)
			{
        Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(worldIn, null) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
        worldIn.createExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 2F, explosion$mode);
		playerIn.getCooldownTracker().setCooldown(this, 120);
		playerIn.attackEntityFrom(Main.UNSTABLE_FABRIC, 8F);
			}
		}
		
		else
		{
        worldIn.playSound((PlayerEntity)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		playerIn.getCooldownTracker().setCooldown(this, 40);
			if (!worldIn.isRemote) {
				EntityFabricParticle enderpearlentity = new EntityFabricParticle(worldIn, playerIn);
				enderpearlentity.func_213884_b(itemstack);
				enderpearlentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
				worldIn.addEntity(enderpearlentity);
			}
		}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}

}
