package me.b1ackange1.basictools

import me.b1ackange1.basictools.commands.Gamemode
import me.b1ackange1.basictools.commands.Hello
import org.bukkit.plugin.java.JavaPlugin

class BasicToolsPlugin : JavaPlugin() {
    override fun onEnable() {
        logger.info("Hello World")
        getCommand("hello")?.setExecutor(Hello())
        getCommand("hello")?.setTabCompleter(Hello())
        getCommand("gm")?.setExecutor(Gamemode())
        getCommand("gm")?.setTabCompleter(Gamemode())
    }
}

