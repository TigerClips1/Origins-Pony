package com.tigerclips1.ponyorigins.abilities.umbrum;

import com.starshootercity.OriginSwapper;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.cooldowns.CooldownAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract  class shadow implements VisibleAbility, Listener, CooldownAbility {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Press your primary power to become an intangible shadow, and haunt your quarrel through walls and other solid objects, immune to harm!\n\nWarning: Fails in bright light!", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Shadow Walk", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("");
    }

}
