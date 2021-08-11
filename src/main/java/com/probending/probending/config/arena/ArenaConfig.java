package com.probending.probending.config.arena;

import com.probending.probending.ProBending;
import com.probending.probending.config.AbstractConfig;
import com.probending.probending.config.configvalue.ConfigValue;
import com.probending.probending.core.arena.Arena;

import java.io.File;

public class ArenaConfig extends AbstractArenaConfig {

    private final ConfigValue<Integer> roundTime = new ConfigValue<>("RoundTime", 180, this, true);
    private final ConfigValue<Integer> roundWin = new ConfigValue<>("RoundWin", 3, this, true);
    private final ConfigValue<Integer> minimalPlayerAmount = new ConfigValue<>("MinimalPlayerAmount", 2, this, true);
    private ConfigValue<Boolean> damage = new ConfigValue<>("Damage", true, this);
    private ConfigValue<Boolean> publicArena = new ConfigValue<>("Public", true, this);
    private ConfigValue<Double> dragValue = new ConfigValue<>("DragForce", 1.0, this, true);
    private ConfigValue<Integer> tirednessMax = new ConfigValue<>("FatigueMax", 200, this, true);
    private ConfigValue<Integer> hpToTirednessRatio = new ConfigValue<>("HPToFatigueRatio", 4, this, true);
    private ConfigValue<Boolean> resetFatigueOnStageLose = new ConfigValue<>("ResetFatigueOnStageLose", false, this, true);


    public ArenaConfig(Arena arena, String path, ProBending plugin) {
        super(arena, path, plugin);
        save();
    }

    public ArenaConfig(Arena arena, File file, ProBending plugin) {
        super(arena, file, plugin);
        save();
    }
    public Integer getRoundTime() {
        return Math.max(roundTime.getValue(), 60);
    }

    public Integer getRoundWin() {
        return Math.max(roundWin.getValue(), 2);
    }

    public Integer getMinimalPlayerAmount() {
        return Math.max(Math.min(minimalPlayerAmount.getValue(), 6), 2);
    }

    public int getTirednessMax() {
        return tirednessMax.getValue();
    }

    public int getHpToTirednessRatio() {
        return hpToTirednessRatio.getValue();
    }

    public boolean getDamage() {
        return damage.getValue();
    }

    public double getDragValue() {
        return dragValue.getValue();
    }

    public boolean getResetFatigueOnStageLose() {
        return resetFatigueOnStageLose.getValue();
    }

    public boolean isPublic() {
        return publicArena.getValue();
    }
}
