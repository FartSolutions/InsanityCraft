package fartsol.insanitycraft.handlers;

import fartsol.insanitycraft.init.ModItems;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ClientEventHandler
{
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event)
    {
        if (event.getTarget() instanceof EntityVillager) {
            EntityPlayer player = event.getEntityPlayer();
            ItemStack heldItem = player.getHeldItem(event.getHand());

            if (player.isSneaking()) {
                if (!heldItem.isEmpty() && heldItem.getItem() == ModItems.KEBAB_SKEWER) {
                    if (!event.getWorld().isRemote) {
                        EntityVillager villager = (EntityVillager)event.getTarget();
                        villager.setDead();
                        event.getWorld().playSound(null, villager.posX, villager.posY, villager.posY, SoundEvents.ENTITY_VILLAGER_DEATH, SoundCategory.PLAYERS, 1.f, 1.f);
                        player.setHeldItem(event.getHand(), new ItemStack(ModItems.KEBAB_SKEWER_VILLAGER));
                    }

                    event.setCanceled(true);
                }
            }
        }
    }
}
