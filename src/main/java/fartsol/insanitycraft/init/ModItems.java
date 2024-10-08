package fartsol.insanitycraft.init;

import java.util.ArrayList;
import java.util.List;
import fartsol.insanitycraft.items.ItemBase;
import fartsol.insanitycraft.items.KebabSkewerItem;
import fartsol.insanitycraft.tileentity.RotatingTileEntity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static KebabSkewerItem KEBAB_SKEWER;
	public static Item KEBAB_SKEWER_VILLAGER;
	
	@SuppressWarnings("deprecation")
	public static void init()
	{
		KEBAB_SKEWER = new KebabSkewerItem();
		KEBAB_SKEWER_VILLAGER = new ItemBase("kebab_skewer_villager");
		GameRegistry.registerTileEntity(RotatingTileEntity.class, "rotating_tile_entity");
	}
	
	public static void register(IForgeRegistry<Item> registry)
	{
		registry.registerAll(ITEMS.toArray(new Item[0]));
	}
	
	public static void registerModels()
	{
		for (Item item : ITEMS) {
			if (item instanceof ItemBase) {
				((ItemBase)item).registerModels();
			}
		}
	}
}
