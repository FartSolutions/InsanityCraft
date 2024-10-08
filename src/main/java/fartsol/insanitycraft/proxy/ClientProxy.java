package fartsol.insanitycraft.proxy;

import fartsol.insanitycraft.init.ModBlocks;
import fartsol.insanitycraft.init.ModItems;
import fartsol.insanitycraft.renderer.RotatingTileEntityRenderer;
import fartsol.insanitycraft.tileentity.RotatingTileEntity;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void init()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(RotatingTileEntity.class, new RotatingTileEntityRenderer());
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(
				item,
				meta,
				new ModelResourceLocation(item.getRegistryName(), id)
			);
	}
	
	@Override
	public void registerModels()
	{
		ModItems.registerModels();
		ModBlocks.registerModels();
	}
}
