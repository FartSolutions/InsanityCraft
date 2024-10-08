package fartsol.insanitycraft.init;

import java.util.ArrayList;
import java.util.List;
import fartsol.insanitycraft.blocks.BlockBase;
import fartsol.insanitycraft.blocks.KebabGrillBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static KebabGrillBlock KEBAB_GRILL;
	
	public static void init()
	{
		KEBAB_GRILL = new KebabGrillBlock();
	}
	
	public static void register(IForgeRegistry<Block> registry)
	{
		registry.registerAll(BLOCKS.toArray(new Block[0]));
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry)
	{
		for (Block block : BLOCKS) {
			registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	}
	
	public static void registerModels()
	{
		for (Block block : BLOCKS) {
			if (block instanceof BlockBase) {
				((BlockBase)block).registerModels();
			}
		}
	}
}
