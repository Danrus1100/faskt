package com.example

import com.example.config.ModConfig
import net.fabricmc.api.ClientModInitializer

class TemplateMod : ClientModInitializer {

    companion object{
        const val MOD_ID = "template_mod"
    }

    override fun onInitializeClient() {
        ModConfig
    }
}