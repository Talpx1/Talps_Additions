package com.talp1.talpsadditions.utils.registration;

import com.talp1.talpsadditions.Main;
import com.talp1.talpsadditions.block.*;
import com.talp1.talpsadditions.config.CommonConfig;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Items;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Block> shiny_shard_ore = BLOCKS.register("shiny_shard_ore", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).setLightLevel(state -> CommonConfig.lightValShinyShardOre.get())));
    public static final RegistryObject<Block> shiny_shard_block = BLOCKS.register("shiny_shard_block", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE).setLightLevel(state -> CommonConfig.lightValShinyShardBlock.get())));
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
    public static final RegistryObject<CoconutBlock> coconut_block = BLOCKS.register("coconut_block", () -> new CoconutBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.2F).sound(SoundType.BAMBOO)));
    public static final RegistryObject<FloweryWaterLily> flowery_water_lily = BLOCKS.register("flowery_water_lily", () -> new FloweryWaterLily(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance().sound(SoundType.LILY_PADS).notSolid()));
    public static final RegistryObject<AncientStatue> ancient_statue = BLOCKS.register("ancient_statue", () -> new AncientStatue(Block.Properties.create(Material.CLAY).hardnessAndResistance(-1.0F, 3600000.0F).sound(SoundType.SAND).setLightLevel(state -> 4)));
}
