package com.tigerclips1.ponyorigins.abilities.pegasus;

import com.starshootercity.OriginSwapper;
import com.starshootercity.abilities.AbilityRegister;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.cooldowns.CooldownAbility;

import com.starshootercity.cooldowns.Cooldowns;
import net.kyori.adventure.key.Key;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.jetbrains.annotations.NotNull;
import org.bukkit.event.EventHandler;
import java.util.List;

public class soincrainboom implements VisibleAbility, Listener, CooldownAbility {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Hold secondary power to launch in the direction you are looking at incredible speed or it's called in MLP FIM the Sonic Rainboom, impacting for explosive damage!\n\nWARNING: The impact may kill you!", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Sonic Rainboom", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("ponyorigins:sonic_rainboom");
    }
    @EventHandler
    public void onplayerSoincRainboom(PlayerToggleSneakEvent event)
    {
        // TODO add it where when you hit G or some sort of key it will activate the power
        AbilityRegister.runForAbility(event.getPlayer(), getKey(), () ->
        {
            if (hasCooldown(event.getPlayer())) return;
            if (event.isSneaking())
            {
                // handle the Sonic rainboom with the rainbow firework particle
                Firework firework = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
                FireworkMeta data = firework.getFireworkMeta();
                data.addEffect(FireworkEffect.builder()
                        .withColor(Color.RED)
                        .withColor(Color.ORANGE)
                        .withColor(Color.YELLOW)
                        .withColor(Color.GREEN)
                        .withColor(Color.BLUE)
                        .withColor(Color.fromRGB(75,0,130))
                        .withColor(Color.PURPLE)
                        .with(FireworkEffect.Type.BALL_LARGE)
                        .withFlicker()
                        .build());
                data.setPower(50);
                firework.setFireworkMeta(data);
            }
            setCooldown(event.getPlayer());
        });

    }
    @Override
    public Cooldowns.CooldownInfo getCooldownInfo() {
        return new Cooldowns.CooldownInfo(1);
    }
}

