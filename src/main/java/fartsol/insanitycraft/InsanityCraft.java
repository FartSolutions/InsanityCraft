package fartsol.insanitycraft;

import fartsol.insanitycraft.handlers.ClientEventHandler;
import fartsol.insanitycraft.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import fartsol.insanitycraft.tabs.InsanityCraftTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = InsanityCraft.MODID, name = InsanityCraft.NAME, version = InsanityCraft.VERSION)
public class InsanityCraft
{
    public static final String MODID = "insanitycraft";
    public static final String NAME = "InsanityCraft";
    public static final String VERSION = "1.0.0";
    public static final String PROXY_CLIENT = "fartsol.insanitycraft.proxy.ClientProxy";
    public static final String PROXY_COMMON = "fartsol.insanitycraft.proxy.CommonProxy";

    @Mod.Instance
    public static InsanityCraft instance;
    
    @SidedProxy(clientSide = PROXY_CLIENT, serverSide = PROXY_COMMON)
    public static CommonProxy proxy;
    
    public static final CreativeTabs InsanityCraftTab = new InsanityCraftTab(MODID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
    
    @EventHandler
    public void serverInit(FMLServerStartingEvent event)
    {
    }
}
