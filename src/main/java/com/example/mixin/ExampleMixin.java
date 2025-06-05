package com.example.mixin;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;

@Mixin(MinecraftClient.class)
public abstract class ExampleMixin {
    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void sayHi(String accessToken, Proxy proxy, CallbackInfo ci) {
        System.out.println("Hi");
    }
}
