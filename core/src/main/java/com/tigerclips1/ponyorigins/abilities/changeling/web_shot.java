package com.tigerclips1.ponyorigins.abilities.changeling;

import com.starshootercity.OriginSwapper;
import com.starshootercity.cooldowns.CooldownAbility;
import com.starshootercity.abilities.VisibleAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.List;

// TODO for the changeling power the visible ability may need to be change idk yet


public abstract class web_shot   implements VisibleAbility, Listener, CooldownAbility  {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("By eating food, you can create sticky silk, and spit it at your target to slow them down.", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Web Shot", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("");
    }
}
