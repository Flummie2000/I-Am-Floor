package com.flums.iamfloor.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IAFItemGroup extends ItemGroup
{

	public IAFItemGroup()
	{
		super("IAmFloor");
	}
	

	@Override
	public ItemStack createIcon() {
		return new ItemStack(IAFItems.FABRIC_PARTICLE, 42);
	}
	
	@Override
	public int getLabelColor() {
		return 	9502955;
	}
	
}
