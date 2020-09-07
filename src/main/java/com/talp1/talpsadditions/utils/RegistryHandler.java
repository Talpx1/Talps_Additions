package com.talp1.talpsadditions.utils;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.block.*;
import com.talp1.talpsadditions.container.GenLabContainer;
import com.talp1.talpsadditions.effect.SensesEffect;
import com.talp1.talpsadditions.entity.MoleEntity.MoleEntity;
import com.talp1.talpsadditions.entity.MoleEntity.MoleRenderer;
import com.talp1.talpsadditions.entity.ResourceChicken.ResourceChickenEntity;
import com.talp1.talpsadditions.entity.ResourceChicken.renderer.*;
import com.talp1.talpsadditions.entity.ResourceChicken.type.*;
import com.talp1.talpsadditions.entity.ResourceSheep.ResourceSheepEntity;
import com.talp1.talpsadditions.entity.ResourceSheep.renderer.*;
import com.talp1.talpsadditions.entity.ResourceSheep.types.*;
import com.talp1.talpsadditions.gui.CustomItemGroup;
import com.talp1.talpsadditions.gui.GenLabScreen;
import com.talp1.talpsadditions.item.BottleOfAcidItem;
import com.talp1.talpsadditions.item.GeneCollectorItem;
import com.talp1.talpsadditions.item.MortarAndPestleItem;
import com.talp1.talpsadditions.tile_entity.GenLabTE;
import com.talp1.talpsadditions.world.features.FlorealVineFeature;
import com.talp1.talpsadditions.world.features.FrostedVineFeature;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RegistryHandler {
    //DefReg per Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    //DefReg per Potions
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Main.MODID);
    //DefReg per Effects
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Main.MODID);
    //DefReg per Blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
    //DefReg per Blocks
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MODID);
    //DefReg per Tile Entities
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MODID);
    //DefReg per Entities
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);
    //DefReg per Features
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Main.MODID);
    //DefReg per Sounds
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MODID);
    //Mod Item Group Instance
    public static final CustomItemGroup CUSTOM_ITEM_GROUP = new CustomItemGroup("talpsadditions", "item_search.png");

    public static void init() {
        //Registrazione DefRegs nel bus eventi
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // registrazione blocchi
    public static final RegistryObject<Block> shiny_shard_ore = BLOCKS.register("shiny_shard_ore", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> shiny_shard_block = BLOCKS.register("shiny_shard_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<BlueBerryBushBlock> blue_berry_bush = BLOCKS.register("blue_berry_bush", () -> new BlueBerryBushBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<HeapOfDirtBlock> heap_of_dirt = BLOCKS.register("heap_of_dirt", () -> new HeapOfDirtBlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(1.0f, 1.0f).sound(SoundType.WET_GRASS).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<VineBlock> floreal_vines = BLOCKS.register("floreal_vines", () -> new VineBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2F).sound(SoundType.VINE)));
    public static final RegistryObject<FlorealDecorationBlock> floreal_decoration = BLOCKS.register("floreal_decoration", () -> new FlorealDecorationBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0.2F).sound(SoundType.VINE)));
    public static final RegistryObject<NormalBushBlock> normal_bush = BLOCKS.register("normal_bush", () -> new NormalBushBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<WhiteHydrangeaBlock> white_hydrangea = BLOCKS.register("white_hydrangea", () -> new WhiteHydrangeaBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<RedHydrangeaBlock> red_hydrangea = BLOCKS.register("red_hydrangea", () -> new RedHydrangeaBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<PinkHydrangeaBlock> pink_hydrangea = BLOCKS.register("pink_hydrangea", () -> new PinkHydrangeaBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<LilacHydrangeaBlock> lilac_hydrangea = BLOCKS.register("lilac_hydrangea", () -> new LilacHydrangeaBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<BlueHydrangeaBlock> blue_hydrangea = BLOCKS.register("blue_hydrangea", () -> new BlueHydrangeaBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<TallFlowerBlock> orange_rose = BLOCKS.register("orange_rose", () -> new TallFlowerBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<TallFlowerBlock> yellow_rose = BLOCKS.register("yellow_rose", () -> new TallFlowerBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<TallFlowerBlock> green_rose = BLOCKS.register("green_rose", () -> new TallFlowerBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<TallFlowerBlock> multicolor_rose = BLOCKS.register("multicolor_rose", () -> new TallFlowerBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<TallFlowerBlock> purple_rose = BLOCKS.register("purple_rose", () -> new TallFlowerBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.PLANT)));
    public static final RegistryObject<BasketBlock> basket = BLOCKS.register("basket", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_orange_flowers = BLOCKS.register("basket_of_orange_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_blue_flowers = BLOCKS.register("basket_of_blue_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_green_flowers = BLOCKS.register("basket_of_green_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_light_blue_flowers = BLOCKS.register("basket_of_light_blue_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_magenta_flowers = BLOCKS.register("basket_of_magenta_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_multicolor_flowers = BLOCKS.register("basket_of_multicolor_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_pink_flowers = BLOCKS.register("basket_of_pink_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_purple_flowers = BLOCKS.register("basket_of_purple_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_red_flowers = BLOCKS.register("basket_of_red_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<BasketBlock> basket_of_yellow_flowers = BLOCKS.register("basket_of_yellow_flowers", () -> new BasketBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().sound(SoundType.CROP)));
    public static final RegistryObject<GenLabBlock> gen_lab_block = BLOCKS.register("gen_lab_block", () -> new GenLabBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<ShinyPebbleBlock> shiny_pebble = BLOCKS.register("shiny_pebble", () -> new ShinyPebbleBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<CauldronWithAcid> cauldron_with_acid = BLOCKS.register("cauldron_with_acid", () -> new CauldronWithAcid(AbstractBlock.Properties.create(Material.IRON, MaterialColor.STONE).setRequiresTool().hardnessAndResistance(2.0F).notSolid()));
    public static final RegistryObject<VineBlock> frosted_vines = BLOCKS.register("frosted_vines", () -> new VineBlock(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2F).sound(SoundType.VINE)));

    //tile entities
    public static final RegistryObject<TileEntityType<GenLabTE>> gen_lab_te = TILE_ENTITIES.register("gen_lab_te", () -> TileEntityType.Builder.create(GenLabTE::new, RegistryHandler.gen_lab_block.get()).build(null));

    //containers
    public static final RegistryObject<ContainerType<GenLabContainer>> gen_lab_container = CONTAINERS.register("gen_lab_container", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new GenLabContainer(windowId, world, pos, inv, inv.player);
    }));

    // registrazione Items
    public static final RegistryObject<Item> moles_nose = ITEMS.register("moles_nose", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard_ore_item = ITEMS.register("shiny_shard_ore", () -> new BlockItem(shiny_shard_ore.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard_block_item = ITEMS.register("shiny_shard_block", () -> new BlockItem(shiny_shard_block.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard = ITEMS.register("shiny_shard", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_shard_dust = ITEMS.register("shiny_shard_dust", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> mole_hide = ITEMS.register("mole_hide", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> heap_of_dirt_item = ITEMS.register("heap_of_dirt", () -> new BlockItem(heap_of_dirt.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> floreal_vines_item = ITEMS.register("floreal_vines", () -> new BlockItem(floreal_vines.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> floreal_decoration_item = ITEMS.register("floreal_decoration", () -> new BlockItem(floreal_decoration.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> petal = ITEMS.register("petal", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> bush_leaf = ITEMS.register("bush_leaf", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> bush_sprout = ITEMS.register("bush_sprout", () -> new BlockNamedItem(RegistryHandler.normal_bush.get(),(new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> white_hydrangea_sprout = ITEMS.register("white_hydrangea_sprout", () -> new BlockNamedItem(RegistryHandler.white_hydrangea.get(),(new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> red_hydrangea_sprout = ITEMS.register("red_hydrangea_sprout", () -> new BlockNamedItem(RegistryHandler.red_hydrangea.get(),(new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> pink_hydrangea_sprout = ITEMS.register("pink_hydrangea_sprout", () -> new BlockNamedItem(RegistryHandler.pink_hydrangea.get(),(new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> lilac_hydrangea_sprout = ITEMS.register("lilac_hydrangea_sprout", () -> new BlockNamedItem(RegistryHandler.lilac_hydrangea.get(),(new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BlockNamedItem> blue_hydrangea_sprout = ITEMS.register("blue_hydrangea_sprout", () -> new BlockNamedItem(RegistryHandler.blue_hydrangea.get(),(new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<TallBlockItem> orange_rose_item = ITEMS.register("orange_rose_item",()->(new TallBlockItem(RegistryHandler.orange_rose.get(), (new Item.Properties()).group(CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> yellow_rose_item = ITEMS.register("yellow_rose_item",()->(new TallBlockItem(RegistryHandler.yellow_rose.get(), (new Item.Properties()).group(CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> green_rose_item = ITEMS.register("green_rose_item",()->(new TallBlockItem(RegistryHandler.green_rose.get(), (new Item.Properties()).group(CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> multicolor_rose_item = ITEMS.register("multicolor_rose_item",()->(new TallBlockItem(RegistryHandler.multicolor_rose.get(), (new Item.Properties()).group(CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<TallBlockItem> purple_rose_item = ITEMS.register("purple_rose_item",()->(new TallBlockItem(RegistryHandler.purple_rose.get(), (new Item.Properties()).group(CUSTOM_ITEM_GROUP))));
    public static final RegistryObject<Item> basket_item = ITEMS.register("basket_item", () -> new BlockItem(RegistryHandler.basket.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_blue_flowers_item = ITEMS.register("basket_of_blue_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_blue_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_green_flowers_item = ITEMS.register("basket_of_green_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_green_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_light_blue_flowers_item = ITEMS.register("basket_of_light_blue_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_light_blue_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_magenta_flowers_item = ITEMS.register("basket_of_magenta_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_magenta_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_multicolor_flowers_item = ITEMS.register("basket_of_multicolor_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_multicolor_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_orange_flowers_item = ITEMS.register("basket_of_orange_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_orange_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_pink_flowers_item = ITEMS.register("basket_of_pink_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_pink_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_purple_flowers_item = ITEMS.register("basket_of_purple_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_purple_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_red_flowers_item = ITEMS.register("basket_of_red_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_red_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> basket_of_yellow_flowers_item = ITEMS.register("basket_of_yellow_flowers_item", () -> new BlockItem(RegistryHandler.basket_of_yellow_flowers.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> gen_lab_item = ITEMS.register("gen_lab_item", () -> new BlockItem(RegistryHandler.gen_lab_block.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> vegetal_gen_modifier = ITEMS.register("vegetal_gene_modifier", ()-> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> animal_gen_modifier = ITEMS.register("animal_gene_modifier", ()-> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> sheep_gene = ITEMS.register("sheep_gene", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> chicken_gene = ITEMS.register("chicken_gene", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> vine_gene = ITEMS.register("vine_gene", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> bush_gene = ITEMS.register("bush_gene", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> shiny_pebble_item = ITEMS.register("shiny_pebble_item", () -> new BlockItem(RegistryHandler.shiny_pebble.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> cauldron_with_acid_item = ITEMS.register("cauldron_with_acid_item", () -> new BlockItem(RegistryHandler.cauldron_with_acid.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> vegetal_dna_helix = ITEMS.register("vegetal_dna_helix", ()-> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> animal_dna_helix = ITEMS.register("animal_dna_helix", ()-> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<BottleOfAcidItem> bottle_of_acid = ITEMS.register("bottle_of_acid", ()-> new BottleOfAcidItem(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> bat_eardrum = ITEMS.register("bat_eardrum",()->new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> mysterious_sensory_organ = ITEMS.register("mysterious_sensory_organ",()->new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    public static final RegistryObject<Item> frosted_vines_item = ITEMS.register("frosted_vines", () -> new BlockItem(frosted_vines.get(), new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    //tools
    public static final RegistryObject<MortarAndPestleItem> mortar_and_pestle = ITEMS.register("mortar_and_pestle", () -> new MortarAndPestleItem(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(1).maxDamage(64)));
    public static final RegistryObject<GeneCollectorItem> gene_collector = ITEMS.register("gene_collector", ()-> new GeneCollectorItem(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair()));
    //foods
    public static final RegistryObject<BlockNamedItem> blue_berries = ITEMS.register("blue_berries", () -> new BlockNamedItem(RegistryHandler.blue_berry_bush.get(), (new Item.Properties()).group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair().food(new Food.Builder().hunger(2).saturation(0.1F).build())));
    public static final RegistryObject<Item> earth_worm = ITEMS.register("earth_worm", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().meat().saturation(0.7f).hunger(1).effect(new EffectInstance(Effects.NAUSEA,200,1),1).build())));
    public static final RegistryObject<Item> cooked_earth_worm = ITEMS.register("cooked_earth_worm", () -> new Item(new Item.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).food(new Food.Builder().meat().saturation(1.5f).hunger(2).build())));

    //sounds
    public static final RegistryObject<SoundEvent> shiny_ores_sound = SOUNDS.register("shiny_ores", ()->new SoundEvent(new ResourceLocation(Main.MODID, "shiny_ores")));

    //registrazione potions
    public static final RegistryObject<Potion> luck_potion = POTIONS.register("luck_potion", () -> new Potion(new EffectInstance(Effects.LUCK, 6000,2)));
    public static final RegistryObject<Potion> senses_potion = POTIONS.register("senses_potion", () -> new Potion(new EffectInstance(Effects.HASTE, 6000, 0),new EffectInstance(Effects.BLINDNESS, 6000, 3),new EffectInstance(RegistryHandler.senses_effect.get(), 6000)));

    //registrazione effects
    public static final RegistryObject<SensesEffect> senses_effect = EFFECTS.register("senses_effect",()->new SensesEffect(EffectType.NEUTRAL, 0x572e19));


    //registrazione entity
    //mole
    public static final EntityType<MoleEntity> moleBuilder = EntityType.Builder.create(MoleEntity::new, EntityClassification.CREATURE).size(0.65f,0.25f).build(new ResourceLocation(Main.MODID, "mole_entity").toString());
    public static final RegistryObject<EntityType<MoleEntity>> mole_entity = ENTITIES.register("mole_entity", () -> moleBuilder);
    //----------------------------------------------------
    //resource Sheeps
    //coal
    public static final EntityType<CoalResourceSheep> coalSheepBuilder =EntityType.Builder.create(CoalResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "coal_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<CoalResourceSheep>> coal_sheep_entity = ENTITIES.register("coal_resource_sheep_entity", () -> coalSheepBuilder);
    //diamond
    public static final EntityType<DiamondResourceSheep> diamondSheepBuilder =EntityType.Builder.create(DiamondResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "diamond_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<DiamondResourceSheep>> diamond_sheep_entity = ENTITIES.register("diamond_resource_sheep_entity", () ->diamondSheepBuilder);
    //emerald
    public static final EntityType<EmeraldResourceSheep> emeraldSheepBuilder =EntityType.Builder.create(EmeraldResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "emerald_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<EmeraldResourceSheep>> emerald_sheep_entity = ENTITIES.register("emerald_resource_sheep_entity", () -> emeraldSheepBuilder);
    //gold
    public static final EntityType<GoldResourceSheep> goldSheepBuilder =EntityType.Builder.create(GoldResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "gold_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<GoldResourceSheep>> gold_sheep_entity = ENTITIES.register("gold_resource_sheep_entity", () -> goldSheepBuilder);
    //iron
    public static final EntityType<IronResourceSheep> ironSheepBuilder =EntityType.Builder.create(IronResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "iron_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<IronResourceSheep>> iron_sheep_entity = ENTITIES.register("iron_resource_sheep_entity", () -> ironSheepBuilder);
    //lapis
    public static final EntityType<LapisResourceSheep> lapisSheepBuilder =EntityType.Builder.create(LapisResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "lapis_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<LapisResourceSheep>> lapis_sheep_entity = ENTITIES.register("lapis_resource_sheep_entity", () -> lapisSheepBuilder);
    //netherite
    public static final EntityType<NetheriteResourceSheep> netheriteSheepBuilder =EntityType.Builder.create(NetheriteResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "netherite_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<NetheriteResourceSheep>> netherite_sheep_entity = ENTITIES.register("netherite_resource_sheep_entity", () -> netheriteSheepBuilder);
    //quartz
    public static final EntityType<QuartzResourceSheep> quartzSheepBuilder =EntityType.Builder.create(QuartzResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "quartz_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<QuartzResourceSheep>> quartz_sheep_entity = ENTITIES.register("quartz_resource_sheep_entity", () -> quartzSheepBuilder);
    //redstone
    public static final EntityType<RedstoneResourceSheep> redstoneSheepBuilder =EntityType.Builder.create(RedstoneResourceSheep::new, EntityClassification.CREATURE).size(0.9F, 1.3F).build(new ResourceLocation(Main.MODID, "redstone_resource_sheep_entity").toString());
    public static final RegistryObject<EntityType<RedstoneResourceSheep>> redstone_sheep_entity = ENTITIES.register("redstone_resource_sheep_entity", () -> redstoneSheepBuilder);
    //---------------------------------------------------
    //resource Chickens
    //coal
    public static final EntityType<CoalResourceChicken> coalChickenBuilder =EntityType.Builder.create(CoalResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "coal_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<CoalResourceChicken>> coal_chicken_entity = ENTITIES.register("coal_resource_chicken_entity", () -> coalChickenBuilder);
    //diamond
    public static final EntityType<DiamondResourceChicken> diamondChickenBuilder =EntityType.Builder.create(DiamondResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "diamond_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<DiamondResourceChicken>> diamond_chicken_entity = ENTITIES.register("diamond_resource_chicken_entity", () ->diamondChickenBuilder);
    //emerald
    public static final EntityType<EmeraldResourceChicken> emeraldChickenBuilder =EntityType.Builder.create(EmeraldResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "emerald_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<EmeraldResourceChicken>> emerald_chicken_entity = ENTITIES.register("emerald_resource_chicken_entity", () -> emeraldChickenBuilder);
    //gold
    public static final EntityType<GoldResourceChicken> goldChickenBuilder =EntityType.Builder.create(GoldResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "gold_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<GoldResourceChicken>> gold_chicken_entity = ENTITIES.register("gold_resource_chicken_entity", () -> goldChickenBuilder);
    //iron
    public static final EntityType<IronResourceChicken> ironChickenBuilder =EntityType.Builder.create(IronResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "iron_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<IronResourceChicken>> iron_chicken_entity = ENTITIES.register("iron_resource_chicken_entity", () -> ironChickenBuilder);
    //lapis
    public static final EntityType<LapisResourceChicken> lapisChickenBuilder =EntityType.Builder.create(LapisResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "lapis_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<LapisResourceChicken>> lapis_chicken_entity = ENTITIES.register("lapis_resource_chicken_entity", () -> lapisChickenBuilder);
    //netherite
    public static final EntityType<NetheriteResourceChicken> netheriteChickenBuilder =EntityType.Builder.create(NetheriteResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "netherite_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<NetheriteResourceChicken>> netherite_chicken_entity = ENTITIES.register("netherite_resource_chicken_entity", () -> netheriteChickenBuilder);
    //quartz
    public static final EntityType<QuartzResourceChicken> quartzChickenBuilder =EntityType.Builder.create(QuartzResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "quartz_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<QuartzResourceChicken>> quartz_chicken_entity = ENTITIES.register("quartz_resource_chicken_entity", () -> quartzChickenBuilder);
    //redstone
    public static final EntityType<RedstoneResourceChicken> redstoneChickenBuilder =EntityType.Builder.create(RedstoneResourceChicken::new, EntityClassification.CREATURE).size(0.4F, 0.7F).build(new ResourceLocation(Main.MODID, "redstone_resource_chicken_entity").toString());
    public static final RegistryObject<EntityType<RedstoneResourceChicken>> redstone_chicken_entity = ENTITIES.register("redstone_resource_chicken_entity", () -> redstoneChickenBuilder);

    //registrazione features
    public static final RegistryObject<Feature<NoFeatureConfig>> floreal_vine_feature = FEATURES.register("floreal_vine_feature", ()->new FlorealVineFeature(NoFeatureConfig.field_236558_a_));
    public static final RegistryObject<Feature<NoFeatureConfig>> frosted_vine_feature = FEATURES.register("frosted_vine_feature", ()->new FrostedVineFeature(NoFeatureConfig.field_236558_a_));

    //registrazione Renderer
    @Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegistryRendererHandler {
        @SubscribeEvent
        public static void registerRenderer(FMLClientSetupEvent event) {
            //mole Renderer Registration
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.mole_entity.get(), MoleRenderer::new);
            //Sheeps Renderer Registration
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.coal_sheep_entity.get(), CoalSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.diamond_sheep_entity.get(), DimaondSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.emerald_sheep_entity.get(), EmeraldSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.gold_sheep_entity.get(), GoldSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.iron_sheep_entity.get(), IronSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.lapis_sheep_entity.get(), LapisSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.quartz_sheep_entity.get(), QuartzSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.netherite_sheep_entity.get(), NetheriteSheepRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.redstone_sheep_entity.get(), RedstoneSheepRenderer::new);
            //Chickens Renderer Registration
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.coal_chicken_entity.get(), CoalResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.diamond_chicken_entity.get(), DiamondResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.emerald_chicken_entity.get(), EmeraldResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.gold_chicken_entity.get(), GoldResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.iron_chicken_entity.get(), IronResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.lapis_chicken_entity.get(), LapisResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.quartz_chicken_entity.get(), QuartzResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.netherite_chicken_entity.get(), NetheriteResourceChickenRenderer::new);
            RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.redstone_chicken_entity.get(), RedstoneResourceChickenRenderer::new);
            //cutout renderer for blue berries bush
            RenderTypeLookup.setRenderLayer(RegistryHandler.blue_berry_bush.get(), RenderType.getCutout());
            //cutout renderer for floreal_vines
            RenderTypeLookup.setRenderLayer(RegistryHandler.floreal_vines.get(), RenderType.getCutout());
            //cutout renderer for floreal_decoration
            RenderTypeLookup.setRenderLayer(RegistryHandler.floreal_decoration.get(), RenderType.getCutout());
            //cutout renderer for frosted_vines
            RenderTypeLookup.setRenderLayer(RegistryHandler.frosted_vines.get(), RenderType.getCutout());
            //cutout renderer for normal_bush
            RenderTypeLookup.setRenderLayer(RegistryHandler.normal_bush.get(), RenderType.getCutout());
            //cutout renderer for hydrangea bushes
            RenderTypeLookup.setRenderLayer(RegistryHandler.white_hydrangea.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.red_hydrangea.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.lilac_hydrangea.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.blue_hydrangea.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.pink_hydrangea.get(), RenderType.getCutout());
            //cutout renderer for Roses
            RenderTypeLookup.setRenderLayer(RegistryHandler.orange_rose.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.yellow_rose.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.green_rose.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.multicolor_rose.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(RegistryHandler.purple_rose.get(), RenderType.getCutout());
            //renderer GUI genLab
            ScreenManager.registerFactory(RegistryHandler.gen_lab_container.get(), GenLabScreen::new);
        }
    }
    //Registrazioni Extra
    @Mod.EventBusSubscriber(modid = Main.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class ExtraRegHandler {
        //registrazione attributi entity
        @SubscribeEvent
        public static void registerAttributes(FMLCommonSetupEvent event) {
            GlobalEntityTypeAttributes.put(RegistryHandler.mole_entity.get(), MoleEntity.setCustomAttributes().create());
            //sheeps
            GlobalEntityTypeAttributes.put(RegistryHandler.coal_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.diamond_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.emerald_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.gold_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.iron_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.lapis_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.netherite_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.quartz_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.redstone_sheep_entity.get(), ResourceSheepEntity.setCustomAttributes().create());
            //chickens
            GlobalEntityTypeAttributes.put(RegistryHandler.coal_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.diamond_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.emerald_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.gold_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.iron_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.lapis_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.netherite_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.quartz_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(RegistryHandler.redstone_chicken_entity.get(), ResourceChickenEntity.setCustomAttributes().create());
        }

        //registrazione spawnEggs
        public static SpawnEggItem moleSpawnEgg = new SpawnEggItem(moleBuilder, 0x2B2B2B, 0x463125, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        //sheeps
        public static SpawnEggItem coalSheepSpawnEgg = new SpawnEggItem(coalSheepBuilder, 0xfff4cf, 0x292929, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem diamondSheepSpawnEgg = new SpawnEggItem(diamondSheepBuilder, 0xfff4cf, 0x19ffe0, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem emeraldSheepSpawnEgg = new SpawnEggItem(emeraldSheepBuilder, 0xfff4cf, 0x19ff3b, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem goldSheepSpawnEgg = new SpawnEggItem(goldSheepBuilder, 0xfff4cf, 0xffe229, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem ironSheepSpawnEgg = new SpawnEggItem(ironSheepBuilder, 0xfff4cf, 0xd1d1d1, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem lapisSheepSpawnEgg = new SpawnEggItem(lapisSheepBuilder, 0xfff4cf, 0x2462ff, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem netheriteSheepSpawnEgg = new SpawnEggItem(netheriteSheepBuilder, 0xfff4cf, 0x3b2a28, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem quartzSheepSpawnEgg = new SpawnEggItem(quartzSheepBuilder, 0xfff4cf, 0xebead8, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem redstoneSheepSpawnEgg = new SpawnEggItem(redstoneSheepBuilder, 0xfff4cf, 0xd60000, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        //chickens
        public static SpawnEggItem coalChickenSpawnEgg = new SpawnEggItem(coalChickenBuilder, 0x4d4d4d, 0x292929, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem diamondChickenSpawnEgg = new SpawnEggItem(diamondChickenBuilder, 0x4d4d4d, 0x19ffe0, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem emeraldChickenSpawnEgg = new SpawnEggItem(emeraldChickenBuilder, 0x4d4d4d, 0x19ff3b, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem goldChickenSpawnEgg = new SpawnEggItem(goldChickenBuilder, 0x4d4d4d, 0xffe229, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem ironChickenSpawnEgg = new SpawnEggItem(ironChickenBuilder, 0x4d4d4d, 0xd1d1d1, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem lapisChickenSpawnEgg = new SpawnEggItem(lapisChickenBuilder, 0x4d4d4d, 0x2462ff, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem netheriteChickenSpawnEgg = new SpawnEggItem(netheriteChickenBuilder, 0x4d4d4d, 0x3b2a28, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem quartzChickenSpawnEgg = new SpawnEggItem(quartzChickenBuilder, 0x4d4d4d, 0xebead8, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        public static SpawnEggItem redstoneChickenSpawnEgg = new SpawnEggItem(redstoneChickenBuilder, 0x4d4d4d, 0xd60000, new SpawnEggItem.Properties().group(CUSTOM_ITEM_GROUP).maxStackSize(64).setNoRepair());
        @SubscribeEvent
        public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    moleSpawnEgg.setRegistryName("mole_spawn_egg"),
                    //sheeps
                    coalSheepSpawnEgg.setRegistryName("coal_sheep_spawn_egg"),
                    diamondSheepSpawnEgg.setRegistryName("diamond_sheep_spawn_egg"),
                    emeraldSheepSpawnEgg.setRegistryName("emerald_sheep_spawn_egg"),
                    goldSheepSpawnEgg.setRegistryName("gold_sheep_spawn_egg"),
                    ironSheepSpawnEgg.setRegistryName("iron_sheep_spawn_egg"),
                    lapisSheepSpawnEgg.setRegistryName("lapis_sheep_spawn_egg"),
                    netheriteSheepSpawnEgg.setRegistryName("netherite_sheep_spawn_egg"),
                    quartzSheepSpawnEgg.setRegistryName("quartz_sheep_spawn_egg"),
                    redstoneSheepSpawnEgg.setRegistryName("redstone_sheep_spawn_egg"),
                    //chickens
                    coalChickenSpawnEgg.setRegistryName("coal_chicken_spawn_egg"),
                    diamondChickenSpawnEgg.setRegistryName("diamond_chicken_spawn_egg"),
                    emeraldChickenSpawnEgg.setRegistryName("emerald_chicken_spawn_egg"),
                    goldChickenSpawnEgg.setRegistryName("gold_chicken_spawn_egg"),
                    ironChickenSpawnEgg.setRegistryName("iron_chicken_spawn_egg"),
                    lapisChickenSpawnEgg.setRegistryName("lapis_chicken_spawn_egg"),
                    netheriteChickenSpawnEgg.setRegistryName("netherite_chicken_spawn_egg"),
                    quartzChickenSpawnEgg.setRegistryName("quartz_chicken_spawn_egg"),
                    redstoneChickenSpawnEgg.setRegistryName("redstone_chicken_spawn_egg")
            );
        }

        //registrazione ricette Pozioni
        @SubscribeEvent
        public static void registerPotionRecepies(FMLCommonSetupEvent event) {
            try {
                Method addMix = PotionBrewing.class.getDeclaredMethod("addMix", Potion.class, Item.class, Potion.class);
                addMix.setAccessible(true);
                //luck
                addMix.invoke(addMix, Potions.AWKWARD, RegistryHandler.shiny_shard_dust.get(), RegistryHandler.luck_potion.get());
                //senses
                addMix.invoke(addMix, Potions.AWKWARD, RegistryHandler.mysterious_sensory_organ.get(), RegistryHandler.senses_potion.get());
            }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }
    }
}
