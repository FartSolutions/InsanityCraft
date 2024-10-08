package fartsol.insanitycraft.tabs;

import fartsol.insanitycraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class InsanityCraftTab extends CreativeTabs
{
	public InsanityCraftTab(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.KEBAB_SKEWER);
	}
}
