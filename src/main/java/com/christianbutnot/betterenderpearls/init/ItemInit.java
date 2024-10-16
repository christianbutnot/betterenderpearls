package com.christianbutnot.betterenderpearls.init;

import com.christianbutnot.betterenderpearls.Main;
import com.christianbutnot.betterenderpearls.items.pearls.AdvancedPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.CreativePearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.DarkenedPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.DeepestPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.EnergizedPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.EnrichedPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.ExpensivePearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.ImmortalPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.NetherPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.TechnicalPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.WardedPearlItem;
import com.christianbutnot.justanotherlibrarymod.common.item.ItemTypes.ResourceItem;
import com.christianbutnot.justanotherlibrarymod.common.item.ItemTypes.UtilityItem;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);

	// resources
	public static final DeferredItem<Item> ERADIUM_SHARD = ITEMS.register("eradium_shard",
			() -> new ResourceItem(new Item.Properties()));
	public static final DeferredItem<Item> ERADIUM = ITEMS.register("eradium",
			() -> new ResourceItem(new Item.Properties()));
	public static final DeferredItem<Item> ERADIUM_CLUSTER = ITEMS.register("eradium_cluster",
			() -> new ResourceItem(new Item.Properties()));

	// objects
	public static final DeferredItem<Item> AUTONOMOUS_FRAME = ITEMS.register("autonomous_frame",
			() -> new UtilityItem(new Item.Properties()));

	// pearls
	// nether pearl (effective TIER 1)
	public static final DeferredItem<Item> NETHER_PEARL = ITEMS.register("nether_pearl",
			() -> new NetherPearlItem(new Item.Properties().stacksTo(1).durability(4)));
	// iron pearl
	public static final DeferredItem<Item> TECHNICAL_ENDERPEARL = ITEMS.register("technical_enderpearl",
			() -> new TechnicalPearlItem(new Item.Properties().stacksTo(1).durability(8)));
	// GOLD pearl
	public static final DeferredItem<Item> ADVANCED_ENDERPEARL = ITEMS.register("advanced_enderpearl",
			() -> new AdvancedPearlItem(new Item.Properties().stacksTo(1).durability(12)));
	// diamond pearl
	public static final DeferredItem<Item> ENRICHED_ENDERPEARL = ITEMS.register("enriched_enderpearl",
			() -> new EnrichedPearlItem(new Item.Properties().stacksTo(1).durability(24)));
	// emerald pearl
	public static final DeferredItem<Item> EXPENSIVE_ENDERPEARL = ITEMS.register("expensive_enderpearl",
			() -> new ExpensivePearlItem(new Item.Properties().stacksTo(1).durability(32)));
	// energized pearl
	public static final DeferredItem<Item> ENERGIZED_ENDERPEARL = ITEMS.register("energized_enderpearl",
			() -> new EnergizedPearlItem(new Item.Properties().stacksTo(1).durability(48)));
	// ender ender pearl
	public static final DeferredItem<Item> IMMORTAL_ENDERPEARL = ITEMS.register("immortal_enderpearl",
			() -> new ImmortalPearlItem(new Item.Properties().stacksTo(1).durability(64)));
	// creative pearl
	public static final DeferredItem<Item> CREATIVE_ENDERPEARL = ITEMS.register("creative_enderpearl",
			() -> new CreativePearlItem(new Item.Properties().stacksTo(1)));
	
	//special pearls
	public static final DeferredItem<Item> DARKENED_ENDERPEARL = ITEMS.register("darkened_enderpearl",
			() -> new DarkenedPearlItem(new Item.Properties().stacksTo(1).durability(8)));
	public static final DeferredItem<Item> DEEPEST_ENDERPEARL = ITEMS.register("deepest_enderpearl",
			() -> new DeepestPearlItem(new Item.Properties().stacksTo(1).durability(15)));
	public static final DeferredItem<Item> WARDED_ENDERPEARL = ITEMS.register("warded_enderpearl",
			() -> new WardedPearlItem(new Item.Properties().stacksTo(1).durability(23)));

	// creative eye WIP
	// public static final DeferredItem<Item> CREATIVE_ENDER_EYE =
	// ITEMS.register("creative_ender_eye",
	// () -> new CreativeEyeItem(
	// new Item.Properties().stacksTo(1)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}