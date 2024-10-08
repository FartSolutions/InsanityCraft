package fartsol.insanitycraft.blocks;

import fartsol.insanitycraft.init.ModItems;
import fartsol.insanitycraft.tileentity.RotatingTileEntity;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KebabGrillBlock extends BlockBase implements ITileEntityProvider
{
	public static final PropertyBool HAS_SKEWER = PropertyBool.create("has_skewer");

	public KebabGrillBlock()
	{
		super("kebab_grill", Material.IRON);
		this.setHardness(2.f);
		this.setResistance(10.f);
		this.setDefaultState(this.blockState.getBaseState().withProperty(HAS_SKEWER, false));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new RotatingTileEntity();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack heldItem = player.getHeldItem(hand);

		if (!world.isRemote) {
			boolean hasSkewer = state.getValue(HAS_SKEWER);

			if (!hasSkewer & heldItem.getItem() == ModItems.KEBAB_SKEWER) {
				world.setBlockState(pos, state.withProperty(HAS_SKEWER, true));

				if (!player.isCreative()) {
					heldItem.shrink(1);
				}

				return true;
			} else if (hasSkewer) {
				world.setBlockState(pos, state.withProperty(HAS_SKEWER, false));
				ItemStack skewerItem = new ItemStack(ModItems.KEBAB_SKEWER);
				spawnAsEntity(world, pos, skewerItem);

				return true;
			}
		}

		return true;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, HAS_SKEWER);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(HAS_SKEWER, meta == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(HAS_SKEWER) ? 1 : 0;
	}
}
