package Stack;
/**
 * In this game, there are only three towers:
 * i) The source
 * ii) The auxiliary (aux)
 * iii) The destination (dest)
 * <p>
 * Algorithm:
 * To win this game optimally, we have to place the bottom disk (disk 3) on the destination tower.
 * To do so, we have to place other disks (disk 1 & 2) on the auxiliary tower first.
 * Then we place the bottom disk (disk 3) on the destination tower.
 * Finally, we have to place all of the other disks (disk 1 & 2) on the destination tower.
 *
 * @author Waiz Wafiq
 */

class TowerOfHanoi {

    //SETTINGS
    private static Stack<Integer>[] tower = new Stack[3];
    private static final int numberOfDisks = 5;

    public static void main(String[] args) {

        //CREATE TOWERS
        for (int i = 0; i < tower.length; i++)
            tower[i] = new Stack<Integer>();

        //PLACE ALL OF THE DISKS AT TOWER 1
        for (int i = numberOfDisks; i >= 1; i--)
            tower[0].push(i);

        //Motive: Moving (numberOfDisks) disks from tower (1) to tower (3)
        moveDisk(numberOfDisks, 0, 1, 2);

    }

    public static void moveDisk(int disk, int source, int aux, int dest) {
        if (disk >= 1) {
            moveDisk(disk - 1, source, dest, aux); //moving (disk-1) disks from source to auxiliary

            //Moving disk from source to dest
            int takenDisk = tower[source].pop();
            tower[dest].push(takenDisk);
            System.out.println("Moved disk " + takenDisk + " from tower " + (source + 1) + " to tower " + (dest + 1));
            display();
            moveDisk(disk - 1, aux, source, dest); //moving (disk-1) disks from auxiliary to destination
        }
    }

    public static void display() {
        System.out.println("‐‐‐‐‐‐‐‐‐‐-");
        System.out.println(" A | B | C");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐");
        for (int i = numberOfDisks - 1; i >= 0; i--) {
            String d1 = " ", d2 = " ", d3 = " ";
            try {
                d1 = String.valueOf(tower[0].get(i));
            } catch (Exception e) { }
            try {
                d2 = String.valueOf(tower[1].get(i));
            } catch (Exception e) { }
            try {
                d3 = String.valueOf(tower[2].get(i));
            } catch (Exception e) { }
            System.out.println(" " + d1 + " | " + d2 + " | " + d3);
        }
        System.out.println("\n");
    }
}
