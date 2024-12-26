package net.levi.tutorialmod;

import net.levi.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //raw sapphire and normal sapphire items
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                        //sapphire ore blocks and sapphire blocks
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE_BLOCK.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE_BLOCK.get());
                        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE_BLOCK.get());

                        //sapphire tools
                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());


                    })
                    .build());



    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
