package com.flums.iamfloor;

import com.flums.iamfloor.registry.IAFItemGroup;
import com.flums.iamfloor.util.Reference;

import net.minecraft.item.ItemGroup;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Reference.MODID)
public class Main
{
    public static Main instance;
//    public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final ItemGroup IAMFLOOR_GROUP = new IAFItemGroup();
	public static final DamageSource UNSTABLE_FABRIC = new DamageSource("unstable_fabric");
	
    public Main()
    {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
    }
    
    private void setupCommon(final FMLCommonSetupEvent event)
    {
//        proxy.preInit();
//        ArachnonEntity.addSpawn();
    }
    
}