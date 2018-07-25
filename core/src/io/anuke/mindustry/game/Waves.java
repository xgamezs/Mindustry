package io.anuke.mindustry.game;

import com.badlogic.gdx.utils.Array;
import io.anuke.mindustry.content.Items;
import io.anuke.mindustry.content.StatusEffects;
import io.anuke.mindustry.content.UnitTypes;
import io.anuke.mindustry.content.Weapons;
import io.anuke.mindustry.type.ItemStack;

public class Waves{

    public static Array<SpawnGroup> getSpawns(){
        return Array.with(
            new SpawnGroup(UnitTypes.scout){{
                end = 8;
                unitScaling = 2;
            }},

            new SpawnGroup(UnitTypes.interceptor){{
                begin = 12;
                end = 14;
            }},

            new SpawnGroup(UnitTypes.scout){{
                begin = 11;
                unitScaling = 2;
                spacing = 2;
                max = 4;
            }},

            new SpawnGroup(UnitTypes.titan){{
                begin = 9;
                spacing = 3;
                unitScaling = 2;

                end = 30;
            }},

            new SpawnGroup(UnitTypes.scout){{
                begin = 10;
                unitScaling = 2;
                unitAmount = 1;
                spacing = 2;
                ammoItem = Items.tungsten;
                end = 30;
            }},

            new SpawnGroup(UnitTypes.titan){{
                begin = 28;
                spacing = 3;
                unitScaling = 2;
                weapon = Weapons.flamethrower;
                end = 40;
            }},

            new SpawnGroup(UnitTypes.titan){{
                begin = 45;
                spacing = 3;
                unitScaling = 2;
                weapon = Weapons.flamethrower;
                effect = StatusEffects.overdrive;
            }},

            new SpawnGroup(UnitTypes.titan){{
                begin = 120;
                spacing = 2;
                unitScaling = 3;
                unitAmount = 5;
                weapon = Weapons.flakgun;
                effect = StatusEffects.overdrive;
            }},

            new SpawnGroup(UnitTypes.interceptor){{
                begin = 16;
                unitScaling = 2;
                spacing = 2;

                end = 39;
                max = 7;
            }},

            new SpawnGroup(UnitTypes.scout){{
                begin = 82;
                spacing = 3;
                unitAmount = 4;
                groupAmount = 2;
                unitScaling = 3;
                effect = StatusEffects.overdrive;
                ammoItem = Items.silicon;
            }},

            new SpawnGroup(UnitTypes.scout){{
                begin = 41;
                spacing = 5;
                unitAmount = 1;
                unitScaling = 3;
                effect = StatusEffects.shielded;
                ammoItem = Items.thorium;
                max = 10;
            }},

            new SpawnGroup(UnitTypes.scout){{
                begin = 35;
                spacing = 3;
                unitAmount = 4;
                groupAmount = 2;
                effect = StatusEffects.overdrive;
                items = new ItemStack(Items.blastCompound, 60);
                end = 60;
            }},

            new SpawnGroup(UnitTypes.scout){{
                begin = 42;
                spacing = 3;
                unitAmount = 4;
                groupAmount = 2;
                effect = StatusEffects.overdrive;
                items = new ItemStack(Items.pyratite, 100);
                end = 130;
            }},

            new SpawnGroup(UnitTypes.monsoon){{
                begin = 40;
                ammoItem = Items.blastCompound;
                unitAmount = 2;
                spacing = 2;
                unitScaling = 3;
                max = 8;
            }},

            new SpawnGroup(UnitTypes.interceptor){{
                begin = 50;
                unitAmount = 4;
                unitScaling = 3;
                spacing = 5;
                groupAmount = 2;
                effect = StatusEffects.overdrive;
                max = 8;
            }},

            new SpawnGroup(UnitTypes.monsoon){{
                begin = 53;
                ammoItem = Items.pyratite;
                unitAmount = 2;
                unitScaling = 3;
                spacing = 4;
                max = 8;
                end = 74;
            }},

            new SpawnGroup(UnitTypes.monsoon){{
                begin = 53;
                ammoItem = Items.coal;
                unitAmount = 2;
                unitScaling = 3;
                spacing = 4;
                max = 8;
                end = 74;
            }}
        );
    }

    public static void testWaves(int from, int to){
        Array<SpawnGroup> spawns = getSpawns();
        for(int i = from; i <= to; i++){
            System.out.print(i + ": ");
            int total = 0;
            for(SpawnGroup spawn : spawns){
                int a = spawn.getUnitsSpawned(i) * spawn.getGroupsSpawned(i);
                total += a;

                if(a > 0){
                    System.out.print(a + "x" + spawn.type.name);

                    if(spawn.weapon != null){
                        System.out.print(":" + spawn.weapon.name);
                    }

                    if(spawn.ammoItem != null){
                        System.out.print(":" + spawn.ammoItem.name);
                    }

                    System.out.print(" ");
                }
            }
            System.out.print(" (" + total + ")");
            System.out.println();
        }
    }
}
