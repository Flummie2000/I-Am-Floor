package com.flums.iamfloor.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockFabricStabilizer extends Block{
	
	public BlockFabricStabilizer()
	{
		super(getProperties());
	}
	
	public static Properties getProperties() {
		Properties properties = (Block.Properties.create(Material.ANVIL, MaterialColor.GRAY));
		properties.hardnessAndResistance(1.5F, 6.0F);
		return properties;
	}
	
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	

}