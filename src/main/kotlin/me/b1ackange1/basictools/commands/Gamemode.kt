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
                        0 -> {
                            if(sender.gameMode == GameMode.SURVIVAL) return true
                            sender.gameMode = GameMode.SURVIVAL
                        }
                        1 -> {
                            if(sender.gameMode == GameMode.CREATIVE) return true
                            sender.gameMode = GameMode.CREATIVE
                        }
                        2 -> {
                            if(sender.gameMode == GameMode.ADVENTURE) return true
                            sender.gameMode = GameMode.ADVENTURE
                        }
                        3 -> {
                            if(sender.gameMode == GameMode.SPECTATOR) return true
                            sender.gameMode = GameMode.SPECTATOR
                        }
                        else -> {
                            sender.sendMessage("you serious?")
                            return true
                        }
                    }
                    sender.sendMessage("Set own gamemode to ${sender.gameMode.name.toLowerCase().capitalize()} Mode")
                } ?: sender.sendMessage("d0 yo0 no numbar?")
            } else {
                sender.sendMessage("Nope")
            }
        } else {
            sender.sendMessage("omae wa mou shindeiru!!(You are not a player.)")
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