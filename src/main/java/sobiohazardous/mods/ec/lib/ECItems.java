package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.item.*;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ECItems
{
	public static ToolMaterial	materialFreezium	= EnumHelper.addToolMaterial("freezium", 3, 1561, 7.0F, 3.0F, 13);
	
	public static ArmorMaterial	armorFreezium		= EnumHelper.addArmorMaterial("freezium", 480, new int[] { 11, 13, 12, 11 }, 11);
	
	public static Item			gems;
	public static Item			shards;
	
	public static Item			bucketIceFloe;
	
	public static Item			swordFreezium;
	public static Item			shovelFreezium;
	public static Item			pickaxeFreezium;
	public static Item			axeFreezium;
	public static Item			hoeFreezium;
	
	public static Item			helmetFreezium;
	public static Item			chestplateFreezium;
	public static Item			leggingsFreezium;
	public static Item			bootsFreezium;
	
	public static void init()
	{
		gems = new ItemGems().setTextureName(ECReference.getTexture("gem"));
		shards = new ItemShards().setTextureName(ECReference.getTexture("shard"));
		
		bucketIceFloe = new ECItemBucket(ECBlocks.iceFloe).setTextureName(ECReference.getTexture("bucket_ice_floe"));
		
		swordFreezium = new ECItemSword(materialFreezium).setTextureName(ECReference.getTexture("ice_sword"));
		shovelFreezium = new ECItemShovel(materialFreezium).setTextureName(ECReference.getTexture("ice_shovel"));
		pickaxeFreezium = new ECItemPickaxe(materialFreezium).setTextureName(ECReference.getTexture("ice_pickaxe"));
		axeFreezium = new ECItemAxe(materialFreezium).setTextureName(ECReference.getTexture("ice_axe"));
		hoeFreezium = new ECItemHoe(materialFreezium).setTextureName(ECReference.getTexture("ice_hoe"));
		
		helmetFreezium = new ECItemArmor(armorFreezium, ECCommonProxy.freezium, 0, "ice").setTextureName(ECReference.getTexture("ice_helmet"));
		chestplateFreezium = new ECItemArmor(armorFreezium, ECCommonProxy.freezium, 1, "ice").setTextureName(ECReference.getTexture("ice_chestplate"));
		leggingsFreezium = new ECItemArmor(armorFreezium, ECCommonProxy.freezium, 2, "ice").setTextureName(ECReference.getTexture("ice_leggings"));
		bootsFreezium = new ECItemArmor(armorFreezium, ECCommonProxy.freezium, 3, "ice").setTextureName(ECReference.getTexture("ice_boots"));
		
		addItem(gems, "elemental_gems");
		addItem(shards, "elemental_shards");
		
		addItem(bucketIceFloe, "bucket_ice_floe");
		
		addItem(swordFreezium, "ice_sword");
		addItem(shovelFreezium, "ice_shovel");
		addItem(pickaxeFreezium, "ice_pickaxe");
		addItem(axeFreezium, "ice_axe");
		addItem(hoeFreezium, "ice_hoe");
		
		addItem(helmetFreezium, "ice_helmet");
		addItem(chestplateFreezium, "ice_chestplate");
		addItem(leggingsFreezium, "ice_leggings");
		addItem(bootsFreezium, "ice_boots");
	}
	
	public static void addItem(Item item, String name)
	{
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
	}
}
