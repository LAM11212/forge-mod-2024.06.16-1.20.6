package net.levi.tutorialmod.block;

import net.levi.tutorialmod.ModItems;
import net.levi.tutorialmod.TutorialMod;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);
    //SAPPHIRE ORE BLOCK
    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = registerBlock("sapphire_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(2f, 3f).requiresCorrectToolForDrops()));
    //DEEPSLATE SAPPHIRE ORE BLOCK
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE_BLOCK = registerBlock("deepslate_sapphire_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(3f, 4f)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    //NETHER SAPPHIRE ORE BLOCK
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE_BLOCK = registerBlock("nether_sapphire_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.of()
                    .strength(3f, 5f)
                    .sound(SoundType.NETHER_ORE)
                    .requiresCorrectToolForDrops()));
    // END STONE SAPPHIRE ORE BLOCK
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE_BLOCK = registerBlock("end_stone_sapphire_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(5, 8), BlockBehaviour.Properties.of()
                    .strength(5f, 6f)
                    .sound(SoundType.POLISHED_DEEPSLATE)
                    .requiresCorrectToolForDrops()));
    // SAPPHIRE BLOCK
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0f, 3.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block); // registers block
        registerBlockItem(name, toReturn); // registers block item
        return toReturn; // returns the block item to function call
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
