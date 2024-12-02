package com.tigerclips1.ponyorigins.abilities.common.flight;

import com.starshootercity.OriginSwapper;
import com.starshootercity.ShortcutUtils;
import com.starshootercity.abilities.AbilityRegister;
import com.starshootercity.abilities.FlightAllowingAbility;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.commands.FlightToggleCommand;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.util.TriState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ponyflight implements VisibleAbility, FlightAllowingAbility, Listener {
    @Override
    public @NotNull Key getKey() {
        return Key.key("ponyorigins:ponyflight");
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Jump in the air to spread your wings and take flight! Be careful not to damage them or get them caught in things, or you may be grounded for a while.\\n\\nManually disable/enable with your primary power to fly with equipment. ", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle() {
        return OriginSwapper.LineData.makeLineFor("Flight", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }
    @EventHandler
    public void onPlayerJump(EntityInteractEvent event)
    {
        AbilityRegister.runForAbility(event.getEntity(), getKey(), () -> {
            if (!event.getEntity().isOnGround())
            {
                event.setCancelled(true);
            }
        });
    }
    @Override
    public boolean canFly(Player player) {
        if (player.isFlying())
        {
            Objects.requireNonNull(player.getPlayer()).removePotionEffect(PotionEffectType.SLOW_FALLING);
        } else
        {
            Objects.requireNonNull(player.getPlayer()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, ShortcutUtils.infiniteDuration(), 0, false, false));
        }
        return !player.isFlying();
    }

    @Override
    public float getFlightSpeed(Player player) {
        return player.getFlySpeed();
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        if (FlightToggleCommand.canFly(event.getPlayer())) return;
        AbilityRegister.runForAbility(event.getPlayer(), getKey(), () -> {
            if (event.isFlying()) {
                event.setCancelled(true);
                event.getPlayer().setFlying(true);
            }
        });
    }

    @Override
    public @NotNull TriState getFlyingFallDamage(Player player ) {
        return TriState.TRUE;
    }
}
