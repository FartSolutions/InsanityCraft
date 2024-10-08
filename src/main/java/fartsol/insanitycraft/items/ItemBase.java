package fartsol.insanitycraft.items;

import fartsol.insanitycraft.InsanityCraft;
import fartsol.insanitycraft.init.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(InsanityCraft.InsanityCraftTab);
		
		ModItems.ITEMS.add(this);
	}
	
	public void registerModels()
	{
		InsanityCraft.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
