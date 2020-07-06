package me.b1ackange1.basictools.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class Hello : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.count() > 0) sender.sendMessage("Say hello to ${args[0]}!")
        else {
            sender.sendMessage("why hello there")
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        return when (args.count()) {
            1 -> Bukkit.getOnlinePlayers().map { it.name }
            else -> emptyList()
        }
    }
}