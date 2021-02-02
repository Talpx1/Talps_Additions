package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.item.*;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    //DefReg per Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // registrazione Items
    public static final RegistryObject<Item> moles_nose = ITEMS.register("moles_nose", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard_ore_item = ITEMS.register("shiny_shard_ore", () -> new BlockItem(ModBlocks.shiny_shard_ore.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard_block_item = ITEMS.register("shiny_shard_block", () -> new BlockItem(ModBlocks.shiny_shard_block.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard = ITEMS.register("shiny_shard", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard_dust = ITEMS.register("shiny_shard_dust", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> mole_hide = ITEMS.register("mole_hide", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> heap_of_dirt_item = ITEMS.register("heap_of_dirt", () -> new BlockItem(ModBlocks.heap_of_dirt.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> floreal_vines_item = ITEMS.register("floreal_vines", () -> new BlockItem(ModBlocks.floreal_vines.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> floreal_decoration_item = ITEMS.register("floreal_decoration", () -> new BlockItem(ModBlocks.floreal_decoration.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> petal = ITEMS.register("petal", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> bush_leaf = ITEMS.register("bush_leaf", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> bush_sprout = ITEMS.register("bush_sprout", () -> new BlockNamedItem(ModBlocks.normal_bush.get(),(new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> white_hydrangea_sprout = ITEMS.register("white_hydrangea_sprout", () -> new BlockNamedItem(ModBlocks.white_hydrangea.get(),(new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> red_hydrangea_sprout = ITEMS.register("red_hydrangea_sprout", () -> new BlockNamedItem(ModBlocks.red_hydrangea.get(),(new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> pink_hydrangea_sprout = ITEMS.register("pink_hydrangea_sprout", () -> new BlockNamedItem(ModBlocks.pink_hydrangea.get(),(new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> lilac_hydrangea_sprout = ITEMS.register("lilac_hydrangea_sprout", () -> new BlockNamedItem(ModBlocks.lilac_hydrangea.get(),(new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> blue_hydrangea_sprout = ITEMS.register("blue_hydrangea_sprout", () -> new BlockNamedItem(ModBlocks.blue_hydrangea.get(),(new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<TallBlockItem> orange_rose_item = ITEMS.register("orange_rose_item",()->(new TallBlockItem(ModBlocks.orange_rose.get(), (new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> yellow_rose_item = ITEMS.register("yellow_rose_item",()->(new TallBlockItem(ModBlocks.yellow_rose.get(), (new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> green_rose_item = ITEMS.register("green_rose_item",()->(new TallBlockItem(ModBlocks.green_rose.get(), (new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> multicolor_rose_item = ITEMS.register("multicolor_rose_item",()->(new TallBlockItem(ModBlocks.multicolor_rose.get(), (new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> purple_rose_item = ITEMS.register("purple_rose_item",()->(new TallBlockItem(ModBlocks.purple_rose.get(), (new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<Item> basket_item = ITEMS.register("basket_item", () -> new BlockItem(ModBlocks.basket.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_blue_flowers_item = ITEMS.register("basket_of_blue_flowers_item", () -> new BlockItem(ModBlocks.basket_of_blue_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_green_flowers_item = ITEMS.register("basket_of_green_flowers_item", () -> new BlockItem(ModBlocks.basket_of_green_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_light_blue_flowers_item = ITEMS.register("basket_of_light_blue_flowers_item", () -> new BlockItem(ModBlocks.basket_of_light_blue_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_magenta_flowers_item = ITEMS.register("basket_of_magenta_flowers_item", () -> new BlockItem(ModBlocks.basket_of_magenta_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_multicolor_flowers_item = ITEMS.register("basket_of_multicolor_flowers_item", () -> new BlockItem(ModBlocks.basket_of_multicolor_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_orange_flowers_item = ITEMS.register("basket_of_orange_flowers_item", () -> new BlockItem(ModBlocks.basket_of_orange_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_pink_flowers_item = ITEMS.register("basket_of_pink_flowers_item", () -> new BlockItem(ModBlocks.basket_of_pink_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_purple_flowers_item = ITEMS.register("basket_of_purple_flowers_item", () -> new BlockItem(ModBlocks.basket_of_purple_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_red_flowers_item = ITEMS.register("basket_of_red_flowers_item", () -> new BlockItem(ModBlocks.basket_of_red_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_yellow_flowers_item = ITEMS.register("basket_of_yellow_flowers_item", () -> new BlockItem(ModBlocks.basket_of_yellow_flowers.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> gen_lab_item = ITEMS.register("gen_lab_item", () -> new BlockItem(ModBlocks.gen_lab_block.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> vegetal_gen_modifier = ITEMS.register("vegetal_gene_modifier", ()-> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> animal_gen_modifier = ITEMS.register("animal_gene_modifier", ()-> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> sheep_gene = ITEMS.register("sheep_gene", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> chicken_gene = ITEMS.register("chicken_gene", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> vine_gene = ITEMS.register("vine_gene", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> bush_gene = ITEMS.register("bush_gene", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_pebble_item = ITEMS.register("shiny_pebble_item", () -> new BlockItem(ModBlocks.shiny_pebble.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> cauldron_with_acid_item = ITEMS.register("cauldron_with_acid_item", () -> new BlockItem(ModBlocks.cauldron_with_acid.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> vegetal_dna_helix = ITEMS.register("vegetal_dna_helix", ()-> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> animal_dna_helix = ITEMS.register("animal_dna_helix", ()-> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BottleOfAcidItem> bottle_of_acid = ITEMS.register("bottle_of_acid", ()-> new BottleOfAcidItem(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> bat_eardrum = ITEMS.register("bat_eardrum",()->new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> mysterious_sensory_organ = ITEMS.register("mysterious_sensory_organ",()->new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> frosted_vines_item = ITEMS.register("frosted_vines", () -> new BlockItem(ModBlocks.frosted_vines.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> fancy_stick = ITEMS.register("fancy_stick", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> coconut_item = ITEMS.register("coconut_item", () -> new BlockItem(ModBlocks.coconut_block.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<LilyPadItem> flowery_water_lily_item = ITEMS.register("flowery_water_lily_item", () -> new LilyPadItem(ModBlocks.flowery_water_lily.get(), new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> strong_string = ITEMS.register("strong_string", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> dolphin_fin = ITEMS.register("dolphin_fin", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> fancy_bowl = ITEMS.register("fancy_bowl", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> yetis_tooth = ITEMS.register("yetis_tooth", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_gem = ITEMS.register("shiny_gem", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    //tools
    public static final RegistryObject<MortarAndPestleItem> mortar_and_pestle = ITEMS.register("mortar_and_pestle", () -> new MortarAndPestleItem(1,1,new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(1).maxDamage(64)));
    public static final RegistryObject<GeneCollectorItem> gene_collector = ITEMS.register("gene_collector", ()-> new GeneCollectorItem(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BedrockCutterItem> bedrock_cutter = ITEMS.register("bedrock_cutter", ()-> new BedrockCutterItem(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<ModFishingRodItem> reinforced_fishing_rod = ITEMS.register("reinforced_fishing_rod", ()-> new ModFishingRodItem(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(1).maxDamage(350), 2));
    public static final RegistryObject<ModFishingRodItem> robust_fishing_rod = ITEMS.register("robust_fishing_rod", ()-> new ModFishingRodItem(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(1).maxDamage(1000), 4));
    public static final RegistryObject<MortarAndPestleItem> fancy_mortar_and_pestle = ITEMS.register("fancy_mortar_and_pestle", () -> new MortarAndPestleItem(2,2,new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(1).maxDamage(300)));
    //foods
    public static final RegistryObject<BlockNamedItem> blue_berries = ITEMS.register("blue_berries", () -> new BlockNamedItem(ModBlocks.blue_berry_bush.get(), (new Item.Properties()).group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair().food(new Food.Builder().hunger(2).saturation(0.1F).build())));
    public static final RegistryObject<Item> earth_worm = ITEMS.register("earth_worm", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().meat().saturation(0.7f).hunger(1).effect(new EffectInstance(Effects.NAUSEA,200,1),1).build())));
    public static final RegistryObject<Item> cooked_earth_worm = ITEMS.register("cooked_earth_worm", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().meat().saturation(1.5f).hunger(2).build())));
    public static final RegistryObject<Item> piece_of_coconut = ITEMS.register("piece_of_coconut", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().hunger(2).saturation(0.3F).build())));
    public static final RegistryObject<Item> yetis_icecream = ITEMS.register("yetis_icecream", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().hunger(1).saturation(0.1f).build())));
    public static final RegistryObject<Item> golden_mushroom = ITEMS.register("golden_mushroom", () -> new Item(new Item.Properties().group(Main.CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().hunger(6).saturation(1.2F).build())));
}
