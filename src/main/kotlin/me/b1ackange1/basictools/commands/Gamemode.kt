package me.b1ackange1.basictools.commands

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class Gamemode : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (args.count() == 1) {
                args[0].toIntOrNull()?.let {
                    when (it) {
                        0 -> sender.gameMode = GameMode.SURVIVAL
                        1 -> sender.gameMode = GameMode.CREATIVE
                        2 -> sender.gameMode = GameMode.ADVENTURE
                        3 -> sender.gameMode = GameMode.SPECTATOR
                        else -> {
                            sender.sendMessage("are you mad?")
                            return true
                        }
                    }
                    sender.sendMessage("Set own gamemode to ${sender.gameMode.name.toLowerCase().capitalize()} Mode")
                }?: sender.sendMessage("do you know number")
            } else {
                sender.sendMessage("Nope")
            }
        } else {
            sender.sendMessage("are you human?")
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        return emptyList()
    }
}