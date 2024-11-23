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

public  class harmony implements VisibleAbility, Listener, CooldownAbility {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Tame any tameable creature with an empty hoof.\n\nAll mobs will ignore you.\n\nYOU CANNOT HARM ANOTHER LIVING CREATURE", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Friend of All", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("ponyorigins:harmony");
    }
    private final Random random = new Random();

    @Override
    public Cooldowns.CooldownInfo getCooldownInfo() {
        return null;
    }
}
