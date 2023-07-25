
public class Main {
        public static void arrayWritesOut(int[] block) {
            for (int i = 0; i < block.length-1; i++) {
                System.out.print(block[i]+", ");
            }
            System.out.println(block[block.length-1]); //we don't do it after the last element ", "-t
        }
        public static boolean contain(int[] block, int number) {
             boolean include = false;
            for (int i = 0; i < block.length; i++) {
                if (block[i]==number) {
                    include = true;
                    break;
                }
            }
            return include;
        }
        public static int[] section(int[] block1, int[] block2) {
            int counter = 0;
            for (int element : block1) {
                if (contain(block2,element)) {
                    counter++;
                }
            }
            int[] section = new int[counter];

            int sectionI = 0;
            for (int element : block1) {
                if (contain(block2,element)) {
                    section[sectionI++]=element;
                }
            }
            return section;
        }
        public static int[] unio (int[]block1, int[]block2) {
            int size = block1.length;
            for (int element : block2) {
                if (!contain(block1,element)) {
                    size++;
                }
            }
            int[] unionT = new int[size];
            int unionI = 0;

            for (int element : block1) {
                unionT[unionI++]=element;
            }
            for (int element : block2) {
                if (!contain(block1,element)) {
                    unionT[unionI++] = element;
                }
            }
            return unionT;
        }
        public static int counting(int[]block, int number) {
            int flag = 0;
            for (int element : block) {
                if (element==number) {
                    flag++;
                }
            }
            return flag;
        }
        public static int search(int[] block, int number) {
            int index = -1;
            int i;
            for ( i = 0; i < block.length && block[i]!= number ; i++) {}

            if (i< block.length) {
                index=i;
            }
            return index;
        }
    public static void main(String[] args) {

        int[] numbers1 = {23,45,12,67,8,2,45,99,56,87,8};
        int[] numbers2 = {7,22,12,99,8,14,50,44,88,98};
        int[] numbers3 = {2,23,87,2,34,55,56,87,2,9,2};

        System.out.println("The numbers of the first Array: ");
        arrayWritesOut(numbers1);
        System.out.println();
        System.out.println("The numbers of the second Array: ");
        arrayWritesOut(numbers2);
        System.out.println();
        System.out.println("Sections of Block1 and Block2: ");
        arrayWritesOut(section(numbers1,numbers2));
        System.out.println();
        System.out.println("Union of Array1 and Array2: ");
        arrayWritesOut(unio(numbers1,numbers2));
        System.out.println();
        System.out.println("It contains (numbers3) "+ counting(numbers3,2)+" of number 2.");
        System.out.println();
        System.out.println("In numbers 3, the number 99 is "+ search(numbers1,99)+" in place.");
    }
}