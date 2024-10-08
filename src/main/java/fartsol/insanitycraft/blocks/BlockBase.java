package fartsol.insanitycraft.blocks;

import fartsol.insanitycraft.InsanityCraft;
import fartsol.insanitycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(InsanityCraft.InsanityCraftTab);
		
		ModBlocks.BLOCKS.add(this);
	}
	
	public void registerModels()
	{
		InsanityCraft.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
