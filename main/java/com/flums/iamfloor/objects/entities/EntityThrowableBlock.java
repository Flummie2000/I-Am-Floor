package com.flums.iamfloor.objects.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nullable;

import com.flums.iamfloor.registry.IAFEntities;
import com.flums.iamfloor.registry.IAFItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityThrowableBlock extends ProjectileItemEntity{
   private LivingEntity perlThrower;   
   Logger logger = Logger.getLogger(EntityThrowableBlock.class.getName());
   public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
   	public EntityThrowableBlock(EntityType<? extends EntityThrowableBlock> type, World worldIn) {
   		super(type, worldIn);
   	}

	   public EntityThrowableBlock(World worldIn, LivingEntity throwerIn) {
	      super(IAFEntities.THROWABLE_BLOCK, throwerIn, worldIn);
	      this.perlThrower = throwerIn;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public EntityThrowableBlock(World worldIn, double x, double y, double z) {
	      super(EntityType.ENDER_PEARL, x, y, z, worldIn);
	   }

	   protected Item func_213885_i() {
	      return IAFItems.STICKY_PARTICLE;
	   }
	   
	   public ItemStack getItem() {
		   ItemStack itemstack = new ItemStack(IAFItems.STICKY_PARTICLE);
		   return itemstack;
	   }

	   protected void onImpact(RayTraceResult result) {
	      LivingEntity livingentity = this.getThrower();
          BlockPos pos = new BlockPos(this.posX, this.posY, this.posZ);
	      if (result.getType() == RayTraceResult.Type.ENTITY) {
	    	  Entity entity = ((EntityRayTraceResult)result).getEntity();
	    	  World worldIn = entity.world;
	    	  if (entity == this.perlThrower) {
	            return;
	         }
	         entity.attackEntityFrom(DamageSource.causeThrownDamage(this, livingentity), 0.0F);
	         
		      if (!this.world.isRemote) {
		    	  itemdrop(worldIn);
		          this.remove();
		      }
		      
	         
	      }

	      World worldIn = livingentity.getEntityWorld();
//	      BlockState[] replaceableblocks;
//	      for(BlockState state : replaceableblocks) {
//	    	  if() {
//	    		  state == pos
//	    	  }
//	      }
//	      boolean isreplaceable;
	      if (!this.world.isRemote && result.getType() == RayTraceResult.Type.BLOCK && worldIn.isAirBlock(pos)) {
	    	  Direction Side = sideisplaceable(worldIn, pos);
	    	  BlockState block = Blocks.TORCH.getDefaultState();
	    	  if(Side != null && Side.getAxis().isHorizontal()) {
	    		  block = Blocks.WALL_TORCH.getDefaultState().with(HORIZONTAL_FACING, Side);	    	  
	    	  }
	    		  
	    	  if(Side == Direction.DOWN) {
	    	  }
	    	  if(Side == Direction.EAST) {
	    		worldIn.setBlockState(pos, block);
	    	  }
	    	  if(Side == Direction.NORTH) {
	    		worldIn.setBlockState(pos, block);
	    	  }
	    	  if(Side == Direction.WEST) {
	    		worldIn.setBlockState(pos, block);
	    	  }
	    	  if(Side == Direction.SOUTH) {
	    		worldIn.setBlockState(pos, block);
	    	  }
	    	  if(Side == Direction.UP) {
		    		worldIn.setBlockState(pos, block);
	    	  }
	    	  if(Side == null && !((PlayerEntity)livingentity).abilities.isCreativeMode){
	    		  itemdrop(worldIn);
	    	  }
	    	  this.remove();
	      }
	   	}
	   
	   
	   
	   public void itemdrop(World worldIn) {
	    	  ItemStack itemstack = new ItemStack(Items.TORCH);
	          ItemEntity item = new ItemEntity(this.world, this.posX, this.posY, this.posZ, itemstack);
	          worldIn.addEntity(item);
	   }
	   
	   
	   
	   public Direction sideisplaceable(World worldIn, BlockPos pos){
		   Direction direction = null;   
		   for( Direction Direction : Direction.values() ){
			   BlockPos placeon = pos.offset(Direction);
			   if(Block.hasSolidSide(worldIn.getBlockState(placeon), worldIn, placeon, Direction.getOpposite())==true) {
				   direction = Direction.getOpposite();
			   }
		   }
		   return direction;
	   }
	   
	   
	   public void tick() {
	      LivingEntity livingentity = this.getThrower();
	      if (livingentity != null && livingentity instanceof PlayerEntity && !livingentity.isAlive()) {
	         this.remove();
	      } else {
	         super.tick();
	      }

	   }

	   public void livingTick() {
		   for(int i = 0; i < 2; ++i) {
			   logger.log(Level.INFO,"ticking");
			   this.world.addParticle(ParticleTypes.FLAME, this.posX, this.posY, this.posZ, 1.0D, 0.0D, 1.0D);
		   }
	   }
	   
	   @Nullable
	   public Entity changeDimension(DimensionType destination) {
	      if (this.owner.dimension != destination) {
	         this.owner = null;
	      }

	      return super.changeDimension(destination);
	   }
}
