package org.getspout.server.temp.commons.command;

import org.bukkit.command.CommandSender;

import java.util.Set;

public interface CommandsManager {
	/**
	 * Executes a command from the input string
	 *
	 * @param input The string input (no preceding /)
	 * @param sender The {@link CommandSender} who input this command.
	 * @param fuzzyLookup Whether to use levenschtein distance-based lookup when exact command does not match.
	 * @return Whether the command could be found.
	 */
	public boolean execute(String input, CommandSender sender, boolean fuzzyLookup);

	/**
	 * Registers a command with this commands manager
	 *
	 * @param collisionPrefix The prefix that this command will be assigned when it collides with another command.
	 * @param command The command to register
	 * @return Whether the registration was successful.
	 */
	public boolean register(String collisionPrefix, Command command);

	/**
	 * Returns a {@link Set&lt;Command&gt;} of commands that have been registered with this CommandsManager
	 * This is a copy, so changes made will not affect the original set that this CommandsManager has.
	 *
	 * @return the commands registered with this CommandsManager.
	 */
	public Set<Command> getRegisteredCommands();

	/**
	 * Returns a {@link Set&lt;Command&gt;} of command names registered with this CommandsManager.
	 * Again, this is a copy, not the original.
	 *
	 * @return the command names registered with this CommandsManager.
	 */
	public Set<String> getRegisteredCommandNames();

	/**
	 * Gets a {@link Command} from this command map if it exists.
	 *
	 * @param name The name to lookup commands by.
	 * @return The matching {@link Command} if found, otherwise null.
	 */
	public Command getCommand(String name);

	/**
	 * Remove all commands than are instances of clazz
	 *
	 * @param clazz The class extinding {@link Command} that should be removed from this command map.
	 * @return Whether this operation was successful.
	 */
	public boolean unregisterCommandsOfType(Class<? extends Command> clazz);

	/**
	 * Unregisters a command from this CommandsManager.
	 *
	 * @param cmd The command to unregister.
	 * @return Whether this operation was successful
	 */
	public boolean unregisterCommand(Command cmd);
}
