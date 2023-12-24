package cn.campsg.practical.bubble.entity;

public class StarList{
    private Star[] stars;
    private int size;
    public StarList(){
        stars=new Star[100];
        size=0;
    }
    public StarList(int size){
        stars=new Star[size];
        this.size=0;
    }
    public void add(Star star){
        stars[size]=star;
        size++;
    }
    public void add(StarList starList){
        for(int i=0;i<starList.size();i++){
            stars[size]=starList.get(i);
            size++;
        }
    }
    public Star get(int index){
        return stars[index];
    }
    public int size(){
        return size;
    }
    public void clear(){
        size=0;
    }
    public void remove(int index){
        for(int i=index;i<size-1;i++){
            stars[i]=stars[i+1];
        }
        size--;
    }
    public void remove(Star star){
        for(int i=0;i<size;i++){
            if(stars[i]==star){
                remove(i);
                break;
            }
        }
    }
    public void remove(StarList starList){
        for(int i=0;i<starList.size();i++){
            remove(starList.get(i));
        }
    }
    public boolean contains(Star star){
        for(int i=0;i<size;i++){
            if(stars[i]==star){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public StarList clone(){
        StarList starList=new StarList(size);
        for(int i=0;i<size;i++){
            starList.add(stars[i]);
        }
        return starList;
    }
    public void set(int index,Star star){
        stars[index]=star;
    }
    public void set(StarList starList){
        for(int i=0;i<starList.size();i++){
            stars[i]=starList.get(i);
        }
        size=starList.size();
    }
    public void set(StarList starList,int index){
        for(int i=0;i<starList.size();i++){
            stars[index+i]=starList.get(i);
        }
        size=index+starList.size();
    }
    public void set(StarList starList,int index,int length){
        for(int i=0;i<length;i++){
            stars[index+i]=starList.get(i);
        }
}
}