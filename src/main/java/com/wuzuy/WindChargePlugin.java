package com.wuzuy;

import com.wuzuy.listeners.WindChargeListener;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Firework;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class WindChargePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new WindChargeListener(this), this);
    }

    @Override
    public void onDisable() {
        // Lógica para quando o plugin é desativado
    }

    public void launchWindCharge(Player player) {
        FileConfiguration config = getConfig();
        double explosionForce = config.getDouble("windcharge.explosionForce", 1.0);
        boolean addParticles = config.getBoolean("windcharge.addParticles", true);
        double projectileSpeed = config.getDouble("windcharge.projectileSpeed", 1.0);

        // Criar um projétil de fogos de artifício como exemplo
        Firework firework = player.getWorld().spawn(player.getLocation().add(player.getLocation().getDirection().multiply(2)), Firework.class);
        firework.setVelocity(player.getLocation().getDirection().multiply(projectileSpeed));

        if (addParticles) {
            // Adicionar partículas ao projétil
            player.getWorld().spawnParticle(Particle.EXPLOSION, firework.getLocation(), 10);
        }

        // Agendar uma tarefa para criar a explosão após um curto período
        new BukkitRunnable() {
            @Override
            public void run() {
                if (firework.isValid()) {
                    firework.getWorld().createExplosion(firework.getLocation(), (float) explosionForce, false, false);
                    firework.remove(); // Remover o projétil após a explosão
                }
            }
        }.runTaskLater(this, 20L); // Espera 1 segundo antes de criar a explosão
    }
}
