package leet_code.java.util;

public record Test() {
    
}
/*
    Semphore: integer var (s)
    down => if (s> 0 ) => s--; else sleep();
    up => s++;

    void down(int semp){
        if(semp > 0){
            semp--;
        }
        else{
            sleep();
        }
    }


    int count = 0; // semaphore variable 
    int[] buffer = new int[Size];

    prod(){
        while(true){
            int i = Random(); // produce item
            if(count == Size) continue; // wait till the buffer got free slot 
            insert(); // insert into the buffer 
            count++; 
            if(count == 1) wakup(consumer); 
        }
    }

    cons(){
        while(true){
            if(count == 0) sleep(); // till count > 0
            getItemFromTheBuffer(); // get item from the buffer 
            count--;
            if(count == N - 1) wakeUp(producer);
            
        }
    }

*/


/*

*/
