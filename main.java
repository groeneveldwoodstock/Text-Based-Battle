
/**
 * Game Play.
 *
 * @author (Richard Groeneveld)
 * @version (August 2020)
 */
import java.util.Random;
import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    // System objects
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    // Game variables enemies and maximums for their traits
    String[] enemies = {"Skeleton", "Ogre", "Dwarf", "Thief", "Wolf", "Wild Rabbit"};
    int maxEnemyHealth = 75;
    int enemyAttackDamage = 20;

    // Player variables at the start of the game
    int health = 100;
    int attackDamage = 50; 
    int numHealthPotions = 3;
    int healthPotionHealAmount = 25;
    int healthPotionDropChance = 50; //percentage
    int experiencePoints = 0;

    boolean running = true;

    System.out.println("Welcome to the Adventure!");
    //add additional introduction information here 

    GAME:
    while(running) {
        System.out.println("---------------------------------------");

        int enemyHealth = rand.nextInt(maxEnemyHealth);
        // rand.nextInt(max) generates random integer between zero and max
        String enemy = enemies[rand.nextInt(enemies.length)];
        System.out.println("\t# A " + enemy + " has appeared! #\n");

        while (enemyHealth > 0) {
          System.out.println("\tYour HP:" + health);
          System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
          System.out.println("\n\tWhat would you like to do?");
          System.out.println("\t1. Attack");
          System.out.println("\t2. Drink health potion");
          System.out.println("\t3. Run!");    

          String input = in.nextLine();
          if(input.equals("1")) {
              int damageDealt = rand.nextInt(attackDamage);
              int damageTaken = rand.nextInt
              
              (enemyAttackDamage);

              enemyHealth -= damageDealt;
              health -= damageTaken;
              experiencePoints = experiencePoints +5 ;
              if(damageDealt < 20) {
                System.out.println("\t> Your attack does the " + enemy + " only " + damageDealt + " damage.");
              }
              else {
                System.out.println("\t> Your attack does the " + enemy + " " + damageDealt + " damage!");
              }
              System.out.println("\t> The " + enemy + " does " + damageTaken + " damage in retaliation!");

              if(health < 1) {
                System.out.println("\t> You have taken too much damage, you are too weak to continue your adventure");
                break;
                }
          }      
          else if(input.equals("2")){
              if(numHealthPotions > 0){
                health += healthPotionHealAmount;
                numHealthPotions--;
                System.out.println("\t> You drink the health potion, healing yourself for " + healthPotionHealAmount +"\n\t> You now have " + health + " HP." + "\n\t> You have " + numHealthPotions + " health potions left.\n");
              }
              else {
                System.out.println("\t> You have no health potions left. If you defeat enemies you have a chance at receiving more health potions.");
              }
          }
          else if(input.equals("3")){
                System.out.println("\tYou run away from the "+ enemy + " and live to fight another day.");
                experiencePoints = experiencePoints +1 ;
                continue GAME;
          }
          else {
              System.out.println("\tUnfortunately that is an invalid command.");

          }
        }
        if(health <1){
          System.out.println("Your adventure is over. You are too weak to continue.");
          break;
        }
        System.out.println("---------------------------------------");
        System.out.println(" # " + enemy + " was defeated! # ");
        System.out.println(" # You have " + health + " HP left. # ");
        System.out.println(" # You now have " + experiencePoints + " experience points # ");
        if(rand.nextInt(100)<healthPotionDropChance){
          numHealthPotions++;
          System.out.println(" # The " + enemy + " dropped a health potion. # ");
          System.out.println(" # You now have " + numHealthPotions + " health potion(s) # ");
        }
        System.out.println("---------------------------------------");
        System.out.println("What do you want to do next?");
        System.out.println("1. Continue fighting");
        System.out.println("2. End the adventure");

        String input = in.nextLine();

        while (!input.equals("1") && !input.equals("2")){
          System.out.println("\tUnfortunately that is an invalid command.");
          input = in.nextLine();
        }
        if (input.equals("1")){
          System.out.println("You continue your adventure!");
        }
        else if (input.equals("2")){
          System.out.println("Your adventure has come to an end, you survived!");
          System.out.println("You end with " + numHealthPotions + " health potion(s), " + health + " HP, and " + experiencePoints + " experience points!");
          int finalscore = 2 * numHealthPotions + health + experiencePoints;
          System.out.println("** Your final score is "+ finalscore +"! **"); 
          break;
  

        }
    }
  }
}