package com.tigerclips1.ponyorigins.abilities.alicorn;
import com.starshootercity.OriginSwapper;
import com.starshootercity.cooldowns.CooldownAbility;
import com.starshootercity.abilities.VisibleAbility;
import com.starshootercity.cooldowns.Cooldowns;
import net.kyori.adventure.key.Key;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public  class  barrier  implements VisibleAbility, Listener, CooldownAbility {
    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getDescription() {
        return OriginSwapper.LineData.makeLineFor("Press your secondary power to activate your barrier to become invulnerable to damage. Your barrier will deplete your energy reserves as you take hits.", OriginSwapper.LineData.LineComponent.LineType.DESCRIPTION);
    }

    @Override
    public @NotNull List<OriginSwapper.LineData.LineComponent> getTitle()
    {
        return OriginSwapper.LineData.makeLineFor("Barrier", OriginSwapper.LineData.LineComponent.LineType.TITLE);
    }

    @Override
    public @NotNull Key getKey() {
        return Key.key("ponyorigins:");
    }
    private final Random random = new Random();

    @Override
    public Cooldowns.CooldownInfo getCooldownInfo() {
        return null;
    }
}
