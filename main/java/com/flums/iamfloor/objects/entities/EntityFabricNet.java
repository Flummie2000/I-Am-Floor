//package com.flums.iamfloor.objects.entities;
//
//import javax.annotation.Nullable;
//
//import com.flums.iamfloor.registry.IAFEntities;
//import com.flums.iamfloor.registry.IAFItems;
//
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.IRendersAsItem;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.ServerPlayerEntity;
//import net.minecraft.entity.projectile.ProjectileItemEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.particles.ParticleTypes;
//import net.minecraft.util.DamageSource;
//import net.minecraft.util.math.EntityRayTraceResult;
//import net.minecraft.util.math.RayTraceResult;
//import net.minecraft.world.World;
//import net.minecraft.world.dimension.DimensionType;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//public class EntityFabricNet extends ProjectileItemEntity implements IRendersAsItem{
//   private LivingEntity perlThrower;
//   
//   	public EntityFabricNet(EntityType<? extends EntityFabricNet> type, World worldIn) {
//   		super(type, worldIn);
//   	}
//
//	   public EntityFabricNet(World worldIn, LivingEntity throwerIn) {
//	      super(IAFEntities.FABRIC_NET, throwerIn, worldIn);
//	      this.perlThrower = throwerIn;
//	   }
//
//	   @OnlyIn(Dist.CLIENT)
//	   public EntityFabricNet(World worldIn, double x, double y, double z) {
//	      super(EntityType.ENDER_PEARL, x, y, z, worldIn);
//	   }
//
//	   protected Item func_213885_i() {
//	      return IAFItems.FABRIC_NET;
//	   }
//	   
//	   public ItemStack getItem() {
//		   ItemStack itemstack = new ItemStack(IAFItems.FABRIC_NET);
//		   return itemstack;
//	   }
//
//	   protected void onImpact(RayTraceResult result) {
//	      LivingEntity livingentity = this.getThrower();
//	      if (result.getType() == RayTraceResult.Type.ENTITY) {
//	         Entity entity = ((EntityRayTraceResult)result).getEntity();
//	         if (entity == this.perlThrower) {
//	            return;
//	         }
//
//	         entity.attackEntityFrom(DamageSource.causeThrownDamage(this, livingentity), 0.0F);
//	      }
//
//	      for(int i = 0; i < 32; ++i) {
//	         this.world.addParticle(ParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
//	      }
//
//	      if (!this.world.isRemote && result.getType() == RayTraceResult.Type.ENTITY) {
//	         if (livingentity instanceof ServerPlayerEntity) {
//	            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)livingentity;
//	               net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(serverplayerentity, this.posX, this.posY, this.posZ, 5.0F);
//	               if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size
//	            if (serverplayerentity.connection.getNetworkManager().isChannelOpen() && serverplayerentity.world == this.world && !serverplayerentity.isSleeping()) {
//	               if (livingentity.isPassenger()) {
//	                  livingentity.stopRiding();
//	               }
//	               Entity entity = ((EntityRayTraceResult)result).getEntity();
//	               entity.setPositionAndUpdate(livingentity.posX, livingentity.posY, livingentity.posZ);
//	               entity.setMotion(0, 0, 0);
//	               livingentity.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
//	               livingentity.fallDistance = 0.0F;
//	               livingentity.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
//	               }
//	            }
//	         } else if (livingentity != null) {
//	            livingentity.setPositionAndUpdate(this.posX, this.posY, this.posZ);
//	            livingentity.fallDistance = 0.0F;
//	         }
//
//	         this.remove();
//	      }
//	      
//	      if (!this.world.isRemote && result.getType() == RayTraceResult.Type.BLOCK) {
//		         if (livingentity instanceof ServerPlayerEntity) {
//		            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)livingentity;
//		               net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(serverplayerentity, this.posX, this.posY, this.posZ, 5.0F);
//		               if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size
//		            if (serverplayerentity.connection.getNetworkManager().isChannelOpen() && serverplayerentity.world == this.world && !serverplayerentity.isSleeping()) {
//		               if (livingentity.isPassenger()) {
//		                  livingentity.stopRiding();
//		               }
//		               PlayerEntity playerIn = (PlayerEntity) livingentity.getEntity();
//		               if (!playerIn.abilities.isCreativeMode) {
//		               ((ServerPlayerEntity) livingentity).addItemStackToInventory(new ItemStack(IAFItems.FABRIC_NET));
//		               }
//		               }
//		            }
//		         } else if (livingentity != null) {
//		            livingentity.setPositionAndUpdate(this.posX, this.posY, this.posZ);
//		            livingentity.fallDistance = 0.0F;
//		         }
//
//		         this.remove();
//		      }
//
//	   }
//
//	   public void tick() {
//	      LivingEntity livingentity = this.getThrower();
//	      if (livingentity != null && livingentity instanceof PlayerEntity && !livingentity.isAlive()) {
//	         this.remove();
//	      } else {
//	         super.tick();
//	      }
//
//	   }
//	   
//	   @Nullable
//	   public Entity changeDimension(DimensionType destination) {
//	      if (this.owner.dimension != destination) {
//	         this.owner = null;
//	      }
//
//	      return super.changeDimension(destination);
//	   }
//}
