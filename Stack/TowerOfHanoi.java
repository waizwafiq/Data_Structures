/**
In this game, there are only three towers:
      i) The source
     ii) The auxiliary (aux)
    iii) The destination (dest)

Algorithm:
    To win this game optimally, we have to place the bottom disk (disk 3) on the destination tower.
    To do so, we have to place other disks (disk 1 & 2) on the auxiliary tower first.
    Then we place the bottom disk (disk 3) on the destination tower.
    Finally, we have to place all of the other disks (disk 1 & 2) on the destination tower.

@author Waiz Wafiq
 */
public class TowerOfHanoi {

    //SETTINGS
    private static MyStack<Integer>[] tower = new MyStack[3];
    private static int numberOfDisks = 3;

    public static void main(String[] args) {

        //CREATE TOWERS
        for (int i = 0; i < tower.length; i++)
            tower[i] = new MyStack<>();

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

            moveDisk(disk - 1, aux, source, dest); //moving (disk-1) disks from auxiliary to destination
        }
    }
}
