package sobiohazardous.mods.ec.cavetype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveType
{
	public static List<CaveType>	caveTypes	= new ArrayList();
	
	public static CaveType			ice			= new CaveTypeIce("ice").setBlock(ECBlocks.glacierRock);
	public static CaveType			ocean		= new CaveTypeOcean("ocean");
	
	public final String				name;
	public Block					block;
	public int						blockMetadata;
	
	public BiomeGenBase				biome;
	
	protected WorldGenerator		wallGen;
	
	protected int					spawnHeight = 64;
	
	public CaveType(String name)
	{
		this.name = name;
		caveTypes.add(this);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public CaveType setBlock(Block block)
	{
		this.block = block;
		return this;
	}
	
	public CaveType setBlockMetadata(int blockMetadata)
	{
		this.blockMetadata = blockMetadata;
		return this;
	}
	
	public CaveType setBiome(BiomeGenBase biome)
	{
		this.biome = biome;
		return this;
	}
	
	public boolean canGenerateAt(World world, int x, int z)
	{
		return this.canGenerateInBiome(world.getBiomeGenForCoords(x, z));
	}
	
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return this.biome == null || this.biome == biome;
	}
	
	public CaveType setSpawnHeight(int height)
	{
		this.spawnHeight = height;
		return this;
	}
	
	public void generate(World world, Random random, int x, int z)
	{
		int y = spawnHeight;
		
		boolean wasAir = true;
		while (y >= 0)
		{
			try
			{
				boolean isAir = world.isAirBlock(x, y, z);
				if (isAir)
				{
					if (!wasAir)
					{
						this.generateCeiling(world, random, x, y + 1, z);
					}
					
					this.generate(world, random, x, y - 3, z);
				}
				else if (wasAir)
				{
					this.generate(world, random, x, y + 3, z);
					this.generateFloor(world, random, x, y, z);
				}
				wasAir = isAir;
			}
			catch (Exception ex)
			{
				System.err.println("Cave Gen Error");
			}
			y--;
		}
	}
	
	public void generate(World world, Random random, int x, int y, int z)
	{
		if (this.wallGen == null)
		{
			this.wallGen = new WorldGenMinable(this.block, this.blockMetadata, 16, Blocks.stone);
		}
		this.wallGen.generate(world, random, x, y, z);
	}
	
	public void generateCeiling(World world, Random random, int x, int y, int z)
	{
		// world.setBlock(x, y, z, this.block, this.blockMetadata, 3);
	}
	
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		// world.setBlock(x, y, z, this.block, this.blockMetadata, 3);
	}
}