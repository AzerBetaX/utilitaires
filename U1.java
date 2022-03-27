import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class outils extends JavaPlugin{

@Override
    public void onEnable()
    {
        System.out.println("===============");
        System.out.println("Plugin en marche");
        System.out.println("===============");
        this.getCommand("test").setExecutor(new CommandTest(this));
    }

    @Override
    public void onDisable(){

        System.out.println("===============");
        System.out.println("Plugin en arrêt");
        System.out.println("===============");
    }


public void repartition_circulaire(World world,int rayon,Player sender,int division)
    {
        for (int i = 0;i < division  ; i++){
                //taille +1 pour ne pas téléporté deux joueurs au même endroit
                double angle_i = (2*Math.PI / (division)) * i;
                double x_i = sender.getLocation().getX() + rayon * Math.cos((Math.PI / 2) - angle_i);
                double z_i = sender.getLocation().getZ() + rayon * Math.cos(angle_i);
                double y_i = sender.getLocation().getY();
                Location coordonee_1 = new Location(world,x_i + 1.0 , y_i, z_i - 1.0);
                Location coordonee_2 = new Location(world,x_i - 1.0 , y_i, z_i + 1.0);
                Cuboid plateforme = new Cuboid(coordonee_1, coordonee_2);
                for(Block block : plateforme){
                    block.setType(Material.ACACIA_PLANKS);

                }


                world.getBlockAt(new Location(world, x_i, y_i, z_i)).setType(Material.GOLD_BLOCK);
                sender.sendMessage("i = " + i);

            }
    }
    
 }
