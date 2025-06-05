package com.example.config

import com.example.TemplateMod
import com.mojang.serialization.Codec
import dev.isxander.yacl3.config.v3.JsonFileCodecConfig
import dev.isxander.yacl3.config.v3.register
import dev.isxander.yacl3.platform.YACLPlatform

open class ModConfig : JsonFileCodecConfig<ModConfig>(
    YACLPlatform.getConfigDir().resolve(TemplateMod.MOD_ID + ".json")
) {

    val myCoolBoolean by register<Boolean>(true, Codec.BOOL)

    companion object : ModConfig() {
        init {
            if (!loadFromFile()) {
                saveToFile()
            }
        }
    }
}
