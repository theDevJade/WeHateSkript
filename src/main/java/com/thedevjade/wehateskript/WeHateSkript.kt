package com.thedevjade.wehateskript

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class WeHateSkript : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        info("WeHateSkript is enabled!")
        info("Looking around...")

        val skriptPlugin = server.pluginManager.getPlugin("Skript")

        if (skriptPlugin != null) {
            disableAndDeleteSkript(skriptPlugin)
        } else {
            info("Skript is not installed!")
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun disableAndDeleteSkript(skriptPlugin: Plugin) {
        info("Skript is installed!")
        info("Disabling Skript...")

        val jarFile = File(skriptPlugin.javaClass.protectionDomain.codeSource.location.toURI().path)

        server.pluginManager.disablePlugin(skriptPlugin)
        info("Skript is disabled!")

        info("Deleting Skript...")
        jarFile.delete()
        info("Skript is deleted!")

        info("We Hate Skript :D")
        server.shutdown()
    }

    private fun info(message: String) {
        logger.info(message)
    }
}
