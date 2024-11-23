package com.tigerclips1.ponyorigins.abilities.alicorn;

import com.starshootercity.OriginSwapper;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.cooldowns.CooldownAbility;
import com.starshootercity.cooldowns.Cooldowns;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public  class fireblast implements VisibleAbility, Listener, CooldownAbility {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Hold your secondary power to charge, release to launch a destructive ball of plasma in the direction you're looking.", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Fire Blast", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("ponyorigins:fireblast");
    }
    private final Random random = new Random();

    @Override
    public Cooldowns.CooldownInfo getCooldownInfo() {
        return null;
    }
}
