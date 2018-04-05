### DICL Internship Program 2018

สวัสดีน้องๆที่ให้ความสนใจมาฝึกงานที่บริษัท ดิจิตอล อินไซด์เดอร์ จำกัด ในปี 2018 นี้ทุกๆคนนะครับ ก่อนที่จะเข้ามาฝึกงานกับเรา พี่มีบททดสอบเล็กน้อยเพื่อวัดทักษะพื้นฐานสำหรับนักพัฒนา Mobile Developer น้องๆไม่จำเป็นต้องตอบหรือต้องรู้ทุกเรื่องในบททดสอบนี้ เพราะเรามาสามารถมาเรียนรู้กันภายหลังได้ เพียงแต่เราอยากให้น้องๆทุกคนลองทำด้วยตัวเอง ค้นคว้าเอง ทั้งหมดก็เพื่อประโยชน์ของตัวน้องๆเองและบริษัท หากใครสนใจส่งคำตอบกันมานะได้เลยนะครับ ปิดรับสมัครวันที่ 8 เมษายน 18 เวลา 23:59 น.

## 1. Code in Swift or Java / Kotlin
แบบทดสอบนี้จะดูทักษะความรู้ความเข้าใจเกี่ยวกับเรื่อง Collection เช่น Array, Dictionary เป็นต้น

ดาวน์โหลดข้อมูล [data.json](https://github.com/memogames/dicl-intern-18/blob/master/data.json) และเขียนโค้ดเพื่อหาคำตอบ
- 1.1 หาคะแนนเฉลี่ย **score** ของนักเรียน
- 1.2 แสดงชื่อและเกรดของนักเรียนที่ได้คะแนนมากว่า 70 ขึ้นไป
- 1.3 ค้นหาชื่อนักเรียนที่มีคะแนนมากที่สุดและต่ำที่สุด **score**

คำตอบ:
```
package testjson;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestJson {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String path = "C:\\Users\\Poramin's\\Documents\\NetBeansProjects\\testJson\\src\\testjson\\data.json";

        try {
            JSONArray arr = (JSONArray) parser.parse(new FileReader(path));
            //System.out.println(arr);
            int i = 0, count = 0;
            double sum = 0;
            long score[] = new long[arr.size()];

            for (Object o : arr) {
                JSONObject std = (JSONObject) o;
                score[i] = (long) std.get("score");
                i++;
            }

            System.out.println("1: avg = " + findAvg(score));

            System.out.println("2: ");
            for (Object o : arr) {
                JSONObject std = (JSONObject) o;
                if (((long) std.get("score")) > 70) {
                    System.out.print("\t" + (count + 1));
                    System.out.print("\tName: " + std.get("name"));
                    System.out.println("\tGrade: " + std.get("grade"));
                    count++;
                }
            }

            System.out.println("3.1: max = " + myMax(score));
            System.out.println("3.2: min = " + myMin(score));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long myMin(long score[]) {
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < score.length; i++) {
            if (min > score[i]) {
                min = score[i];
            }
        }

        return min;
    }

    public static long myMax(long score[]) {
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }

        return max;
    }

    public static long findAvg(long score[]) {
        long sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        long avg = sum / score.length;
        return avg;
    }
}

```

## 2. Create Simple Mobile Application

แบบทดสอบนี้จะดูทักษะความรู้ความเข้าใจสำหรับการพัฒนาแอปพลิเคชั่น และการใช้ UI พื้นฐานของแต่ละ Platform

### Features
- GET ข้อมูล JSON จาก [movie.json](https://github.com/memogames/dicl-intern-18/blob/master/movie.json)
- แสดงรายชื่อและรูปภาพใน ListView หรือ TableView
- ผู้ใช้สามารถกดเพื่อดูข้อมูลรายละเอียดได้ในหน้าถัดไป
- ผู้ใช้สามารถแชร์ข้อมูลชื่อหนังที่สนใจให้กับเพื่อนๆได้
- ออกแบบ UI ได้ตามความต้องการ
- ใช้ Library เพิิ่มเติิมได้

### Technical
- ดาวน์โหลดข้อมูล JSON
- เครื่องมือที่ใช้ Android Studio หรือ Xcode.

## 3. Tiny Question

Q1: Firebase คืออะไร มีฟังก์ชั่นที่น้องๆชื่นชอบนอะไรบ้างและเพราะอะไร (อย่างน้อย 3 ฟังก์ชั่น)

```
A1: Firebase คือ NoSQL cloud database ที่เก็บข้อมูลอยู่ในรูปแบบของ JSON 
    1:Realtime Database เพราะเมื่อมีการอัพเดตข้อมูล ข้อมูลจะอัพเดตอัตโนมัติทันที่
    2:Firebase Authentication เพราะถ้าต้องการให้เข้าระบบผ่าน facebook สามารถทำผ่าน Firebase Authentication ได้เลย
    3:Firebase Cloud Messaging เพราะสามารถส่งข้อความได้เยอะภายในครั้งเดียวและได้ทุก platform 
```

Q2: REST API คืออะไร

```
A2: เป็น Web Service รูปแบบหนึ่ง ที่ใช้ HTTP ในการทำงานและส่งผลกลับมาในรูปแบบ JSON หรือ XML
```

Q3: หากต้องสร้างแอปพลิเคชั่น 1 ตัว เพื่อให้รองรับทั้งระบบ iOS และ Android วิิธีไหนที่น้องๆอยากเลือกใช้พัฒนาระหว่าง Native App กับ Cross Platform และเพราะอะไร 

```
A3: Native App เพราะ เขียนแค่ครั้งเดียวแต่ได้ทั้งสองระบบ
```

Q4: ถ้าให้เลือกได้ 1 บ้าน น้องๆอยากอยู่บ้านไหนระหว่าง Apple , Google และ Microsoft

```
A4: เลือก Google เพราะทุกวันนี้ใช้งาน google บ่อยสุดและมีโปรเจคเยอะ ไม่ว่าจะเป็น Search engine, Youtube, Google Drive, Firebase เป็นต้น
```

Q5: เวลาว่างสิ่งที่ชอบทำที่สุดคืออะไร 2 อันดับแรก

```
A5: เล่นเกม, ฟังเพลง
```

Q6: แอปพลิเคชั่นไหนบนมือถือที่ชอบที่สุดและเกียจที่สุดตั้งแต่เคยใช้งานมา (ไม่รวมเกมส์) เพราะอะไร

```
A6: ชอบที่สุด => Youtube เพราะ ใช้ในการหาอะไรดูแก้เบื่อ
    ไม่ชอบ =>   นาฬิกาปลุก เพราะ ตั้งปลุกบางทีก็ไม่ดังทำให้ตื่นไปเรียนไม่ทัน 
```

Q7: อะไรบ้างที่น้องๆคาดว่าจะได้รับในขณะที่ฝึกงานกับพวกเรา?

```
A7: ประสบการณ์และบรรยากาศในการทำงาน พร้อมทั้งความรู้ใหม่ ๆ 
```

## Submitting

ให้น้องๆ fork repo นี้แล้วตอบคำถาม จากนั้นส่ง repo มาที่ อีเมลล์ memo.games@gmail.com
