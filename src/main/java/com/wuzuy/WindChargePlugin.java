package com.wuzuy;

import com.wuzuy.listeners.WindChargeListener;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

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
        String particleTypeName = config.getString("windcharge.particleType", "FLAME");

        // Converte o nome da partícula para o tipo de partícula correspondente
        Particle particleType;
        try {
            particleType = Particle.valueOf(particleTypeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            getLogger().warning("Tipo de partícula inválido: " + particleTypeName + ". Usando FLAME como padrão.");
            particleType = Particle.FLAME;
        }

        if (addParticles) {
            player.getWorld().spawnParticle(particleType, player.getLocation(), 100);
        }

        // Cria uma explosão TNT para simular a força da explosão
        TNTPrimed tnt = player.getWorld().spawn(player.getLocation(), TNTPrimed.class);
        tnt.setYield((float) explosionForce);
        tnt.setFuseTicks(0); // Detona imediatamente

        // Cria um projétil de exemplo e ajusta a velocidade
        Projectile projectile = player.getWorld().spawn(player.getLocation(), org.bukkit.entity.Arrow.class);
        Vector direction = player.getLocation().getDirection().normalize().multiply(projectileSpeed);
        projectile.setVelocity(direction);
    }
}
