package iceheart.archeology.core.init;

import iceheart.archeology.Archeology;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Archeology.MOD_ID);

    public static final RegistryObject<Item> BRUSH = ITEMS.register("brush",
            () -> new Item(new Item.Properties().maxDamage(2000).group(ModItemGroup.ARCHEOLOGY)));

    //BlockItems
    public static final RegistryObject<BlockItem> COPPER_ORE = ITEMS.register("copper_ore",
            () -> new BlockItem(BlockInit.COPPER_ORE.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));
    public static final RegistryObject<BlockItem> LIGHTNING_ROD = ITEMS.register("lightning_rod",
            () -> new BlockItem(BlockInit.LIGHTNING_ROD.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));
    public static final RegistryObject<BlockItem> OLD_GRAVEL = ITEMS.register("old_gravel",
            () -> new BlockItem(BlockInit.OLD_GRAVEL.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));

    // Copper Mainia
    public static final RegistryObject<BlockItem> COPPER_BLOCK = ITEMS.register("copper_block",
            () -> new BlockItem(BlockInit.COPPER_BLOCK.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));
    public static final RegistryObject<BlockItem> SLIGHTLY_WEATHERED_COPPER_BLOCK = ITEMS.register("slightly_weathered_copper_block",
            () -> new BlockItem(BlockInit.SLIGHTLY_WEATHERED_COPPER_BLOCK.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));

    public static final RegistryObject<BlockItem> WAXED_COPPER_BLOCK = ITEMS.register("waxed_copper_block",
            () -> new BlockItem(BlockInit.WAXED_COPPER_BLOCK.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));
    public static final RegistryObject<BlockItem> WAXED_SLIGHTLY_WEATHERED_COPPER_BLOCK = ITEMS.register("waxed_slightly_weathered_copper_block",
            () -> new BlockItem(BlockInit.WAXED_SLIGHTLY_WEATHERED_COPPER_BLOCK.get(), new Item.Properties().group(ModItemGroup.ARCHEOLOGY)));
}
