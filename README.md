# TrialWeapons v1.2

**Minecraft 1.12.2 plugin** that backports Maces, Spears, Wind Charges, Breeze, Bogged, Trial Spawners and Vaults from 1.21.

You build the Trial Chambers yourself. The plugin handles the gameplay.

---

## Features

### Weapons
- **Mace** – Smash attacks scale with fall distance, cancel fall damage, AOE knockback
  - Custom enchants: Density, Breach, Wind Burst
- **Spears** – Iron / Diamond / Netherite tiers with charge attacks
- **Wind Charge** – Throwable. Launch yourself or enemies

### Mobs
- **Breeze** – Jumps, shoots Wind Charges, drops Breeze Rods (Plains, Desert, Savanna, Mesa)
- **Bogged** – Poison arrow skeletons (Swamp only), drops bones, arrows, vines

### Systems
- **Trial Spawner** – Place it → nearby players activate waves → rewards + Trial Keys
- **Vault** – Requires Trial Key → opens for rare loot (Maces, Spears, Diamonds, Totems...)

---

## Commands

| Command | Description |
|---------|-------------|
| `/recipes` | View all crafting recipes (everyone) |
| `/mace` | Get a Mace (OP) |
| `/spear [iron|diamond|netherite]` | Get a Spear (OP) |
| `/windcharge [amount]` | Get Wind Charges (OP) |
| `/trial give <item>` | Give any item (OP) |
| `/trial trialkey` | Get a Trial Key |
| `/trial spawner` | Get a Trial Spawner |
| `/trial vault` | Get a Vault |
| `/trial breeze` | Spawn a Breeze |
| `/trial bogged` | Spawn a Bogged |
| `/trial reload` | Reload config |

Special items: `mace_god`, `mace_density`, `mace_breach`, `mace_wind`

---

## How to use

1. Build your Trial Chamber however you want
2. `/trial spawner` and place Trial Spawners where fights should happen
3. `/trial vault` and place Vaults for rewards
4. Players walk near a spawner → waves start
5. Survive → get loot + Trial Keys
6. Use Trial Key on a Vault → rare rewards

---

## Building

```bash
mvn clean package
```

Jar will be in `target/TrialWeapons.jar`

**Requires:** Java 8+, Maven, Spigot 1.12.2 server

---

## Installation

1. Drop `TrialWeapons.jar` into your server's `plugins` folder
2. Restart the server
3. Edit `plugins/TrialWeapons/config.yml` if you want to tweak values

---

## License

Free to use and modify.
