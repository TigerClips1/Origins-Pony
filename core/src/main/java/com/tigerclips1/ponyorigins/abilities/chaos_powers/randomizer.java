package com.tigerclips1.ponyorigins.abilities.chaos_powers;


// TODO This may be change to work with Discord powers

import com.starshootercity.OriginSwapper;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.cooldowns.CooldownAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class randomizer  implements VisibleAbility, Listener, CooldownAbility  {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Chaos forms are naturally indeterminate, but will collapse to some kind of form at random after choosing this race.", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Chaos Form", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("");
    }
}
