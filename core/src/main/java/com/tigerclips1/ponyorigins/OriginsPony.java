package com.tigerclips1.ponyorigins;

import com.starshootercity.OriginsAddon;
import com.starshootercity.abilities.Ability;
import com.tigerclips1.ponyorigins.abilities.abyssinian.claws;
import com.tigerclips1.ponyorigins.abilities.alicorn.*;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OriginsPony extends OriginsAddon {
    @Override
    public @NotNull String getNamespace() {
        return "ponyorigins";
    }

    @Override
    public @NotNull List<Ability> getAbilities() {
        // TODO add the code and call all of the classes in the abilities
        return List.of(
                // Abyssinian powers.
                new claws(),

                // Alicon powers.
                new barrier(),
                new celestial(),
                new fireblast(),
                new harmony(),
                new laser(),
                new mightyhoof(),
                new miner(),
                new teleport()

                // Changeling powers.

                // Discord powers or chaos powers.

                // Common powers.

                // Diamond_dog powers.

                // Dragon powers.

                // Earth pony powers.

                // Kirin powers.

                // Minotaur powers.

                // Pegasus pony powers.

                // Pony talents powers stuff that every unicorn have. I think.

                // Primary talents.

                // Projectiles powers.

                // Umbrum powers.

                // Yak powers.

                // Zebra powers.
        );
    }
private static PonyNMSInvoker nmsInvoker;

private static void initializeNMSInvoker() {
    nmsInvoker = switch (Bukkit.getMinecraftVersion()) {
        case "1.19" -> new PonyNMSInvokerV1_19();
        case "1.19.1" -> new PonyNMSInvokerV1_19_1();
        case "1.19.2" -> new PonyNMSInvokerV1_19_2();
        case "1.19.3" -> new PonyNMSInvokerV1_19_3();
        case "1.19.4" -> new PonyNMSInvokerV1_19_4();
        case "1.20" -> new PonyNMSInvokerV1_20();
        case "1.20.1" -> new PonyNMSInvokerV1_20_1();
        case "1.20.2" -> new PonyNMSInvokerV1_20_2();
        case "1.20.3" -> new PonyNMSInvokerV1_20_3();
        case "1.20.4" -> new PonyNMSInvokerV1_20_4();
        case "1.20.5", "1.20.6" -> new PonyNMSInvokerV1_20_6();
        case "1.21" -> new PonyNMSInvokerV1_21();
        case "1.21.1" -> new PonyNMSInvokerV1_21_1();
        case "1.21.2", "1.21.3" -> new PonyNMSInvokerV1_21_3();
        default -> throw new IllegalStateException("Unexpected version: " + Bukkit.getMinecraftVersion() + " only versions 1.20 - 1.20.6 are supported");
    };
}

public static PonyNMSInvoker getNMSInvoker() {
    return nmsInvoker;
}

@Override
public void onRegister() {
    initializeNMSInvoker();
    }
}