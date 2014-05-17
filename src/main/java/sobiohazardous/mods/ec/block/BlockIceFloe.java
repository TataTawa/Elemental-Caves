package sobiohazardous.mods.ec.block;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class BlockIceFloe extends BlockFluidClassic
{
	private IIcon flowingIcon;
	
	public BlockIceFloe()
	{
		super(ElementalCaves.iceFloe, Material.water);
		ElementalCaves.iceFloe.setBlock(this);
		this.disableStats();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(ECReference.getTexture("icefloe_still"));
		this.flowingIcon = iconRegister.registerIcon(ECReference.getTexture("icefloe_flowing"));
	}
	
    @Override public Fluid getFluid()
    { 
    	return ElementalCaves.iceFloe; 
    }

	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return (side == 0 || side == 1)? this.blockIcon : flowingIcon;
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.flowing_water)
		{
			world.setBlock(x, y, z, Blocks.snow);
		}
		else if (block == Blocks.water)
		{
			world.setBlock(x, y, z, Blocks.ice);
		}
		else if (block == Blocks.flowing_lava)
		{
			world.setBlock(x, y, z, ECBlocks.glacierRock, 1, 3);
		}
		else if (block == Blocks.lava)
		{
			world.setBlock(x, y, z, Blocks.obsidian);
		}
		return super.displaceIfPossible(world, x, y, z);
	}
}
