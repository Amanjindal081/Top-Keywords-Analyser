package tech.codingclub.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import tech.codingclub.TaskManager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TopKeywordAnalayser implements Runnable{

    private final  String filepath;
    public TopKeywordAnalayser(String filepath) {
        this.filepath = filepath;
    }


    public void run() {
        ArrayList<String> data = FileUtility.readfileaslist(filepath);
        HashMap<String,Integer> countkeywords = new HashMap<String, Integer>();
        for(String row: data){
            String[] keywords = row.split(" ");
            for(String keyword:keywords){
                String str = keyword.toLowerCase();
                if(!countkeywords.containsKey(str)){
                    countkeywords.put(str,1);
                }
                else{
                    Integer x = countkeywords.get(str);
                    countkeywords.put(str,x+1);
                }
            }
        }
        ArrayList<KeyWordCount>keyWordCountArrayList = new ArrayList<KeyWordCount>();
        for(String keys:countkeywords.keySet()){
            keyWordCountArrayList.add(new KeyWordCount(keys,countkeywords.get(keys)));
        }
        Collections.sort(keyWordCountArrayList, new Comparator<KeyWordCount>() {
            public int compare(KeyWordCount o1, KeyWordCount o2) {
                if(o2.count==o1.count){
                    return o1.keyword.compareTo(o2.keyword);
                }
                return o2.count-o1.count;
            }
        });
        //int r=0;
        //for(KeyWordCount i: keyWordCountArrayList){
          //  if(r==10) break;
            //r++;
            //System.out.println(i.keyword+" "+i.count);
        //}
        String json = new Gson().toJson(keyWordCountArrayList);
        System.out.println(json);
        String convertjson = "{\"keyword\":\"gujarata\",\"count\":1}";
        KeyWordCount keyW= new Gson().fromJson(convertjson,KeyWordCount.class);
        System.out.println("##################################");
        System.out.println(keyW.keyword+" :"+keyW.count);
        String convertjsonarray="[{\"keyword\":\"dravida\",\"count\":1},{\"keyword\":\"gahe\",\"count\":1},{\"keyword\":\"ganga\",\"count\":1},{\"keyword\":\"gatha\",\"count\":1},{\"keyword\":\"gujarata\",\"count\":1},{\"keyword\":\"himachala\",\"count\":1},{\"keyword\":\"jage\",\"count\":1},{\"keyword\":\"jaladhi\",\"count\":1},{\"keyword\":\"mage\",\"count\":1},{\"keyword\":\"mana\",\"count\":1},{\"keyword\":\"mangala\",\"count\":1},{\"keyword\":\"maratha\",\"count\":1},{\"keyword\":\"name\",\"count\":1},{\"keyword\":\"panjaba\",\"count\":1},{\"keyword\":\"sindh\",\"count\":1},{\"keyword\":\"taranga\",\"count\":1},{\"keyword\":\"uchchala\",\"count\":1},{\"keyword\":\"utkala\",\"count\":1},{\"keyword\":\"vindhya\",\"count\":1},{\"keyword\":\"yamuna\",\"count\":1}]";
        ArrayList<KeyWordCount>  keyWordCountArrayList1 = new Gson().fromJson(convertjsonarray, new TypeToken<ArrayList<KeyWordCount>>(){}.getType());
        for(KeyWordCount keyWordCount: keyWordCountArrayList){
            System.out.println(keyWordCount.keyword+" "+keyWordCount.count);
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(1);
        String fpath = "C:\\Users\\ajind\\Downloads\\untitled2\\data\\practice\\file"+"create-file.txt";
        taskManager.waittillqueueisfreeandadd(new TopKeywordAnalayser(fpath));
    }
}
