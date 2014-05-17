package sobiohazardous.mods.ec.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockM
{
	public Block	block;
	public int		metadata;
	
	public BlockM(Block block, int metadata)
	{
		this.block = block;
		this.metadata = metadata;
	}
	
	public void set(World world, int x, int y, int z)
	{
		world.setBlock(x, y, z, this.block, this.metadata, 3);
	}
	
	@Override
	public int hashCode()
	{
		return Block.getIdFromBlock(this.block) | this.metadata << 12;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BlockM))
			return false;
		BlockM other = (BlockM) obj;
		return this.equals(other.block, other.metadata);
	}
	
	public boolean equals(Block block, int metadata)
	{
		return this.block == block && this.metadata == metadata;
	}
}