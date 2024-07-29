package com.wuzuy.listeners;

import com.wuzuy.WindChargePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class WindChargeListener implements Listener {

    private final WindChargePlugin plugin;

    public WindChargeListener(WindChargePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        // Verifica se o jogador está usando o item Wind Charge
        // Exemplo: if (event.getItem().getType() == Material.DIAMOND_SWORD)
        plugin.launchWindCharge(event.getPlayer());
    }
}
