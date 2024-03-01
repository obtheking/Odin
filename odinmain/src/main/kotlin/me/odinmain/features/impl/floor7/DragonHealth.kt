package me.odinmain.features.impl.floor7

import me.odinmain.utils.addVec
import me.odinmain.utils.render.Color
import me.odinmain.utils.render.world.RenderUtils
import me.odinmain.utils.render.world.RenderUtils.renderVec
import net.minecraft.entity.boss.EntityDragon
import net.minecraftforge.client.event.RenderLivingEvent

object DragonHealth{

    fun renderHP(event: RenderLivingEvent.Post<*>) {
        if (event.entity !is EntityDragon || event.entity.health <= 0) return
        RenderUtils.drawStringInWorld(colorHealth(event.entity.health.toInt()), event.entity.renderVec.addVec(y = 1.5), Color.WHITE.rgba,
            false, false, false, 0.2f, true)
    }

    private fun colorHealth(health: Int): String {
        return when {
            health >= 0.75 -> "§a${formatHealth(health)}"
            health >= 0.5 -> "§e${formatHealth(health)}"
            health >= 0.25 -> "§6${formatHealth(health)}"
            else -> "§c${formatHealth(health)}"
        }
    }

    private fun formatHealth(health: Int): String {
        return when {
            health >= 1_000_000_000 -> "${(health / 1_000_000_000)}b"
            health >= 1_000_000 -> "${(health / 1_000_000)}m"
            health >= 1_000 -> "${(health / 1_000)}k"
            else -> "$health"
        }
    }
}