package net.darkhax.tesla.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * An interface used by objects that can handle Tesla power.
 */
public interface ITeslaHandler extends INBTSerializable<NBTBase> {

    /**
     * Gets the amount of tesla power stored by the handler.
     *
     * @param side The side being checked.
     * @return The amount of tesla power stored by the handler.
     */
    long getStoredPower (EnumFacing side);

    /**
     * Gets the maximum amount of tesla power that the handler can hold.
     *
     * @param side The side being checked.
     * @return The maximum amount of tesla power that can be held by the handler.
     */
    long getCapacity (EnumFacing side);

    /**
     * Takes power from the handler by removing it from an internal source.
     *
     * @param power The amount of power to request from the handler.
     * @param side The side being checked.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was actually taken.
     */
    long takePower (long power, EnumFacing side, boolean simulated);

    /**
     * Provides the handler with a bit of power.
     *
     * @param power The amount of power to provide the handler with.
     * @param side The side being checked.
     * @param simulated Whether or not this is being called as part of a simulation.
     * @return The amount of power that was accepted by the handler.
     */
    long givePower (long power, EnumFacing side, boolean simulated);

    /**
     * Checks if a given side is a valid input face..
     *
     * @param side The side being checked.
     * @return Whether or not the side is a valid input side.
     */
    boolean isInputSide (EnumFacing side);

    /**
     * Checks if a given side is a valid output face.
     *
     * @param side The side being checked.
     * @return Whether or not the side is a valid output side.
     */
    boolean isOutputSide (EnumFacing side);
}
