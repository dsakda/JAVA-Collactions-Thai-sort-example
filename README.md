# JAVA-Collactions-Thai-sort-example
ตัวอย่างการใช้ comparator เรียงลำดับข้อมูลภาษาไทย
```java
list.sort(new Comparator<Province>() {
  @Override
  public int compare(Province o1, Province o2) {
    Collator coll = Collator.getInstance(new Locale("th", "TH"));
      return coll.compare(o1.getNameTh(), o2.getNameTh());
    }
  });
```
