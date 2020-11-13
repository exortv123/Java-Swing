/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappipbird;

import java.util.HashMap;

/**
 *
 * @author SE140779
 */
public class RecordTable extends HashMap<String, Integer>{
    String maxName = "Not Recorded";
    int maxPoint = 0;
    
    
    


    String getMaxRecordName() {
        updateMax();
        return maxName;
    }

    String getMaxRecordPoint() {
        updateMax();
        return maxPoint + "";
    }

    private void updateMax() {
        for (String key : this.keySet()) {
            if (this.get(key) > maxPoint) {
                maxName = key;
                maxPoint = this.get(key);
            }
        }
    }
    
}
