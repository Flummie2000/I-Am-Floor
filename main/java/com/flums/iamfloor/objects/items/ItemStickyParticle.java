package com.flums.iamfloor.objects.items;

import com.flums.iamfloor.Main;
import com.flums.iamfloor.objects.entities.EntityThrowableBlock;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemStickyParticle extends Item{
	
	public ItemStickyParticle()
	{
		super(getProperties());
	}
	
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(Main.IAMFLOOR_GROUP);
		properties.maxStackSize(64);
		
		return properties;
	}	   
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!playerIn.abilities.isCreativeMode) {
		itemstack.shrink(1);
		}
		worldIn.playSound((PlayerEntity)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
			if (!worldIn.isRemote) {
				EntityThrowableBlock throwableblock = new EntityThrowableBlock(worldIn, playerIn);
				throwableblock.func_213884_b(itemstack);
				throwableblock.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 2.0F, 1.5F, 0.0F);
				worldIn.addEntity(throwableblock);
			}

		playerIn.addStat(Stats.ITEM_USED.get(this));
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}

}
