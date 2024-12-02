package com.tigerclips1.ponyorigins.abilities.common.flight;

import com.starshootercity.OriginSwapper;
import com.starshootercity.abilities.FlightAllowingAbility;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.commands.FlightToggleCommand;
import io.papermc.paper.event.entity.EntityMoveEvent;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.util.TriState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.jetbrains.annotations.NotNull;
import com.starshootercity.abilities.AbilityRegister;

import java.util.List;

public class ponyflight implements VisibleAbility, FlightAllowingAbility, Listener {
        @Override
        public @NotNull Key getKey() {
            return Key.key("ponyorigins:ponyflight");
        }

        @Override
        public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
            return OriginSwapper.LineData.makeLineFor("Jump in the air to spread your wings and take flight! Be careful not to damage them or get them caught in things, or you may be grounded for a while.\n\nManually disable/enable with your primary power to fly with equipment.", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
        }

        @Override
        public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle() {
            return OriginSwapper.LineData.makeLineFor("Flight", OriginSwapper.LineData.LineComponent.LineType.TITLE);
        }

        @EventHandler
        public void onEntityToggleFlying(EntityMoveEvent event) {
            AbilityRegister.runForAbility(event.getEntity(), getKey(), () -> {
                if (!event.getEntity().isOnGround() && !event.getEntity().isGliding()) {
                    event.setCancelled(true);
                }
            });
        }

        @Override
        public boolean canFly(Player player) {
            return !player.isGliding();
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
                    event.getPlayer().setGliding(true);
                }
            });
        }

        @Override
        public @NotNull TriState getFlyingFallDamage(Player player) {
            return TriState.TRUE;
        }
    }