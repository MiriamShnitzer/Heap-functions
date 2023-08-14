

/**
 * This calss runs a heap functions by user choices
 * @author (Miriam Shnitzer)
 * @version (16/5/23)
 */
import java.util.*;
public class Driver
{ 
    public static void main(String[]args)
    {
        Heap heap=new Heap();
        build(heap);
        Driver.menu(heap);
    }
    /**
     * This function gets an empty heap and build it by first reading values from the user chosen file and putting them in the heap array
     * and then call to the build_heap function on the heap in order to order it to a legal heap
     * @param heap a max-min heap
     */
    public static void build(Heap heap)
    {
        double val;
        int count=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of numbers you want to insert to the heap(maximum 512)");
        count=scan.nextInt();
        System.out.println("Now enter the numbers you want to insert to the heap");
        heap.resetHeapsize();
        for(int i=0;i<count;i++)
        {
            val=scan.nextDouble();
            heap.addNumber(val);
        }
        heap.buildHeap();
    }
    /**
     * This function gets a heap and call to the variety of function on a max-min heap of the Heap class, by the user choices
     * @param heap the max-min heap builded in main function    
     */
    public static void menu(Heap heap)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Heap is ready! now here is a function menu:");
        System.out.println("Exit -\t\t\tpress 0\nBuild_Heap -\t\tpress 1\nHeap_Extract_Max -\tpress 2\nHeap_Extract_Min -\tpress 3\nHeap_Insert -\t\tpress 4\nHeap_Delete -\t\tpress 5\nPrint_Heap -\t\tpress 6");
        double val;
        int index,choice=scan.nextInt();//read the user choice
        while(choice!=0)
        {
            switch(choice){
            case 0:
                {
                    System.exit(0);
                }
            case 1:
                {
                    build(heap);
                    heap.printHeap();
                    break;
                }
            case 2:
                {
                    heap.heapExtractMax();
                    heap.printHeap();
                    break;
                }
            case 3:
                {
                    heap.heapExtractMin();
                    heap.printHeap();
                    break;
                }
            case 4:
                {
                    System.out.println("Please enter a value to insert");
                    val=scan.nextDouble();
                    heap.heapInsert(val);
                    heap.printHeap();
                    break;
                }
            case 5:
                {
                    System.out.println("Please enter an index to delete a value from");
                    index=scan.nextInt();
                    if(heap.heapDelete(index)==0)
                    {
                        System.out.println("Index is out of heap bounds");
                        break;
                    }
                    heap.printHeap();
                    break;
                }
            case 6:
                {
                    heap.printHeap();
                    break;
                }
            default: 
                {
                    System.out.println("Invalid choice");
                    choice=scan.nextInt();
                    continue;
                }
            }
            System.out.println("You can enter your choice");
            choice=scan.nextInt();
        }
    }
}
