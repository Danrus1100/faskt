package com.example.config

import com.example.TemplateMod
import dev.isxander.yacl3.config.v3.register
import dev.isxander.yacl3.dsl.YetAnotherConfigLib
import dev.isxander.yacl3.dsl.controller
import dev.isxander.yacl3.dsl.tickBox
import net.minecraft.client.gui.screens.Screen

fun createGui(screen: Screen) = GuiFactory().createGui(screen)

private class GuiFactory {

    val config = ModConfig()

    fun createGui(parent: Screen?): Screen = YetAnotherConfigLib(TemplateMod.MOD_ID) {
        save { config.saveToFile() }
        val simpleCategory by categories.registering {
            groups.register("general") {
                val myCoolBooleanOption = options.register(config.myCoolBoolean) {
                    controller = tickBox()
                }
            }
        }

    }.generateScreen(parent)
}