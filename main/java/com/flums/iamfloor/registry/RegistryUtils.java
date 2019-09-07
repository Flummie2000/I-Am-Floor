package com.flums.iamfloor.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class RegistryUtils {
	
	public static BlockItem createSimpleItemBlock(Block block, ItemGroup itemGroup) {
		return (BlockItem) new BlockItem(block, new Item.Properties().group(itemGroup)).setRegistryName(block.getRegistryName());
	}
}
