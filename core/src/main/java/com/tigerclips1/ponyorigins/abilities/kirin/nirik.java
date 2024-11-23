package com.tigerclips1.ponyorigins.abilities.kirin;

import com.starshootercity.OriginSwapper;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.cooldowns.CooldownAbility;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class nirik implements VisibleAbility, Listener, CooldownAbility  {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Taking damage will build up rage. Press your primary power to unleash your rage in the terrifying Nirik form, a burning, fire launching monster!\n\nAttack with an empty hoof to launch fireballs, or directly set opponents on fire!\n\nWarning: Will activate if rage exceeds its limits. Cannot be turned off until all the rage is out!", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Nirik", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("");
    }
}
