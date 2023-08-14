
/**
 * This class represents max-min heap.
 * @author (Miiriam Shnitzer)
 * @version (16/5/23)
 */
import java.util.*;
public class Heap
{
    private double[]a=new double[513];//the heap array
    private int heap_size;//the number of values in array of heap
    
    /**This function builds a new heap*/
    public Heap()
    {
        heap_size=0;
    }
    /**This function gets a number and add it to the heap
     * @param val the number*/
    public void addNumber(double val)
    {
        heap_size++;
        if(heap_size>a.length)//if there is no place in the array
        {
            System.out.println("Heap is full");
            return;
        }
        a[heap_size]=val;
    }
    /**This function reset the heap size by putting zero in it.*/
    public void resetHeapsize()
    {
        heap_size=0;
    }
    /**
     * This function gets an index in the heap and returns the depth of the 
       junction of this index
     *@param i the index of junction*/
    public int getDepth(int i)
    {
        return (int)(Math.floor(Math.log(i)/Math.log(2)));//the depth is log i in 2 base
    }
    /**This function returns the heap size
     * @return the heap size*/
    public int getHeapSize()
    {
        return heap_size;
    }
    /**
     * This function gets an index and returns the biggest value between
     * the junction in the index itself, its two sons and its four grandchilds
     * @param i the index 
     * @return the index of maximum value*/
    public int findBiggest(int i)
    {   
        double max=a[i];//max saves the maximum    
        int index=i;//index saves the index of the maximum
        if(i*2<=heap_size)//if the reight son is in the array bounds
            if(a[2*i]>max)
            {
                max=a[2*i];
                index=2*i;
            }    
        if(i*2+1<=heap_size)//if the left son is in the array bounds
            if(a[2*i+1]>max)
            {
                max=a[2*i+1];
                index=2*i+1;
            }    
        if(i*4<=heap_size)//if the most left grandchild is in the array bounds
            if(a[4*i]>max)
            {
                max=a[4*i];
                index=4*i;
            }    
        if(i*4+1<=heap_size)//if the second left grandchild is in the array bounds
            if(a[4*i+1]>max)
            {
                max=a[4*i+1];
                index=4*i+1;
            }    
        if(i*4+2<=heap_size)//if the third left grandchild is in the array bounds
            if(a[4*i+2]>max)
            {
                max=a[4*i+2];
                index=4*i+2;
            }    
        if(i*4+3<=heap_size)//if the nost right grandchild is in the array bounds
            if(a[4*i+3]>max)
            {
                max=a[4*i+3];
                index=4*i+3;
            }    
        return index;
    }
    /**
     * This function gets an index and returns the smallest value between
     * the junction in the index itself, its two sons and its four grandchilds
     * @param i the index 
     * @return the index of minimum value*/
    public int findSmallest(int i)
    {
        double min=a[i];//max saves the minimum    
        int index=i;//index saves the index of the minimum
        if(i*2<=heap_size)//if the reight son is in the array bounds
            if(a[2*i]<min)
            {
                min=a[2*i];
                index=2*i;
            }    
        if(i*2+1<=heap_size)//if the left son is in the array bounds
            if(a[2*i+1]<min)
            {
                min=a[2*i+1];
                index=2*i+1;
            }    
        if(i*4<=heap_size)//if the most left grandchild is in the array bounds
            if(a[4*i]<min)
            {
                min=a[4*i];
                index=4*i;
            }    
        if(i*4+1<=heap_size)//if the second left grandchild is in the array bounds
            if(a[4*i+1]<min)
            {
                min=a[4*i+1];
                index=4*i+1;
            }    
        if(i*4+2<=heap_size)//if the third left grandchild is in the array bounds
            if(a[4*i+2]<min)
            {
                min=a[4*i+2];
                index=4*i+2;
            }    
        if(i*4+3<=heap_size)//if the nost right grandchild is in the array bounds
            if(a[4*i+3]<min)
            {
                min=a[4*i+3];
                index=4*i+3;
            }    
        return index;
    }
    /**
     * This function gets an index in the heap and down in to its proper place in the heap. the two sub-trees - the right and the left
     * are legal max-min heaps.
     * @param i the index
     */
    public void heapify(int i)
    {   
        int new_index;
        if(i<=heap_size)
        {
            if(getDepth(i)%2==0)
            {
                new_index=findBiggest(i);
                if(new_index==i)//if a[i] is in its proper place already
                    return;
            }
            else
            {
                new_index=findSmallest(i);
                if(new_index==i)//if a[i] is in its proper place already
                    return;
            }
            a[new_index]=(a[i] + a[new_index])-(a[i] = a[new_index]);//switch between a[i] and a[new_index]
            if(getDepth(new_index)%2==0)
            {
                if(a[new_index]<a[new_index/2])//if after the switching a[new_index] is smaller than its father
                {
                    a[new_index/2]=(a[new_index] + a[new_index/2])-(a[new_index] = a[new_index/2]);//switch between a[new_index] and its father
                } 
            }
            else
            {
                if(a[new_index]>a[new_index/2])//if after the switching a[new_index] is bigger than its father
                {
                    a[new_index/2]=(a[new_index] + a[new_index/2])-(a[new_index] = a[new_index/2]);//switch between a[new_index] and its father
                }
            }
            heapify(new_index);    
        }
    }
    /**
     * This function gets an index and take it up all the way to its proper place. the fathers of a[i] are legal max-min heap
     * @param i the index
     */
    public void upHeap(int i)
    {  
        if(i<0 || i>heap_size)//if i is out of bounds
        {
            return;
        }
        if(i==1)//if i is the root- it is in its proper place already
            return;
        if((i==2 || i==3) && a[i]>a[1])//if i is one of the two sons of the root and a[i] is bigger than the root
        {
            a[i]=(a[1]+a[i])-(a[1]=a[i]);//switch between a[i] and the root
            return;
        }
        int up_limit,low_limit;
        if(getDepth(i)%2==0)
        {
            up_limit=i/4;    
            low_limit=i/2; 
        }
        else
        {
            low_limit=i/4;    
            up_limit=i/2;
        }
        if(a[i]>a[up_limit])
        {
            a[i]=(a[up_limit]+a[i])-(a[up_limit]=a[i]);//switch between a[i] and a[up_limit]
            upHeap(up_limit);
        }
        if(a[i]<a[low_limit])
        {
            a[i]=(a[low_limit]+a[i])-(a[low_limit]=a[i]);//switch between a[i] and a[low_limit]
            upHeap(low_limit);
        }
    }
    /**
     * This function builds a heap. it works on an exist array with numbers that is not a max-min heap, and make it a max-min heap 
     * by ordering the junctions value
     */
    public void buildHeap()
    {
        for(int i=heap_size/2;i>0;i--)//the function runs on all the not-leaves junctions and call to heapify for every junction
        {
            heapify(i);
        }
    }
    /**
     * This functino delete the biggest value in the heap-the root
     */
    public void heapExtractMax()
    {
        a[1]=(a[heap_size]+a[1])-(a[heap_size]=a[1]);//switch between a[1] and the last leaf
        heap_size--;
        heapify(1);
    }
    /**
     * This function delete the smallest value in the heap-one of a[2] and a[3]
     */
    public void heapExtractMin()
    {
        if(a[2]<a[3])
        {
            heapDelete(2);
        }
        else
        {
            heapDelete(3);
        }
    }
    /**
     * This functino gets a value and insert it to the heap as a new junction
     * @param key the new value
     */
    public void heapInsert(double key)
    {
        if(heap_size==a.length-1)
            System.out.println("Cannot insert new value, because heap is full");
        else
        {
            heap_size++;
            a[heap_size]=key;
            upHeap(heap_size);
        }
    }
    /**
     * This function gets an index and delete a[i] from the heap
     * @param i the index
     * @return 1 if the deleting was done successfuly and 0 if not
     */
    public int heapDelete(int i)
    {
        if(i<0 || i>heap_size)//if i is out of bounds
        {
            return 0;
        }
        a[i]=a[1]+1;//make a[i] the biggest value int the heap by puting the root value+1 in it
        upHeap(i);
        heapExtractMax();
        return 1;
    }
    /**
     * This function prints the heap array
     */
    public void printHeap()
    {
        System.out.print("[");
        for(int i=1;i<heap_size+1;i++)
        {
            if((int)(a[i])==a[i])//if the value is integer
                System.out.print((int)(a[i]));
            else
                System.out.print(a[i]);
            if(i<heap_size)//if this is not the last value
                System.out.print(",");
        }
        System.out.print("]\n");
    }
    
}
