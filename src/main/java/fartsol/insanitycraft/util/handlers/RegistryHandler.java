package fartsol.insanitycraft.util.handlers;

import fartsol.insanitycraft.init.ModBlocks;
import fartsol.insanitycraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		ModBlocks.init();
		ModBlocks.register(event.getRegistry());
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		ModItems.init();
		ModBlocks.registerItemBlocks(event.getRegistry());
		ModItems.register(event.getRegistry());
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		ModItems.registerModels();
		ModBlocks.registerModels();
	}
}
